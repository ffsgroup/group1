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
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import ffsbeans.Generics;
import ffsutils.MemUtils;

@WebServlet("/MemberUpdateNote")
public class MemberUpdateNote extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberUpdateNote() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount userName = MyUtils.getLoginedUser(session);
        String thisMember = request.getParameter("thisMember");
        System.out.println("MemberUpdateNote " + thisMember );
        String notedid = request.getParameter("notedid");
        String newnote = request.getParameter("newnote");        
        
        ArrayList<Generics> generics =new ArrayList<Generics>();
        try {
            generics = MemUtils.UpdateMemberNotes(conn, userName, thisMember, notedid, newnote);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
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
