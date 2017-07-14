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
import ffsutils.TaskUtils;
import ffsutils.MyUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import ffsbeans.Generics;

@WebServlet("/TaskUpdate")
public class TaskUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TaskUpdate() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
                HttpSession session = request.getSession();
                UserAccount loginedUser = MyUtils.getLoginedUser(session);
                String tranid = request.getParameter("tranid"); 
                String recur1 = request.getParameter("recur1"); 
                String recur3 = request.getParameter("recur3"); 
                String recur4 = request.getParameter("recur4"); 
                String recur5 = request.getParameter("recur5"); 
                String recur6 = request.getParameter("recur6"); 
                String recur7 = request.getParameter("recur7"); 
                String recur8 = request.getParameter("recur8"); 
                String recur9 = request.getParameter("recur9"); 
                String recur10 = request.getParameter("recur10"); 
                String ir = request.getParameter("ir"); 
                String tasksumm = request.getParameter("tasksumm"); 
                String taskfull = request.getParameter("taskfull"); 
                String recur13 = request.getParameter("recur13"); 
                String recur11 = request.getParameter("recur11"); 
                String recur12 = request.getParameter("recur12"); 
                String sdate = request.getParameter("sdate"); 
                String rdate = request.getParameter("rdate"); 
                String edate = request.getParameter("edate"); 
                String prior = request.getParameter("prior"); 
                String stats = request.getParameter("stats"); 
                String recur2 = request.getParameter("recur2"); 
                String taskto1 = request.getParameter("taskto1"); 
                String taskto2 = request.getParameter("taskto2"); 
                String taskto3 = request.getParameter("taskto3"); 
                String taskto4 = request.getParameter("taskto4"); 
                String taskto5 = request.getParameter("taskto5"); 
                String taskto6 = request.getParameter("taskto6"); 
                String taskto7 = request.getParameter("taskto7"); 
                String taskto8 = request.getParameter("taskto8"); 
                String taskto9 = request.getParameter("taskto9"); 
                String taskto10 = request.getParameter("taskto10"); 
                String taskto11 = request.getParameter("taskto11"); 
                String taskto12 = request.getParameter("taskto12"); 
                String taskto13 = request.getParameter("taskto13"); 
                String taskto14 = request.getParameter("taskto14"); 
                String taskto15 = request.getParameter("taskto15"); 
                String fromUser = request.getParameter("fromUser"); 
                String irnr = request.getParameter("irnr"); 
                String requestir = request.getParameter("requestir"); 
                String train =  request.getParameter("train"); 
                
                System.out.println("TaskUpdate " + tranid + " " + recur1);
		ArrayList<Generics> generics =new ArrayList<Generics>();
                
                try {
		generics=TaskUtils.taskUpdate(conn, loginedUser, tranid, recur1, recur3, recur4,recur5,recur6,recur7,recur8,recur9,recur10, ir,tasksumm,taskfull, recur13, recur11,recur12,sdate,rdate,edate,prior,stats,recur2,taskto1,taskto2,taskto3,taskto4,taskto5,taskto6,taskto7,taskto8,taskto9,taskto10,taskto11,taskto12,taskto13,taskto14,taskto15, fromUser, train);
                        } catch (SQLException e) {
            e.printStackTrace();
            String errorString;
            errorString = e.getMessage();
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
