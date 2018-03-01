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
import ffsutils.DBUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import ffsbeans.Generics;

@WebServlet("/DiaryCreateNew")
public class DiaryCreateNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DiaryCreateNew() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                
                UserAccount loginedUser = MyUtils.getLoginedUser(session);
                String userName = loginedUser.getUserName();
                String diarysumm = request.getParameter("diarysumm"); 
                String startdate = request.getParameter("startdate");
                String enddate = request.getParameter("enddate");
                String locat = request.getParameter("locat");
                String diarytask = request.getParameter("diarytask");
                String diarynotes = request.getParameter("diarynotes");
                String duser1 = request.getParameter("diaryuser1");
                String duser2 = request.getParameter("diaryuser2");
                String duser3 = request.getParameter("diaryuser3");
                String duser4 = request.getParameter("diaryuser4");
                String duser5 = request.getParameter("diaryuser5");
                String duser6 = request.getParameter("diaryuser6");
                String duser7 = request.getParameter("diaryuser7");
                String duser8 = request.getParameter("diaryuser8");
                String duser9 = request.getParameter("diaryuser9");
                String duser10 = request.getParameter("diaryuser10");
                String resp1 = request.getParameter("response1");
                String resp2 = request.getParameter("response2");
                String resp3 = request.getParameter("response3");
                String resp4 = request.getParameter("response4");
                String resp5 = request.getParameter("response5");
                String resp6 = request.getParameter("response6");
                String resp7 = request.getParameter("response7");
                String resp8 = request.getParameter("response8");
                String resp9 = request.getParameter("response9");
                String resp10 = request.getParameter("response10");
                String fromuser = request.getParameter("fromuser");
                String tranid = request.getParameter("tranid");
                String completed = request.getParameter("complete");
                System.out.print("DiaryCreateNew " + completed);
                ArrayList<Generics> generics =new ArrayList<Generics>();
                try {
                generics = DBUtils.NewDiary(conn, tranid, loginedUser, diarysumm, startdate, enddate, locat, diarytask, diarynotes, duser1, duser2, duser3, duser4, duser5, duser6, duser7, duser8, duser9, duser10, resp1, resp2, resp3, resp4, resp5, resp6, resp7, resp8, resp9, resp10, fromuser, completed);
		
                
		//generics=DBUtils.AddDiaryResp(conn, loginedUser.getUserName(), thislocat);
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
