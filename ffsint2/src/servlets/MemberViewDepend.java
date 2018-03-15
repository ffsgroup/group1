package servlets;

import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsbeans.MemberDepen;
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

@WebServlet(urlPatterns = {"/MemberViewDepend"})
public class MemberViewDepend extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberViewDepend() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        String tranid = request.getParameter("key");
        System.out.println("MemberViewDepend " + tranid);
        ArrayList<MemberDepen> depend = new ArrayList<MemberDepen>();
        try {
            depend = MemUtils.getOneDepen(conn, loginedUser, tranid);
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
        
        for (MemberDepen memberDepen1 : depend) {
            a = memberDepen1.getTranid();
            b = memberDepen1.getini();
            c = memberDepen1.getsur();
            d = memberDepen1.getsex();
            e = memberDepen1.getstatus();
            f = memberDepen1.getstatusdate();
            g = memberDepen1.getjoindate();
            h = memberDepen1.getgebdat();
            i = memberDepen1.getidno();
            j = memberDepen1.getlidno();
            k = memberDepen1.getverwskap();
            l = memberDepen1.getage();
        }

        String showDel = "";
        String showNee = "";
        String secure = (loginedUser.getsecurestr().substring(148, 149));  // from 0, secure[149] 

        request.setAttribute("tranid", a);
        request.setAttribute("ini", b);
        request.setAttribute("sur", c);
        request.setAttribute("sex", d);
        request.setAttribute("status", e);
        request.setAttribute("statusdate", f);
        request.setAttribute("joindate", g);
        request.setAttribute("gebdat", h);        
        request.setAttribute("idno", i);        
        request.setAttribute("lidno", j);        
        request.setAttribute("verwskap", k);  
        request.setAttribute("secur", l);  
        
        System.out.println("MemberViewDepend -" + k + "-" + d + "-" + e + "-" + f + "-" + l + "-");
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/memberDepen.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
