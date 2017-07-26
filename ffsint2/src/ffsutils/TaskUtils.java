/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsutils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.Tasks;
import ffsbeans.TaskImage;
import ffsbeans.Generics;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import ffsbeans.UserAccount;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import org.apache.commons.fileupload.FileItem;

public class TaskUtils extends HttpServlet {

    public static ArrayList<Generics> getTaskReportRoles(Connection conn) throws SQLException {

        System.out.println("getTaskReportRoles ");
        String sql = "Select genericdescriptioneng from generics where gengroupid = 43";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            Generics gen1 = new Generics();
            gen1.setGenericDescriptionEng(rs.getString("genericdescriptioneng"));
            list.add(gen1);
        }
        return list;
    }

    public static ArrayList<Tasks> getTaskOne(Connection conn, UserAccount Username, String Tranid) throws SQLException {
        System.out.println("getTaskOne " + Tranid);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "Select * from tasks where tranid =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, Tranid);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();

        if (rs.next()) {
            String task0 = rs.getString("taskfrom");
            String task1 = rs.getString("taskto1");
            String task2 = rs.getString("taskto2");
            String task3 = rs.getString("taskto3");
            String task4 = rs.getString("taskto4");
            String task5 = rs.getString("taskto5");
            String task6 = rs.getString("taskto6");
            String task7 = rs.getString("taskto7");
            String task8 = rs.getString("taskto8");
            String task9 = rs.getString("taskto9");
            String task10 = rs.getString("taskto10");
            String task11 = rs.getString("taskto11");
            String task12 = rs.getString("taskto12");
            String task13 = rs.getString("taskto13");
            String task14 = rs.getString("taskto14");
            String task15 = rs.getString("taskto15");
            if (task0 == null) {
                task0 = "";
            }
            if (task1 == null) {
                task1 = "";
            }
            if (task2 == null) {
                task2 = "";
            }
            if (task3 == null) {
                task3 = "";
            }
            if (task4 == null) {
                task4 = "";
            }
            if (task5 == null) {
                task5 = "";
            }
            if (task6 == null) {
                task6 = "";
            }
            if (task7 == null) {
                task7 = "";
            }
            if (task8 == null) {
                task8 = "";
            }
            if (task9 == null) {
                task9 = "";
            }
            if (task10 == null) {
                task10 = "";
            }
            if (task11 == null) {
                task11 = "";
            }
            if (task12 == null) {
                task12 = "";
            }
            if (task13 == null) {
                task13 = "";
            }
            if (task14 == null) {
                task14 = "";
            }
            if (task15 == null) {
                task15 = "";
            }

            if (task0.equals(Username.getUserName()) || task1.equals(Username.getUserName()) || task2.equals(Username.getUserName()) || task3.equals(Username.getUserName()) || task4.equals(Username.getUserName()) || task5.equals(Username.getUserName()) || task6.equals(Username.getUserName()) || task7.equals(Username.getUserName()) || task8.equals(Username.getUserName()) || task9.equals(Username.getUserName()) || task10.equals(Username.getUserName()) || task11.equals(Username.getUserName()) || task12.equals(Username.getUserName()) || task13.equals(Username.getUserName()) || task14.equals(Username.getUserName()) || task15.equals(Username.getUserName()) || Username.getsecurestr().substring(143, 144).equals("1")) {
                Date date1 = new Date();
                Calendar cal1 = new GregorianCalendar();

                if (rs.getTimestamp("revdate") == null) {
                    cal1.setTime(rs.getTimestamp("enddate"));
                } else {
                    cal1.setTime(rs.getTimestamp("revdate"));
                }
                String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                if (hour1.length() == 1) {
                    hour1 = "0" + hour1;
                }
                if (minute1.length() == 1) {
                    minute1 = "0" + minute1;
                }
                if (month1.length() == 1) {
                    month1 = "0" + month1;
                }
                if (day1.length() == 1) {
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
                if (hour2.length() == 1) {
                    hour2 = "0" + hour2;
                }
                if (minute2.length() == 1) {
                    minute2 = "0" + minute2;
                }
                if (month2.length() == 1) {
                    month2 = "0" + month2;
                }
                if (day2.length() == 1) {
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
                if (hour3.length() == 1) {
                    hour3 = "0" + hour3;
                }
                if (minute3.length() == 1) {
                    minute3 = "0" + minute3;
                }
                if (month3.length() == 1) {
                    month3 = "0" + month3;
                }
                if (day3.length() == 1) {
                    day3 = "0" + day3;
                }

                Date date4 = new Date();
                Calendar cal4 = new GregorianCalendar();

                cal4.setTime(rs.getTimestamp("taskdate"));
                String year4 = Integer.toString(cal4.get(Calendar.YEAR));
                String month4 = Integer.toString(cal4.get(Calendar.MONTH) + 1);
                String day4 = Integer.toString(cal4.get(Calendar.DAY_OF_MONTH));
                String hour4 = Integer.toString(cal4.get(Calendar.HOUR_OF_DAY));
                String minute4 = Integer.toString(cal4.get(Calendar.MINUTE));
                if (hour4.length() == 1) {
                    hour4 = "0" + hour4;
                }
                if (minute4.length() == 1) {
                    minute4 = "0" + minute4;
                }
                if (month4.length() == 1) {
                    month4 = "0" + month4;
                }
                if (day4.length() == 1) {
                    day4 = "0" + day4;
                }

                Date date5 = new Date();
                Calendar cal5 = new GregorianCalendar();

                if (rs.getTimestamp("statusday") == null) {
                    cal5.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal5.setTime(rs.getTimestamp("statusday"));
                }
//            cal5.setTime(rs.getTimestamp("statusday"));
                String year5 = Integer.toString(cal5.get(Calendar.YEAR));
                String month5 = Integer.toString(cal5.get(Calendar.MONTH) + 1);
                String day5 = Integer.toString(cal5.get(Calendar.DAY_OF_MONTH));
                String hour5 = Integer.toString(cal5.get(Calendar.HOUR_OF_DAY));
                String minute5 = Integer.toString(cal5.get(Calendar.MINUTE));
                if (hour5.length() == 1) {
                    hour5 = "0" + hour5;
                }
                if (minute5.length() == 1) {
                    minute5 = "0" + minute5;
                }
                if (month5.length() == 1) {
                    month5 = "0" + month5;
                }
                if (day5.length() == 1) {
                    day5 = "0" + day5;
                }

                Date date6 = new Date();
                Calendar cal6 = new GregorianCalendar();

                if (rs.getTimestamp("statusday1") == null) {
                    cal6.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal6.setTime(rs.getTimestamp("statusday1"));
                }

                String year6 = Integer.toString(cal6.get(Calendar.YEAR));
                String month6 = Integer.toString(cal6.get(Calendar.MONTH) + 1);
                String day6 = Integer.toString(cal6.get(Calendar.DAY_OF_MONTH));
                String hour6 = Integer.toString(cal6.get(Calendar.HOUR_OF_DAY));
                String minute6 = Integer.toString(cal6.get(Calendar.MINUTE));
                if (hour6.length() == 1) {
                    hour6 = "0" + hour6;
                }
                if (minute6.length() == 1) {
                    minute6 = "0" + minute6;
                }
                if (month6.length() == 1) {
                    month6 = "0" + month6;
                }
                if (day6.length() == 1) {
                    day6 = "0" + day6;
                }

                Date date7 = new Date();
                Calendar cal7 = new GregorianCalendar();

                if (rs.getTimestamp("statusday2") == null) {
                    cal7.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal7.setTime(rs.getTimestamp("statusday2"));
                }
                String training;
                if (rs.getString("train").equals("Y")) {
                    training = "Y";
                } else {
                    training = "N";
                }
                String year7 = Integer.toString(cal7.get(Calendar.YEAR));
                String month7 = Integer.toString(cal7.get(Calendar.MONTH) + 1);
                String day7 = Integer.toString(cal7.get(Calendar.DAY_OF_MONTH));
                String hour7 = Integer.toString(cal7.get(Calendar.HOUR_OF_DAY));
                String minute7 = Integer.toString(cal7.get(Calendar.MINUTE));
                if (hour7.length() == 1) {
                    hour7 = "0" + hour7;
                }
                if (minute7.length() == 1) {
                    minute7 = "0" + minute7;
                }
                if (month7.length() == 1) {
                    month7 = "0" + month7;
                }
                if (day7.length() == 1) {
                    day7 = "0" + day7;
                }

                Date date8 = new Date();
                Calendar cal8 = new GregorianCalendar();

                if (rs.getTimestamp("statusday3") == null) {
                    cal8.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal8.setTime(rs.getTimestamp("statusday3"));
                }

                String year8 = Integer.toString(cal8.get(Calendar.YEAR));
                String month8 = Integer.toString(cal8.get(Calendar.MONTH) + 1);
                String day8 = Integer.toString(cal8.get(Calendar.DAY_OF_MONTH));
                String hour8 = Integer.toString(cal8.get(Calendar.HOUR_OF_DAY));
                String minute8 = Integer.toString(cal8.get(Calendar.MINUTE));
                if (hour8.length() == 1) {
                    hour8 = "0" + hour8;
                }
                if (minute8.length() == 1) {
                    minute8 = "0" + minute8;
                }
                if (month8.length() == 1) {
                    month8 = "0" + month8;
                }
                if (day8.length() == 1) {
                    day8 = "0" + day8;
                }

                Date date9 = new Date();
                Calendar cal9 = new GregorianCalendar();

                if (rs.getTimestamp("statusday4") == null) {
                    cal9.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal9.setTime(rs.getTimestamp("statusday4"));
                }

                String year9 = Integer.toString(cal9.get(Calendar.YEAR));
                String month9 = Integer.toString(cal9.get(Calendar.MONTH) + 1);
                String day9 = Integer.toString(cal9.get(Calendar.DAY_OF_MONTH));
                String hour9 = Integer.toString(cal9.get(Calendar.HOUR_OF_DAY));
                String minute9 = Integer.toString(cal9.get(Calendar.MINUTE));
                if (hour9.length() == 1) {
                    hour9 = "0" + hour9;
                }
                if (minute9.length() == 1) {
                    minute9 = "0" + minute9;
                }
                if (month9.length() == 1) {
                    month9 = "0" + month9;
                }
                if (day9.length() == 1) {
                    day9 = "0" + day9;
                }

                Date date10 = new Date();
                Calendar cal10 = new GregorianCalendar();

                if (rs.getTimestamp("statusday5") == null) {
                    cal10.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal10.setTime(rs.getTimestamp("statusday5"));
                }

                String year10 = Integer.toString(cal10.get(Calendar.YEAR));
                String month10 = Integer.toString(cal10.get(Calendar.MONTH) + 1);
                String day10 = Integer.toString(cal10.get(Calendar.DAY_OF_MONTH));
                String hour10 = Integer.toString(cal10.get(Calendar.HOUR_OF_DAY));
                String minute10 = Integer.toString(cal10.get(Calendar.MINUTE));
                if (hour10.length() == 1) {
                    hour10 = "0" + hour10;
                }
                if (minute10.length() == 1) {
                    minute10 = "0" + minute10;
                }
                if (month10.length() == 1) {
                    month10 = "0" + month10;
                }
                if (day10.length() == 1) {
                    day10 = "0" + day10;
                }

                Date date11 = new Date();
                Calendar cal11 = new GregorianCalendar();

                if (rs.getTimestamp("statusday6") == null) {
                    cal11.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal11.setTime(rs.getTimestamp("statusday6"));
                }

                String year11 = Integer.toString(cal11.get(Calendar.YEAR));
                String month11 = Integer.toString(cal11.get(Calendar.MONTH) + 1);
                String day11 = Integer.toString(cal11.get(Calendar.DAY_OF_MONTH));
                String hour11 = Integer.toString(cal11.get(Calendar.HOUR_OF_DAY));
                String minute11 = Integer.toString(cal11.get(Calendar.MINUTE));
                if (hour11.length() == 1) {
                    hour11 = "0" + hour11;
                }
                if (minute11.length() == 1) {
                    minute11 = "0" + minute11;
                }
                if (month11.length() == 1) {
                    month11 = "0" + month11;
                }
                if (day11.length() == 1) {
                    day11 = "0" + day11;
                }

                Date date12 = new Date();
                Calendar cal12 = new GregorianCalendar();

                if (rs.getTimestamp("statusday7") == null) {
                    cal12.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal12.setTime(rs.getTimestamp("statusday7"));
                }

                String year12 = Integer.toString(cal12.get(Calendar.YEAR));
                String month12 = Integer.toString(cal12.get(Calendar.MONTH) + 1);
                String day12 = Integer.toString(cal12.get(Calendar.DAY_OF_MONTH));
                String hour12 = Integer.toString(cal12.get(Calendar.HOUR_OF_DAY));
                String minute12 = Integer.toString(cal12.get(Calendar.MINUTE));
                if (hour12.length() == 1) {
                    hour12 = "0" + hour12;
                }
                if (minute12.length() == 1) {
                    minute12 = "0" + minute12;
                }
                if (month12.length() == 1) {
                    month12 = "0" + month12;
                }
                if (day12.length() == 1) {
                    day12 = "0" + day12;
                }

                Date date13 = new Date();
                Calendar cal13 = new GregorianCalendar();

                if (rs.getTimestamp("statusday8") == null) {
                    cal13.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal13.setTime(rs.getTimestamp("statusday8"));
                }

                String year13 = Integer.toString(cal13.get(Calendar.YEAR));
                String month13 = Integer.toString(cal13.get(Calendar.MONTH) + 1);
                String day13 = Integer.toString(cal13.get(Calendar.DAY_OF_MONTH));
                String hour13 = Integer.toString(cal13.get(Calendar.HOUR_OF_DAY));
                String minute13 = Integer.toString(cal13.get(Calendar.MINUTE));
                if (hour13.length() == 1) {
                    hour13 = "0" + hour13;
                }
                if (minute13.length() == 1) {
                    minute13 = "0" + minute13;
                }
                if (month13.length() == 1) {
                    month13 = "0" + month13;
                }
                if (day13.length() == 1) {
                    day13 = "0" + day13;
                }

                Date date14 = new Date();
                Calendar cal14 = new GregorianCalendar();

                if (rs.getTimestamp("statusday9") == null) {
                    cal14.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal14.setTime(rs.getTimestamp("statusday9"));
                }

                String year14 = Integer.toString(cal14.get(Calendar.YEAR));
                String month14 = Integer.toString(cal14.get(Calendar.MONTH) + 1);
                String day14 = Integer.toString(cal14.get(Calendar.DAY_OF_MONTH));
                String hour14 = Integer.toString(cal14.get(Calendar.HOUR_OF_DAY));
                String minute14 = Integer.toString(cal14.get(Calendar.MINUTE));
                if (hour14.length() == 1) {
                    hour14 = "0" + hour14;
                }
                if (minute14.length() == 1) {
                    minute14 = "0" + minute14;
                }
                if (month14.length() == 1) {
                    month14 = "0" + month14;
                }
                if (day14.length() == 1) {
                    day14 = "0" + day14;
                }

                Date date15 = new Date();
                Calendar cal15 = new GregorianCalendar();

                if (rs.getTimestamp("statusday10") == null) {
                    cal15.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal15.setTime(rs.getTimestamp("statusday10"));
                }

                String year15 = Integer.toString(cal15.get(Calendar.YEAR));
                String month15 = Integer.toString(cal15.get(Calendar.MONTH) + 1);
                String day15 = Integer.toString(cal15.get(Calendar.DAY_OF_MONTH));
                String hour15 = Integer.toString(cal15.get(Calendar.HOUR_OF_DAY));
                String minute15 = Integer.toString(cal15.get(Calendar.MINUTE));
                if (hour15.length() == 1) {
                    hour15 = "0" + hour15;
                }
                if (minute15.length() == 1) {
                    minute15 = "0" + minute15;
                }
                if (month15.length() == 1) {
                    month15 = "0" + month15;
                }
                if (day15.length() == 1) {
                    day15 = "0" + day15;
                }

                Date date16 = new Date();
                Calendar cal16 = new GregorianCalendar();

                if (rs.getTimestamp("statusday11") == null) {
                    cal16.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal16.setTime(rs.getTimestamp("statusday11"));
                }

                String year16 = Integer.toString(cal16.get(Calendar.YEAR));
                String month16 = Integer.toString(cal16.get(Calendar.MONTH) + 1);
                String day16 = Integer.toString(cal16.get(Calendar.DAY_OF_MONTH));
                String hour16 = Integer.toString(cal16.get(Calendar.HOUR_OF_DAY));
                String minute16 = Integer.toString(cal16.get(Calendar.MINUTE));
                if (hour16.length() == 1) {
                    hour16 = "0" + hour16;
                }
                if (minute16.length() == 1) {
                    minute16 = "0" + minute16;
                }
                if (month16.length() == 1) {
                    month16 = "0" + month16;
                }
                if (day16.length() == 1) {
                    day16 = "0" + day16;
                }

                Date date17 = new Date();
                Calendar cal17 = new GregorianCalendar();

                if (rs.getTimestamp("statusday12") == null) {
                    cal17.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal17.setTime(rs.getTimestamp("statusday12"));
                }

                String year17 = Integer.toString(cal17.get(Calendar.YEAR));
                String month17 = Integer.toString(cal17.get(Calendar.MONTH) + 1);
                String day17 = Integer.toString(cal17.get(Calendar.DAY_OF_MONTH));
                String hour17 = Integer.toString(cal17.get(Calendar.HOUR_OF_DAY));
                String minute17 = Integer.toString(cal17.get(Calendar.MINUTE));
                if (hour17.length() == 1) {
                    hour17 = "0" + hour17;
                }
                if (minute17.length() == 1) {
                    minute17 = "0" + minute17;
                }
                if (month17.length() == 1) {
                    month17 = "0" + month17;
                }
                if (day17.length() == 1) {
                    day17 = "0" + day17;
                }

                Date date18 = new Date();
                Calendar cal18 = new GregorianCalendar();

                if (rs.getTimestamp("statusday13") == null) {
                    cal18.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal18.setTime(rs.getTimestamp("statusday13"));
                }

                String year18 = Integer.toString(cal18.get(Calendar.YEAR));
                String month18 = Integer.toString(cal18.get(Calendar.MONTH) + 1);
                String day18 = Integer.toString(cal18.get(Calendar.DAY_OF_MONTH));
                String hour18 = Integer.toString(cal18.get(Calendar.HOUR_OF_DAY));
                String minute18 = Integer.toString(cal18.get(Calendar.MINUTE));
                if (hour18.length() == 1) {
                    hour18 = "0" + hour18;
                }
                if (minute18.length() == 1) {
                    minute18 = "0" + minute18;
                }
                if (month18.length() == 1) {
                    month18 = "0" + month18;
                }
                if (day18.length() == 1) {
                    day18 = "0" + day18;
                }

                Date date19 = new Date();
                Calendar cal19 = new GregorianCalendar();

                if (rs.getTimestamp("statusday14") == null) {
                    cal19.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal19.setTime(rs.getTimestamp("statusday14"));
                }

                String year19 = Integer.toString(cal19.get(Calendar.YEAR));
                String month19 = Integer.toString(cal19.get(Calendar.MONTH) + 1);
                String day19 = Integer.toString(cal19.get(Calendar.DAY_OF_MONTH));
                String hour19 = Integer.toString(cal19.get(Calendar.HOUR_OF_DAY));
                String minute19 = Integer.toString(cal19.get(Calendar.MINUTE));
                if (hour19.length() == 1) {
                    hour19 = "0" + hour19;
                }
                if (minute19.length() == 1) {
                    minute19 = "0" + minute19;
                }
                if (month19.length() == 1) {
                    month19 = "0" + month19;
                }
                if (day19.length() == 1) {
                    day19 = "0" + day19;
                }

                Date date20 = new Date();
                Calendar cal20 = new GregorianCalendar();

                if (rs.getTimestamp("statusday15") == null) {
                    cal20.setTime(rs.getTimestamp("taskdate"));
                } else {
                    cal20.setTime(rs.getTimestamp("statusday15"));
                }

                String year20 = Integer.toString(cal20.get(Calendar.YEAR));
                String month20 = Integer.toString(cal20.get(Calendar.MONTH) + 1);
                String day20 = Integer.toString(cal20.get(Calendar.DAY_OF_MONTH));
                String hour20 = Integer.toString(cal20.get(Calendar.HOUR_OF_DAY));
                String minute20 = Integer.toString(cal20.get(Calendar.MINUTE));
                if (hour20.length() == 1) {
                    hour20 = "0" + hour20;
                }
                if (minute20.length() == 1) {
                    minute20 = "0" + minute20;
                }
                if (month20.length() == 1) {
                    month20 = "0" + month20;
                }
                if (day20.length() == 1) {
                    day20 = "0" + day20;
                }

                String statusday1 = day6 + "/" + month6 + "/" + year6 + " " + hour6 + ":" + minute6;
                String statusday2 = day7 + "/" + month7 + "/" + year7 + " " + hour7 + ":" + minute7;
                String statusday3 = day8 + "/" + month8 + "/" + year8 + " " + hour8 + ":" + minute8;
                String statusday4 = day9 + "/" + month9 + "/" + year9 + " " + hour9 + ":" + minute9;
                String statusday5 = day10 + "/" + month10 + "/" + year10 + " " + hour10 + ":" + minute10;
                String statusday6 = day11 + "/" + month11 + "/" + year11 + " " + hour11 + ":" + minute11;
                String statusday7 = day12 + "/" + month12 + "/" + year12 + " " + hour12 + ":" + minute12;
                String statusday8 = day13 + "/" + month13 + "/" + year13 + " " + hour13 + ":" + minute13;
                String statusday9 = day14 + "/" + month14 + "/" + year14 + " " + hour14 + ":" + minute14;
                String statusday10 = day15 + "/" + month15 + "/" + year15 + " " + hour15 + ":" + minute15;
                String statusday11 = day16 + "/" + month16 + "/" + year16 + " " + hour16 + ":" + minute16;
                String statusday12 = day17 + "/" + month17 + "/" + year17 + " " + hour17 + ":" + minute17;
                String statusday13 = day18 + "/" + month18 + "/" + year18 + " " + hour18 + ":" + minute18;
                String statusday14 = day19 + "/" + month19 + "/" + year19 + " " + hour19 + ":" + minute19;
                String statusday15 = day20 + "/" + month20 + "/" + year20 + " " + hour20 + ":" + minute20;

                String taskdate = day4 + "/" + month4 + "/" + year4 + " " + hour4 + ":" + minute4;
                String statusday = day5 + "/" + month5 + "/" + year5 + " " + hour5 + ":" + minute5;

                String tranid = rs.getString("tranid");
                String taskfrom = rs.getString("taskfrom");
                String description = rs.getString("description");
                String revdate = year1 + "/" + month1 + "/" + day1 + " " + hour1 + ":" + minute1;
                String enddate = year2 + "/" + month2 + "/" + day2 + " " + hour2 + ":" + minute2;
                String taskstat = rs.getString("taskstat");
                String startdate = year3 + "/" + month3 + "/" + day3 + " " + hour3 + ":" + minute3;

                Tasks task = new Tasks();
                task.setTranid(tranid);
                task.setTaskfrom(taskfrom);
                task.setDescription(description);
                task.setRevdate(revdate);
                task.setEnddate(enddate);
                task.setTaskstat(taskstat);
                task.setStartdate(startdate);
                task.setirnr(rs.getString("irnr"));
                task.setTaskdate(taskdate);
                task.setTaskfull(rs.getString("taskfull"));
                task.setTaskprior(rs.getString("taskprior"));
                task.setTaskstat(rs.getString("taskstat"));
                task.setStatusday(statusday);

                String temp1 = Username.getsecurestr();
                if (temp1.substring(149, 150) == "1") {
                    task.setTasknote(rs.getString("tasknote"));
                    System.out.println("getTaskOne Security 150=1");
                } else {
                    System.out.println("getTaskOne Security 150=0");
                    String TaskNote = rs.getString("tasknote");

                    String TempString = "";
                    Integer TempI = TaskNote.indexOf("http://google.com/maps");
                    while (TempI != -1) {
                        System.out.println("getTaskOne found location");
                        Integer TempI2 = TempI + 15;
                        do {
                            TempString = TaskNote.substring(TempI2 - 1, TempI2);
                            TempI2++;
                            //                  System.out.println("TaskEditNote TempString -" + TempString + "- " + TempI2.toString());
                        } while (!TempString.equals("~") && TempI2 < TaskNote.length() - 1);
                        TempI2--;
                        String delStr = TaskNote.substring(TempI, TempI2);
                        String newStr = TaskNote.replace(delStr, "");
                        TaskNote = newStr;
                        TempI = TaskNote.indexOf("http://google.com/maps");
                    }

                    task.setTasknote((TaskNote));
                }

                task.setrecurgam(rs.getString("recurgam"));
                task.setRecur(rs.getString("recur"));
                task.setRecura(rs.getString("recura"));
                task.setRecurday(rs.getString("recurday"));
                task.setRecurd(rs.getString("recurd"));
                task.setRecurf(rs.getString("recurf"));
                task.setrecdayofweek(rs.getString("recdayofweek"));
                task.setRecurb(rs.getString("recurb"));
                task.setRecurc(rs.getString("recurc"));
                task.setrecurg(rs.getString("recurg"));
                task.setRecure(rs.getString("recure"));
                task.setrecurh(rs.getString("recurh"));
                task.setrecuri(rs.getString("recuri"));
                task.setTaskto1(rs.getString("taskto1"));
                task.setTaskto2(rs.getString("taskto2"));
                task.setTaskto3(rs.getString("taskto3"));
                task.setTaskto4(rs.getString("taskto4"));
                task.setTaskto5(rs.getString("taskto5"));
                task.setTaskto6(rs.getString("taskto6"));
                task.setTaskto7(rs.getString("taskto7"));
                task.setTaskto8(rs.getString("taskto8"));
                task.setTaskto9(rs.getString("taskto9"));
                task.setTaskto10(rs.getString("taskto10"));
                task.setTaskto11(rs.getString("taskto11"));
                task.setTaskto12(rs.getString("taskto12"));
                task.settaskto13(rs.getString("taskto13"));
                task.setTaskto14(rs.getString("taskto14"));
                task.setTaskto15(rs.getString("taskto15"));
                task.setTaskstat1(rs.getString("taskstat1"));
                task.setTaskstat2(rs.getString("taskstat2"));
                task.setTaskstat3(rs.getString("taskstat3"));
                task.setTaskstat4(rs.getString("taskstat4"));
                task.setTaskstat5(rs.getString("taskstat5"));
                task.setTaskstat6(rs.getString("taskstat6"));
                task.setTaskstat7(rs.getString("taskstat7"));
                task.setTaskstat8(rs.getString("taskstat8"));
                task.settaskstat9(rs.getString("taskstat9"));
                task.setTaskstat10(rs.getString("taskstat10"));
                task.setTaskstat11(rs.getString("taskstat11"));
                task.setTaskstat12(rs.getString("taskstat12"));
                task.setTaskstat13(rs.getString("taskstat13"));
                task.setTaskstat14(rs.getString("taskstat14"));
                task.setTaskstat15(rs.getString("taskstat15"));
                task.setStatusday1(statusday1);
                task.setStatusday2(statusday2);
                task.setStatusday3(statusday3);
                task.setStatusday4(statusday4);
                task.setStatusday5(statusday5);
                task.setStatusday6(statusday6);
                task.setStatusday7(statusday7);
                task.setStatusday8(statusday8);
                task.setStatusday9(statusday9);
                task.setStatusday10(statusday10);
                task.setStatusday11(statusday11);
                task.setstatusday12(statusday12);
                task.setStatusday13(statusday13);
                task.setStatusday14(statusday14);
                task.setstatusday15(statusday15);
                task.setTrain(training);

                list.add(task);

                // set task not new and not updated
                if (Username.getUserName().equals(rs.getString("taskfrom"))) {
                    String sqlf = "update tasks set comaddf='Y',newtf='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto1"))) {
                    String sqlf = "update tasks set comadd1='Y',newt1='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto2"))) {
                    String sqlf = "update tasks set comadd2='Y',newt2='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto3"))) {
                    String sqlf = "update tasks set comadd3='Y',newt3='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto4"))) {
                    String sqlf = "update tasks set comadd4='Y',newt4='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto5"))) {
                    String sqlf = "update tasks set comadd5='Y',newt5='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto6"))) {
                    String sqlf = "update tasks set comadd6='Y',newt6='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto7"))) {
                    String sqlf = "update tasks set comadd7='Y',newt7='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto8"))) {
                    String sqlf = "update tasks set comadd8='Y',newt8='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto9"))) {
                    String sqlf = "update tasks set comadd9='Y',newt9='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto10"))) {
                    String sqlf = "update tasks set comadd10='Y',newt10='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto11"))) {
                    String sqlf = "update tasks set comadd11='Y',newt11='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto12"))) {
                    String sqlf = "update tasks set comadd12='Y',newt12='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto13"))) {
                    String sqlf = "update tasks set comadd13='Y',newt13='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto14"))) {
                    String sqlf = "update tasks set comadd14='Y',newt14='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }
                if (Username.getUserName().equals(rs.getString("taskto15"))) {
                    String sqlf = "update tasks set comadd15='Y',newt15='Y' where tranid = ?";
                    PreparedStatement pstmf = conn.prepareStatement(sqlf);
                    pstmf.setString(1, Tranid);
                    pstmf.executeUpdate();
                }

            } else {
                Tasks task = new Tasks();
                task.setTranid("0");
                task.setTaskfrom("Security problem");
                list.add(task);
            }
        }

        if (Tranid.equals("0")) {
            System.out.println("getTaskOne New Task");
            Tasks task = new Tasks();
            task.setTranid("0");
            task.setTaskfrom(Username.getUserName());
            list.add(task);
        }
        return list;

    }

    public static ArrayList<Tasks> getTrainingTask(Connection conn, String Username, String onlyUser) throws SQLException {
        System.out.println("getTrainingTask " + Username);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));
        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where ((((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is null))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is null))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is null))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is null))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is null))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is null))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is null))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is null))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is null))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is null))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is null))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is null))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is null))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is null))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is null)))) or (taskfrom = ?))and (taskstat <> 'Completed') and (train = 'Y')";
        } else {
            sql = "select * from tasks where ((((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is null))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is null))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is null))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is null))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is null))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is null))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is null))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is null))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is null))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is null))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is null))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is null))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is null))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is null))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is null)))) or (taskfrom = ?))and (taskstat <> 'Completed') and (train = 'Y') and (taskfrom='" + onlyUser + "')";
        }
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
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getUrgentTasks(Connection conn, String Username, String onlyUser) throws SQLException {
        System.out.println("getUrgentTasks " + Username);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

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
        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (taskfrom = '" + Username + "' ) and (taskstat <> 'Completed') and (revdate > '" + year + "/" + month + "/" + day + " 00:01') and (revdate < '" + year1 + "/" + month1 + "/" + day1 + " 23:59')";
        } else {
            sql = "select * from tasks where (taskfrom = '" + onlyUser + "' ) and (taskstat <> 'Completed') and (revdate > '" + year + "/" + month + "/" + day + " 00:01') and (revdate < '" + year1 + "/" + month1 + "/" + day1 + " 23:59')";
        }
        PreparedStatement pstm = conn.prepareStatement(sql);
        // pstm.setString(1, Username);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
            Date date10 = new Date();
            Calendar cal10 = new GregorianCalendar();
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year10 = Integer.toString(cal10.get(Calendar.YEAR));
            String month10 = Integer.toString(cal10.get(Calendar.MONTH) + 1);
            String day10 = Integer.toString(cal10.get(Calendar.DAY_OF_MONTH));
            String hour10 = Integer.toString(cal10.get(Calendar.HOUR_OF_DAY));
            String minute10 = Integer.toString(cal10.get(Calendar.MINUTE));
            if (hour10.length() == 1) {
                hour10 = "0" + hour10;
            }
            if (minute10.length() == 1) {
                minute10 = "0" + minute10;
            }
            if (month10.length() == 1) {
                month10 = "0" + month10;
            }
            if (day10.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);


String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            list.add(task);

        }
        String sql1 = "";
        if (onlyUser.length() < 4) {
            sql1 = "select * from tasks where (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is null))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is null))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is null))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is null))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is null))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is null))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is null))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is null))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is null))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is null))) or((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is null))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is null))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is null))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is null))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is null)))) and (taskstat <> 'Completed') and (revdate > '" + year + "/" + month + "/" + day + " 00:01') and (revdate < '" + year1 + "/" + month1 + "/" + day1 + " 23:59')";
        } else {
            sql1 = "select * from tasks where (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is null))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is null))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is null))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is null))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is null))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is null))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is null))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is null))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is null))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is null))) or((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is null))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is null))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is null))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is null))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is null)))) and (taskstat <> 'Completed') and (revdate > '" + year + "/" + month + "/" + day + " 00:01') and (revdate < '" + year1 + "/" + month1 + "/" + day1 + " 23:59') and (taskfrom = '" + onlyUser + "')";
        }
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
            if (rs1.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs1.getTimestamp("revdate"));
            }
//            cal1.setTime(rs1.getTimestamp("revdate"));
            String year11 = Integer.toString(cal11.get(Calendar.YEAR));
            String month11 = Integer.toString(cal11.get(Calendar.MONTH) + 1);
            String day11 = Integer.toString(cal11.get(Calendar.DAY_OF_MONTH));
            String hour11 = Integer.toString(cal11.get(Calendar.HOUR_OF_DAY));
            String minute11 = Integer.toString(cal11.get(Calendar.MINUTE));
            if (hour11.length() == 1) {
                hour11 = "0" + hour11;
            }
            if (minute11.length() == 1) {
                minute11 = "0" + minute11;
            }
            if (month11.length() == 1) {
                month11 = "0" + month11;
            }
            if (day11.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs1.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs1.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs1.getString("taskto1")) && (!"Y".equals(rs1.getString("newt1")))) || (Username.equals(rs1.getString("taskto2")) && (!"Y".equals(rs1.getString("newt2")))) || (Username.equals(rs1.getString("taskto3")) && (!"Y".equals(rs1.getString("newt3")))) || (Username.equals(rs1.getString("taskto4")) && (!"Y".equals(rs1.getString("newt4")))) || (Username.equals(rs1.getString("taskto5")) && (!"Y".equals(rs1.getString("newt5")))) || (Username.equals(rs1.getString("taskto6")) && (!"Y".equals(rs1.getString("newt6")))) || (Username.equals(rs1.getString("taskto7")) && (!"Y".equals(rs1.getString("newt7")))) || (Username.equals(rs1.getString("taskto8")) && (!"Y".equals(rs1.getString("newt8")))) || (Username.equals(rs1.getString("taskto9")) && (!"Y".equals(rs1.getString("newt9")))) || (Username.equals(rs1.getString("taskto10")) && (!"Y".equals(rs1.getString("newt10")))) || (Username.equals(rs1.getString("taskto11")) && (!"Y".equals(rs1.getString("newt11")))) || (Username.equals(rs1.getString("taskto12")) && (!"Y".equals(rs1.getString("newt12")))) || (Username.equals(rs1.getString("taskto13")) && (!"Y".equals(rs1.getString("newt13")))) || (Username.equals(rs1.getString("taskto14")) && (!"Y".equals(rs1.getString("newt14")))) || (Username.equals(rs1.getString("taskto15")) && (!"Y".equals(rs1.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getUpdatedTasks(Connection conn, String Username, String onlyUser) throws SQLException {
        System.out.println("getUpdatedTasks " + Username);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));
        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (((taskstat1 <> 'Completed') or (taskstat1 is null)) and (taskto1 = ?) and (newt1 is null)) or (((taskstat2 <> 'Completed') or (taskstat2 is null)) and (taskto2 = ?) and (newt2 is null)) or (((taskstat3 <> 'Completed') or (taskstat3 is null)) and (taskto3 = ?) and (newt3 is null)) or(((taskstat4 <> 'Completed') or (taskstat4 is null)) and (taskto4 = ?) and (newt4 is null)) or (((taskstat5 <> 'Completed') or (taskstat5 is null)) and (taskto5 = ?) and (newt5 is null)) or (((taskstat6 <> 'Completed') or (taskstat6 is null)) and (taskto6 = ?) and (newt6 is null)) or (((taskstat7 <> 'Completed') or (taskstat7 is null)) and (taskto7 = ?) and (newt7 is null)) or (((taskstat8 <> 'Completed') or (taskstat8 is null)) and (taskto8 = ?) and (newt8 is null)) or (((taskstat9 <> 'Completed') or (taskstat9 is null)) and (taskto9 = ?) and (newt9 is null)) or (((taskstat11 <> 'Completed') or (taskstat11 is null)) and (taskto11 = ?) and (newt11 is null)) or (((taskstat12 <> 'Completed') or (taskstat12 is null)) and (taskto12 = ?) and (newt12 is null)) or (((taskstat13 <> 'Completed') or (taskstat12 is null)) and (taskto13 = ?) and (newt13 is null)) or (((taskstat14 <> 'Completed') or (taskstat14 is null)) and (taskto14 = ?) and (newt14 is null)) or (((taskstat15 <> 'Completed') or (taskstat15 is null)) and (taskto15 = ?) and (newt15 is null)) or (((taskstat10 <> 'Completed') or (taskstat10 is null)) and (taskto10 = ?) and (newt10 is null)) or (((taskstat <> 'Completed') or (taskstat is null)) and (taskfrom = ?) and (newtf is null))";
        } else {
            sql = "select * from tasks where ((((taskstat1 <> 'Completed') or (taskstat1 is null)) and (taskto1 = ?) and (newt1 is null)) or (((taskstat2 <> 'Completed') or (taskstat2 is null)) and (taskto2 = ?) and (newt2 is null)) or (((taskstat3 <> 'Completed') or (taskstat3 is null)) and (taskto3 = ?) and (newt3 is null)) or(((taskstat4 <> 'Completed') or (taskstat4 is null)) and (taskto4 = ?) and (newt4 is null)) or (((taskstat5 <> 'Completed') or (taskstat5 is null)) and (taskto5 = ?) and (newt5 is null)) or (((taskstat6 <> 'Completed') or (taskstat6 is null)) and (taskto6 = ?) and (newt6 is null)) or (((taskstat7 <> 'Completed') or (taskstat7 is null)) and (taskto7 = ?) and (newt7 is null)) or (((taskstat8 <> 'Completed') or (taskstat8 is null)) and (taskto8 = ?) and (newt8 is null)) or (((taskstat9 <> 'Completed') or (taskstat9 is null)) and (taskto9 = ?) and (newt9 is null)) or (((taskstat11 <> 'Completed') or (taskstat11 is null)) and (taskto11 = ?) and (newt11 is null)) or (((taskstat12 <> 'Completed') or (taskstat12 is null)) and (taskto12 = ?) and (newt12 is null)) or (((taskstat13 <> 'Completed') or (taskstat12 is null)) and (taskto13 = ?) and (newt13 is null)) or (((taskstat14 <> 'Completed') or (taskstat14 is null)) and (taskto14 = ?) and (newt14 is null)) or (((taskstat15 <> 'Completed') or (taskstat15 is null)) and (taskto15 = ?) and (newt15 is null)) or (((taskstat10 <> 'Completed') or (taskstat10 is null)) and (taskto10 = ?) and (newt10 is null)) or (((taskstat <> 'Completed') or (taskstat is null)) and (taskfrom = ?) and (newtf is null))) and (taskfrom = '" + onlyUser + "')";
        }
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
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getTaskToMeComp(Connection conn, String Username, String onlyUser) throws SQLException {
        System.out.println("getTaskToMeComp " + Username);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (((taskto1 = ?) and (taskstat1 = 'Completed')) or ((taskto2 = ?) and (taskstat2 = 'Completed')) or ((taskto3 = ?) and (taskstat3 = 'Completed')) or ((taskto4 = ?) and (taskstat4 = 'Completed')) or ((taskto5 = ?) and (taskstat5 = 'Completed'))  or ((taskto6 = ?) and (taskstat6 = 'Completed'))  or ((taskto7 = ?) and (taskstat7 = 'Completed'))  or ((taskto8 = ?) and (taskstat8 = 'Completed')) or ((taskto9 = ?) and (taskstat9 = 'Completed'))  or ((taskto10 = ?) and (taskstat10 = 'Completed')) or ((taskto11 = ?) and (taskstat11 = 'Completed')) or ((taskto12 = ?) and (taskstat12 = 'Completed')) or ((taskto13 = ?) and (taskstat13 = 'Completed')) or ((taskto14 = ?) and (taskstat14 = 'Completed')) or ((taskto15 = ?) and (taskstat15 = 'Completed')) )  and (recur = '0')";
        } else {
            sql = "select * from tasks where ((((taskto1 = ?) and (taskstat1 = 'Completed')) or ((taskto2 = ?) and (taskstat2 = 'Completed')) or ((taskto3 = ?) and (taskstat3 = 'Completed')) or ((taskto4 = ?) and (taskstat4 = 'Completed')) or ((taskto5 = ?) and (taskstat5 = 'Completed'))  or ((taskto6 = ?) and (taskstat6 = 'Completed'))  or ((taskto7 = ?) and (taskstat7 = 'Completed'))  or ((taskto8 = ?) and (taskstat8 = 'Completed')) or ((taskto9 = ?) and (taskstat9 = 'Completed'))  or ((taskto10 = ?) and (taskstat10 = 'Completed')) or ((taskto11 = ?) and (taskstat11 = 'Completed')) or ((taskto12 = ?) and (taskstat12 = 'Completed')) or ((taskto13 = ?) and (taskstat13 = 'Completed')) or ((taskto14 = ?) and (taskstat14 = 'Completed')) or ((taskto15 = ?) and (taskstat15 = 'Completed')) )  and (recur = '0')) and (taskfrom = '" + onlyUser + "')";
        }
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
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("startdate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);

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
            if (rs1.getTimestamp("revdate") == null) {
                cal1.setTime(rs1.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs1.getTimestamp("revdate"));
            }
            // cal1.setTime(rs1.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);

            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getNewTask(Connection conn, String Username, String onlyUser) throws SQLException {
        System.out.println("getNewTask " + onlyUser);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where ((taskstat <> 'Completed') or (taskstat is null)) and (((taskstat1 <> 'Completed') or (taskstat1 is null)) and (taskto1 = ?) and (comadd1 is null)) or (((taskstat2 <> 'Completed') or (taskstat2 is null)) and (taskto2 = ?) and (comadd2 is null)) or (((taskstat3 <> 'Completed') or (taskstat3 is null)) and (taskto3 = ?) and (comadd3 is null)) or (((taskstat4 <> 'Completed') or (taskstat4 is null)) and (taskto4 = ?) and (comadd4 is null)) or (((taskstat5 <> 'Completed') or (taskstat5 is null)) and (taskto5 = ?) and (comadd5 is null)) or (((taskstat6 <> 'Completed') or (taskstat6 is null)) and (taskto6 = ?) and (comadd6 is null)) or (((taskstat7 <> 'Completed') or (taskstat7 is null)) and (taskto7 = ?) and (comadd7 is null)) or (((taskstat8 <> 'Completed') or (taskstat8 is null)) and (taskto8 = ?) and (comadd8 is null)) or (((taskstat9 <> 'Completed') or (taskstat9 is null)) and (taskto9 = ?) and (comadd9 is null)) or (((taskstat11 <> 'Completed') or (taskstat11 is null)) and (taskto11 = ?) and (comadd11 is null)) or (((taskstat12 <> 'Completed') or (taskstat12 is null)) and (taskto12 = ?) and (comadd12 is null)) or (((taskstat13 <> 'Completed') or (taskstat13 is null)) and (taskto13 = ?) and (comadd13 is null)) or (((taskstat14 <> 'Completed') or (taskstat14 is null)) and (taskto14 = ?) and (comadd14 is null)) or (((taskstat15 <> 'Completed') or (taskstat15 is null)) and (taskto15 = ?) and (comadd15 is null)) or (((taskstat10 <> 'Completed') or (taskstat10 is null)) and (taskto10 = ?) and (comadd10 is null)) or (((taskstat <> 'Completed') or (taskstat is null)) and (taskfrom = ?) and (comaddf is null)) ";
        } else {
            sql = "select * from tasks where (((taskstat <> 'Completed') or (taskstat is null)) and (((taskstat1 <> 'Completed') or (taskstat1 is null)) and (taskto1 = ?) and (comadd1 is null)) or (((taskstat2 <> 'Completed') or (taskstat2 is null)) and (taskto2 = ?) and (comadd2 is null)) or (((taskstat3 <> 'Completed') or (taskstat3 is null)) and (taskto3 = ?) and (comadd3 is null)) or (((taskstat4 <> 'Completed') or (taskstat4 is null)) and (taskto4 = ?) and (comadd4 is null)) or (((taskstat5 <> 'Completed') or (taskstat5 is null)) and (taskto5 = ?) and (comadd5 is null)) or (((taskstat6 <> 'Completed') or (taskstat6 is null)) and (taskto6 = ?) and (comadd6 is null)) or (((taskstat7 <> 'Completed') or (taskstat7 is null)) and (taskto7 = ?) and (comadd7 is null)) or (((taskstat8 <> 'Completed') or (taskstat8 is null)) and (taskto8 = ?) and (comadd8 is null)) or (((taskstat9 <> 'Completed') or (taskstat9 is null)) and (taskto9 = ?) and (comadd9 is null)) or (((taskstat11 <> 'Completed') or (taskstat11 is null)) and (taskto11 = ?) and (comadd11 is null)) or (((taskstat12 <> 'Completed') or (taskstat12 is null)) and (taskto12 = ?) and (comadd12 is null)) or (((taskstat13 <> 'Completed') or (taskstat13 is null)) and (taskto13 = ?) and (comadd13 is null)) or (((taskstat14 <> 'Completed') or (taskstat14 is null)) and (taskto14 = ?) and (comadd14 is null)) or (((taskstat15 <> 'Completed') or (taskstat15 is null)) and (taskto15 = ?) and (comadd15 is null)) or (((taskstat10 <> 'Completed') or (taskstat10 is null)) and (taskto10 = ?) and (comadd10 is null)) or (((taskstat <> 'Completed') or (taskstat is null)) and (taskfrom = ?) and (comaddf is null))) and (taskfrom ='" + onlyUser + "') ";
        }
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
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("startdate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getTaskByMeComp(Connection conn, String Username, String onlyUser) throws SQLException {
        System.out.println("getTaskByMeComp " + onlyUser);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (taskfrom = ?) and (taskstat = 'Completed')";
        } else {
            sql = "select * from tasks where (taskfrom = ?) and (taskstat = 'Completed') and ((taskto1 ='" + onlyUser + "') or (taskto2 ='" + onlyUser + "') or (taskto3 ='" + onlyUser + "') or (taskto4 ='" + onlyUser + "') or (taskto5 ='" + onlyUser + "') or (taskto6 ='" + onlyUser + "') or (taskto7 ='" + onlyUser + "') or (taskto8 ='" + onlyUser + "') or (taskto9 ='" + onlyUser + "') or (taskto10 ='" + onlyUser + "') or (taskto11 ='" + onlyUser + "') or (taskto12 ='" + onlyUser + "') or (taskto13 ='" + onlyUser + "') or (taskto14 ='" + onlyUser + "') or (taskto15 ='" + onlyUser + "'))";
        }
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, Username);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("startdate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            task.setTaskto1(rs.getString("taskto1"));
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getTaskInFuture(Connection conn, String Username, String onlyUser) throws SQLException {

        System.out.println("getTaskInFuture " + onlyUser);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (startdate > '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and ( recur = '0') and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)))) and (taskstat <> 'Completed')";
        } else {
            sql = "select * from tasks where (startdate > '" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and ( recur = '0') and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)))) and (taskstat <> 'Completed') and (taskfrom = '" + onlyUser + "')";
        }
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
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("startdate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }
        String sql1 = "";
        if (onlyUser.length() < 4) {
            sql1 = "select * from tasks where (recur =1) and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL)) and (RECURDATE1 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate1 < enddate)) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL)) and (RECURDATE2 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate2 < enddate)) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL)) and (RECURDATE3 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate3 < enddate)) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL)) and (RECURDATE4 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate4 < enddate)) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL)) and (RECURDATE5 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate5 < enddate)) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL)) and (RECURDATE6 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate6 < enddate)) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL)) and (RECURDATE7 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate7 < enddate)) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL)) and (RECURDATE8 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate8 < enddate)) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL)) and (RECURDATE9 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate9 < enddate)) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL)) and (RECURDATE11 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate11 < enddate)) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL)) and (RECURDATE12 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate12 < enddate)) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL)) and (RECURDATE13 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate13 < enddate)) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL)) and (RECURDATE14 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate14 < enddate)) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)) and (RECURDATE15 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate15 < enddate)) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)) and (RECURDATE10 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate10 < enddate)))";
        } else {
            sql1 = "select * from tasks where (recur =1) and (((taskto1 = ?) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL)) and (RECURDATE1 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate1 < enddate)) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL)) and (RECURDATE2 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate2 < enddate)) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL)) and (RECURDATE3 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate3 < enddate)) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL)) and (RECURDATE4 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate4 < enddate)) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL)) and (RECURDATE5 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate5 < enddate)) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL)) and (RECURDATE6 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate6 < enddate)) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL)) and (RECURDATE7 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate7 < enddate)) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL)) and (RECURDATE8 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate8 < enddate)) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL)) and (RECURDATE9 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate9 < enddate)) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL)) and (RECURDATE11 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate11 < enddate)) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL)) and (RECURDATE12 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate12 < enddate)) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL)) and (RECURDATE13 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate13 < enddate)) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL)) and (RECURDATE14 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate14 < enddate)) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)) and (RECURDATE15 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate15 < enddate)) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL)) and (RECURDATE10 >'" + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":00') and (recurdate10 < enddate))) and (taskfrom ='" + onlyUser + "')";
        }
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
            if (rs1.getTimestamp("revdate") == null) {
                cal1.setTime(rs1.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs1.getTimestamp("revdate"));
            }
            // cal1.setTime(rs1.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs1.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs1.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);


String color2 = "black";
            if ( (Username.equals(rs1.getString("taskto1")) && (!"Y".equals(rs1.getString("newt1")))) || (Username.equals(rs1.getString("taskto2")) && (!"Y".equals(rs1.getString("newt2")))) || (Username.equals(rs1.getString("taskto3")) && (!"Y".equals(rs1.getString("newt3")))) || (Username.equals(rs1.getString("taskto4")) && (!"Y".equals(rs1.getString("newt4")))) || (Username.equals(rs1.getString("taskto5")) && (!"Y".equals(rs1.getString("newt5")))) || (Username.equals(rs1.getString("taskto6")) && (!"Y".equals(rs1.getString("newt6")))) || (Username.equals(rs1.getString("taskto7")) && (!"Y".equals(rs1.getString("newt7")))) || (Username.equals(rs1.getString("taskto8")) && (!"Y".equals(rs1.getString("newt8")))) || (Username.equals(rs1.getString("taskto9")) && (!"Y".equals(rs1.getString("newt9")))) || (Username.equals(rs1.getString("taskto10")) && (!"Y".equals(rs1.getString("newt10")))) || (Username.equals(rs1.getString("taskto11")) && (!"Y".equals(rs1.getString("newt11")))) || (Username.equals(rs1.getString("taskto12")) && (!"Y".equals(rs1.getString("newt12")))) || (Username.equals(rs1.getString("taskto13")) && (!"Y".equals(rs1.getString("newt13")))) || (Username.equals(rs1.getString("taskto14")) && (!"Y".equals(rs1.getString("newt14")))) || (Username.equals(rs1.getString("taskto15")) && (!"Y".equals(rs1.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

//    Task Assined to Me
    public static ArrayList<Tasks> getTask(Connection conn, String Username, String onlyUser) throws SQLException {
      System.out.println("getTask " + Username + " " + onlyUser);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (recur = '0') and (startdate < '" + year + "/" + month + "/" + day + " 23:59') and (taskstat <> 'Completed') and (((taskto1 = ? ) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)))) ";
        } else {

            sql = "select * from tasks where (recur = '0') and (startdate < '" + year + "/" + month + "/" + day + " 23:59') and (taskstat <> 'Completed') and (((taskto1 = ? ) and ((taskstat1 <> 'Completed') or (taskstat1 is NULL))) or ((taskto2 = ?) and ((taskstat2 <> 'Completed') or (taskstat2 is NULL))) or ((taskto3 = ?) and ((taskstat3 <> 'Completed') or (taskstat3 is NULL))) or ((taskto4 = ?) and ((taskstat4 <> 'Completed') or (taskstat4 is NULL))) or ((taskto5 = ?) and ((taskstat5 <> 'Completed') or (taskstat5 is NULL))) or ((taskto6 = ?) and ((taskstat6 <> 'Completed') or (taskstat6 is NULL))) or ((taskto7 = ?) and ((taskstat7 <> 'Completed') or (taskstat7 is NULL))) or ((taskto8 = ?) and ((taskstat8 <> 'Completed') or (taskstat8 is NULL))) or ((taskto9 = ?) and ((taskstat9 <> 'Completed') or (taskstat9 is NULL))) or ((taskto10 = ?) and ((taskstat10 <> 'Completed') or (taskstat10 is NULL))) or ((taskto11 = ?) and ((taskstat11 <> 'Completed') or (taskstat11 is NULL))) or ((taskto12 = ?) and ((taskstat12 <> 'Completed') or (taskstat12 is NULL))) or ((taskto13 = ?) and ((taskstat13 <> 'Completed') or (taskstat13 is NULL))) or ((taskto14 = ?) and ((taskstat14 <> 'Completed') or (taskstat14 is NULL))) or ((taskto15 = ?) and ((taskstat15 <> 'Completed') or (taskstat15 is NULL)))) and (taskfrom = '" + onlyUser + "')";
        }
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
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            // cal1.setTime(rs.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            String color2 = "black";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
            task.setlinkup2(color2);
            
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
            if (rs1.getTimestamp("revdate") == null) {
                cal1.setTime(rs1.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs1.getTimestamp("revdate"));
            }
            // cal1.setTime(rs1.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            String color1 = "";
            if (date.after(rs1.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs1.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);


String color2 = "black";
            if ( (Username.equals(rs1.getString("taskto1")) && (!"Y".equals(rs1.getString("newt1")))) || (Username.equals(rs1.getString("taskto2")) && (!"Y".equals(rs1.getString("newt2")))) || (Username.equals(rs1.getString("taskto3")) && (!"Y".equals(rs1.getString("newt3")))) || (Username.equals(rs1.getString("taskto4")) && (!"Y".equals(rs1.getString("newt4")))) || (Username.equals(rs1.getString("taskto5")) && (!"Y".equals(rs1.getString("newt5")))) || (Username.equals(rs1.getString("taskto6")) && (!"Y".equals(rs1.getString("newt6")))) || (Username.equals(rs1.getString("taskto7")) && (!"Y".equals(rs1.getString("newt7")))) || (Username.equals(rs1.getString("taskto8")) && (!"Y".equals(rs1.getString("newt8")))) || (Username.equals(rs1.getString("taskto9")) && (!"Y".equals(rs1.getString("newt9")))) || (Username.equals(rs1.getString("taskto10")) && (!"Y".equals(rs1.getString("newt10")))) || (Username.equals(rs1.getString("taskto11")) && (!"Y".equals(rs1.getString("newt11")))) || (Username.equals(rs1.getString("taskto12")) && (!"Y".equals(rs1.getString("newt12")))) || (Username.equals(rs1.getString("taskto13")) && (!"Y".equals(rs1.getString("newt13")))) || (Username.equals(rs1.getString("taskto14")) && (!"Y".equals(rs1.getString("newt14")))) || (Username.equals(rs1.getString("taskto15")) && (!"Y".equals(rs1.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);

            list.add(task);

        }

        return list;
    }

    public static ArrayList<Tasks> getTaskByMe(Connection conn, String Username, String onlyUser) throws SQLException {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar cal121 = new GregorianCalendar();
        cal121.setTime(date);
        cal121.add(Calendar.DATE, 3);
        Date days3 = cal121.getTime();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));

        String sql = "";
        if (onlyUser.length() < 4) {
            sql = "select * from tasks where (taskfrom = ?) and (taskstat <> 'Completed')";
        } else {
            sql = "select * from tasks where ((taskfrom = ?) and (taskstat <> 'Completed')) and ((taskto1 = '" + onlyUser + "') or (taskto2 = '" + onlyUser + "') or (taskto3 = '" + onlyUser + "') or (taskto4 = '" + onlyUser + "') or (taskto5 = '" + onlyUser + "') or (taskto6 = '" + onlyUser + "') or (taskto7 = '" + onlyUser + "') or (taskto8 = '" + onlyUser + "') or (taskto9 = '" + onlyUser + "') or (taskto10 = '" + onlyUser + "') or (taskto11 = '" + onlyUser + "') or (taskto12 = '" + onlyUser + "') or (taskto13 = '" + onlyUser + "') or (taskto14 = '" + onlyUser + "') or (taskto15 = '" + onlyUser + "')) ";
        }

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, Username);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            // cal1.setTime(rs.getTimestamp("revdate"));
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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
            task.setTaskto1(rs.getString("taskto1"));
            String color1 = "";
            if (date.after(rs.getTimestamp("revdate"))) {
                color1 = "red";
            }
            if (color1 == "" && days3.after(rs.getTimestamp("revdate"))) {
                color1 = "orange";
            }
            if (color1 == "") {
                color1 = "green";
            }
            task.setlinkup1(color1);
            String color2 = "black";
            if ( (Username.equals(rs.getString("taskto1")) && (!"Y".equals(rs.getString("newt1")))) || (Username.equals(rs.getString("taskto2")) && (!"Y".equals(rs.getString("newt2")))) || (Username.equals(rs.getString("taskto3")) && (!"Y".equals(rs.getString("newt3")))) || (Username.equals(rs.getString("taskto4")) && (!"Y".equals(rs.getString("newt4")))) || (Username.equals(rs.getString("taskto5")) && (!"Y".equals(rs.getString("newt5")))) || (Username.equals(rs.getString("taskto6")) && (!"Y".equals(rs.getString("newt6")))) || (Username.equals(rs.getString("taskto7")) && (!"Y".equals(rs.getString("newt7")))) || (Username.equals(rs.getString("taskto8")) && (!"Y".equals(rs.getString("newt8")))) || (Username.equals(rs.getString("taskto9")) && (!"Y".equals(rs.getString("newt9")))) || (Username.equals(rs.getString("taskto10")) && (!"Y".equals(rs.getString("newt10")))) || (Username.equals(rs.getString("taskto11")) && (!"Y".equals(rs.getString("newt11")))) || (Username.equals(rs.getString("taskto12")) && (!"Y".equals(rs.getString("newt12")))) || (Username.equals(rs.getString("taskto13")) && (!"Y".equals(rs.getString("newt13")))) || (Username.equals(rs.getString("taskto14")) && (!"Y".equals(rs.getString("newt14")))) || (Username.equals(rs.getString("taskto15")) && (!"Y".equals(rs.getString("newt15")))) ) {
             color2 = "green";    
            }
task.setlinkup2(color2);
            
            list.add(task);

        }

        return list;
    }

    public static ArrayList<Generics> taskUpdate(Connection conn, UserAccount Username, String tranid, String recur1, String recur3, String recur4, String recur5, String recur6, String recur7, String recur8, String recur9, String recur10, String ir, String tasksumm, String taskfull, String recur13, String recur11, String recur12, String sdate, String rdate, String edate, String prior, String stats, String recur2, String taskTo1, String taskTo2, String taskTo3, String taskTo4, String taskTo5, String taskTo6, String taskTo7, String taskTo8, String taskTo9, String taskTo10, String taskTo11, String taskTo12, String taskTo13, String taskTo14, String taskTo15, String fromUser, String train) throws SQLException {
        System.out.println("taskUpdate " + tranid + " " + train);
        ArrayList<Generics> list = new ArrayList<Generics>();
        String result = "not updated";
        String recur = "";
        String recura = "";
        String recurb = "";
        String recurc = "";
        String recurd = "";
        String recure = "";
        String recurf = "";
        String recurg = "";
        String recurh = "";
        String recuri = "";
        String train1 = "";
        if (recur1.equals("true")) {
            recur = "1";
        } else {
            recur = "0";
        }
        if (recur3.equals("true")) {
            recura = "1";
        } else {
            recura = "0";
        }
        if (recur2.equals("true")) {
            recurd = "1";
        } else {
            recurd = "0";
        }
        if (recur5.equals("true")) {
            recurh = "1";
        } else {
            recurh = "0";
        }
        if (recur6.equals("true")) {
            recurb = "1";
        } else {
            recurb = "0";
        }
        if (recur7.equals("true")) {
            recure = "1";
        } else {
            recure = "0";
        }
        if (recur8.equals("true")) {
            recuri = "1";
        } else {
            recuri = "0";
        }
        if (recur9.equals("true")) {
            recurc = "1";
        } else {
            recurc = "0";
        }
        if (recur10.equals("true")) {
            recurf = "1";
        } else {
            recurf = "0";
        }
        if (recur12.equals("true")) {
            recurg = "1";
        } else {
            recurg = "0";
        }

        if (tranid.equals("0")) {
            String irnr1 = "";
            if (ir.equals("true")) { // requested ir, must update
                System.out.println("taskUpdate requestir");
                String upir = "select nextir from branch";
                PreparedStatement upirst = conn.prepareStatement(upir);
                ResultSet rsir = upirst.executeQuery();
                if (rsir.next()) {
                    System.out.println("taskUpdate ir " + rsir.getString("nextir"));
                    irnr1 = rsir.getString("nextir");
                    String upir2 = "Update branch set nextir = '" + (Integer.parseInt(irnr1) + 1) + "'";
                    PreparedStatement upirst2 = conn.prepareStatement(upir2);
                    upirst2.executeUpdate();
                }
            }
            String newSql = "insert into tasks (taskfrom,taskuser,taskto1,taskto2,taskto3,taskto4,taskto5,taskto6,taskto7,taskto8,taskto9,taskto10,taskto11,taskto12,taskto13,taskto14,taskto15,description,recur,recura,recurb,recurc,recurd,recure, startdate,revdate,enddate,taskprior, taskfull,taskdate, recurday, recurf,recdayofweek,taskby,recurg,recurgam, recurh, recuri,irnr,train ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement newPstm = conn.prepareStatement(newSql);
            newPstm.setString(1, fromUser);
            newPstm.setString(2, Username.getUserName());
            newPstm.setString(3, taskTo1);
            newPstm.setString(4, taskTo2);
            newPstm.setString(5, taskTo3);
            newPstm.setString(6, taskTo4);
            newPstm.setString(7, taskTo5);
            newPstm.setString(8, taskTo6);
            newPstm.setString(9, taskTo7);
            newPstm.setString(10, taskTo8);
            newPstm.setString(11, taskTo9);
            newPstm.setString(12, taskTo10);
            newPstm.setString(13, taskTo11);
            newPstm.setString(14, taskTo12);
            newPstm.setString(15, taskTo13);
            newPstm.setString(16, taskTo14);
            newPstm.setString(17, taskTo15);
            newPstm.setString(18, tasksumm);
            newPstm.setString(19, recur);
            newPstm.setString(20, recura);
            newPstm.setString(21, recurb);
            newPstm.setString(22, recurc);
            newPstm.setString(23, recurd);
            newPstm.setString(24, recure);
            newPstm.setString(25, sdate);
            newPstm.setString(26, rdate);
            newPstm.setString(27, edate);
            newPstm.setString(28, prior);
            newPstm.setString(29, taskfull);
            newPstm.setString(30, recur4);
            newPstm.setString(31, recurf);
            newPstm.setString(32, recur11);
            newPstm.setString(33, Username.getUserName());
            newPstm.setString(34, recurg);
            newPstm.setString(35, recur13);
            newPstm.setString(36, recurh);
            newPstm.setString(37, recuri);
            newPstm.setString(38, irnr1);
            newPstm.setString(39, train);

            newPstm.executeUpdate();

            result = "task created";
        } else {

            String sql = "select taskfull,tasknote, taskfrom,irnr,taskto1, taskto2, taskto3, taskto4, taskto5, taskto6, taskto7, taskto8, taskto9, taskto10,taskto11, taskto12, taskto13, taskto14, taskto15 from tasks where tranid = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, tranid);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                if (rs.getString("taskfrom").equals(Username.getUserName())) {
                    System.out.println("taskUpdate from this user");
                    String temp1 = rs.getString("irnr");
                    if (temp1 == null) {
                        temp1 = "";
                    }
                    if (temp1.length() < 4 && ir.equals("true")) { // requested ir, must update
                        String upir = "select nextir from branch";
                        PreparedStatement upirst = conn.prepareStatement(upir);
                        ResultSet rsir = upirst.executeQuery();
                        if (rs.next()) {
                            String thisir = rs.getString("nextir");
                            String upir2 = "Update branch set nextir = '" + (Integer.parseInt(thisir) + 1) + "'";
                            PreparedStatement upirst2 = conn.prepareStatement(upir2);
                            upirst2.executeUpdate();

                            String upir3 = "update tasks set irnr = '" + thisir + "' where tranid = ?";
                            PreparedStatement upirst3 = conn.prepareStatement(upir3);
                            upirst.setString(1, tranid);
                            upirst3.executeUpdate();
                        }
                    }
                    if (!rs.getString("taskfull").equals(taskfull)) {
                        long millis = System.currentTimeMillis();
                        java.sql.Date date = new java.sql.Date(millis);
                        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
                        Date now = new Date();
                        String strTime = sdfTime.format(now);
                        String newcomm = rs.getString("tasknote") + "~~Task Description updated from : ~" + rs.getString("taskfull") + "~" + Username.getUserName() + " " + date + " " + strTime + "~______________________~";
                        String sql1 = "update tasks set tasknote = ? where tranid = ?";
                        PreparedStatement pstm2 = conn.prepareStatement(sql1);
                        pstm2.setString(1, newcomm);
                        pstm2.setString(2, tranid);
                        pstm2.executeUpdate();

                    }
                    System.out.println("taskUpdate update task detail " + train);
                    String sqlu1 = "update tasks set description=?, taskfull=?, startdate=?, revdate=?, enddate=?, taskprior=?, taskstat=?, recur=?, recura=?, recurb=?, recurc=?, recurd=?, recure=?, recurf=?, recurg=?, recurh=?, recuri=?, recdayofweek=?, recurday=?, recurgam=?, train=? where tranid = ?";
                    PreparedStatement upta = conn.prepareStatement(sqlu1);
                    upta.setString(1, tasksumm);
                    upta.setString(2, taskfull);
                    upta.setString(3, sdate);
                    upta.setString(4, rdate);
                    upta.setString(5, edate);
                    upta.setString(6, prior);
                    upta.setString(7, stats);

                    upta.setString(8, recur);
                    upta.setString(9, recura);
                    upta.setString(10, recurb);
                    upta.setString(11, recurc);
                    upta.setString(12, recurd);
                    upta.setString(13, recure);
                    upta.setString(14, recurf);
                    upta.setString(15, recurg);
                    upta.setString(16, recurh);
                    upta.setString(17, recuri);

                    upta.setString(18, recur11);
                    upta.setString(19, recur4);
                    upta.setString(20, recur13);
                    upta.setString(21, train);
                    upta.setString(22, tranid);

                    upta.executeUpdate();
                    result = "success";

                    //PreparedStatement pstmu = conn.prepareStatement(sqlu1);
                    //pstmu.setString(1, ir);
                    //pstmu.executeUpdate();
                }
                // not this user, only update status
                if (rs.getString("taskto1").equals(Username.getUserName())) {
                    String sql1 = "update tasks set taskstat1 = ? , task1date=current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, stats);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                }

            } else {  // no task, return error           
                result = "Task not found";
            }
        }
        Generics generics = new Generics();
        generics.setGenericDescriptionEng(result);
        list.add(generics);
        return list;
    }

    public static ArrayList<Tasks> TaskSaveComm(Connection conn, UserAccount user, String comments, String tranid, String coordsa, String coordsb) throws SQLException, InterruptedException {

        String sql = "Select tasknote, taskfrom, taskto1, taskto2, taskto3, taskto4, taskto5, taskto6, taskto7, taskto8, taskto9, taskto10, taskto11, taskto12, taskto13, taskto14, taskto15 from tasks where tranid = ?";
        System.out.println("TaskSaveComm " + tranid + "coordsa-" + coordsa + "- coordsb-" + coordsb);
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tranid);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            Date now = new Date();
            String strTime = sdfTime.format(now);

            String oldcomm = rs.getString("tasknote");
            String newcomm = rs.getString("tasknote") + "~" + comments + "~http://google.com/maps/place/" + coordsa + "," + coordsb + '~' + user.getUserName() + " " + date + " " + strTime + "~______________________~";

            String sql1 = "update tasks set tasknote = ? where tranid = ?";

            PreparedStatement pstm2 = conn.prepareStatement(sql1);

            pstm2.setString(1, newcomm);
            pstm2.setString(2, tranid);
            pstm2.executeUpdate();

            if (rs.getString("taskfrom").equals(user.getUserName())) {
                String sqlf = "update tasks set newt1=null, newt2=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto1").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt2=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto2").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto3").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt2=null, newt4=null, newt5=null, newt6=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto4").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt2=null, newt5=null, newt6=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto5").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt2=null, newt6=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto6").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt2=null, newt7=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto7").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt2=null, newt8=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto8").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto9").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt8=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto10").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt8=null, newt11=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto11").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt10=null, newt8=null, newt12=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto12").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt10=null, newt11=null, newt8=null, newt13=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto13").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt10=null, newt11=null, newt12=null, newt8=null, newt14=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto14").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt8=null, newt15=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
            if (rs.getString("taskto15").equals(user.getUserName())) {
                String sqlf = "update tasks set newtf=null, newt1=null, newt3=null, newt4=null, newt5=null, newt6=null, newt7=null, newt2=null, newt9=null, newt10=null, newt11=null, newt12=null, newt13=null, newt14=null, newt8=null where tranid = ?";
                PreparedStatement pstmf = conn.prepareStatement(sqlf);
                pstmf.setString(1, tranid);
                pstmf.executeUpdate();
            }
        }

        Thread.sleep(1500);

        String sql3 = "Select tasknote from tasks where tranid = ?";

        PreparedStatement pstm3 = conn.prepareStatement(sql3);
        pstm3.setString(1, tranid);

        ResultSet rs3 = pstm3.executeQuery();

        ArrayList<Tasks> list = new ArrayList<Tasks>();
        if (rs3.next()) {
            String diarycomm = rs3.getString("tasknote");

            Tasks tasks = new Tasks();
            tasks.setTasknote(diarycomm);

            list.add(tasks);
        }
        return list;
    }

    public static ArrayList<Generics> taskUpdatePeople(Connection conn, UserAccount user, String tranid, String user1, String user2, String user3, String user4, String user5, String user6, String user7, String user8, String user9, String user10, String user11, String user12, String user13, String user14, String user15) throws SQLException {
        ArrayList<Generics> list = new ArrayList<Generics>();
        String sql = "Select taskfrom, taskto1, taskto2, taskto3, taskto4, taskto5, taskto6, taskto7, taskto8, taskto9, taskto10, taskto11, taskto12, taskto13, taskto14, taskto15 from tasks where tranid = ?";
        System.out.println("TaskUpdatePeople " + tranid + " " + user1);
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tranid);
        String result = "no updates done";

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if (rs.getString("taskfrom").equals(user.getUserName())) {
                if (!rs.getString("taskto1").equals(user1)) {
                    String sql1 = "update tasks set taskto1 = ?,task1date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user1);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto2").equals(user2)) {
                    String sql1 = "update tasks set taskto2 = ?,task2date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user2);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto3").equals(user3)) {
                    String sql1 = "update tasks set taskto3 = ?,task3date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user3);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto4").equals(user4)) {
                    String sql1 = "update tasks set taskto4 = ?,task4date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user4);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto5").equals(user5)) {
                    String sql1 = "update tasks set taskto5 = ?,task5date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user5);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto6").equals(user6)) {
                    String sql1 = "update tasks set taskto6 = ?,task6date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user6);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto7").equals(user7)) {
                    String sql1 = "update tasks set taskto7 = ?,task7date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user7);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto8").equals(user8)) {
                    String sql1 = "update tasks set taskto8 = ?,task8date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user8);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto9").equals(user9)) {
                    String sql1 = "update tasks set taskto9 = ?,task9date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user9);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto10").equals(user10)) {
                    String sql1 = "update tasks set taskto10 = ?,task10date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user10);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto11").equals(user11)) {
                    String sql1 = "update tasks set taskto11 = ?,task11date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user11);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto12").equals(user12)) {
                    String sql1 = "update tasks set taskto12 = ?,task12date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user12);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto13").equals(user13)) {
                    String sql1 = "update tasks set taskto13 = ?,task13date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user13);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto14").equals(user14)) {
                    String sql1 = "update tasks set taskto14 = ?,task14date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user14);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }
                if (!rs.getString("taskto15").equals(user15)) {
                    String sql1 = "update tasks set taskto15 = ?,task15date = current_timestamp where tranid = ?";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, user15);
                    pstm1.setString(2, tranid);
                    pstm1.executeUpdate();
                    result = "success";
                    System.out.println("TaskUpdatePeople success");
                }

            } else {
                result = "not your task";
                System.out.println("TaskUpdatePeople not your task");
            }
        } else {
            result = "task not found";
        }
        Generics generics = new Generics();
        generics.setGenericDescriptionEng(result);
        list.add(generics);
        return list;
    }

    public static ArrayList<Tasks> getTaskSearch(Connection conn, UserAccount Username, String idSearch, String summSearch) throws SQLException {
        System.out.println("getTaskSearch " + idSearch);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));
        String temp1 = Username.getsecurestr();
        String sql = "";
        PreparedStatement pstm = null;
        System.out.println("getTaskSearch " + temp1.substring(143, 144) + " " + idSearch.length());
        if (temp1.substring(143, 144).equals("1") && idSearch.length() > 0) {
            sql = "select * from tasks where (tranid=?) ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, idSearch);
        }
        if (temp1.substring(143, 144).equals("0") && idSearch.length() > 0) {
            sql = "select * from tasks where (tranid=?) and ((taskfrom is ?) or (taskto1 = ?) or (taskto2 = ?) or (taskto3 = ?) or (taskto4 = ?) or (taskto5 = ?) or (taskto6 = ?) or (taskto7 = ?) or (taskto8 = ?) or (taskto9 = ?) or (taskto10 = ?) or (taskto11 = ?) or (taskto12 = ?) or (taskto13 = ?) or (taskto14 = ?) or (taskto15 = ?)) ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, idSearch);
            pstm.setString(2, Username.getUserName());
            pstm.setString(3, Username.getUserName());
            pstm.setString(4, Username.getUserName());
            pstm.setString(5, Username.getUserName());
            pstm.setString(6, Username.getUserName());
            pstm.setString(7, Username.getUserName());
            pstm.setString(8, Username.getUserName());
            pstm.setString(9, Username.getUserName());
            pstm.setString(10, Username.getUserName());
            pstm.setString(11, Username.getUserName());
            pstm.setString(12, Username.getUserName());
            pstm.setString(13, Username.getUserName());
            pstm.setString(14, Username.getUserName());
            pstm.setString(15, Username.getUserName());
            pstm.setString(16, Username.getUserName());
            pstm.setString(17, Username.getUserName());
        }

        if (temp1.substring(143, 144).equals("1") && summSearch.length() > 0) {
            sql = "select * from tasks where (description like '%" + summSearch + "%')";
            pstm = conn.prepareStatement(sql);
        }
        if (temp1.substring(143, 144).equals("0") && summSearch.length() > 0) {
            sql = "select * from tasks where (description like '%" + summSearch + "%') and ((taskfrom is ?) or (taskto1 = ?) or (taskto2 = ?) or (taskto3 = ?) or (taskto4 = ?) or (taskto5 = ?) or (taskto6 = ?) or (taskto7 = ?) or (taskto8 = ?) or (taskto9 = ?) or (taskto10 = ?) or (taskto11 = ?) or (taskto12 = ?) or (taskto13 = ?) or (taskto14 = ?) or (taskto15 = ?)) ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, Username.getUserName());
            pstm.setString(2, Username.getUserName());
            pstm.setString(3, Username.getUserName());
            pstm.setString(4, Username.getUserName());
            pstm.setString(5, Username.getUserName());
            pstm.setString(6, Username.getUserName());
            pstm.setString(7, Username.getUserName());
            pstm.setString(8, Username.getUserName());
            pstm.setString(9, Username.getUserName());
            pstm.setString(10, Username.getUserName());
            pstm.setString(11, Username.getUserName());
            pstm.setString(12, Username.getUserName());
            pstm.setString(13, Username.getUserName());
            pstm.setString(14, Username.getUserName());
            pstm.setString(15, Username.getUserName());
            pstm.setString(16, Username.getUserName());
        }
        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        while (rs.next()) {
            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();
            if (rs.getTimestamp("revdate") == null) {
                cal1.setTime(rs.getTimestamp("enddate"));
            } else {
                cal1.setTime(rs.getTimestamp("revdate"));
            }
            String year1 = Integer.toString(cal1.get(Calendar.YEAR));
            String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
            if (hour1.length() == 1) {
                hour1 = "0" + hour1;
            }
            if (minute1.length() == 1) {
                minute1 = "0" + minute1;
            }
            if (month1.length() == 1) {
                month1 = "0" + month1;
            }
            if (day1.length() == 1) {
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
            if (hour2.length() == 1) {
                hour2 = "0" + hour2;
            }
            if (minute2.length() == 1) {
                minute2 = "0" + minute2;
            }
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
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
            if (hour3.length() == 1) {
                hour3 = "0" + hour3;
            }
            if (minute3.length() == 1) {
                minute3 = "0" + minute3;
            }
            if (month3.length() == 1) {
                month3 = "0" + month3;
            }
            if (day3.length() == 1) {
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

    public static String getTaskIdea(Connection conn, UserAccount Username) throws SQLException {
        System.out.println("getTaskIdea " + Username.getUserName());

        String sql = "select myidea from users where name = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, Username.getUserName());

        ResultSet rs = pstm.executeQuery();
        // ArrayList<String> list = new ArrayList<String>();
        String idea1 = "";
        if (rs.next()) {
            idea1 = rs.getString("myidea");
        }
        return idea1;
    }

    public static ArrayList<Generics> taskUpdateIdea(Connection conn, UserAccount user, String myIdea) throws SQLException {
        ArrayList<Generics> list = new ArrayList<Generics>();
        System.out.println("TaskUpdateIdea");

        String sql = "update users set myidea = ? where name =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, myIdea);
        pstm.setString(2, user.getUserName());
        pstm.executeUpdate();

        String result = "success";

        Generics generics = new Generics();
        generics.setGenericDescriptionEng(result);
        list.add(generics);
        return list;
    }

    public static ArrayList<Tasks> getReportFor(Connection conn, UserAccount Username, String reportFor, String reportPeople) throws SQLException {
        System.out.println("getReportFor " + reportPeople);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));
        String second = Integer.toString(cal.get(Calendar.SECOND));
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        String filename = Username.getUserName() + "-" + hour + "-" + minute + "-" + second + ".csv";
        if (reportFor.length() == 0) {
            String sql = "select * from tasks where taskto1='" + reportPeople + "' or taskto2='" + reportPeople + "' or taskto3='" + reportPeople + "' or taskto4='" + reportPeople + "' or taskto5='" + reportPeople + "' or taskto6='" + reportPeople + "' or taskto7='" + reportPeople + "' or taskto8='" + reportPeople + "' or taskto9='" + reportPeople + "' or taskto10='" + reportPeople + "' or taskto11='" + reportPeople + "' or taskto12='" + reportPeople + "' or taskto13='" + reportPeople + "' or taskto14='" + reportPeople + "' or taskto15='" + reportPeople + "'";
            System.out.println("getReportFor " + sql);
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            try {
                PrintWriter writer = new PrintWriter("C:/java/ffsint3/ffsint2/build/web/resources/" + filename, "UTF-8");
                writer.println("id ,taskfrom, description , startdate , revdate , enddate , taskstat");
                while (rs.next()) {
                    Date date1 = new Date();
                    Calendar cal1 = new GregorianCalendar();
                    if (rs.getTimestamp("revdate") == null) {
                        cal1.setTime(rs.getTimestamp("enddate"));
                    } else {
                        cal1.setTime(rs.getTimestamp("revdate"));
                    }
                    String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                    String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                    String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                    String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                    String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                    if (hour1.length() == 1) {
                        hour1 = "0" + hour1;
                    }
                    if (minute1.length() == 1) {
                        minute1 = "0" + minute1;
                    }
                    if (month1.length() == 1) {
                        month1 = "0" + month1;
                    }
                    if (day1.length() == 1) {
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
                    if (hour2.length() == 1) {
                        hour2 = "0" + hour2;
                    }
                    if (minute2.length() == 1) {
                        minute2 = "0" + minute2;
                    }
                    if (month2.length() == 1) {
                        month2 = "0" + month2;
                    }
                    if (day2.length() == 1) {
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
                    if (hour3.length() == 1) {
                        hour3 = "0" + hour3;
                    }
                    if (minute3.length() == 1) {
                        minute3 = "0" + minute3;
                    }
                    if (month3.length() == 1) {
                        month3 = "0" + month3;
                    }
                    if (day3.length() == 1) {
                        day3 = "0" + day3;
                    }
                    String tranid = rs.getString("tranid");
                    String taskfrom = rs.getString("taskfrom");
                    String description = rs.getString("description");
                    String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1;
                    String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2;
                    String taskstat = rs.getString("taskstat");
                    String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3;

                    writer.println(tranid + "," + taskfrom + "," + description + "," + startdate + "," + revdate + "," + enddate + "," + taskstat);

                    //    list.add(task);
                }
                writer.close();
            } catch (IOException e) {
                // do something
            }

        } else {
            String sql = "select * from tasks where (taskto1='" + reportPeople + "' or taskto2='" + reportPeople + "' or taskto3='" + reportPeople + "' or taskto4='" + reportPeople + "' or taskto5='" + reportPeople + "' or taskto6='" + reportPeople + "' or taskto7='" + reportPeople + "' or taskto8='" + reportPeople + "' or taskto9='" + reportPeople + "' or taskto10='" + reportPeople + "' or taskto11='" + reportPeople + "' or taskto12='" + reportPeople + "' or taskto13='" + reportPeople + "' or taskto14='" + reportPeople + "' or taskto15='" + reportPeople + "') and taskstat='" + reportFor + "'";
            System.out.println("getReportFor " + sql);
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            try {
                PrintWriter writer = new PrintWriter("C:/java/ffsint3/ffsint2/build/web/resources/" + filename, "UTF-8");
                writer.println("id ,taskfrom, description , startdate , revdate , enddate , taskstat");
                while (rs.next()) {
                    Date date1 = new Date();
                    Calendar cal1 = new GregorianCalendar();
                    if (rs.getTimestamp("revdate") == null) {
                        cal1.setTime(rs.getTimestamp("enddate"));
                    } else {
                        cal1.setTime(rs.getTimestamp("revdate"));
                    }
                    String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                    String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                    String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                    String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                    String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                    if (hour1.length() == 1) {
                        hour1 = "0" + hour1;
                    }
                    if (minute1.length() == 1) {
                        minute1 = "0" + minute1;
                    }
                    if (month1.length() == 1) {
                        month1 = "0" + month1;
                    }
                    if (day1.length() == 1) {
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
                    if (hour2.length() == 1) {
                        hour2 = "0" + hour2;
                    }
                    if (minute2.length() == 1) {
                        minute2 = "0" + minute2;
                    }
                    if (month2.length() == 1) {
                        month2 = "0" + month2;
                    }
                    if (day2.length() == 1) {
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
                    if (hour3.length() == 1) {
                        hour3 = "0" + hour3;
                    }
                    if (minute3.length() == 1) {
                        minute3 = "0" + minute3;
                    }
                    if (month3.length() == 1) {
                        month3 = "0" + month3;
                    }
                    if (day3.length() == 1) {
                        day3 = "0" + day3;
                    }
                    String tranid = rs.getString("tranid");
                    String taskfrom = rs.getString("taskfrom");
                    String description = rs.getString("description");
                    String revdate = year1 + "-" + month1 + "-" + day1 + " " + hour1 + ":" + minute1;
                    String enddate = year2 + "-" + month2 + "-" + day2 + " " + hour2 + ":" + minute2;
                    String taskstat = rs.getString("taskstat");
                    String startdate = year3 + "-" + month3 + "-" + day3 + " " + hour3 + ":" + minute3;
                    writer.println(tranid + "," + taskfrom + "," + description + "," + startdate + "," + revdate + "," + enddate + "," + taskstat);

                    //     list.add(task);
                }
                writer.close();
            } catch (IOException e) {
                // do something
            }
        }

        Tasks task = new Tasks();
        task.setTaskfrom(filename);
        list.add(task);

        return list;
    }

    public static ArrayList<Tasks> getReportBranch(Connection conn, UserAccount Username, String reportFor, String reportBranch) throws SQLException {
        System.out.println("getReportBranch " + reportBranch);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));
        String second = Integer.toString(cal.get(Calendar.SECOND));
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        String filename = Username.getUserName() + "-" + hour + "-" + minute + "-" + second + ".csv";
        if (reportFor.length() == 0) {
            String sql1 = "select name from users where branch = '" + reportBranch + "'";
            PreparedStatement pstm1 = conn.prepareStatement(sql1);
            ResultSet rs1 = pstm1.executeQuery();

            while (rs1.next()) {

                String sql = "select * from tasks where (taskto1='" + rs1.getString("name") + "' or taskto2='" + rs1.getString("name") + "' or taskto3='" + rs1.getString("name") + "' or taskto4='" + rs1.getString("name") + "' or taskto5='" + rs1.getString("name") + "' or taskto6='" + rs1.getString("name") + "' or taskto7='" + rs1.getString("name") + "' or taskto8='" + rs1.getString("name") + "' or taskto9='" + rs1.getString("name") + "' or taskto10='" + rs1.getString("name") + "' or taskto11='" + rs1.getString("name") + "' or taskto12='" + rs1.getString("name") + "' or taskto13='" + rs1.getString("name") + "' or taskto14='" + rs1.getString("name") + "' or taskto15='" + rs1.getString("name") + "')";
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();

                try {
                    PrintWriter writer = new PrintWriter("C:/java/ffsint3/ffsint2/build/web/resources/" + filename, "UTF-8");
                    writer.println("id ,taskfrom, description , startdate , revdate , enddate , taskstat");
                    while (rs.next()) {
                        Date date1 = new Date();
                        Calendar cal1 = new GregorianCalendar();
                        if (rs.getTimestamp("revdate") == null) {
                            cal1.setTime(rs.getTimestamp("enddate"));
                        } else {
                            cal1.setTime(rs.getTimestamp("revdate"));
                        }
                        String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                        String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                        String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                        String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                        String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                        if (hour1.length() == 1) {
                            hour1 = "0" + hour1;
                        }
                        if (minute1.length() == 1) {
                            minute1 = "0" + minute1;
                        }
                        if (month1.length() == 1) {
                            month1 = "0" + month1;
                        }
                        if (day1.length() == 1) {
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
                        if (hour2.length() == 1) {
                            hour2 = "0" + hour2;
                        }
                        if (minute2.length() == 1) {
                            minute2 = "0" + minute2;
                        }
                        if (month2.length() == 1) {
                            month2 = "0" + month2;
                        }
                        if (day2.length() == 1) {
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
                        if (hour3.length() == 1) {
                            hour3 = "0" + hour3;
                        }
                        if (minute3.length() == 1) {
                            minute3 = "0" + minute3;
                        }
                        if (month3.length() == 1) {
                            month3 = "0" + month3;
                        }
                        if (day3.length() == 1) {
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
                        writer.println(tranid + "," + taskfrom + "," + description + "," + startdate + "," + revdate + "," + enddate + "," + taskstat);
                        task.setTranid(tranid);
                        task.setTaskfrom(taskfrom);
                        task.setDescription(description);
                        task.setRevdate(revdate);
                        task.setEnddate(enddate);
                        task.setTaskstat(taskstat);
                        task.setStartdate(startdate);
                    }
                    writer.close();
                } catch (IOException e) {
                    // do something
                }
            }

        } else {
            String sql2 = "select name from users where branch = '" + reportBranch + "'";
            PreparedStatement pstm2 = conn.prepareStatement(sql2);
            ResultSet rs2 = pstm2.executeQuery();

            while (rs2.next()) {
                String sql = "select * from tasks where (taskto1='" + rs2.getString("name") + "' or taskto2='" + rs2.getString("name") + "' or taskto3='" + rs2.getString("name") + "' or taskto4='" + rs2.getString("name") + "' or taskto5='" + rs2.getString("name") + "' or taskto6='" + rs2.getString("name") + "' or taskto7='" + rs2.getString("name") + "' or taskto8='" + rs2.getString("name") + "' or taskto9='" + rs2.getString("name") + "' or taskto10='" + rs2.getString("name") + "' or taskto11='" + rs2.getString("name") + "' or taskto12='" + rs2.getString("name") + "' or taskto13='" + rs2.getString("name") + "' or taskto14='" + rs2.getString("name") + "' or taskto15='" + rs2.getString("name") + "') and taskstat='" + reportFor + "'";
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                try {
                    PrintWriter writer = new PrintWriter("C:/java/ffsint3/ffsint2/build/web/resources/" + filename, "UTF-8");
                    writer.println("id ,taskfrom, description , startdate , revdate , enddate , taskstat");
                    while (rs.next()) {
                        Date date1 = new Date();
                        Calendar cal1 = new GregorianCalendar();
                        if (rs.getTimestamp("revdate") == null) {
                            cal1.setTime(rs.getTimestamp("enddate"));
                        } else {
                            cal1.setTime(rs.getTimestamp("revdate"));
                        }
                        String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                        String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                        String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                        String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                        String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                        if (hour1.length() == 1) {
                            hour1 = "0" + hour1;
                        }
                        if (minute1.length() == 1) {
                            minute1 = "0" + minute1;
                        }
                        if (month1.length() == 1) {
                            month1 = "0" + month1;
                        }
                        if (day1.length() == 1) {
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
                        if (hour2.length() == 1) {
                            hour2 = "0" + hour2;
                        }
                        if (minute2.length() == 1) {
                            minute2 = "0" + minute2;
                        }
                        if (month2.length() == 1) {
                            month2 = "0" + month2;
                        }
                        if (day2.length() == 1) {
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
                        if (hour3.length() == 1) {
                            hour3 = "0" + hour3;
                        }
                        if (minute3.length() == 1) {
                            minute3 = "0" + minute3;
                        }
                        if (month3.length() == 1) {
                            month3 = "0" + month3;
                        }
                        if (day3.length() == 1) {
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
                        writer.println(tranid + "," + taskfrom + "," + description + "," + startdate + "," + revdate + "," + enddate + "," + taskstat);
                        task.setTranid(tranid);
                        task.setTaskfrom(taskfrom);
                        task.setDescription(description);
                        task.setRevdate(revdate);
                        task.setEnddate(enddate);
                        task.setTaskstat(taskstat);
                        task.setStartdate(startdate);

                        //     list.add(task);
                    }
                    writer.close();
                } catch (IOException e) {
                    // do something
                }
            }
        }
        Tasks task = new Tasks();
        task.setTaskfrom(filename);
        list.add(task);

        return list;
    }

    public static ArrayList<Tasks> getReportRole(Connection conn, UserAccount Username, String reportFor, String reportRole) throws SQLException {
        System.out.println("getReportRole " + reportRole);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(cal.get(Calendar.MINUTE));
        String second = Integer.toString(cal.get(Calendar.SECOND));
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        String filename = Username.getUserName() + "-" + hour + "-" + minute + "-" + second + ".csv";
        if (reportFor.length() == 0) {
            String sql = "select * from tasks where (taskto1='" + reportRole + "' or taskto2='" + reportRole + "' or taskto3='" + reportRole + "' or taskto4='" + reportRole + "' or taskto5='" + reportRole + "' or taskto6='" + reportRole + "' or taskto7='" + reportRole + "' or taskto8='" + reportRole + "' or taskto9='" + reportRole + "' or taskto10='" + reportRole + "' or taskto11='" + reportRole + "' or taskto12='" + reportRole + "' or taskto13='" + reportRole + "' or taskto14='" + reportRole + "' or taskto15='" + reportRole + "')";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            try {
                PrintWriter writer = new PrintWriter("C:/java/ffsint3/ffsint2/build/web/resources/" + filename, "UTF-8");
                writer.println("id ,taskfrom, description , startdate , revdate , enddate , taskstat");
                while (rs.next()) {
                    Date date1 = new Date();
                    Calendar cal1 = new GregorianCalendar();
                    if (rs.getTimestamp("revdate") == null) {
                        cal1.setTime(rs.getTimestamp("enddate"));
                    } else {
                        cal1.setTime(rs.getTimestamp("revdate"));
                    }
                    String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                    String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                    String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                    String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                    String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                    if (hour1.length() == 1) {
                        hour1 = "0" + hour1;
                    }
                    if (minute1.length() == 1) {
                        minute1 = "0" + minute1;
                    }
                    if (month1.length() == 1) {
                        month1 = "0" + month1;
                    }
                    if (day1.length() == 1) {
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
                    if (hour2.length() == 1) {
                        hour2 = "0" + hour2;
                    }
                    if (minute2.length() == 1) {
                        minute2 = "0" + minute2;
                    }
                    if (month2.length() == 1) {
                        month2 = "0" + month2;
                    }
                    if (day2.length() == 1) {
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
                    if (hour3.length() == 1) {
                        hour3 = "0" + hour3;
                    }
                    if (minute3.length() == 1) {
                        minute3 = "0" + minute3;
                    }
                    if (month3.length() == 1) {
                        month3 = "0" + month3;
                    }
                    if (day3.length() == 1) {
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
                    writer.println(tranid + "," + taskfrom + "," + description + "," + startdate + "," + revdate + "," + enddate + "," + taskstat);
                    task.setTranid(tranid);
                    task.setTaskfrom(taskfrom);
                    task.setDescription(description);
                    task.setRevdate(revdate);
                    task.setEnddate(enddate);
                    task.setTaskstat(taskstat);
                    task.setStartdate(startdate);

                    //    list.add(task);
                }
                writer.close();
            } catch (IOException e) {
                // do something
            }

        } else {
            String sql = "select * from tasks where (taskto1='" + reportRole + "' or taskto2='" + reportRole + "' or taskto3='" + reportRole + "' or taskto4='" + reportRole + "' or taskto5='" + reportRole + "' or taskto6='" + reportRole + "' or taskto7='" + reportRole + "' or taskto8='" + reportRole + "' or taskto9='" + reportRole + "' or taskto10='" + reportRole + "' or taskto11='" + reportRole + "' or taskto12='" + reportRole + "' or taskto13='" + reportRole + "' or taskto14='" + reportRole + "' or taskto15='" + reportRole + "') and taskstat='" + reportFor + "'";
            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            try {
                PrintWriter writer = new PrintWriter("C:/java/ffsint3/ffsint2/build/web/resources/" + filename, "UTF-8");
                writer.println("id ,taskfrom, description , startdate , revdate , enddate , taskstat");
                while (rs.next()) {
                    Date date1 = new Date();
                    Calendar cal1 = new GregorianCalendar();
                    if (rs.getTimestamp("revdate") == null) {
                        cal1.setTime(rs.getTimestamp("enddate"));
                    } else {
                        cal1.setTime(rs.getTimestamp("revdate"));
                    }
                    String year1 = Integer.toString(cal1.get(Calendar.YEAR));
                    String month1 = Integer.toString(cal1.get(Calendar.MONTH) + 1);
                    String day1 = Integer.toString(cal1.get(Calendar.DAY_OF_MONTH));
                    String hour1 = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
                    String minute1 = Integer.toString(cal1.get(Calendar.MINUTE));
                    if (hour1.length() == 1) {
                        hour1 = "0" + hour1;
                    }
                    if (minute1.length() == 1) {
                        minute1 = "0" + minute1;
                    }
                    if (month1.length() == 1) {
                        month1 = "0" + month1;
                    }
                    if (day1.length() == 1) {
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
                    if (hour2.length() == 1) {
                        hour2 = "0" + hour2;
                    }
                    if (minute2.length() == 1) {
                        minute2 = "0" + minute2;
                    }
                    if (month2.length() == 1) {
                        month2 = "0" + month2;
                    }
                    if (day2.length() == 1) {
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
                    if (hour3.length() == 1) {
                        hour3 = "0" + hour3;
                    }
                    if (minute3.length() == 1) {
                        minute3 = "0" + minute3;
                    }
                    if (month3.length() == 1) {
                        month3 = "0" + month3;
                    }
                    if (day3.length() == 1) {
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
                    writer.println(tranid + "," + taskfrom + "," + description + "," + startdate + "," + revdate + "," + enddate + "," + taskstat);
                    task.setTranid(tranid);
                    task.setTaskfrom(taskfrom);
                    task.setDescription(description);
                    task.setRevdate(revdate);
                    task.setEnddate(enddate);
                    task.setTaskstat(taskstat);
                    task.setStartdate(startdate);

                    //     list.add(task);
                }
                writer.close();
            } catch (IOException e) {
                // do something
            }
        }

        Tasks task = new Tasks();
        task.setTaskfrom(filename);
        list.add(task);

        return list;
    }

    public static ArrayList<TaskImage> getTaskImage(Connection connconn, UserAccount UserName, String tranid1) throws SQLException {
        System.out.println("getTaskImage " + tranid1);
        String tranid2 = "";
        Integer comp = 2;
        Integer tranlen = tranid1.length();

        if (tranlen.equals(1)) {
            tranid2 = "0" + tranid1;
        }
        if (tranlen.equals(2)) {
            tranid2 = tranid1;
        }
        if (tranlen > 2) {
            tranid2 = tranid1.substring(tranid1.length() - 2);
        }
        String sql = "Select tranid,user,imagedesc,imagetype,dateup from taskimag" + tranid2 + " a where a.taskid =?";

        PreparedStatement pstm = connconn.prepareStatement(sql);
        pstm.setString(1, tranid1);

        ResultSet rs = pstm.executeQuery();
        ArrayList<TaskImage> list = new ArrayList<TaskImage>();
        while (rs.next()) {
            String Tranid = rs.getString("tranid");
            String User = rs.getString("user");
            String ImageDesc = rs.getString("imagedesc");
            String ImageType = rs.getString("imagetype");

            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("dateup"));
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(calendar.get(Calendar.MINUTE));
            int length = month.length();
            if (length == 1) {
                month = "0" + month;
            }
            int length2 = day.length();
            if (length2 == 1) {
                day = "0" + day;
            }
            int length3 = hour.length();
            if (length3 == 1) {
                hour = "0" + hour;
            }
            int length4 = minute.length();
            if (length4 == 1) {
                minute = "0" + minute;
            }
            String thistime = year + "/" + month + "/" + day;
            String DateUp = thistime;

            TaskImage taskimage = new TaskImage();
            taskimage.setTranid(Tranid);
            taskimage.setUser(User);
            taskimage.setImageDesc(ImageDesc);
            taskimage.setImageType(ImageType);
            taskimage.setDateUp(DateUp);

            list.add(taskimage);
        }
        return list;
    }

    public static ArrayList<Tasks> TaskFile(Connection conn, String tranid, String diaryid) throws SQLException, FileNotFoundException, IOException {
        String tranid2;
        Integer comp = 2;
        Integer tranlen = tranid.length();
        int retval = comp.compareTo(tranlen);
        if (retval > 0) {
            tranid2 = "0" + tranid;
        } else if (retval < 0) {
            tranid2 = tranid.substring(tranid.length() - 2);
        } else {
            tranid2 = tranid;
        }

        System.out.println("tranid2 " + tranid2 + " diaryid " + diaryid + " tranid " + tranid);

        String sql = "Select * from taskimag" + tranid2 + " where tranid = ? and taskid = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, diaryid);
        pstm.setString(2, tranid);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Tasks> list = new ArrayList<Tasks>();
        if (rs.next()) {
            String thisFile = rs.getString("imagedesc") + rs.getString("imagetype");
            String filename = "C:/java/ffsint3/ffsint2/build/web/resources/" + rs.getString("imagedesc") + rs.getString("imagetype");
            File file = new File(filename);

            FileOutputStream output = new FileOutputStream(file);
            InputStream input = rs.getBinaryStream("imag1");
            byte[] buffer = new byte[1024];
            while (input.read(buffer) > 0) {
                output.write(buffer);
            }

            Tasks tasks = new Tasks();
            tasks.setTaskfrom(thisFile);
            list.add(tasks);

        }
        return list;
    }

    public static ArrayList<TaskImage> getTaskUpImag(Connection connconn, String tranid1, String userName, String Description, String filetype, FileItem thisfile) throws SQLException {

        String tranid2;
        Integer comp = 2;
        Integer tranlen = tranid1.length();
        int retval = comp.compareTo(tranlen);
        if (retval > 0) {
            tranid2 = "0" + tranid1;
        } else if (retval < 0) {
            tranid2 = tranid1.substring(tranid1.length() - 2);
        } else {
            tranid2 = tranid1;
        }

        System.out.println("getTaskUpImag " + userName + " size " + String.valueOf(thisfile.getSize()) + " " + tranid2);
        PreparedStatement pstm2 = null;
        FileInputStream fis;

        pstm2 = connconn.prepareStatement("insert into taskimag" + tranid2 + " (user, dateup,imagedesc, taskid, imagetype, imag1) values (?, current_timestamp, ? , '" + tranid1 + "' ,'" + filetype + "', ?)");
//PreparedStatement pstm2 = connconn.prepareStatement(sql2);
        OutputStream inputstream = null;
        try {
            inputstream = thisfile.getOutputStream();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pstm2.setString(1, userName);
        pstm2.setString(2, Description);
//pstm2.setBlob(3,inputstream);
        try {
            pstm2.setBinaryStream(3, thisfile.getInputStream(), (int) thisfile.getSize());
        } catch (IOException e) {
            e.printStackTrace();

        }
// pstm2.setString(1, tranid1);

        Integer temp1 = pstm2.executeUpdate();

        String sql = "Select * from taskimag" + tranid2 + " a where a.taskid =?";

        PreparedStatement pstm = connconn.prepareStatement(sql);
        pstm.setString(1, tranid1);

        ResultSet rs = pstm.executeQuery();
        ArrayList<TaskImage> list = new ArrayList<TaskImage>();
        while (rs.next()) {
            String Tranid = rs.getString("tranid");
            String User = rs.getString("user");
            String ImageDesc = rs.getString("imagedesc");
            String ImageType = rs.getString("imagetype");

            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("dateup"));
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(calendar.get(Calendar.MINUTE));
            int length = month.length();
            if (length == 1) {
                month = "0" + month;
            }
            int length2 = day.length();
            if (length2 == 1) {
                day = "0" + day;
            }
            int length3 = hour.length();
            if (length3 == 1) {
                hour = "0" + hour;
            }
            int length4 = minute.length();
            if (length4 == 1) {
                minute = "0" + minute;
            }
            String thistime = year + "/" + month + "/" + day + " " + hour + ":" + minute;
            String DateUp = thistime;

            TaskImage taskimage = new TaskImage();
            taskimage.setTranid(Tranid);
            taskimage.setUser(User);
            taskimage.setImageDesc(ImageDesc);

            taskimage.setImageType(ImageType);
            taskimage.setDateUp(DateUp);

            list.add(taskimage);
        }
        return list;
    }

}
