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

@WebServlet("/TaskSendEmail")
public class TaskSendEmail extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskSendEmail() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        String tranid = request.getParameter("tranid");
        String mailto = request.getParameter("mailto");
        String mailcontent = request.getParameter("mailcontent");       
        if (mailto == null) { mailto = "1";}
        if (mailto.length() < 5) {mailto = "1";}
        System.out.println("TaskSendEmail " + tranid + " " + loginedUser.getUserName() );
        ArrayList<Generics> generics = new ArrayList<Generics>();
        try {
            generics = TaskUtils.taskEmailSend(conn, loginedUser, tranid, mailto, mailcontent); 
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
