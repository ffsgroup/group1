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

@WebServlet("/DiaryUpdatePeople")
public class DiaryUpdatePeople extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DiaryUpdatePeople() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                UserAccount loginedUser = MyUtils.getLoginedUser(session);
                String tranid = request.getParameter("tranid"); 
                String userName = loginedUser.getUserName();
             String duser1 = request.getParameter("duser1");   
             String duser2 = request.getParameter("duser2");
             String duser3 = request.getParameter("duser3");
             String duser4 = request.getParameter("duser4");
             String duser5 = request.getParameter("duser5");
             String duser6 = request.getParameter("duser6");
             String duser7 = request.getParameter("duser7");
             String duser8 = request.getParameter("duser8");
             String duser9 = request.getParameter("duser9");
             String duser10 = request.getParameter("duser10");
             String resp1 = request.getParameter("resp1");
             String resp2 = request.getParameter("resp2");
             String resp3 = request.getParameter("resp3");
             String resp4 = request.getParameter("resp4");
             String resp5 = request.getParameter("resp5");
             String resp6 = request.getParameter("resp6");
             String resp7 = request.getParameter("resp7");
             String resp8 = request.getParameter("resp8");
             String resp9 = request.getParameter("resp9");
             String resp10 = request.getParameter("resp10");
             String fromuser = request.getParameter("fromuser");
                
        	ArrayList<Generics> generics =new ArrayList<Generics>();
                try {
		generics = DBUtils.SavePeople(conn, tranid, userName, duser1, duser2, duser3, duser4, duser5, duser6, duser7, duser8, duser9, duser10, resp1, resp2, resp3, resp4, resp5, resp6, resp7, resp8, resp9, resp10, fromuser);
                        } catch (SQLException e) {
            e.printStackTrace();
          //  errorString = e.getMessage();
        }
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(generics, new TypeToken<List<Generics>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
