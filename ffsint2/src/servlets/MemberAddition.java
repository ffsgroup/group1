package servlets;

import ffsbeans.MemberExtraPol;
import ffsbeans.UserAccount;
import ffsbeans.Generics;
import ffsbeans.MemberClaims;
import ffsbeans.MemberClaimDoc;

import ffsutils.MyUtils;
import ffsutils.MemUtils;
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

@WebServlet(urlPatterns = {"/MemberAddition"})
public class MemberAddition extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberAddition() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        
        String tranid = request.getParameter("key");
        System.out.println("MemberAddition " + tranid);
        ArrayList<MemberExtraPol> memAdd = new ArrayList<MemberExtraPol>();
        try {
            memAdd = MemUtils.getMemberExtraPol(conn, tranid, loginedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String a= "";
        String b= "";
        String c= "";
        String d= "";
        String e= "";
        String f= "";
        String g= "";
        String h= "";
        String i= "";
        String j= "";
        
        for (MemberExtraPol memAdd1 : memAdd) {
            System.out.println("MemberAddition pol1 " + memAdd1.getSecPol1() );
            a=memAdd1.getSecPol1();
            b=memAdd1.getSecPol2();
            c=memAdd1.getSecPol3();
            d=memAdd1.getSecPol4();
            e=memAdd1.getSecPol5();
            f=memAdd1.getSecPol6();
            g=memAdd1.getSecPol7();
            h=memAdd1.getSecPol8();
            i=memAdd1.getSecPol9();
            j=memAdd1.getSecPol10();
        }
        
        String secure = (loginedUser.getsecurestr().substring(148,149) ) ;  // from 0, secure[149] 

        request.setAttribute("pol1", a);
        request.setAttribute("pol2", b);
        request.setAttribute("pol3", c);
        request.setAttribute("pol4", d);
        request.setAttribute("pol5", e);
        request.setAttribute("pol6", f);
        request.setAttribute("pol7", g);
        request.setAttribute("pol8", h);
        request.setAttribute("pol9", i);
        request.setAttribute("pol10", j);        
        request.setAttribute("member", tranid);    
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/memberAddition.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
