package servlets;
import ffsbeans.UserAccount;
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DiaryCreate")
public class DiaryCreate extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:/temp";
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String tranid = "0";
       String diarysumm = "";
       String startdate = "";
       String enddate = "";
       String filetype = "";
       String diarytask = "";
       String diarynotes = "";
       String locat = "";
       String duser1 = "";
       String duser2 = "";
       String duser3 = "";
       String duser4 = "";
       String duser5 = "";
       String duser6 = "";
       String duser7 = "";
       String duser8 = "";
       String duser9 = "";
       String duser10 = "";
       String resp1 = "";
       String resp2 = "";
       String resp3 = "";
       String resp4 = "";
       String resp5 = "";
       String resp6 = "";
       String resp7 = "";
       String resp8 = "";
       String resp9 = "";
       String resp10 = "";
       String fromuser = "";
       
       FileItem thisfile = null;
      Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      String userName = loginedUser.getUserName();
      System.out.println("User " + userName + " start file upload "  );           
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        
                        char a = name.charAt(name.length()-4);
                        if (a == '.') { filetype = name.substring(name.length()-4);}
                        char c = name.charAt(name.length()-5);
                        if (c == '.') { filetype = name.substring(name.length()-5);}
                        
                      //  item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        thisfile = item;
                    } else {

                     System.out.println( "Field " + item.getFieldName() + 
                    " with value: " + item.getString() );
                    if ("diarysumm".equals(item.getFieldName())) {
                        diarysumm = item.getString();                       
                    }
                    if ("tranId".equals(item.getFieldName())) {
                        tranid = item.getString();                       
                    }
                    if ("startdate".equals(item.getFieldName())) {
                        startdate = item.getString();                       
                    }
                    if ("enddate".equals(item.getFieldName())) {
                        enddate = item.getString();                       
                    }
                    if ("locat".equals(item.getFieldName())) {
                        locat = item.getString();                       
                    }
                    if ("diarytask".equals(item.getFieldName())) {
                        diarytask = item.getString();                       
                    }
                    if ("diarynotes".equals(item.getFieldName())) {
                        diarynotes = item.getString();                       
                    }
                    if ("duser1".equals(item.getFieldName())) {
                        duser1 = item.getString();                       
                    }
                    if ("duser2".equals(item.getFieldName())) {
                        duser2 = item.getString();                       
                    }
                    if ("duser3".equals(item.getFieldName())) {
                        duser3 = item.getString();                       
                    }
                    if ("duser4".equals(item.getFieldName())) {
                        duser4 = item.getString();                       
                    }
                    if ("duser5".equals(item.getFieldName())) {
                        duser5 = item.getString();                       
                    }
                    if ("duser6".equals(item.getFieldName())) {
                        duser6 = item.getString();                       
                    }
                    if ("duser7".equals(item.getFieldName())) {
                        duser7 = item.getString();                       
                    }
                    if ("duser8".equals(item.getFieldName())) {
                        duser8 = item.getString();                       
                    }
                    if ("duser9".equals(item.getFieldName())) {
                        duser9 = item.getString();                       
                    }
                    if ("duser10".equals(item.getFieldName())) {
                        duser10 = item.getString();                       
                    }
                    if ("resp1".equals(item.getFieldName())) {
                        resp1 = item.getString();                       
                    }
                    if ("resp2".equals(item.getFieldName())) {
                        resp2 = item.getString();                       
                    }
                    if ("resp3".equals(item.getFieldName())) {
                        resp3 = item.getString();                       
                    }
                    if ("resp4".equals(item.getFieldName())) {
                        resp4 = item.getString();                       
                    }
                    if ("resp5".equals(item.getFieldName())) {
                        resp5 = item.getString();                       
                    }
                    if ("resp6".equals(item.getFieldName())) {
                        resp6 = item.getString();                       
                    }
                    if ("resp7".equals(item.getFieldName())) {
                        resp7 = item.getString();                       
                    }
                    if ("resp8".equals(item.getFieldName())) {
                        resp8 = item.getString();                       
                    }
                    if ("resp9".equals(item.getFieldName())) {
                        resp9 = item.getString();                       
                    }
                    if ("resp10".equals(item.getFieldName())) {
                        resp10 = item.getString();                       
                    }
                    if ("fromuser".equals(item.getFieldName())) {
                        fromuser = item.getString();                       
                    }
                    
                    }
                 
                    
                }
 DBUtils.NewDiary(conn, tranid, loginedUser, diarysumm, startdate, enddate, locat, diarytask, diarynotes, duser1, duser2, duser3, duser4, duser5, duser6, duser7, duser8, duser9, duser10, resp1, resp2, resp3, resp4, resp5, resp6, resp7, resp8, resp9, resp10, fromuser);
 
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/result.jsp").forward(request, response);
     
    }
  
}
