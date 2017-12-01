/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import com.WacomGSS.STU.*;
import com.WacomGSS.STU.Protocol.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

@WebServlet(urlPatterns = {"/MemberReceiptPrint"})
// Notes:
// There are three coordinate spaces to deal with that are named:
//   tablet: the raw tablet coordinate
//   screen: the tablet LCD screen
//   client: the Form window client area
public class MemberReceiptPrint extends JFrame {

    private static final long serialVersionUID = 1L;
    public String member;
    
    static class SignatureDialog extends JDialog implements ITabletHandler {

        private static final long serialVersionUID = 1L;

        private Tablet tablet;
        private Capability capability;
        private Information information;

        @Override
        public void onEventDataPinPad(EventDataPinPad edpp) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onEventDataKeyPad(EventDataKeyPad edkp) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onEventDataSignature(EventDataSignature eds) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onEventDataPinPadEncrypted(EventDataPinPadEncrypted edppe) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onEventDataKeyPadEncrypted(EventDataKeyPadEncrypted edkpe) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onEventDataSignatureEncrypted(EventDataSignatureEncrypted edse) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        // In order to simulate buttons, we have our own Button class that
        // stores the bounds and event handler.
        // Using an array of these makes it easy to add or remove buttons as
        // desired.
        private static class Button {

            java.awt.Rectangle bounds; // in Screen coordinates
            String text;
            ActionListener click;

            void performClick() {
                click.actionPerformed(null);
            }
        }

        // The isDown flag is used like this:
        // 0 = up
        // +ve = down, pressed on button number
        // -1 = down, inking
        // -2 = down, ignoring
        private int isDown;

        private List<PenData> penData; // Array of data being stored. This can
        // be subsequently used as desired.

        private Button[] btns; // The array of buttons that we are emulating.

        private JPanel panel;

        private BufferedImage bitmap; // This bitmap that we display on the
        // screen.
        private EncodingMode encodingMode; // How we send the bitmap to the
        // device.
        private byte[] bitmapData; // This is the flattened data of the bitmap
        // that we send to the device.

        private Point2D.Float tabletToClient(PenData penData) {
            // Client means the panel coordinates.
            return new Point2D.Float((float) penData.getX()
                    * this.panel.getWidth() / this.capability.getTabletMaxX(),
                    (float) penData.getY() * this.panel.getHeight()
                    / this.capability.getTabletMaxY());
        }

        private Point2D.Float tabletToScreen(PenData penData) {
            // Screen means LCD screen of the tablet.
            return new Point2D.Float((float) penData.getX()
                    * this.capability.getScreenWidth()
                    / this.capability.getTabletMaxX(), (float) penData.getY()
                    * this.capability.getScreenHeight()
                    / this.capability.getTabletMaxY());
        }

        private Point clientToScreen(Point pt) {
            // client (window) coordinates to LCD screen coordinates.
            // This is needed for converting mouse coordinates into LCD bitmap
            // coordinates as that's
            // what this application uses as the coordinate space for buttons.
            return new Point(
                    Math.round((float) pt.getX()
                            * this.capability.getScreenWidth()
                            / this.panel.getWidth()), Math.round((float) pt
                    .getY()
                    * this.capability.getScreenHeight()
                    / this.panel.getHeight()));
        }

        private void pressOkButton() throws STUException {
            this.setVisible(false);
        }

        private void pressClearButton() throws STUException {
            clearScreen();
        }

        private void pressCancelButton() throws STUException {
            this.setVisible(false);
            this.penData = null;
        }

        private void clearScreen() throws STUException {
            this.tablet.writeImage(this.encodingMode, this.bitmapData);

            this.penData.clear();
            this.isDown = 0;
            this.panel.repaint();
        }

        public void dispose() {
            // Ensure that you correctly disconnect from the tablet, otherwise
            // you are
            // likely to get errors when wanting to connect a second time.
            if (this.tablet != null) {
                try {
                    this.tablet.setInkingMode(InkingMode.Off);
                    this.tablet.setClearScreen();
                } catch (Throwable t) {
                }
                this.tablet.disconnect();
                this.tablet = null;
            }

            super.dispose();
        }

        private void drawCenteredString(Graphics2D gfx, String text, int x,
                int y, int width, int height) {
            FontMetrics fm = gfx.getFontMetrics(gfx.getFont());
            int textHeight = fm.getHeight();
            int textWidth = fm.stringWidth(text);

            int textX = x + (width - textWidth) / 2;
            int textY = y + (height - textHeight) / 2 + fm.getAscent();

            gfx.drawString(text, textX, textY);
        }

        private void drawInk(Graphics2D gfx, PenData pd0, PenData pd1) {
            gfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            gfx.setColor(new Color(0, 0, 64, 255));
            gfx.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND));

            Point2D.Float pt0 = tabletToClient(pd0);
            Point2D.Float pt1 = tabletToClient(pd1);
            Shape l = new Line2D.Float(pt0, pt1);
            gfx.draw(l);
        }

        private void drawInk(Graphics2D gfx) {
            PenData[] pd = new PenData[0];
            pd = this.penData.toArray(pd);
            for (int i = 1; i < pd.length; ++i) {
                if (pd[i - 1].getSw() != 0 && pd[i].getSw() != 0) {
                    drawInk(gfx, pd[i - 1], pd[i]);
                }
            }
        }

        // Pass in the device you want to connect to!
        public SignatureDialog(Frame frame, UsbDevice usbDevice)
                throws STUException {
            super(frame, true);
            this.setLocation(new Point(0, 0));
            this.setLocationRelativeTo(frame);
            this.panel = new JPanel() {
                private static final long serialVersionUID = 1L;

                @Override
                public void paintComponent(Graphics gfx) {
                    super.paintComponent(gfx);
                    if (bitmap != null) {
                        Image rescaled = bitmap.getScaledInstance(
                                panel.getWidth(), panel.getHeight(),
                                Image.SCALE_SMOOTH);
                        gfx.drawImage(rescaled, 0, 0, null);
                        drawInk((Graphics2D) gfx);
                    }
                }
            };
            this.panel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Point pt = clientToScreen(e.getPoint());
                    for (Button btn : SignatureDialog.this.btns) {
                        if (btn.bounds.contains(pt)) {
                            btn.performClick();
                            break;
                        }
                    }
                }
            });

            this.penData = new ArrayList<PenData>();

            try {
                this.tablet = new Tablet();
                // A more sophisticated applications should cycle for a few
                // times as the connection may only be
                // temporarily unavailable for a second or so.
                // For example, if a background process such as Wacom STU
                // Display
                // is running, this periodically updates a slideshow of images
                // to the device.

                int e = tablet.usbConnect(usbDevice, true);
                if (e == 0) {
                    this.capability = tablet.getCapability();
                    this.information = tablet.getInformation();
                } else {
                    throw new RuntimeException(
                            "Failed to connect to USB tablet, error " + e);
                }

                // Set the size of the client window to be actual size,
                // based on the reported DPI of the monitor.
                int screenResolution = this.getToolkit().getScreenResolution();

                Dimension d = new Dimension(this.capability.getTabletMaxX()
                        * screenResolution / 2540,
                        this.capability.getTabletMaxY() * screenResolution
                        / 2540);
                this.panel.setPreferredSize(d);
                this.setLayout(new BorderLayout());
                this.setResizable(false);
                this.add(this.panel);
                this.pack();

                this.btns = new Button[3];
                this.btns[0] = new Button();
                this.btns[1] = new Button();
                this.btns[2] = new Button();

                if (this.tablet.getProductId() != UsbDevice.ProductId_300) {
                    // Place the buttons across the bottom of the screen.

                    int w2 = this.capability.getScreenWidth() / 3;
                    int w3 = this.capability.getScreenWidth() / 3;
                    int w1 = this.capability.getScreenWidth() - w2 - w3;
                    int y = this.capability.getScreenHeight() * 6 / 7;
                    int h = this.capability.getScreenHeight() - y;

                    btns[0].bounds = new java.awt.Rectangle(0, y, w1, h);
                    btns[1].bounds = new java.awt.Rectangle(w1, y, w2, h);
                    btns[2].bounds = new java.awt.Rectangle(w1 + w2, y, w3, h);
                } else {
                    // The STU-300 is very shallow, so it is better to utilise
                    // the buttons to the side of the display instead.

                    int x = this.capability.getScreenWidth() * 3 / 4;
                    int w = this.capability.getScreenWidth() - x;

                    int h2 = this.capability.getScreenHeight() / 3;
                    int h3 = this.capability.getScreenHeight() / 3;
                    int h1 = this.capability.getScreenHeight() - h2 - h3;

                    btns[0].bounds = new java.awt.Rectangle(x, 0, w, h1);
                    btns[1].bounds = new java.awt.Rectangle(x, h1, w, h2);
                    btns[2].bounds = new java.awt.Rectangle(x, h1 + h2, w, h3);
                }
                btns[0].text = "OK";
                btns[1].text = "Clear";
                btns[2].text = "Cancel";
                btns[0].click = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            pressOkButton();
                        } catch (STUException e) {
                            // e
                        }
                    }
                };

                btns[1].click = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            pressClearButton();
                        } catch (STUException e) {
                            // e
                        }
                    }
                };

                btns[2].click = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            pressCancelButton();
                        } catch (STUException e) {
                            // e
                        }
                    }
                };

                byte encodingFlag = ProtocolHelper.simulateEncodingFlag(
                        this.tablet.getProductId(),
                        this.capability.getEncodingFlag());

                boolean useColor = ProtocolHelper
                        .encodingFlagSupportsColor(encodingFlag);

                // Disable color if the bulk driver isn't installed.
                // This isn't necessary, but uploading colour images with out
                // the driver
                // is very slow.
                useColor = useColor && this.tablet.supportsWrite();

                // Calculate the encodingMode that will be used to update the
                // image
                if (useColor) {
                    if (this.tablet.supportsWrite()) {
                        this.encodingMode = EncodingMode.EncodingMode_16bit_Bulk;
                    } else {
                        this.encodingMode = EncodingMode.EncodingMode_16bit;
                    }
                } else {
                    this.encodingMode = EncodingMode.EncodingMode_1bit;
                }

                // Size the bitmap to the size of the LCD screen.
                // This application uses the same bitmap for both the screen and
                // client (window).
                // However, at high DPI, this bitmap will be stretch and it
                // would be better to
                // create individual bitmaps for screen and client at native
                // resolutions.
                this.bitmap = new BufferedImage(
                        this.capability.getScreenWidth(),
                        this.capability.getScreenHeight(),
                        BufferedImage.TYPE_INT_RGB);
                {
                    Graphics2D gfx = bitmap.createGraphics();
                    gfx.setColor(Color.WHITE);
                    gfx.fillRect(0, 0, bitmap.getWidth(), bitmap.getHeight());

                    double fontSize = (this.btns[0].bounds.getHeight() / 2.0); // pixels
                    gfx.setFont(new Font("Serif", Font.PLAIN, (int) fontSize));

                    // Draw the buttons
                    for (Button btn : this.btns) {
                        if (useColor) {
                            gfx.setColor(Color.LIGHT_GRAY);
                            gfx.fillRect((int) btn.bounds.getX(),
                                    (int) btn.bounds.getY(),
                                    (int) btn.bounds.getWidth(),
                                    (int) btn.bounds.getHeight());
                        }
                        gfx.setColor(Color.BLACK);
                        gfx.drawRect((int) btn.bounds.getX(),
                                (int) btn.bounds.getY(),
                                (int) btn.bounds.getWidth(),
                                (int) btn.bounds.getHeight());
                        drawCenteredString(gfx, btn.text,
                                (int) btn.bounds.getX(),
                                (int) btn.bounds.getY(),
                                (int) btn.bounds.getWidth(),
                                (int) btn.bounds.getHeight());
                    }

                    gfx.dispose();
                }

                // Now the bitmap has been created, it needs to be converted to
                // device-native
                // format.
                this.bitmapData = ProtocolHelper.flatten(this.bitmap,
                        this.bitmap.getWidth(), this.bitmap.getHeight(),
                        useColor);

                // If you wish to further optimize image transfer, you can
                // compress the image using
                // the Zlib algorithm.
                boolean useZlibCompression = false;

                if (!useColor && useZlibCompression) {
                    // m_bitmapData = compress_using_zlib(m_bitmapData); //
                    // insert compression here!
                    // m_encodingMode = EncodingMode.EncodingMode_1bit_Zlib;
                }

                // Add the delagate that receives pen data.
                this.tablet.addTabletHandler(this);

                // Initialize the screen
                clearScreen();

                // Enable the pen data on the screen (if not already)
                this.tablet.setInkingMode(InkingMode.On);
            } catch (Throwable t) {
                if (this.tablet != null) {
                    this.tablet.disconnect();
                    this.tablet = null;
                }
                throw t;
            }
        }

        public void onGetReportException(STUException e) {
            JOptionPane.showMessageDialog(this, "Error:" + e,
                    "Error (onGetReportException)", JOptionPane.ERROR_MESSAGE);
            this.tablet.disconnect();
            this.tablet = null;
            this.penData = null;
            this.setVisible(false);
        }

        public void onUnhandledReportData(byte[] data) {
        }

        public void onPenData(PenData penData) {
            Point2D pt = tabletToScreen(penData);

            int btn = 0; // will be +ve if the pen is over a button.
            {
                for (int i = 0; i < this.btns.length; ++i) {
                    if (this.btns[i].bounds.contains(pt)) {
                        btn = i + 1;
                        break;
                    }
                }
            }

            boolean isDown = (penData.getSw() != 0);

            // This code uses a model of four states the pen can be in:
            // down or up, and whether this is the first sample of that state.
            if (isDown) {
                if (this.isDown == 0) {
                    // transition to down
                    if (btn > 0) {
                        // We have put the pen down on a button.
                        // Track the pen without inking on the client.

                        this.isDown = btn;
                    } else {
                        // We have put the pen down somewhere else.
                        // Treat it as part of the signature.

                        this.isDown = -1;
                    }
                } else {
                    // already down, keep doing what we're doing!
                    // draw
                    if (!this.penData.isEmpty() && this.isDown == -1) {
                        // Draw a line from the previous down point to this down
                        // point.
                        // This is the simplist thing you can do; a more
                        // sophisticated program
                        // can perform higher quality rendering than this!
                        Graphics2D gfx = (Graphics2D) this.panel.getGraphics();
                        drawInk(gfx, this.penData.get(this.penData.size() - 1),
                                penData);
                        gfx.dispose();
                    }

                }

                // The pen is down, store it for use later.
                if (this.isDown == -1) {
                    this.penData.add(penData);
                }
            } else {
                if (this.isDown != 0) {
                    // transition to up
                    if (btn > 0) {
                        // The pen is over a button

                        if (btn == this.isDown) {
                            // The pen was pressed down over the same button as
                            // is was lifted now.
                            // Consider that as a click!
                            this.btns[btn - 1].performClick();
                        }
                    }
                    this.isDown = 0;
                } else {
                    // still up
                }

                // Add up data once we have collected some down data.
                if (!this.penData.isEmpty()) {
                    this.penData.add(penData);
                }
            }

        }

        public void onPenDataOption(PenDataOption penDataOption) {
            onPenData(penDataOption);
        }

        public void onPenDataEncrypted(PenDataEncrypted penDataEncrypted) {
            onPenData(penDataEncrypted.getPenData1());
            onPenData(penDataEncrypted.getPenData2());
        }

        public void onPenDataEncryptedOption(
                PenDataEncryptedOption penDataEncryptedOption) {
            onPenData(penDataEncryptedOption.getPenDataOption1());
            onPenData(penDataEncryptedOption.getPenDataOption2());
        }

        public void onPenDataTimeCountSequence(
                PenDataTimeCountSequence penDataTimeCountSequence) {
            onPenData(penDataTimeCountSequence);
        }

        public void onPenDataTimeCountSequenceEncrypted(
                PenDataTimeCountSequenceEncrypted penDataTimeCountSequenceEncrypted) {
            onPenData(penDataTimeCountSequenceEncrypted);
        }

        public void onEncryptionStatus(EncryptionStatus encryptionStatus) {
        }

        public void onDevicePublicKey(DevicePublicKey devicePublicKey) {
        }

        public PenData[] getPenData() {
            if (this.penData != null) {
                PenData[] arrayPenData = new PenData[0];
                return this.penData.toArray(arrayPenData);
            }
            return null;
        }

        public Information getInformation() {
            if (this.penData != null) {
                return this.information;
            }
            return null;
        }

        public Capability getCapability() {
            if (this.penData != null) {
                return this.capability;
            }
            return null;
        }

    }

    BufferedImage signatureImage;
    JPanel imagePanel;

    private Point2D.Float tabletToClient(PenData penData, Capability capability, JPanel panel) {
        // Client means the panel coordinates.
        return new Point2D.Float((float) penData.getX()
                * panel.getWidth() / capability.getTabletMaxX(),
                (float) penData.getY() * panel.getHeight()
                / capability.getTabletMaxY());
    }

    private BufferedImage createImage(PenData[] penData, Capability capability, Information information) {
        BufferedImage bi = new BufferedImage(capability.getScreenWidth(), capability.getScreenHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g.setColor(new Color(0, 0, 64, 255));
        g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        for (int i = 1; i < penData.length; i++) {
            PenData p1 = penData[i];
            if (p1.getSw() != 0) {
                Point2D.Float pt1 = tabletToClient(penData[i - 1], capability, imagePanel);
                Point2D.Float pt2 = tabletToClient(penData[i], capability, imagePanel);
                Shape l = new Line2D.Float(pt1, pt2);
                g.draw(l);
            }
        }

        return bi;

    }

    private void onGetSignature() throws IOException {
        try {

            com.WacomGSS.STU.UsbDevice[] usbDevices = UsbDevice.getUsbDevices();

            if (usbDevices != null && usbDevices.length > 0) {
                SignatureDialog signatureDialog = new SignatureDialog(this,
                        usbDevices[0]);

                signatureDialog.setVisible(true);

                PenData[] penData = signatureDialog.getPenData();
                if (penData != null && penData.length > 0) {
                    // collected data!
                    this.signatureImage = createImage(penData,
                            signatureDialog.getCapability(),
                            signatureDialog.getInformation());
                    imagePanel.repaint();
                    ImageIO.write(signatureImage, "PNG", new File("c:/reports/filename.png"));
                    PDDocument doc = new PDDocument();
                    try {
                        PDPage page = new PDPage();
                        doc.addPage(page);

                        PDFont font = PDType1Font.TIMES_ROMAN;

                        PDPageContentStream contents = new PDPageContentStream(doc, page);
                        contents.beginText();
                        contents.setFont(font, 14);
                        contents.newLineAtOffset(60, 720);
                        contents.showText("SANLAM     Client Declaration");
                        contents.endText();
                        contents.close();
                        
                        PDPageContentStream contents2 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents2.beginText();
                        contents2.setFont(font, 10);
                        contents2.newLineAtOffset(30, 670);
                        contents2.showText("1 Notification is hereby given by FFS GROUP with regards to policy number " + member  + " that");
                        contents2.endText();
                        contents2.close();                        
                        PDPageContentStream contents3 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents3.beginText();
                        contents3.setFont(font, 10);
                        contents3.newLineAtOffset(30, 655);
                        contents3.showText("premiums for the current month are required to be paid before closure of the 7th business day of each");
                        contents3.endText();
                        contents3.close();       
                        PDPageContentStream contents4 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents4.beginText();
                        contents4.setFont(font, 10);
                        contents4.newLineAtOffset(30, 640);
                        contents4.showText("month, or policy benefits will be suspended and the policy may lapse.");
                        contents4.endText();
                        contents4.close();     
                        PDPageContentStream contents5 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents5.beginText();
                        contents5.setFont(font, 10);
                        contents5.newLineAtOffset(30, 610);
                        contents5.showText("2. The policy is currently in arrears and requies a double (2X) premium to be paid in order");
                        contents5.endText();
                        contents5.close();                          
                        PDPageContentStream contents6 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents6.beginText();
                        contents6.setFont(font, 10);
                        contents6.newLineAtOffset(30, 595);
                        contents6.showText("to bring the policy up to date and un-suspend the policy benefits.");
                        contents6.endText();
                        contents6.close(); 
                        PDPageContentStream contents7 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents7.beginText();
                        contents7.setFont(font, 10);
                        contents7.newLineAtOffset(30, 565);
                        contents7.showText("3. In the event that premiums can only be paid between the 8th and last day of the month, notification");
                        contents7.endText();
                        contents7.close();                         
                        PDPageContentStream contents8 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents8.beginText();
                        contents8.setFont(font, 10);
                        contents8.newLineAtOffset(30, 550);
                        contents8.showText("is given that such premiums must be in advance for the month to follow.");
                        contents8.endText();
                        contents8.close(); 
                        PDPageContentStream contents9 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents9.beginText();
                        contents9.setFont(font, 10);
                        contents9.newLineAtOffset(30, 520);
                        contents9.showText("4. The premium payer hereby declares that there is no outstanding claims in regards with un-reported");
                        contents9.endText();
                        contents9.close();                         
                        PDPageContentStream contents10 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents10.beginText();
                        contents10.setFont(font, 10);
                        contents10.newLineAtOffset(30, 505);
                        contents10.showText("deaths on this policy and FFS GROUP places on record that it receives the arrear premium for");
                        contents10.endText();
                        contents10.close();  
                        PDPageContentStream contents11 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents11.beginText();
                        contents11.setFont(font, 10);
                        contents11.newLineAtOffset(30, 490);
                        contents11.showText("the sole purpose of bringing the policy contributions up to date for policy benefits to be");
                        contents11.endText();
                        contents11.close();  
                        PDPageContentStream contents12 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
                        contents12.beginText();
                        contents12.setFont(font, 10);
                        contents12.newLineAtOffset(30, 475);
                        contents12.showText("un-suspended and be made active from the date and time the premium was received.");                        
                        contents12.endText();
                        contents12.close();                          

                        
//                        PDPageContentStream contents12 = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, false);
//                        contents12.beginText();
//                        contents12.setFont(font, 10);
//                        contents12.newLineAtOffset(30, 505);
//                        contents12.showText("un-suspended and be made active from the date and time the premium was received.");
//                        contents12.endText();
//                        contents12.close();                        

                        
                        PDImageXObject pdImage = PDImageXObject.createFromFile("c:/reports/filename.png", doc);
                        PDPageContentStream contents1 = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, false);

                        // draw the image at full size at (x=20, y=20)
                        contents1.drawImage(pdImage, 10, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);

                        
                        // to draw the image at half size at (x=20, y=20) use
                        // contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);
                        contents1.close();

                        doc.save("c:/reports/1.pdf");
                    } finally {
                        doc.close();
                    }
                }
                signatureDialog.dispose();

            } else {
                throw new RuntimeException("No USB tablets attached");
            }
        } catch (STUException e) {
            JOptionPane.showMessageDialog(this, e, "Error (STU)",
                    JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e, "Error (RT)",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public MemberReceiptPrint(String member) {
        this.setTitle("Member sign");
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton btn = new JButton("Get Signature");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    onGetSignature();
                } catch (IOException ex) {
                    Logger.getLogger(MemberReceiptPrint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panel.add(btn);
JLabel lbl1 = new JLabel(member);
panel.add(lbl1);

        imagePanel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics gfx) {
                super.paintComponent(gfx);
                if (signatureImage != null) {
                    double newHeight = ((double) signatureImage.getHeight() / signatureImage
                            .getWidth()) * this.getWidth();
                    Image rescaled = signatureImage.getScaledInstance(
                            this.getWidth(), (int) newHeight,
                            Image.SCALE_AREA_AVERAGING);
                    gfx.drawImage(rescaled, 0,
                            (int) ((this.getHeight() / 2) - (newHeight / 2)),
                            null);
                    File outputfile = new File("c:/reports/save.png");
                    try {
                        ImageIO.write(signatureImage, "PNG", new File("filename.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(MemberReceiptPrint.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };
        imagePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
                "Image", TitledBorder.LEADING, TitledBorder.TOP, null,
                Color.BLACK));
        imagePanel.setPreferredSize(new Dimension(300, 200));

        this.add(panel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.SOUTH);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void runProgram(String member) {
        MemberReceiptPrint sample = new MemberReceiptPrint(member);
        sample.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
              String member = "0";
              
                runProgram(member);
            }
        });
    }
}
