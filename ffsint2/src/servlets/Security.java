package servlets;

import ffsutils.SecureUtils;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.UserAccount;
import java.sql.Connection;
import ffsutils.MyUtils;
 
@WebServlet(urlPatterns = { "/Security.jsp" })
public class Security extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public Security() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();    
  UserAccount loginedUser = MyUtils.getLoginedUser(session);
 	ArrayList<UserAccount> users =new ArrayList<UserAccount>();
                try {
		users = SecureUtils.getAllUsers(conn, loginedUser.getUserName());
                        } catch (SQLException e) {
            e.printStackTrace();
          //  errorString = e.getMessage();
        }
        String a = "";
        for (UserAccount users1 : users) {       
                
                
         a = a+ "   <tr> <td style='min-width:200px; width:200px;'>"+ users1.getUserName()+ "</td> <td style='min-width:130px; width:130px;'>"+ users1.getcode()+ " </td> <td style='min-width:100px; width:100px;'> "+ users1.getbranch()+ " </td > <td style='min-width:45px; width:45px;'>"+ users1.getTranId()+ "  </td> </tr>";
        }  
      //System.out.println("userlist " + a);  
      request.setAttribute("errorString", a);  
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/security.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}