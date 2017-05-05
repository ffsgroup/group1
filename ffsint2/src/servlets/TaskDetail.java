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

@WebServlet(urlPatterns = {"/TaskView.jsp"})
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
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTaskOne(conn, loginedUser.getUserName(), tranid);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        String f = "";
        String g = "";
        String h = "";
        String i = "";
        String j = "";
        String k = "";
        String l = "";
        String m = "";
         String n = "";
        String o = "";
        String p = "";
         
        for (Tasks task1 : task) {

            a = task1.getTranid();
            b = "'" + task1.getDescription() + "'";
            c = task1.getTaskfrom();
            d = "'" + task1.getirnr() + "'";
            e = task1.getTaskdate();
            f = task1.getTaskfull();
            g = "'" + task1.getStartdate() + "'";
            h = "'" + task1.getRevdate() + "'";
            i = "'" + task1.getEnddate() + "'";
            j = "'" + task1.getTaskprior() + "'";
            k = "'" + task1.getTaskstat() + "'";
            l = task1.getStatusday(); 
            m = task1.getTasknote();
             n =  "'" + task1.getrecurgam() + "'";
             o = task1.getRecur();
             p = task1.getRecura();
        }
        request.setAttribute("taskid", a);
        request.setAttribute("description", b);
        request.setAttribute("taskfrom", c);
        request.setAttribute("irnr", d);
        request.setAttribute("taskdate", e);
        request.setAttribute("taskfull", f);
        request.setAttribute("startdate", g);
        request.setAttribute("revdate", h);
        request.setAttribute("enddate", i);
        request.setAttribute("taskprior", j);
        request.setAttribute("taskstat", k);
        request.setAttribute("statusday", l);
         request.setAttribute("tasknotes", m);
         request.setAttribute("recureverymonths", n);
         request.setAttribute("recur", o);
         request.setAttribute("recura", p);
  
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
