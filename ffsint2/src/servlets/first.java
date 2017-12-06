package servlets;

import java.applet.Applet;  
import java.awt.Graphics;  
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = {"/first"})
public class first extends Applet{  
  
public void paint(Graphics g){  
g.drawString("welcome",150,150);  
}  
  
}  