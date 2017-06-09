package servlets;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsutils.TaskUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet("/TaskReportRole")
public class TaskReportRole extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskReportRole() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        String reportFor = request.getParameter("reportFor");
        String reportRole = request.getParameter("reportRole");
        System.out.println("TaskReportRole " + reportRole);
        try {
            task = TaskUtils.getReportRole(conn, loginedUser, reportFor, reportRole);
          // write file here ,, no written by takutils ??? 

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(task, new TypeToken<List<Tasks>>() {
        }.getType());
// redirect to another page >> taskreportdown.java ??


        JsonArray jsonArray = element.getAsJsonArray();
       response.setContentType("application/json");
        response.getWriter().print(jsonArray);

         
    }

    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    

}
