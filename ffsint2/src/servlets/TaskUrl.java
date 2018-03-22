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
        String taskD = (String) session.getAttribute("taskDisp");
        System.out.println("taskUrl " + taskView);
        System.out.println("current taskView " + taskView);
        String a = "";
        Integer b = 0;

        if (taskView == "taskUrgent" || taskView == "") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getUrgentTasks(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskTraining") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getTrainingTask(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskUpdated") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getUpdatedTasks(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskInFuture") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getTaskInFuture(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskNew") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getNewTask(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                a = a + "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
            }
        }

        if (taskView == "taskByMe") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getTaskByMe(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskToMeComp") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getTaskToMeComp(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskByMeComp") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getTaskByMeComp(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        if (taskView == "taskServlet") {
            ArrayList<Tasks> task = new ArrayList<Tasks>();
            try {
                task = TaskUtils.getTask(conn, loginedUser, taskFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Tasks task1 : task) {
                b++;
                String rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px;'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "black") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }

                if (task1.getlinkup1() == "green" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:teal'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "red" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(148,0,211)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                if (task1.getlinkup1() == "orange" && task1.getlinkup2() == "green") {
                    rowNew = "   <tr> <td style='min-width:50px; width:50px;color:teal;'>" + task1.getTranid() + "</td> <td style='min-width:200px; width:200px;'>" + task1.getTaskfrom() + " </td> <td style='min-width:220px; width:220px;'> " + task1.getDescription() + " </td > <td style='min-width:130px; width:130px; color:rgb(153,153,0)'>" + task1.getRevdate() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getEnddate() + " </td> <td style='min-width:90px; width:90px;'>" + task1.getTaskstat() + "  </td> <td style='min-width:130px; width:130px;'>" + task1.getStartdate() + "  </td></tr>";
                }
                a = a + rowNew;
            }
        }

        request.setAttribute("errorString", a);
        request.setAttribute("nrTask", b);
        //String taskDisp = "";
        //if (taskView.equals("taskUrgent")) {taskDisp = "8";}
        //if (taskView.equals("taskUpdated")) {taskDisp = "7";}
        //if (taskView.equals("taskInFuture")) {taskDisp = "3";}
        //if (taskView.equals("taskNew")) {taskDisp = "9";}
        //if (taskView.equals("taskByMe")) {taskDisp = "1";}
        //if (taskView.equals("taskToMeComp")) {taskDisp = "5";}
        //if (taskView.equals("taskByMeComp")) {taskDisp = "2";}
        //if (taskView.equals("taskServlet")) {taskDisp = "4";}
        //if (taskView.equals("taskTraining")) {taskDisp = "6";}
        
        request.setAttribute("taskD" , taskD );
        
        session.setAttribute("ViewedTasks", a);
        session.setAttribute("taskDisp", taskD);
        System.out.println("current taskView " + taskD);
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
