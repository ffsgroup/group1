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
            claimSumm = MemUtils.getClaimSumm(conn, loginedUser , tranid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        ArrayList<MemberClaimDoc> claimDoc = new ArrayList<MemberClaimDoc>();
        try {
         claimDoc = MemUtils.getClaimImage(conn, loginedUser, tranid);
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
        }
        
        String showDel = "";
        String showNee = "";
        String secure = (loginedUser.getsecurestr().substring(148,149) ) ;  // from 0, secure[149] 
        
        String z = "";
        for (MemberClaimDoc claimDoc1 : claimDoc) {          
          String docUser = claimDoc1.getdoc1User();
          String docDate = claimDoc1.getdoc1Date();
          if (docUser == null ) { docUser = "";
          docDate = "";
          }
          
          if (secure.equals("1") && !docUser.equals("") ) {
              showDel = "Delete";
          } else {showDel = "";}
          if (secure.equals("1") && docUser.equals("") ) {
              showNee = "Not Needed";
          } else {showNee = "";}
          if (claimDoc1.getdoc1().length() > 3) {
          z = z + "<tr> <td style='min-width:180px; width:180px;border:1px solid grey;border-collapse:collapse;'>" + claimDoc1.getdoc1()+ "</td> <td style='min-width:160px; width:160px;border:1px solid grey;border-collapse:collapse;'>" + docUser + "</td> <td style='min-width:160px; width:160px;border:1px solid grey;'> " + docDate + " </td> <td style='min-width:95px; width:95px;border:1px solid grey;border-collapse:collapse;'>" + showDel + " </td> <td style='min-width:95px; width:95px;border:1px solid grey;border-collapse:collapse;'>" + showNee + " </td></tr> ";             
          }         
        }
      
        request.setAttribute("taskenq", a);
        request.setAttribute("taskclaim", b);
        request.setAttribute("deceased", c);
        request.setAttribute("taskpay", d);
        request.setAttribute("decid", e);
        request.setAttribute("lidno", f);
        request.setAttribute("claimid", g);
        request.setAttribute("summid", h);
        
        request.setAttribute("docs", z);
        
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
