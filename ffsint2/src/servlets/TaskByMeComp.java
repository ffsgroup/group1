package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import javax.servlet.http.HttpSession;

@WebServlet("/TaskByMeComp")
public class TaskByMeComp extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskByMeComp() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String onlyUser = request.getParameter("onlyUser");
        System.out.println("TaskByMeComp " + onlyUser);
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        session.setAttribute("taskView", "taskByMeComp");
        session.setAttribute("taskFilter", onlyUser);
        session.setAttribute("taskDisp", "2");
        try {
            task = TaskUtils.getTaskByMeComp(conn, loginedUser.getUserName(), onlyUser);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(task, new TypeToken<List<Tasks>>() {
        }.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
