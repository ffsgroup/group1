package servlets;

import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsbeans.TaskImage;
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
        ArrayList<MemberClaims> claimSumm = new ArrayList<MemberClaims>();
        try {
            claimSumm = MemUtils.getClaimDetails(conn, loginedUser , tranid);
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
String k= "";

        for (MemberClaims memberClaim1 : claimSumm) {
            a=memberClaim1.getClaimNr();
            b=memberClaim1.getClaimDate();
            c=memberClaim1.getDeceasedIni();
            d=memberClaim1.getDeceasedSur();
            e=memberClaim1.getDateOfDeath();
            f=memberClaim1.getlidNo();
            g=memberClaim1.getsummId();
            h=memberClaim1.gettombNr();
            i=memberClaim1.getpolTipe();
            j=memberClaim1.getBenefName();
            k=memberClaim1.getBenefId();
            
            System.out.println("MemberClaimGetDetails " +memberClaim1.getlidNo() );
        }
       
        String showDel = "";
        String showNee = "";
        String secure = (loginedUser.getsecurestr().substring(148,149) ) ;  // from 0, secure[149]         
      
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
