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

@WebServlet(urlPatterns = {"/doTaskMyIdea.jsp"})
public class TaskMyIdea extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskMyIdea() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        System.out.println("TaskMyIdea");
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
       // ArrayList<String> idea1 = new ArrayList<String>();\
       String idea1 = "";
        try {
            idea1 = TaskUtils.getTaskIdea(conn, loginedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("myIdea", idea1);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/taskMyIdea.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
