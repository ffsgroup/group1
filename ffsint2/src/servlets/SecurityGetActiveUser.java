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
import ffsbeans.Member;
import ffsbeans.UserAccount;
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import ffsutils.SecureUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

@WebServlet("/SecurityGetActiveUser")
public class SecurityGetActiveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecurityGetActiveUser() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                 System.out.println("SecurityGetActiveUser");
                 UserAccount loginedUser = MyUtils.getLoginedUser(session);
		ArrayList<UserAccount> users =new ArrayList<UserAccount>();
                try {
		users=SecureUtils.getAllActiveUser(conn, loginedUser);
                        } catch (SQLException e) {
            e.printStackTrace();
          //  errorString = e.getMessage();
        }
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(users, new TypeToken<List<Member>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
