package servlets;

import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsbeans.TaskImage;
import ffsbeans.Diary;
import ffsutils.MyUtils;
import ffsutils.TaskUtils;
import ffsutils.DBUtils;

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

@WebServlet(urlPatterns = {"/DiaryFromTask"})
public class DiaryFromTask extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DiaryFromTask() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        String tranid = request.getParameter("key");
        if (tranid == null) {
            tranid = "0";
        }

        System.out.println("DiaryFromTask " + tranid);
        ArrayList<Diary> diary = new ArrayList<Diary>();
        try {
            diary = DBUtils.getOneDiaryFromTask(conn, loginedUser, tranid);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }

        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        String f = "";
        String g = "";
        String h = "";
String i = "";
        for (Diary diary1 : diary) {
            a = diary1.getTranid();
            b = diary1.getUser();
            c = "'" + diary1.getDesc1() + "'";
            d = "'" + diary1.getsdate() + "'";
            e = "'" + diary1.getedate() + "'";
            f = "'" + diary1.getlocat() + "'";
            g = diary1.gettask();
            h = diary1.getnotes();
            i = diary1.getcomm();

            if (h == "undefined") {
                h = "";
            }
            if (h.length() > 0) {
                //   document.getElementById("diarycomment").value = "2"; 
                h = h.replace("~", "\n");
            }
            if (i == "undefined") {
                i = "";
            }
            if (i.length() > 0) {
                //   document.getElementById("diarycomment").value = "2"; 
                i = i.replace("~", "\n");
            }            

            System.out.println("l1 " + a);
        }

        request.setAttribute("getid", a);
        request.setAttribute("fuser", b);
        request.setAttribute("dsumm", c);
        request.setAttribute("sdate", d);
        request.setAttribute("edate", e);
        request.setAttribute("dlocat", f);
        request.setAttribute("dtask", tranid);
        request.setAttribute("dnotes", h);
        request.setAttribute("comm", i);
      
        request.setAttribute("taskFiler", session.getAttribute("taskFilter"));

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/diary.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
