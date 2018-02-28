package servlets;

import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsbeans.TaskImage;
import ffsutils.MyUtils;
import ffsutils.TaskUtils;
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

@WebServlet(urlPatterns = {"/TaskView.jsp"})
public class TaskDetail extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TaskDetail() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        
        
        String tranid = request.getParameter("key");
        if (tranid == null) {tranid = "0";}
        String link1 = request.getParameter("link");
        if (link1 == null) {link1 = "0";}
        System.out.println("TaskDetail " + tranid + " " + link1);
        ArrayList<Tasks> task = new ArrayList<Tasks>();
        try {
            task = TaskUtils.getTaskOne(conn, loginedUser, tranid);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }

        ArrayList<TaskImage> taskImage = new ArrayList<TaskImage>();
        try {
         taskImage = TaskUtils.getTaskImage(conn, loginedUser, tranid);
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
        String j = "";
        String k = "";
        String l = "";
        String m = "";
        String n = "";
        String o = "";
        String p = "";
        String q = "";
        String r = "";
        String s = "";
        String t = "";
        String u = "";
        String v = "";
        String w = "";
        String x = "";
        String y = "";
        String z = "";
        String aa = "";
        String ab = "";
        String ac = "";
        String ad = "";
        String ae = "";
        String af = "";
        String ag = "";
        String ah = "";
        String ai = "";
        String aj = "";
        String ak = "";
        String al = "";
        String am = "";
        String an = "";
        String ao = "";
        String ap = "";
        String aq = "";
        String ar = "";
        String as = "";
        String at = "";
        String au = "";
        String av = "";
        String aw = "";
        String ax = "";
        String ay = "";
        String az = "";
        String ba = "";
        String bb = "";
        String bc = "";
        String bd = "";
        String be = "";
        String bf = "";
        String bh = "";
        String bi = "";
        String bj = "";
        String bk = "";
        String bl = "";
        String bm = "";
        String bn = "";
        String bo = "";
        String bp = "";
        String bq = "";
        String br = "";
        String bs = "";
        String bt = "";
        String bg = "";
        String ti="";
        String ti1 ="";
        String l1 = "";
        String l2 = "";
        String l3 = "";
        String l4 = "";
        String l5 = "";
        String l6 = "";
        String l7 = "";
        String l8 = "";
        for (Tasks task1 : task) {
            a = task1.getTranid();
            b = "'" + task1.getDescription() + "'";
            c = task1.getTaskfrom();
            d = "'" + task1.getirnr() + "'";
            e = task1.getTaskdate();
            f = task1.getTaskfull();
            g = "'" + task1.getStartdate() + "'";
            h = "'" + task1.getRevdate() + "'";
            i = "'" + task1.getEnddate() + "'";
            j = "'" + task1.getTaskprior() + "'";
            k = "'" + task1.getTaskstat() + "'";
            l = task1.getStatusday();
            m = task1.getTasknote();
            n = "'" + task1.getrecurgam() + "'";
            o = task1.getRecur();
            p = task1.getRecura();
            q = "'" + task1.getRecurday() + "'";
            r = task1.getRecurd();
            s = "'" + task1.getRecurf() + "'";
            t = "'" + task1.getRecdayofweek() + "'";
            u = "'" + task1.getrecurb() + "'";
            v = "'" + task1.getRecurc() + "'";
            w = "'" + task1.getrecurg() + "'";
            x = "'" + task1.getRecure() + "'";
            y = "'" + task1.getrecurh() + "'";
            z = "'" + task1.getrecuri() + "'";
            aa = task1.getTaskto1();
            ab = task1.getTaskto2();
            ac = task1.getTaskto3();
            ad = task1.getTaskto4();
            ae = task1.getTaskto5();
            af = task1.getTaskto6();
            ag = task1.getTaskto7();
            ah = task1.getTaskto8();
            ai = task1.getTaskto9();
            aj = task1.getTaskto10();
            ak = task1.getTaskto11();
            al = task1.getTaskto12();
            am = task1.getTaskto13();
            an = task1.gettaskto14();
            ao = task1.getTaskto15();
            ap = task1.getTaskstat1();
            aq = task1.getTaskstat2();
            ar = task1.getTaskstat3();
            as = task1.getTaskstat4();
            at = task1.getTaskstat5();
            au = task1.getTaskstat6();
            av = task1.getTaskstat7();
            aw = task1.getTaskstat8();
            ax = task1.getTaskstat9();
            ay = task1.getTaskstat10();
            az = task1.getTaskstat11();
            ba = task1.getTaskstat12();
            bb = task1.getTaskstat13();
            bc = task1.getTaskstat14();
            bd = task1.getTaskstat15();
            be = task1.getStatusday1();
            bf = task1.getStatusday2();
            bh = task1.getStatusday3();
            bi = task1.getStatusday4();
            bj = task1.getStatusday5();
            bk = task1.getStatusday6();
            bl = task1.getStatusday7();
            bm = task1.getStatusday8();
            bn = task1.getStatusday9();
            bo = task1.getStatusday10();
            bp = task1.getStatusday11();
            bq = task1.getstatusday12();
            br = task1.getStatusday13();
            bs = task1.getStatusday14();
            bt = task1.getStatusday15();
            bg = task1.getTaskstat();
            l1 = task1.getlinkup1();
            l2 = task1.getlinkup2();
            l3 = task1.getlinkup3();
            l4 = task1.getlinkup4();
            l5 = task1.getlinkup5();
            l6 = task1.getlinkup6();
            l7 = task1.getlinkup7();
            l8 = task1.getlinkup8();
            ti1 = "'" + task1.getTrain() +"'";
        System.out.println("l1 " + l1);    
        }
       
        for (TaskImage taskImage1 : taskImage ) {
         ti = ti + "   <tr> <td style='min-width:120px; width:120px;border:1px solid black;'>" + taskImage1.getDateUp()+ "</td> <td style='min-width:180px; width:180px;border:1px solid black;'>" + taskImage1.getUser() + " </td> <td style='min-width:200px; width:200px;border:1px solid black;'> " + taskImage1.getImageDesc() + " </td > <td style='min-width:40px; width:40px;border:1px solid black;'>" + taskImage1.getTranid() + " </td></tr>";   
        }
        
        request.setAttribute("taskid", a);
        request.setAttribute("description", b);
        request.setAttribute("taskfrom", c);
        request.setAttribute("irnr", d);
        request.setAttribute("taskdate", e);
        request.setAttribute("taskfull", f);
        request.setAttribute("startdate", g);
        request.setAttribute("revdate", h);
        request.setAttribute("enddate", i);
        request.setAttribute("taskprior", j);
        request.setAttribute("taskstat", k);
        request.setAttribute("statusday", l);
        request.setAttribute("tasknotes", m);
        request.setAttribute("recureverymonths", n);
        request.setAttribute("recur", o);
        request.setAttribute("recura", p);
        request.setAttribute("recurday", q);
        request.setAttribute("recurd", r);
        request.setAttribute("recurf", s);
        request.setAttribute("recdayofweek", t);
        request.setAttribute("recurb", u);
        request.setAttribute("recurc", v);
        request.setAttribute("recurg", w);
        request.setAttribute("recure", x);
        request.setAttribute("recurh", y);
        request.setAttribute("recuri", z);
        request.setAttribute("taskto1", aa);
        request.setAttribute("taskto2", ab);
        request.setAttribute("taskto3", ac);
        request.setAttribute("taskto4", ad);
        request.setAttribute("taskto5", ae);
        request.setAttribute("taskto6", af);
        request.setAttribute("taskto7", ag);
        request.setAttribute("taskto8", ah);
        request.setAttribute("taskto9", ai);
        request.setAttribute("taskto10", aj);
        request.setAttribute("taskto11", ak);
        request.setAttribute("taskto12", al);
        request.setAttribute("taskto13", am);
        request.setAttribute("taskto14", an);
        request.setAttribute("taskto15", ao);
        request.setAttribute("taskstat1", ap);
        request.setAttribute("taskstat2", aq);
        request.setAttribute("taskstat3", ar);
        request.setAttribute("taskstat4", as);
        request.setAttribute("taskstat5", at);
        request.setAttribute("taskstat6", au);
        request.setAttribute("taskstat7", av);
        request.setAttribute("taskstat8", aw);
        request.setAttribute("taskstat9", ax);
        request.setAttribute("taskstat10", ay);
        request.setAttribute("taskstat11", az);
        request.setAttribute("taskstat12", ba);
        request.setAttribute("taskstat13", bb);
        request.setAttribute("taskstat14", bc);
        request.setAttribute("taskstat15", bd);
        request.setAttribute("statusday1", be);
        request.setAttribute("statusday2", bf);
        request.setAttribute("statusday3", bh);
        request.setAttribute("statusday4", bi);
        request.setAttribute("statusday5", bj);
        request.setAttribute("statusday6", bk);
        request.setAttribute("statusday7", bl);
        request.setAttribute("statusday8", bm);
        request.setAttribute("statusday9", bn);
        request.setAttribute("statusday10", bo);
        request.setAttribute("statusday11", bp);
        request.setAttribute("statusday12", bq);
        request.setAttribute("statusday13", br);
        request.setAttribute("statusday14", bs);
        request.setAttribute("train", ti1);
        request.setAttribute("statusday15", bt);
        request.setAttribute("taskstatus", bg);
        request.setAttribute("linkup1", l1);
        request.setAttribute("linkup2", l2);
        request.setAttribute("linkup3", l3);
        request.setAttribute("linkup4", l4);
        request.setAttribute("linkup5", l5);
        request.setAttribute("linkup6", l6);
        request.setAttribute("linkup7", l7);
        request.setAttribute("linkup8", l8);
        
        request.setAttribute("taskFiler", session.getAttribute("taskFilter"));
        request.setAttribute("linktask11", link1);
        
        request.setAttribute("taskimage", ti);
        
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/taskView.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
