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
import ffsutils.TaskUtils;
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import ffsbeans.DiaryImag;
import ffsbeans.TaskImage;
import ffsbeans.UserAccount;
import javax.servlet.http.HttpSession;

@WebServlet("/TaskImage")
public class TaskImageGet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskImageGet() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String tranid = request.getParameter("tranid");
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        System.out.println("TaskImageGet " + tranid);
        ArrayList<TaskImage> taskImage = new ArrayList<TaskImage>();
        try {
            taskImage = TaskUtils.getTaskImage(conn,loginedUser, tranid);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(taskImage, new TypeToken<List<Diary>>() {
        }.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
