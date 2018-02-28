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

@WebServlet("/MemberUpdateContact")
public class MemberUpdateContact extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberUpdateContact() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount userName = MyUtils.getLoginedUser(session);
        String thisMember = request.getParameter("thisMember");
        System.out.println("MemberUpdateContact " + thisMember);
        String padd1 = request.getParameter("padd1");
        String padd2 = request.getParameter("padd2");
        String padd3 = request.getParameter("padd3");
        String pcode = request.getParameter("pcode");
        String post1 = request.getParameter("post1");
        String post2 = request.getParameter("post2");
        String post3 = request.getParameter("post3");
        String postcode = request.getParameter("postcode");
        String phonecell = request.getParameter("phonecell");
        String phonework = request.getParameter("phonework");
        String phonehome = request.getParameter("phonehome");
        ArrayList<Generics> generics =new ArrayList<Generics>();
        try {
            generics = MemUtils.UpdateContact(conn, userName, thisMember, padd1, padd2, padd3, pcode, post1, post2, post3, postcode, phonecell, phonework, phonehome);
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
