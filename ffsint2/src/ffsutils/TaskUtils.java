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
    
    public static ArrayList<Tasks> getTrainingTask(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
      
    String sql = "select * from tasks where ((((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is null))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is null))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is null))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is null))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is null))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is null))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is null))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is null))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is null))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is null))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is null))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is null))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is null))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is null))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is null)))) or (taskfrom = ?))and (taskstat <> 'Completed') and (train = 'Y')";
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
       pstm.setString(16, Username);
       
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
            if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
               System.out.println("2 "+rs.getString("tranid"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        
        
        return list;
    }
    
    
    
    
    
    public static ArrayList<Tasks> getUrgentTasks(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

              cal.add(Calendar.DATE, 3);
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
            
             Date date1 = new Date();
            Calendar cal1 = Calendar.getInstance();

              cal1.add(Calendar.DATE, 4);
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
        
      
    String sql = "select * from tasks where (taskfrom = ?) and (taskstat <> 'Completed') and (revdate > '" + year + "/" + month + "/" + day + " 00:01') and (revdate < '" + year1 + "/" + month1 + "/" + day1 + " 23:59')";
        PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, Username);
   
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
             Date date10 = new Date();
            Calendar cal10 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
           if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
            String year10 = Integer.toString(cal10.get(Calendar.YEAR));
            String month10 = Integer.toString(cal10.get(Calendar.MONTH) + 1);
            String day10 = Integer.toString(cal10.get(Calendar.DAY_OF_MONTH));
            String hour10 = Integer.toString(cal10.get(Calendar.HOUR_OF_DAY));
            String minute10 = Integer.toString(cal10.get(Calendar.MINUTE));
            if (hour10.length() == 1 ){
                hour10 = "0" + hour10;
            } 
            if (minute10.length() == 1 ){
                minute10 = "0" + minute10;
            }
             if (month10.length() == 1 ){
                month10 = "0" + month10;
            }
              if (day10.length() == 1 ){
                day10 = "0" + day10;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        String sql1 = "select * from tasks where (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is null))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is null))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is null))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is null))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is null))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is null))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is null))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is null))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is null))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is null))) or((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is null))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is null))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is null))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is null))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is null)))) and (taskstat <> 'Completed') and (revdate > '" + year + "/" + month + "/" + day + " 00:01') and (revdate < '" + year1 + "/" + month1 + "/" + day1 + " 23:59')";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
    
         pstm1.setString(1, Username);
        pstm1.setString(2, Username);
        pstm1.setString(3, Username);
        pstm1.setString(4, Username);
        pstm1.setString(5, Username);
        pstm1.setString(6, Username);
      pstm1.setString(7, Username);
        pstm1.setString(8, Username);
        pstm1.setString(9, Username);
        pstm1.setString(10, Username);
        pstm1.setString(11, Username);
        pstm1.setString(12, Username);
        pstm1.setString(13, Username);
        pstm1.setString(14, Username);
        pstm1.setString(15, Username);
        
        ResultSet rs1 = pstm1.executeQuery();
      
        while (rs1.next()) {
             Date date11 = new Date();
            Calendar cal11 = new GregorianCalendar();


            cal1.setTime(rs1.getTimestamp("revdate"));
            String year11 = Integer.toString(cal11.get(Calendar.YEAR));
            String month11 = Integer.toString(cal11.get(Calendar.MONTH) + 1);
            String day11 = Integer.toString(cal11.get(Calendar.DAY_OF_MONTH));
            String hour11 = Integer.toString(cal11.get(Calendar.HOUR_OF_DAY));
            String minute11 = Integer.toString(cal11.get(Calendar.MINUTE));
            if (hour11.length() == 1 ){
                hour11 = "0" + hour11;
            } 
            if (minute11.length() == 1 ){
                minute11 = "0" + minute11;
            }
             if (month11.length() == 1 ){
                month11 = "0" + month11;
            }
              if (day11.length() == 1 ){
                day11 = "0" + day11;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs1.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs1.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs1.getString("tranid");
            String taskfrom = rs1.getString("taskfrom");
             String description = rs1.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs1.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
        
        return list;
    }
    
    
    
    
     public static ArrayList<Tasks> getUpdatedTasks(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
      
    String sql = "select * from tasks where (((taskstat1 <> 'Completed') or (taskstat1 is null)) and (taskto1 = ?) and (newt1 is null)) or (((taskstat2 <> 'Completed') or (taskstat2 is null)) and (taskto2 = ?) and (newt2 is null)) or (((taskstat3 <> 'Completed') or (taskstat3 is null)) and (taskto3 = ?) and (newt3 is null)) or(((taskstat4 <> 'Completed') or (taskstat4 is null)) and (taskto4 = ?) and (newt4 is null)) or (((taskstat5 <> 'Completed') or (taskstat5 is null)) and (taskto5 = ?) and (newt5 is null)) or (((taskstat6 <> 'Completed') or (taskstat6 is null)) and (taskto6 = ?) and (newt6 is null)) or (((taskstat7 <> 'Completed') or (taskstat7 is null)) and (taskto7 = ?) and (newt7 is null)) or (((taskstat8 <> 'Completed') or (taskstat8 is null)) and (taskto8 = ?) and (newt8 is null)) or (((taskstat9 <> 'Completed') or (taskstat9 is null)) and (taskto9 = ?) and (newt9 is null)) or (((taskstat11 <> 'Completed') or (taskstat11 is null)) and (taskto11 = ?) and (newt11 is null)) or (((taskstat12 <> 'Completed') or (taskstat12 is null)) and (taskto12 = ?) and (newt12 is null)) or (((taskstat13 <> 'Completed') or (taskstat12 is null)) and (taskto13 = ?) and (newt13 is null)) or (((taskstat14 <> 'Completed') or (taskstat14 is null)) and (taskto14 = ?) and (newt14 is null)) or (((taskstat15 <> 'Completed') or (taskstat15 is null)) and (taskto15 = ?) and (newt15 is null)) or (((taskstat10 <> 'Completed') or (taskstat10 is null)) and (taskto10 = ?) and (newt10 is null)) or (((taskstat <> 'Completed') or (taskstat is null)) and (taskfrom = ?) and (newtf is null))";
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
       pstm.setString(16, Username);
       
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
            if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
               System.out.println("2 "+rs.getString("tranid"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        
        
        return list;
    }
    
    
    
    
    
    public static ArrayList<Tasks> getTaskToMeComp(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
      
    String sql = "select * from tasks where (((taskto1 = ?) and (taskstat1 = 'Completed')) or ((taskto2 = ?) and (taskstat2 = 'Completed')) or ((taskto3 = ?) and (taskstat3 = 'Completed')) or ((taskto4 = ?) and (taskstat4 = 'Completed')) or ((taskto5 = ?) and (taskstat5 = 'Completed'))  or ((taskto6 = ?) and (taskstat6 = 'Completed'))  or ((taskto7 = ?) and (taskstat7 = 'Completed'))  or ((taskto8 = ?) and (taskstat8 = 'Completed')) or ((taskto9 = ?) and (taskstat9 = 'Completed'))  or ((taskto10 = ?) and (taskstat10 = 'Completed')) or ((taskto11 = ?) and (taskstat11 = 'Completed')) or ((taskto12 = ?) and (taskstat12 = 'Completed')) or ((taskto13 = ?) and (taskstat13 = 'Completed')) or ((taskto14 = ?) and (taskstat14 = 'Completed')) or ((taskto15 = ?) and (taskstat15 = 'Completed')) )  and (recur = '0')";
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
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
           if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        String sql1 = "select * from tasks where (recur =1) and (((taskto1 = ?) and ((taskstat1 = 'Completed') or (recurdate1 > enddate))) or((taskto2 = ?) and ((taskstat2 = 'Completed') or (recurdate2 > enddate))) or((taskto3 = ?) and ((taskstat3 = 'Completed') or (recurdate3 > enddate))) or((taskto4 = ?) and ((taskstat4 = 'Completed') or (recurdate4 > enddate))) or ((taskto5 = ?) and ((taskstat5 = 'Completed') or (recurdate5 > enddate))) or ((taskto6 = ?) and ((taskstat6 = 'Completed') or (recurdate6 > enddate))) or ((taskto7 = ?) and ((taskstat7 = 'Completed') or (recurdate7 > enddate))) or ((taskto8 = ?) and ((taskstat8 = 'Completed') or (recurdate8 > enddate))) or((taskto9 = ?) and ((taskstat9 = 'Completed') or (recurdate9 > enddate))) or ((taskto11 = ?) and ((taskstat11 = 'Completed') or (recurdate11 > enddate))) or ((taskto12 = ?) and ((taskstat12 = 'Completed') or (recurdate12 > enddate))) or ((taskto13 = ?) and ((taskstat13 = 'Completed') or (recurdate13 > enddate))) or ((taskto14 = ?) and ((taskstat14 = 'Completed') or (recurdate14 > enddate))) or ((taskto15 = ?) and ((taskstat15 = 'Completed') or (recurdate15 > enddate))) or ((taskto10 = ?) and ((taskstat10 = 'Completed') or (recurdate10 > enddate))))";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
    
         pstm1.setString(1, Username);
        pstm1.setString(2, Username);
        pstm1.setString(3, Username);
        pstm1.setString(4, Username);
        pstm1.setString(5, Username);
        pstm1.setString(6, Username);
      pstm1.setString(7, Username);
        pstm1.setString(8, Username);
        pstm1.setString(9, Username);
        pstm1.setString(10, Username);
        pstm1.setString(11, Username);
        pstm1.setString(12, Username);
        pstm1.setString(13, Username);
        pstm1.setString(14, Username);
        pstm1.setString(15, Username);
        
        ResultSet rs1 = pstm1.executeQuery();
      
        while (rs1.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();


            cal1.setTime(rs1.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs1.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs1.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs1.getString("tranid");
            String taskfrom = rs1.getString("taskfrom");
             String description = rs1.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs1.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
        
        return list;
    }
    
    
    
    public static ArrayList<Tasks> getNewTask(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
      
    String sql = "select * from tasks where ((taskstat <> 'Completed') or (taskstat is null)) and (((taskstat1 <> 'Completed') or (taskstat1 is null)) and (taskto1 = ?) and (comadd1 is null)) or (((taskstat2 <> 'Completed') or (taskstat2 is null)) and (taskto2 = ?) and (comadd2 is null)) or (((taskstat3 <> 'Completed') or (taskstat3 is null)) and (taskto3 = ?) and (comadd3 is null)) or (((taskstat4 <> 'Completed') or (taskstat4 is null)) and (taskto4 = ?) and (comadd4 is null)) or (((taskstat5 <> 'Completed') or (taskstat5 is null)) and (taskto5 = ?) and (comadd5 is null)) or (((taskstat6 <> 'Completed') or (taskstat6 is null)) and (taskto6 = ?) and (comadd6 is null)) or (((taskstat7 <> 'Completed') or (taskstat7 is null)) and (taskto7 = ?) and (comadd7 is null)) or (((taskstat8 <> 'Completed') or (taskstat8 is null)) and (taskto8 = ?) and (comadd8 is null)) or (((taskstat9 <> 'Completed') or (taskstat9 is null)) and (taskto9 = ?) and (comadd9 is null)) or (((taskstat11 <> 'Completed') or (taskstat11 is null)) and (taskto11 = ?) and (comadd11 is null)) or (((taskstat12 <> 'Completed') or (taskstat12 is null)) and (taskto12 = ?) and (comadd12 is null)) or (((taskstat13 <> 'Completed') or (taskstat13 is null)) and (taskto13 = ?) and (comadd13 is null)) or (((taskstat14 <> 'Completed') or (taskstat14 is null)) and (taskto14 = ?) and (comadd14 is null)) or (((taskstat15 <> 'Completed') or (taskstat15 is null)) and (taskto15 = ?) and (comadd15 is null)) or (((taskstat10 <> 'Completed') or (taskstat10 is null)) and (taskto10 = ?) and (comadd10 is null)) or (((taskstat <> 'Completed') or (taskstat is null)) and (taskfrom = ?) and (comaddf is null)) ";
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
       pstm.setString(16, Username);
       
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
            if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
               System.out.println("2 "+rs.getString("tranid"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        
        
        return list;
    }
    
    
    
    
    public static ArrayList<Tasks> getTaskByMeComp(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
       // String sql = "select tranid,Taskfrom,Description,revdate,enddate,statusday,startdate from tasks where taskto1 = ? or taskto2 = ? or taskto3 = ? or taskto4 = ?  or taskto5 = ? or taskto6 = ? or taskto6 = ? or taskto8 = ? or taskto9 = ? or taskto10 = ? or taskto11 = ? or taskto12 = ? or taskto13 = ? or taskto14 = ? or taskto15 = ?  limit 10";
    String sql = "select * from tasks where (taskfrom = ?) and (taskstat = 'Completed')";
        PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, Username);
        
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
            if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
               System.out.println("2 "+rs.getString("tranid"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        
        
        return list;
    }
   
    
    
    
    
        public static ArrayList<Tasks> getTaskInFuture(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
       // String sql = "select tranid,Taskfrom,Description,revdate,enddate,statusday,startdate from tasks where taskto1 = ? or taskto2 = ? or taskto3 = ? or taskto4 = ?  or taskto5 = ? or taskto6 = ? or taskto6 = ? or taskto8 = ? or taskto9 = ? or taskto10 = ? or taskto11 = ? or taskto12 = ? or taskto13 = ? or taskto14 = ? or taskto15 = ?  limit 10";
    String sql = "select * from tasks where (startdate > '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and ( recur = '0') and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)))) and (taskstat <> 'Completed')";
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
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            System.out.println("1 "+rs.getString("tranid"));
            System.out.println("3 "+rs.getTimestamp("revdate"));
           if (rs.getTimestamp("revdate")== null) {
             cal1.setTime(rs.getTimestamp("startdate"));
        }
           else
           {
            cal1.setTime(rs.getTimestamp("revdate"));       
                   }
             System.out.println("2 "+rs.getString("tranid"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        String sql1 = "select * from tasks where (recur =1) and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL)) and (RECURDATE1 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate1 < enddate)) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL)) and (RECURDATE2 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate2 < enddate)) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL)) and (RECURDATE3 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate3 < enddate)) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL)) and (RECURDATE4 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate4 < enddate)) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL)) and (RECURDATE5 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate5 < enddate)) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL)) and (RECURDATE6 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate6 < enddate)) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL)) and (RECURDATE7 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate7 < enddate)) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL)) and (RECURDATE8 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate8 < enddate)) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL)) and (RECURDATE9 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate9 < enddate)) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL)) and (RECURDATE11 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate11 < enddate)) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL)) and (RECURDATE12 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate12 < enddate)) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL)) and (RECURDATE13 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate13 < enddate)) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL)) and (RECURDATE14 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate14 < enddate)) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)) and (RECURDATE15 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate15 < enddate)) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)) and (RECURDATE10 >'" + year + "/" +month+ "/" + day + " " + hour + ":" + minute + ":00') and (recurdate10 < enddate)))";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
    
         pstm1.setString(1, Username);
        pstm1.setString(2, Username);
        pstm1.setString(3, Username);
        pstm1.setString(4, Username);
        pstm1.setString(5, Username);
        pstm1.setString(6, Username);
      pstm1.setString(7, Username);
        pstm1.setString(8, Username);
        pstm1.setString(9, Username);
        pstm1.setString(10, Username);
        pstm1.setString(11, Username);
        pstm1.setString(12, Username);
        pstm1.setString(13, Username);
        pstm1.setString(14, Username);
        pstm1.setString(15, Username);
        
        ResultSet rs1 = pstm1.executeQuery();
      
        while (rs1.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();


            cal1.setTime(rs1.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs1.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs1.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs1.getString("tranid");
            String taskfrom = rs1.getString("taskfrom");
             String description = rs1.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs1.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
        
        return list;
    }
    
    
    
    
    
    
    public static ArrayList<Tasks> getTask(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
       // String sql = "select tranid,Taskfrom,Description,revdate,enddate,statusday,startdate from tasks where taskto1 = ? or taskto2 = ? or taskto3 = ? or taskto4 = ?  or taskto5 = ? or taskto6 = ? or taskto6 = ? or taskto8 = ? or taskto9 = ? or taskto10 = ? or taskto11 = ? or taskto12 = ? or taskto13 = ? or taskto14 = ? or taskto15 = ?  limit 10";
    String sql = "select * from tasks where (recur = '0') and (startdate < '" + year + "/" +month+ "/" + day + " 23:59') and (taskstat <> 'Completed') and (((taskto1 = ? ) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)))) ";
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
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();


            cal1.setTime(rs.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
           
        String sql1 = "select * from tasks where (recur =1) and (taskstat <> 'Completed') and  (startdate <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL)) and (RECURDATE1 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate1 < enddate)) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL)) and (RECURDATE2 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate2 < enddate)) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL)) and (RECURDATE3 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate3 < enddate)) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL)) and (RECURDATE4 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate4 < enddate)) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL)) and (RECURDATE5 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate5 < enddate)) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL)) and (RECURDATE6 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate6 < enddate)) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL)) and (RECURDATE7 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate7 < enddate)) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL)) and (RECURDATE8 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate8 < enddate)) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL)) and (RECURDATE9 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate9 < enddate)) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL)) and (RECURDATE11 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate11 < enddate)) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL)) and (RECURDATE12 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate12 < enddate)) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL)) and (RECURDATE13 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate13 < enddate)) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL)) and (RECURDATE14 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate14 < enddate)) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)) and (RECURDATE15 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate15 < enddate)) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)) and (RECURDATE10 <= '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate10 < enddate)))";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
    
         pstm1.setString(1, Username);
        pstm1.setString(2, Username);
        pstm1.setString(3, Username);
        pstm1.setString(4, Username);
        pstm1.setString(5, Username);
        pstm1.setString(6, Username);
      pstm1.setString(7, Username);
        pstm1.setString(8, Username);
        pstm1.setString(9, Username);
        pstm1.setString(10, Username);
        pstm1.setString(11, Username);
        pstm1.setString(12, Username);
        pstm1.setString(13, Username);
        pstm1.setString(14, Username);
        pstm1.setString(15, Username);
        
        ResultSet rs1 = pstm1.executeQuery();
      
        while (rs1.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();


            cal1.setTime(rs1.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs1.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs1.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs1.getString("tranid");
            String taskfrom = rs1.getString("taskfrom");
             String description = rs1.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs1.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
            list.add(task);
            
        }
        
        return list;
    }
    
    
    public static ArrayList<Tasks> getTaskByMe(Connection conn, String Username) throws SQLException {
        
         Date date = new Date();
            Calendar cal = Calendar.getInstance();

           
            String year = Integer.toString(cal.get(Calendar.YEAR));
            String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(cal.get(Calendar.MINUTE));
        
       // String sql = "select tranid,Taskfrom,Description,revdate,enddate,statusday,startdate from tasks where taskto1 = ? or taskto2 = ? or taskto3 = ? or taskto4 = ?  or taskto5 = ? or taskto6 = ? or taskto6 = ? or taskto8 = ? or taskto9 = ? or taskto10 = ? or taskto11 = ? or taskto12 = ? or taskto13 = ? or taskto14 = ? or taskto15 = ?  limit 10";
    String sql = "select * from tasks where (taskfrom = ?) and (taskstat <> 'Completed')";
        PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, Username);
        
        
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
             Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();


            cal1.setTime(rs.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1 ){
                hour1 = "0" + hour1;
            } 
            if (minute1.length() == 1 ){
                minute1 = "0" + minute1;
            }
             if (month1.length() == 1 ){
                month1 = "0" + month1;
            }
              if (day1.length() == 1 ){
                day1 = "0" + day1;
            }
              Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
              
              cal2.setTime(rs.getTimestamp("enddate"));
            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            String hour2 = Integer.toString(cal2.get(Calendar.HOUR_OF_DAY));
            String minute2 = Integer.toString(cal2.get(Calendar.MINUTE));
            if (hour2.length() == 1 ){
                hour2 = "0" + hour2;
            } 
            if (minute2.length() == 1 ){
                minute2 = "0" + minute2;
            }
             if (month2.length() == 1 ){
                month2 = "0" + month2;
            }
              if (day2.length() == 1 ){
                day2 = "0" + day2;
            }
               Date date3 = new Date();
            Calendar cal3 = new GregorianCalendar();
            
              cal3.setTime(rs.getTimestamp("startdate"));
            String year3 = Integer.toString(cal3.get(Calendar.YEAR));
            String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
            String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
            String hour3 = Integer.toString(cal3.get(Calendar.HOUR_OF_DAY));
            String minute3 = Integer.toString(cal3.get(Calendar.MINUTE));
            if (hour3.length() == 1 ){
                hour3 = "0" + hour3;
            } 
            if (minute3.length() == 1 ){
                minute3 = "0" + minute3;
            }
             if (month3.length() == 1 ){
                month3 = "0" + month3;
            }
              if (day3.length() == 1 ){
                day3 = "0" + day3;
            }
            String tranid = rs.getString("tranid");
            String taskfrom = rs.getString("taskfrom");
             String description = rs.getString("description");
              String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1; 
               String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2; 
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3; 
            Tasks task = new Tasks();
            task.setTranid(tranid);
            task.setTaskfrom(taskfrom);
            task.setDescription(description);
            task.setRevdate(revdate);
            task.setEnddate(enddate);
            task.setTaskstat(taskstat);
            task.setStartdate(startdate);
            
          
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
