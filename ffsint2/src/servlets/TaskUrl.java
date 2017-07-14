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

@WebServlet(urlPatterns = {"/TaskIndex.jsp"})
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
        String taskView = (String) session.getAttribute("taskView");
        String taskFilter = (String) session.getAttribute("taskFilter");
        System.out.println("current taskView " + taskView);
        String a = "";
      
        if (taskView == "taskUrgent" || taskView == "") {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getUrgentTasks(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskTraining")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTrainingTask(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskUpdated")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getUpdatedTasks(conn, loginedUser.getUserName(),taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskInFuture")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTaskInFuture(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskNew")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getNewTask(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskByMe")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTaskByMe(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskToMeComp")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTaskToMeComp(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskByMeComp")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTaskByMeComp(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
        }
        
        if (taskView == "taskServlet")  {
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTask(conn, loginedUser.getUserName(), taskFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Tasks task1 : task) {
            a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
        }
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
