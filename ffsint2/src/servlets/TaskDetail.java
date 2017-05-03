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
 
@WebServlet(urlPatterns = { "/TaskView.jsp" })
public class TaskDetail extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public TaskDetail() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      Connection conn = MyUtils.getStoredConnection(request);
       HttpSession session = request.getSession();
       UserAccount loginedUser = MyUtils.getLoginedUser(session);
   String tranid = request.getParameter("key");
 System.out.println("TaskDetail " + tranid);
 ArrayList<Tasks> task =new ArrayList<Tasks>();
                try {
		task=TaskUtils.getTaskOne(conn, loginedUser.getUserName(),tranid);
                        } catch (SQLException e) {
            e.printStackTrace();
          //  errorString = e.getMessage();
        }
         String a = "";
         String b = "";
        for (Tasks task1 : task) {       
                
                
         a = task1.getTranid();
         b = task1.getDescription();
        }
      request.setAttribute("taskid", a);  
      request.setAttribute("description",b);
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/TaskView.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}