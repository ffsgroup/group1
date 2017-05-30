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
import ffsbeans.Diary;
import ffsbeans.UserAccount;
import ffsutils.TaskUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import ffsbeans.Generics;

@WebServlet("/TaskUpdatePeople")
public class TaskUpdatePeople extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskUpdatePeople() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        String tranid = request.getParameter("tranid");
        String user1 = request.getParameter("user1");
        String user2 = request.getParameter("user2");
        String user3 = request.getParameter("user3");
        String user4 = request.getParameter("user4");
        String user5 = request.getParameter("user5");
        String user6 = request.getParameter("user6");
        String user7 = request.getParameter("user7");
        String user8 = request.getParameter("user8");
        String user9 = request.getParameter("user9");
        String user10 = request.getParameter("user10");
        String user11 = request.getParameter("user11");
        String user12 = request.getParameter("user12");
        String user13 = request.getParameter("user13");
        String user14 = request.getParameter("user14");
        String user15 = request.getParameter("user15");

        System.out.println("TaskUpdatepeople " + tranid);
        ArrayList<Generics> generics = new ArrayList<Generics>();

        try {
            generics = TaskUtils.taskUpdatePeople(conn, loginedUser, tranid, user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12, user13, user14, user15); 
        } catch (SQLException e) {
            e.printStackTrace();
            String errorString;
            errorString = e.getMessage();
        }
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(generics, new TypeToken<List<Generics>>() {
        }.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
