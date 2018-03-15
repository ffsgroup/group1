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

@WebServlet("/MemberUpdateDepend")
public class MemberUpdateDepend extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberUpdateDepend() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount userName = MyUtils.getLoginedUser(session);
        
        String thisMember = request.getParameter("thisMember");
        System.out.println("MemberUpdatedepend " + thisMember + " m-" + request.getParameter("mrelate1")+ "-,-" + request.getParameter("gend1") );
        String tranid = request.getParameter("tranid");
        String ini = request.getParameter("ini");
        String sur = request.getParameter("sur");
        String idno = request.getParameter("idno");
        String bdate = request.getParameter("bdate");
        String joindate = request.getParameter("joindate");
        String mrelate1 = request.getParameter("mrelate1");
        String gend1 = request.getParameter("gend1");
        String stat1 = request.getParameter("stat1");
        String statdate1 = request.getParameter("statdate1");

        ArrayList<Generics> generics =new ArrayList<Generics>();
        try {
            generics = MemUtils.UpdateDepend(conn, userName, thisMember, tranid, ini, sur, idno, bdate, joindate, mrelate1, gend1, stat1, statdate1);
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
