package servlets;

import ffsbeans.UserAccount;
import ffsbeans.MemberClaims;
import ffsbeans.MemberClaimDoc;

import ffsutils.MyUtils;
import ffsutils.MemUtils;

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

@WebServlet(urlPatterns = {"/MemberClaimDetails.jsp"})
public class MemberClaimGetDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberClaimGetDetails() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        String tranid = request.getParameter("claim");
        System.out.println("MemberClaimGetDetails " + tranid);
        //ArrayList<MemberClaims> claimSumm = new ArrayList<MemberClaims>();
        MemberClaims claimSumm = new MemberClaims();
        try {
            claimSumm = MemUtils.getClaimDetails(conn, loginedUser, tranid);
        } catch (SQLException e) {
            e.printStackTrace();
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

//        for (MemberClaims memberClaim1 : claimSumm) {
        a = claimSumm.getClaimNr();
        b = claimSumm.getClaimDate();
        c = "'" + claimSumm.getDeceasedIni() + "'";
        d = "'" + claimSumm.getDeceasedSur() + "'";
        e = claimSumm.getDateOfDeath();
        f = claimSumm.getlidNo();
        g = claimSumm.getsummId();
        h = claimSumm.gettombNr();
        if (h.length() < 2) {
            h = "None";
        }
        i = "'" + claimSumm.getpolTipe() + "'";
        j = "'" + claimSumm.getBenefName() + "'";
        k = "'" + claimSumm.getBenefId() + "'";
        l = claimSumm.gettranId();
        m = "'" + claimSumm.getdeceasedId() + "'";
        n = claimSumm.getdecRel();
        o = "'" + claimSumm.getClaimSur() + "'";
        p = "'" + claimSumm.getClaimId() + "'";
        q =  claimSumm.getCause1();
        r = "'" + claimSumm.getclaimAm() + "'";
        s = "'" + claimSumm.getCause2() + "'";
        t = "'" + claimSumm.getClaimRel() + "'";
        u = "'" + claimSumm.getgrocery() + "'";
        v = "'" + claimSumm.getdateOfDeath() + "'";
        w = "'" + claimSumm.getclaimTel() + "'";
        x =  "'" + claimSumm.getcashFuneral() + "'";
        y =  "'" + claimSumm.getbank() + "'";
        z =  "'" + claimSumm.getclaimAdd1() + "'";
        aa = "'" + claimSumm.getfuneralAmount() + "'";
        ab = "'" + claimSumm.getbranchNr() + "'";
        ac = "'" + claimSumm.getclaimAdd2() + "'";
        ad = "'" + claimSumm.getmemAge() + "'";
        
        System.out.println("MemberClaimGetDetails " + x);
        if (x.equals('0')) {x = "Cash";} else {x="Funeral";}

        System.out.println("MemberClaimGetDetails " + claimSumm.getlidNo());

        String showDel = "";
        String showNee = "";
        String secure = (loginedUser.getsecurestr().substring(148, 149));  // from 0, secure[149]         

        request.setAttribute("claimnr", a);
        request.setAttribute("claimdate", b);
        request.setAttribute("ini", c);
        request.setAttribute("sur", d);
        request.setAttribute("dod", e);
        request.setAttribute("lidno", f);
        request.setAttribute("summid", g);
        request.setAttribute("tombnr", h);
        request.setAttribute("poltipe", i);
        request.setAttribute("benname", j);
        request.setAttribute("benid", k);
        request.setAttribute("tranid", l);
        request.setAttribute("decid", m);
        request.setAttribute("decrel", n);
        request.setAttribute("claimsur", o);
        request.setAttribute("claimerid", p);
        request.setAttribute("cause1", q);
        request.setAttribute("claimam", r);
        request.setAttribute("cause2", s);
        request.setAttribute("claimrel", t);
        request.setAttribute("grocery", u);
        request.setAttribute("deathdate", v);
        request.setAttribute("claimcell", w);
        request.setAttribute("claimtipe", x);
        request.setAttribute("bankname", y);
        request.setAttribute("address1", z);
        request.setAttribute("funam", aa);
        request.setAttribute("branchnr", ab);
        request.setAttribute("address2", ac);
        request.setAttribute("decage", ad);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/memberClaimDetails.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
