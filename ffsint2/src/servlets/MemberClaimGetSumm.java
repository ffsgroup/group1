package servlets;

import ffsbeans.Tasks;
import ffsbeans.UserAccount;
import ffsbeans.TaskImage;
import ffsutils.MyUtils;
import ffsutils.MemUtils;
import ffsutils.TaskUtils;
import ffsbeans.MemberClaims;
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

@WebServlet(urlPatterns = {"/MemberClaimSumm.jsp"})
public class MemberClaimGetSumm extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberClaimGetSumm() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        
        
        String tranid = request.getParameter("key");
        System.out.println("MemberClaimGetSumm " + tranid);
        ArrayList<MemberClaims> claimSumm = new ArrayList<MemberClaims>();
        try {
            claimSumm = MemUtils.getClaimSumm(conn, loginedUser.getUserName() , tranid);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }

        String a= "";
        String b= "";
        String c= "";
        String d= "";
        String e= "";
        String f= "";
        String g= "";
        String h= "";
        for (MemberClaims memberClaim1 : claimSumm) {
            a=memberClaim1.getClaimStatus();
            b=memberClaim1.getClaimNr();
            c=memberClaim1.getDeceasedIni();
            d=memberClaim1.getClaimSur();
            e=memberClaim1.getClaimId();
            f=memberClaim1.getClaimRel();
            g=memberClaim1.getBenefName();
            h=memberClaim1.getBenefId();
            
        System.out.println("Claimdet " + a);    
        }
      
        request.setAttribute("taskenq", a);
        request.setAttribute("taskclaim", b);
        request.setAttribute("deceased", c);
        request.setAttribute("taskpay", d);
        request.setAttribute("decid", e);
        request.setAttribute("lidno", f);
        request.setAttribute("claimid", g);
        request.setAttribute("summid", h);
        
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/memberClaimSum.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
