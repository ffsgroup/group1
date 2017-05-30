package ffsutils;

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

            String joindat = year2 + "/" + month2 + "/" + day2;
            String postdate = year1 + "/" + month1 + "/" + day1;
            String thistime = year + "/" + month + "/" + day;
            members.setrecruitdate(thistime);

            members.settroustat(rs.getString("troustat"));
            members.setgebdat(rs.getString("gebdat"));
            members.setaanstdat(rs.getString("aanstdat"));
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

            list.add(members);
        }
        return list;
    }

    public static ArrayList<MemberRec> getMemberRec(Connection conn, String thisMember, String userName) throws SQLException {

        System.out.println("getMemberRec " + thisMember);
        String sql = "Select * from lidkwit where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberRec> list = new ArrayList<MemberRec>();
        while (rs.next()) {
            MemberRec memberrec = new MemberRec();
            memberrec.setkwitno(rs.getString("kwitno"));

            list.add(memberrec);
        }
        return list;
    }

}
