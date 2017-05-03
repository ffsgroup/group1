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
import ffsbeans.UserAccount;
import ffsbeans.MemberRec;
import ffsutils.MyUtils;
import ffsutils.MemUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberGetRec")
public class MemberGetRec extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberGetRec() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                 String thisMember = request.getParameter("thisRec");                 
                 UserAccount loginedUser = MyUtils.getLoginedUser(session);
                 System.out.println("MemberGetRec " + thisMember);
		ArrayList<MemberRec> memberrecs =new ArrayList<MemberRec>();
                try {
		memberrecs=MemUtils.getMemberRec(conn, thisMember, loginedUser.getUserName());
                        } catch (SQLException e) {
            e.printStackTrace();
          //  errorString = e.getMessage();
        }
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(memberrecs, new TypeToken<List<MemberRec>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
