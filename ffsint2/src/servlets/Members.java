package servlets;

import ffsutils.MemUtils;
import ffsbeans.Member;
import ffsbeans.UserAccount;
import ffsutils.MyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet(urlPatterns = { "/Members.jsp" })
public class Members extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public Members() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      		Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                UserAccount loginedUser = MyUtils.getLoginedUser(session);
                
                String currentMember = (String) session.getAttribute("currentMember");
                ArrayList<Member> member = new ArrayList<Member>();
                try {
                 member=MemUtils.getMember(conn, currentMember, loginedUser);}
                    catch (SQLException e) {
                    e.printStackTrace();
                    }
                
             String a = "";   
             String b = "";   
              for (Member member1 : member) {
            a = member1.getlidno();
            b = member1.getsur();
              }  
     request.setAttribute("lidno", a);
     request.setAttribute("sur", b);
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/members.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}