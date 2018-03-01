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
        String p1 = "";
        String p2 = "";
        String p3 = "";
        String p4 = "";
        String p5 = "";
        String p6 = "";
        String p7 = "";
        String p8 = "";
        String p9 = "";
        String p10 = "";
        String a1 = "";
        String a2 = "";
        String a3 = "";
        String a4 = "";
        String a5 = "";
        String a6 = "";
        String a7 = "";
        String a8 = "";
        String a9 = "";
        String a10 = "";
        String taskid = "";
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
            p1 = "'" + diary1.getuser1() + "'";
            p2 = "'" + diary1.getuser2() + "'";
            p3 = "'" + diary1.getuser3() + "'";
            p4 = "'" + diary1.getuser4() + "'";
            p5 = "'" + diary1.getuser5() + "'";
            p6 = "'" + diary1.getuser6() + "'";
            p7 = "'" + diary1.getuser7() + "'";
            p8 = "'" + diary1.getuser8() + "'";
            p9 = "'" + diary1.getuser9() + "'";
            p10 = "'" + diary1.getuser10() + "'";
            a1 = "'" + diary1.getuser1ans() + "'";
            a2 = "'" + diary1.getuser2ans() + "'";
            a3 = "'" + diary1.getuser3ans() + "'";
            a4 = "'" + diary1.getuser4ans() + "'";
            a5 = "'" + diary1.getuser5ans() + "'";
            a6 = "'" + diary1.getuser6ans() + "'";
            a7 = "'" + diary1.getuser7ans() + "'";
            a8 = "'" + diary1.getuser8ans() + "'";
            a9 = "'" + diary1.getuser9ans() + "'";
            a10 = "'" + diary1.getuser10ans() + "'";
            taskid = "'" + diary1.gettask() + "'";
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

            System.out.println("l1 " + taskid);
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
        request.setAttribute("p1", p1);
        request.setAttribute("p2", p2);
        request.setAttribute("p3", p3);
        request.setAttribute("p4", p4);
        request.setAttribute("p5", p5);
        request.setAttribute("p6", p6);
        request.setAttribute("p7", p7);
        request.setAttribute("p8", p8);
        request.setAttribute("p9", p9);
        request.setAttribute("p10", p10);
        request.setAttribute("a1", a1);
        request.setAttribute("a2", a2);
        request.setAttribute("a3", a3);
        request.setAttribute("a4", a4);
        request.setAttribute("a5", a5);
        request.setAttribute("a6", a6);
        request.setAttribute("a7", a7);
        request.setAttribute("a8", a8);
        request.setAttribute("a9", a9);
        request.setAttribute("a10", a10);
        request.setAttribute("dtask", taskid);
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
