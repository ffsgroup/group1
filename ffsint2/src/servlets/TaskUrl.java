package servlets;

import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsutils.MyUtils;
import ffsutils.TaskUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet(urlPatterns = { "/TaskIndex.jsp" })
public class TaskUrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public TaskUrl() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
       
    
                Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                UserAccount loginedUser = MyUtils.getLoginedUser(session);
 	ArrayList<Tasks> task =new ArrayList<Tasks>();
                try {
		task=TaskUtils.getUrgentTasks(conn, loginedUser.getUserName());
                        } catch (SQLException e) {
            e.printStackTrace();
          //  errorString = e.getMessage();
        }
         String a = "";
        for (Tasks task1 : task) {       
                
                
         a = a+ "   <tr> <td style='min-width:50px; width:50px;'>"+ task1.getTranid()+ "</td> <td style='min-width:200px; width:200px;'>"+ task1.getTaskfrom()+ " </td> <td style='min-width:220px; width:220px;'> "+ task1.getDescription()+ " </td > <td style='min-width:130px; width:130px;'>"+ task1.getRevdate()+ "  </td> <td style='min-width:130px; width:130px;'>"+ task1.getEnddate()+ " </td> <td style='min-width:90px; width:90px;'>"+ task1.getTaskstat()+ "  </td> <td style='min-width:130px; width:130px;'>"+ task1.getStartdate()+ "  </td></tr>";
        }
                       request.setAttribute("errorString", a);
                 RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/taskIndex.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}