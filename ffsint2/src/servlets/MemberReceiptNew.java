package servlets;

import ffsbeans.UserAccount;
import ffsbeans.MemberClaims;
import ffsbeans.MemberClaimDoc;
import ffsbeans.Member;

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

@WebServlet(urlPatterns = {"/MemberNewRec.jsp"})
public class MemberReceiptNew extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberReceiptNew() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        String thisMember = request.getParameter("key");
        System.out.println("MemberReceiptNew " + thisMember);
        
        Member member = new Member();
        // Member member = new Member();
        try {
            member = MemUtils.getMemberRecDetails(conn, loginedUser, thisMember);
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

        //for (Member member1 : member) {
        a = member.getinitialPayment();
        b = member.getshortname() + " " + member.getini() + " " + member.getsur();
        c = member.getbettot();
        d = member.getkrediet();        
        e = member.getlidno();
        f = member.getbranch();
        g = member.getpobox();
        h = member.getcity();
        i = member.getstatus();
        j = member.getemail();
        k = member.getkrediet();
        
        String showDel = "";
        String showNee = "";
        String secure = (loginedUser.getsecurestr().substring(148, 149));  // from 0, secure[149]         

        request.setAttribute("premium", a);
        request.setAttribute("name", b);
        request.setAttribute("bettot", c);
        request.setAttribute("credit", d);
        request.setAttribute("lidno", e);
        request.setAttribute("payment", f);
        request.setAttribute("amount", g);
        request.setAttribute("message1", h);
        request.setAttribute("status", i);
        request.setAttribute("canchange", j);
        request.setAttribute("credit", k);
        System.out.println("MemberReceiptNew status " + i);
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/memberReceiptNew.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
