package servlets;
import ffsbeans.UserAccount;
import ffsbeans.DiaryImag;
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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

@WebServlet("/DiaryFileUploader")


public class DiaryFileUploader extends HttpServlet {
   private static final long serialVersionUID = 1L; 
    public DiaryFileUploader() {
        
    }
    private final String UPLOAD_DIRECTORY = "C:/temp";
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
       String tranid = "0";
       String description = "";
       String filetype = "";
       FileItem thisfile = null;
      Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      String userName = loginedUser.getUserName();
      System.out.println("DiaryFileUploader " + userName   );           
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
                    if ("imageText".equals(item.getFieldName())) {
                        description = item.getString();                       
                    }
                    if ("tranId".equals(item.getFieldName())) {
                        tranid = item.getString();                       
                    }
                    
                    }
                 
                    
                }
                ArrayList<DiaryImag> diaryimag =new ArrayList<DiaryImag>();
  diaryimag = DBUtils.getDiaryUpImag(conn, tranid, loginedUser, description, filetype, thisfile);
 
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
