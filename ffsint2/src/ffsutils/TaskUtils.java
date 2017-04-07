/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsutils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.Product;
import ffsbeans.Tasks;
import ffsbeans.Generics;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import ffsbeans.DiaryImag;
import ffsbeans.UserAccount;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author user149
 */
public class TaskUtils extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    public static ArrayList<Tasks> getTask(Connection conn, String Username) throws SQLException {
        String sql = "select tranid,Taskfrom,Description,revdate,enddate,statusday,startdate, from tasks where taskto1 = ? or taskto2 = ? or taskto3 = ? or taskto4 = ?  or taskto5 = ? or taskto6 = ? or taskto6 = ? or taskto8 = ? or taskto9 = ? or taskto10 = ? or taskto11 = ? or taskto12 = ? or taskto13 = ? or taskto14 = ? or taskto15 = ? limit 10";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, Username);
        pstm.setString(2, Username);
        pstm.setString(3, Username);
        pstm.setString(4, Username);
        pstm.setString(5, Username);
        pstm.setString(6, Username);
        pstm.setString(7, Username);
        pstm.setString(8, Username);
        pstm.setString(9, Username);
        pstm.setString(10, Username);
        pstm.setString(11, Username);
        pstm.setString(12, Username);
        pstm.setString(13, Username);
        pstm.setString(14, Username);
        pstm.setString(15, Username);
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
            String tranid = rs.getString("tranid");
            Tasks task = new Tasks();
            task.setTranid(tranid);
          
            list.add(task);
        }
        return list;
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaskUtils</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaskUtils at " + request.getContextPath() + "</h1>");
            out.println("</body>");
   
         out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
