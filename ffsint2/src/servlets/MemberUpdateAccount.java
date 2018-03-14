package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import ffsbeans.Diary;
import ffsbeans.UserAccount;
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import ffsbeans.Generics;
import ffsutils.MemUtils;

@WebServlet("/MemberUpdateAccount")
public class MemberUpdateAccount extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemberUpdateAccount() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount userName = MyUtils.getLoginedUser(session);
        String thisMember = request.getParameter("thisMember");
        System.out.println("MemberUpdateAccount " + thisMember + " m " + request.getParameter("paymeth") + " b " + request.getParameter("mbranch") );
        String joindat = request.getParameter("joindat");
        String claimdat = request.getParameter("claimdat");
        String coveramount = request.getParameter("coveramount");
        String bettot = request.getParameter("bettot");
        String paypoint = request.getParameter("paypoint");
        String benefname = request.getParameter("benefname");
        String benefid = request.getParameter("benefid");
        String benefrelation = request.getParameter("benefrelation");
        String benefdate = request.getParameter("benefdate");
        String mbranch = request.getParameter("mbranch");
        String paymeth = request.getParameter("paymeth");
        String accholder = request.getParameter("accholder");
        String accNo = request.getParameter("accNo");
        String deductDay = request.getParameter("deductDay");
        String bankName = request.getParameter("bankName");
        String accType = request.getParameter("accType");
        String debitdate = request.getParameter("debitdate");
        String branchNr = request.getParameter("branchNr");
        String groupScheme = request.getParameter("groupScheme");
        String empName1 = request.getParameter("empName1");
        String payerName = request.getParameter("payerName");
        String empName2 = request.getParameter("empName2");
        String payerId = request.getParameter("payerId");
        String stopOrderDate = request.getParameter("stopOrderDate");
        String salNr = request.getParameter("salNr");
        
        
        ArrayList<Generics> generics =new ArrayList<Generics>();
        try {
            generics = MemUtils.UpdateAccount(conn, userName, thisMember, joindat, claimdat, coveramount, bettot, paypoint, benefname, benefid, benefrelation, benefdate, mbranch, paymeth, accholder, accNo, deductDay, bankName, accType, debitdate, branchNr, groupScheme, empName1, payerName, empName2, payerId, stopOrderDate, salNr);
        } catch (SQLException e) {
            e.printStackTrace();
            //  errorString = e.getMessage();
        }
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(generics, new TypeToken<List<Generics>>() {
        }.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
