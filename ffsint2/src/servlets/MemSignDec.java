package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MemSignDec.jsp"})
public class MemSignDec extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MemSignDec() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String member = request.getParameter("member");
//        String amount = request.getParameter("amount");
        System.out.println("MemSignDec " + member);
        request.setAttribute("member", member);
//  request.setAttribute("amount", amount);
//        RequestDispatcher dispatcher = request.getServletContext()
//                .getRequestDispatcher("/WEB-INF/views/memSign.jsp");
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/resources/memSign.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
