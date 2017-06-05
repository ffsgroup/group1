package ffsutils;

import ffsbeans.memberNotes;
import ffsbeans.MemberDepen;
import ffsbeans.MemberRec;
import ffsbeans.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.Generics;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.sql.Connection;

public class MemUtils {
    
    
    public static ArrayList<memberNotes> getmemberNotes(Connection conn, String thisMember, String userName) throws SQLException {

        System.out.println("getmemberNotes " + thisMember);
        String sql = "Select * from tblcomments where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<memberNotes> list = new ArrayList<memberNotes>();
        while (rs.next()) {
            memberNotes membernotes = new memberNotes();
                          Date date = new Date();
            Calendar calendar = new GregorianCalendar();

             if (rs.getTimestamp("trandate") == null) {
                System.out.println("12" );
                calendar.setTime(rs.getTimestamp("dateMod"));
            } else {if(rs.getTimestamp("trandate").getYear() > 1900){
               calendar.setTime(rs.getTimestamp("trandate"));  
            } else{
                calendar.setTime(rs.getTimestamp("dateMod"));
            }
            }
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            if (month.length() == 1) {
                month = "0" + month;
            }
            if (day.length() == 1) {
                day = "0" + day;
            }
            String dateMod = year + "/" + month + "/" + day;

              membernotes.settranId(rs.getString("tranId"));
               membernotes.settranUserId(rs.getString("tranUserId"));
                membernotes.settranComment(rs.getString("tranComment"));
                membernotes.setdateMod(dateMod);
            list.add(membernotes);
        }
        return list;
    }
    
    

    public static ArrayList<MemberDepen> getMemberDepen(Connection conn, String thisMember, String userName) throws SQLException {

        System.out.println("getMemberDepen " + thisMember);
        String sql = "Select *,(select genericdescriptioneng from generics where gengroupid = '9' and genericid = afhank.sex) as depensex,(select genericdescriptioneng from generics where gengroupid = '14' and genericid = afhank.verwskap) as relationship from afhank where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberDepen> list = new ArrayList<MemberDepen>();
        while (rs.next()) {
            MemberDepen memberdepen = new MemberDepen();

            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("gebdat"));
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            int length = month.length();
            if (length == 1) {
                month = "0" + month;
            }
            int length2 = day.length();
            if (length2 == 1) {
                day = "0" + day;
            }

            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            if (rs.getTimestamp("statusdate") == null) {
                cal1.setTime(rs.getTimestamp("joindat"));
            } else {
                cal1.setTime(rs.getTimestamp("statusdate"));
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

            String statusdate = year1 + "/" + month1 + "/" + day1;
            String gebdat = year + "/" + month + "/" + day;

            memberdepen.setini(rs.getString("ini"));
            memberdepen.setsur(rs.getString("sur"));
            memberdepen.setgebdat(gebdat);
            memberdepen.setsex(rs.getString("depensex"));
            memberdepen.setverwskap(rs.getString("relationship"));
            memberdepen.setpremie(rs.getString("premie"));
            memberdepen.setstatus(rs.getString("status"));
            memberdepen.setstatusdate(statusdate);
            memberdepen.setTranid(rs.getString("tranid"));

            list.add(memberdepen);
        }
        return list;
    }

    public static ArrayList<Generics> getPolStatus(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '10' order by GenericID asc";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String GenericDescriptionEng = rs.getString("GenericDescriptionEng");

            Generics generics = new Generics();
            generics.setGenericDescriptionEng(GenericDescriptionEng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getPolicyType(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '33' order by GenericID asc";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String GenericDescriptionEng = rs.getString("GenericDescriptionEng");

            Generics generics = new Generics();
            generics.setGenericDescriptionEng(GenericDescriptionEng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getCompanyName(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '32' order by GenericID asc";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String GenericDescriptionEng = rs.getString("GenericDescriptionEng");

            Generics generics = new Generics();
            generics.setGenericDescriptionEng(GenericDescriptionEng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getMarriage(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '12' order by GenericID asc";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String GenericDescriptionEng = rs.getString("GenericDescriptionEng");

            Generics generics = new Generics();
            generics.setGenericDescriptionEng(GenericDescriptionEng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getRecruit(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '35'";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String GenericDescriptionEng = rs.getString("GenericDescriptionEng");

            Generics generics = new Generics();
            generics.setGenericDescriptionEng(GenericDescriptionEng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Member> getMember(Connection conn, String thisMember, String userName) throws SQLException {

        System.out.println("getMember " + thisMember);
        String sql = "Select * from lededata where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Member> list = new ArrayList<Member>();
        if (rs.next()) {
            Member members = new Member();
            members.setlidno(rs.getString("lidno"));
            members.setsur(rs.getString("sur"));
            members.setini(rs.getString("ini"));
            members.setshortname(rs.getString("shortname"));
            members.setidno(rs.getString("idno"));
            members.setsex(rs.getString("sex"));
            members.setemail(rs.getString("email"));
            members.setrecruiter(rs.getString("recruiter"));
//            members.setrecruitdate(rs.getString("recruitdate"));
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("recruitdate"));
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            int length = month.length();
            if (length == 1) {
                month = "0" + month;
            }
            int length2 = day.length();
            if (length2 == 1) {
                day = "0" + day;
            }

            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            if (rs.getTimestamp("postdate") == null) {
                cal1.setTime(rs.getTimestamp("joindat"));
            } else {
                cal1.setTime(rs.getTimestamp("postdate"));
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

            cal2.setTime(rs.getTimestamp("joindat"));
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

            if (rs.getTimestamp("eisdat") == null) {
                cal3.setTime(rs.getTimestamp("joindat"));
            } else {
                cal3.setTime(rs.getTimestamp("eisdat"));
            }
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

            if (rs.getTimestamp("bettot") == null) {
                cal4.setTime(rs.getTimestamp("joindat"));
            } else {
                cal4.setTime(rs.getTimestamp("bettot"));
            }
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

            if (rs.getTimestamp("benefdate") == null) {
                cal5.setTime(rs.getTimestamp("joindat"));
            } else {
                cal5.setTime(rs.getTimestamp("benefdate"));
            }
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

            //Calender for birthday
            Date date6 = new Date();
            Calendar calendar6 = new GregorianCalendar();

            calendar6.setTime(rs.getTimestamp("gebdat"));
            String year6 = Integer.toString(calendar6.get(Calendar.YEAR));
            String month6 = Integer.toString(calendar6.get(Calendar.MONTH) + 1);
            String day6 = Integer.toString(calendar6.get(Calendar.DAY_OF_MONTH));
            if (month6.length() == 1) {
                month6 = "0" + month6;
            }
            if (day6.length() == 1) {
                day6 = "0" + day6;
            }
            
            // Calender for today
            Date date16 = new Date();
            Calendar calendar16 = new GregorianCalendar();
            calendar16.setTime(new Date());
            String year16 = Integer.toString(calendar16.get(Calendar.YEAR));
            String month16 = Integer.toString(calendar16.get(Calendar.MONTH) + 1);
            String day16 = Integer.toString(calendar16.get(Calendar.DAY_OF_MONTH));
            if (month16.length() == 1) {
                month16 = "0" + month16;
            }
            if (day16.length() == 1) {
                day16 = "0" + day16;
            }

            Date date7 = new Date();
            Calendar calendar7 = new GregorianCalendar();

            calendar7.setTime(rs.getTimestamp("aanstdat"));
            String year7 = Integer.toString(calendar7.get(Calendar.YEAR));
            String month7 = Integer.toString(calendar7.get(Calendar.MONTH) + 1);
            String day7 = Integer.toString(calendar7.get(Calendar.DAY_OF_MONTH));
            if (month7.length() == 1) {
                month7 = "0" + month7;
            }
            if (day7.length() == 1) {
                day7 = "0" + day7;
            }
            
               int yearsInBetween = calendar6.get(Calendar.YEAR) 
                                - calendar16.get(Calendar.YEAR);
                int monthsDiff = calendar6.get(Calendar.MONTH) 
                                - calendar16.get(Calendar.MONTH);

//                if (month6 > month16)
//                {
//                  String byear = year16 - year6 - 1;
//                  String bmonth = 12 - month6 + month16; 
//                }


      



            String aanstdat = year7 + "/" + month7 + "/" + day7;
            String gebdat = year6 + "/" + month6 + "/" + day6;
            String benefdate = year5 + "/" + month5 + "/" + day5;
            String bettot = year4 + "/" + month4 + "/" + day4;
            String eisdat = year3 + "/" + month3 + "/" + day3;
            String joindat = year2 + "/" + month2 + "/" + day2;
            String postdate = year1 + "/" + month1 + "/" + day1;
            String thistime = year + "/" + month + "/" + day;
            members.setrecruitdate(thistime);
            
          
            members.settroustat(rs.getString("troustat"));
            members.setgebdat(gebdat);
            members.setaanstdat(aanstdat);
//            members.setjoindat(rs.getString("joindat"));
            members.setorgid(rs.getString("orgid"));
            members.setlidtipe(rs.getString("lidtipe"));
            members.settaal(rs.getString("taal"));
            members.setcancode(rs.getString("cancode"));
            members.setstatus(rs.getString("status"));
            members.setinitialPayment(rs.getString("initialPayment"));
            //tab 2 Contact
            members.setphysline1(rs.getString("physline1"));
            members.setphysline2(rs.getString("physline2"));
            members.setphysline3(rs.getString("physline3"));
            members.setphyscode(rs.getString("physcode"));
            members.setpobox(rs.getString("pobox"));
            members.setstreet(rs.getString("street"));
            members.setcity(rs.getString("city"));
            members.setzip(rs.getString("zip"));
            members.setpostdate(postdate);
            members.setopmaak(rs.getString("opmaak"));
            members.settelh(rs.getString("telh"));
            members.settelw(rs.getString("telw"));
            //tab 4 Account
            members.setjoindat(joindat);
            members.seteisdat(eisdat);
            members.setbranch(rs.getString("branch"));
            members.setcoveramount(rs.getString("coveramount"));
            members.setbetmet(rs.getString("betmet"));
            members.setbettot(bettot);
            members.setpaypoint(rs.getString("paypoint"));
            members.setbenefname(rs.getString("benefname"));
            members.setbenefID(rs.getString("benefID"));
            members.setbenefRelation(rs.getString("benefRelation"));
//                members.setbenefdate(rs.getString("benefdate"));
            members.setbenefdate(benefdate);

            list.add(members);
        }
        return list;
    }

    public static ArrayList<MemberRec> getMemberRec(Connection conn, String thisMember, String userName) throws SQLException {

        System.out.println("getMemberRec " + thisMember);
        String sql = "Select *,(select genericdescriptioneng from generics where gengroupid = '3' and genericid = lidkwit.betmet) as recpaymet from lidkwit where lidno = ? order by tranid desc";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberRec> list = new ArrayList<MemberRec>();
        while (rs.next()) {
            MemberRec memberrec = new MemberRec();

            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("datum"));
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            int length = month.length();
            if (length == 1) {
                month = "0" + month;
            }
            int length2 = day.length();
            if (length2 == 1) {
                day = "0" + day;
            }

            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            cal1.setTime(rs.getTimestamp("bettot"));
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

            String datum = year + "/" + month + "/" + day;
            String bettot = year1 + "/" + month1 + "/" + day1;
            memberrec.setkwitno(rs.getString("kwitno"));
            memberrec.setdatum(datum);
            memberrec.setbedrag(rs.getString("bedrag"));
            memberrec.setbetmet(rs.getString("recpaymet"));
            memberrec.setdescr(rs.getString("descr"));
            memberrec.setoperator(rs.getString("operator"));
            memberrec.setbettot(bettot);
            memberrec.setcardused(rs.getString("cardused"));
            memberrec.setdecsign(rs.getString("decsign"));

            list.add(memberrec);
        }
        return list;
    }

}
