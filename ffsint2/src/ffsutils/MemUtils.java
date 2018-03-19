package ffsutils;

import ffsbeans.MemberDebitOrder;
import ffsbeans.MemberClaims;
import ffsbeans.MemberImages;
import ffsbeans.MemberNote;
import ffsbeans.MemberDepen;
import ffsbeans.MemberRec;
import ffsbeans.Member;
import ffsbeans.MemberClaimSumm;
import ffsbeans.MemberExtraPol;
import ffsbeans.UserAccount;
import ffsbeans.Generics;
import ffsbeans.MemberClaimDoc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;

public class MemUtils {
   public static ArrayList<MemberNote> getmemberOneNote(Connection conn, String thisMember, UserAccount userName, String tranid) throws SQLException {

        System.out.println("getmemberOneNote " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".tblcomments where lidno = ? and tranid = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);
        pstm.setString(2,tranid);
        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberNote> list = new ArrayList<MemberNote>();
        while (rs.next()) {
            MemberNote membernotes = new MemberNote();
            membernotes.settranComment(rs.getString("trancomment"));
            list.add(membernotes);
        }
        return list;
    }
   
    public static ArrayList<MemberDepen> getMemberActiveDepen(Connection conn, String thisMember, UserAccount userName) throws SQLException {
        System.out.println("getMemberActiveDepen" + thisMember);
        String sql = "select count(status) from " + userName.getcompany() + ".afhank where lidno = ? and status = 'active'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberDepen> list = new ArrayList<MemberDepen>();
        while (rs.next()) {
            MemberDepen memberactivedepen = new MemberDepen();

            memberactivedepen.setstatus(rs.getString("count(status)"));
            System.out.println("getMemberActiveDepen Count:" + rs.getString("count(status)"));
            list.add(memberactivedepen);
        }
        return list;
    }

    public static ArrayList<MemberDebitOrder> getmemberDebitOrder(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getmemberDebitOrder " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".tbldebitorder where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberDebitOrder> list = new ArrayList<MemberDebitOrder>();
        while (rs.next()) {
            MemberDebitOrder memberdebitorder = new MemberDebitOrder();
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(rs.getTimestamp("DAT1"));
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            if (month.length() == 1) {
                month = "0" + month;
            }
            if (day.length() == 1) {
                day = "0" + day;
            }
            String DAT1 = year + "/" + month + "/" + day;

            Calendar calendar2 = new GregorianCalendar();
            calendar2.setTime(rs.getTimestamp("startstop"));
            String year2 = Integer.toString(calendar2.get(Calendar.YEAR));
            String month2 = Integer.toString(calendar2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(calendar2.get(Calendar.DAY_OF_MONTH));
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
                day2 = "0" + day2;
            }
            String DAT2 = year2 + "/" + month2 + "/" + day2;

            memberdebitorder.settranId(rs.getString("tranId"));
            memberdebitorder.setREK_NAAM(rs.getString("REK_NAAM"));
            memberdebitorder.setREK_NO(rs.getString("REK_NO"));
            memberdebitorder.setKERE(rs.getString("KERE"));
            memberdebitorder.setBankName(rs.getString("BankName"));
            memberdebitorder.setTIPE_REK(rs.getString("TIPE_REK"));
            memberdebitorder.setTAKKODE(rs.getString("TAKKODE"));
            memberdebitorder.setEmpName1(rs.getString("EmpName1"));
            memberdebitorder.setEmpName2(rs.getString("EmpName2"));
            memberdebitorder.setPayerID(rs.getString("PayerID"));
            memberdebitorder.setPayerName(rs.getString("PayerName"));
            memberdebitorder.setSalNr(rs.getString("SalNr"));
            memberdebitorder.setDAT1(DAT1);
            memberdebitorder.setstartStop(DAT2);
            list.add(memberdebitorder);
        }
        return list;
    }

    public static ArrayList<MemberImages> getmemberVoice(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getmemberVoice " + thisMember);
        String tranid2 = "";
        Integer comp = 2;
        Integer tranlen = thisMember.length();

        if (tranlen.equals(1)) {
            tranid2 = "0" + thisMember;
        }
        if (tranlen.equals(2)) {
            tranid2 = thisMember;
        }
        if (tranlen > 2) {
            tranid2 = thisMember.substring(thisMember.length() - 2);
        }
        String sql = "Select tranid,user,description,datemod,imagetype from " + userName.getcompany() + ".imagelibrary" + tranid2 + " a where lidno = ? and ((imagetype like 'wav%') or (imagetype like 'wav%')or (imagetype like 'wav%'))";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberImages> list = new ArrayList<MemberImages>();
        while (rs.next()) {
            MemberImages membervoice = new MemberImages();
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("dateMod"));
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

            membervoice.settranId(rs.getString("tranId"));
            membervoice.setuser(rs.getString("user"));
            membervoice.setdescription(rs.getString("description"));
            membervoice.setdateMod(dateMod);
            list.add(membervoice);
        }
        return list;
    }

    public static ArrayList<MemberClaims> getmemberClaims(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getmemberClaims " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".claims where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberClaims> list = new ArrayList<MemberClaims>();
        while (rs.next()) {
            MemberClaims memberclaims = new MemberClaims();
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            if (rs.getTimestamp("ClaimDate") == null) {
            } else {
                calendar.setTime(rs.getTimestamp("ClaimDate"));
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

            Date date1 = new Date();
            Calendar cal1 = new GregorianCalendar();

            if (rs.getTimestamp("DateOfDeath") == null) {
            } else {
                calendar.setTime(rs.getTimestamp("DateOfDeath"));
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

            String ClaimDate = year + "/" + month + "/" + day;
            String dod = year1 + "/" + month1 + "/" + day;

            memberclaims.settranId(rs.getString("tranId"));
            memberclaims.setClaimNr(rs.getString("ClaimNr"));
            memberclaims.setDeceasedSur(rs.getString("DeceasedSur"));
            memberclaims.setDeceasedIni(rs.getString("DeceasedIni"));
            memberclaims.setClaimStatus(rs.getString("ClaimStatus"));
            memberclaims.setClaimDate(ClaimDate);
            memberclaims.setDateOfDeath(dod);
            list.add(memberclaims);
        }
        return list;
    }

    public static ArrayList<MemberImages> getmemberImages(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getmemberImages " + thisMember);
        String tranid2 = "";
        Integer comp = 2;
        Integer tranlen = thisMember.length();

        if (tranlen.equals(1)) {
            tranid2 = "0" + thisMember;
        }
        if (tranlen.equals(2)) {
            tranid2 = thisMember;
        }
        if (tranlen > 2) {
            tranid2 = thisMember.substring(thisMember.length() - 2);
        }
        String sql = "Select tranid,user,description,datemod,imagetype from " + userName.getcompany() + ".imagelibrary" + tranid2 + " a where lidno = ? and not ((imagetype like 'wav%') or (imagetype like 'wav%')or (imagetype like 'wav%'))";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberImages> list = new ArrayList<MemberImages>();
        while (rs.next()) {
            MemberImages memberimages = new MemberImages();
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("dateMod"));
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

            memberimages.settranId(rs.getString("tranId"));
            memberimages.setuser(rs.getString("user"));
            memberimages.setdescription(rs.getString("description"));
            memberimages.setdateMod(dateMod);
            list.add(memberimages);
        }
        return list;
    }

    public static ArrayList<MemberNote> getmemberNotes(Connection conn, String thisMember, UserAccount userName) throws SQLException {
        System.out.println("getmemberNotes " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".tblcomments where lidno = ? order by tranid desc";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberNote> list = new ArrayList<MemberNote>();
        while (rs.next()) {
            MemberNote membernotes = new MemberNote();
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            //Fails if date is 0000-00-00

            calendar.setTime(rs.getTimestamp("trandate"));
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
            membernotes.settranDescr(rs.getString("trandescr"));
            membernotes.setdateMod(dateMod);
            list.add(membernotes);
        }
        return list;
    }

    public static ArrayList<MemberDepen> getMemberDepen(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getMemberDepen " + thisMember);
        String sql = "Select *,(select genericdescriptioneng from " + userName.getcompany() + ".generics where gengroupid = '9' and genericid = afhank.sex) as depensex,(select genericdescriptioneng from " + userName.getcompany() + ".generics where gengroupid = '14' and genericid = afhank.verwskap) as relationship from " + userName.getcompany() + ".afhank where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);

        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberDepen> list = new ArrayList<MemberDepen>();
        while (rs.next()) {
            MemberDepen memberdepen = new MemberDepen();

            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("gebdat"));

            //                       var startdate = new Date(value['gebdat']);
            Date enddate = new Date();
            Calendar calendarEnd = new GregorianCalendar();
            calendarEnd.setTime(enddate);

            int monthsDif = calendarEnd.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
            int yearsDif = calendarEnd.get(calendar.YEAR) - calendar.get(Calendar.YEAR);
            if (monthsDif < 1) {
                monthsDif += 12;
                yearsDif--;
            }

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
            memberdepen.setage(Integer.toString(yearsDif) + "." + Integer.toString(monthsDif));
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

    public static ArrayList<Generics> getPolStatus(Connection conn, UserAccount userName) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from " + userName.getcompany() + ".Generics a where GenGroupId = '10' order by GenericID asc";

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

    public static ArrayList<Generics> getPolicyType(Connection conn, UserAccount userName) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from " + userName.getcompany() + ".Generics a where GenGroupId = '33' order by GenericID asc";

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

    public static ArrayList<Generics> getCompanyName(Connection conn, UserAccount userName) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from " + userName.getcompany() + ".Generics a where GenGroupId = '32' order by GenericID asc";

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

    public static ArrayList<Generics> getMarriage(Connection conn, UserAccount userName) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from " + userName.getcompany() + ".Generics a where GenGroupId = '12' order by GenericID asc";

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

    public static ArrayList<Generics> getRecruit(Connection conn, UserAccount userName) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from " + userName.getcompany() + ".Generics a where GenGroupId = '35'";

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

    public static ArrayList<Member> getMember(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getMember " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".lededata where lidno = ?";
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
            String thistime;
            if (rs.getTimestamp("postdate") == null) {
                thistime = "";
            } else {
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
                thistime = year + "/" + month + "/" + day;
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
            String aanstdat = year7 + "/" + month7 + "/" + day7;
            String gebdat = year6 + "/" + month6 + "/" + day6;
            String benefdate = year5 + "/" + month5 + "/" + day5;
            String bettot = year4 + "/" + month4 + "/" + day4;
            String eisdat = year3 + "/" + month3 + "/" + day3;
            String joindat = year2 + "/" + month2 + "/" + day2;
            String postdate = year1 + "/" + month1 + "/" + day1;

            members.setrecruitdate(thistime);
            members.settroustat(rs.getString("troustat"));
            members.setgebdat(gebdat);
            members.setaanstdat(aanstdat);
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
            System.out.println("getMember " + rs.getString("betmet"));
            members.setbettot(bettot);
            members.setpaypoint(rs.getString("paypoint"));
            members.setbenefname(rs.getString("benefname"));
            members.setbenefID(rs.getString("benefID"));
            members.setbenefRelation(rs.getString("benefRelation"));
            members.setkrediet(rs.getString("krediet"));
//                members.setbenefdate(rs.getString("benefdate"));
            members.setbenefdate(benefdate);
            members.setGroupSc(rs.getString("GroupSc"));
            String Alerted = rs.getString("newprelidno");
            if (rs.getString("newprelidno") == null) {
                Alerted = "NNNNNNNNN";
            }

            while (Alerted.length() < 9) {
                Alerted = Alerted + 'N';
            }
            members.setnewprelidno(Alerted);

            list.add(members);
        }
        return list;
    }

    public static ArrayList<MemberRec> getMemberRec(Connection conn, String thisMember, UserAccount userName) throws SQLException {

        System.out.println("getMemberRec " + thisMember);
        String sql = "Select *,(select genericdescriptioneng from " + userName.getcompany() + ".generics where gengroupid = '3' and genericid = lidkwit.betmet) as recpaymet from " + userName.getcompany() + ".lidkwit where lidno = ? order by tranid desc";
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

    public static ArrayList<MemberExtraPol> getMemberExtraPol(Connection conn, String thisMember, UserAccount userName) throws SQLException {
        System.out.println("getMemberExtraPol " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".extrapol where mainpol = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);
        ResultSet rs = pstm.executeQuery();
        ArrayList<MemberExtraPol> list = new ArrayList<MemberExtraPol>();
        while (rs.next()) {
            MemberExtraPol memberextra = new MemberExtraPol();
            memberextra.setSecPol1(rs.getString("secpol1"));
            memberextra.setSecPol1Premie(rs.getString("secpol1premie"));
            memberextra.setSecPol2(rs.getString("secpol2"));
            memberextra.setSecPol2Premie(rs.getString("secpol2premie"));
            memberextra.setSecPol3(rs.getString("secpol3"));
            memberextra.setSecPol3Premie(rs.getString("secpol3premie"));
            memberextra.setSecPol4(rs.getString("secpol4"));
            memberextra.setSecPol4Premie(rs.getString("secpol4premie"));
            memberextra.setSecPol5(rs.getString("secpol5"));
            memberextra.setSecPol5Premie(rs.getString("secpol5premie"));
            memberextra.setSecPol6(rs.getString("secpol6"));
            memberextra.setSecPol6Premie(rs.getString("secpol6premie"));
            memberextra.setSecPol7(rs.getString("secpol7"));
            memberextra.setSecPol7Premie(rs.getString("secpol7premie"));
            memberextra.setSecPol8(rs.getString("secpol8"));
            memberextra.setSecPol8Premie(rs.getString("secpol8premie"));
            memberextra.setSecPol9(rs.getString("secpol9"));
            memberextra.setSecPol9Premie(rs.getString("secpol9premie"));
            memberextra.setSecPol10(rs.getString("secpol10"));
            memberextra.setSecPol10Premie(rs.getString("secpol10premie"));
            list.add(memberextra);
        }
        return list;
    }

    public static ArrayList<Generics> getMemberHavePost(Connection conn, String thisMember, UserAccount userName) throws SQLException {
        System.out.println("getMemberHavePost " + thisMember);
        String sql = "Select * from " + userName.getcompany() + ".postsend where lidno = ? and recby = 'Nobody'";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisMember);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        Generics generic1 = new Generics();
        if (rs.next()) {
            generic1.setGenGroupId("Y");
            System.out.println("getMemberHavePost found post");
        } else {
            generic1.setGenGroupId("N");
        }
        list.add(generic1);
        return list;
    }

    public static ArrayList<MemberClaims> getClaimSumm(Connection conn, UserAccount userName, String tranId) throws SQLException {
        System.out.println("getClaimSumm " + tranId);

        String sql = "Select summid, tranid from " + userName.getcompany() + ".claims where claimnr = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tranId);
        ResultSet rs = pstm.executeQuery();

        ArrayList<MemberClaims> list = new ArrayList<MemberClaims>();

        if (rs.next()) {
            String ClaimTranId = rs.getString("tranid");
            System.out.println("getClaimSumm found summ " + rs.getString("summid"));
            String sql1 = "Select * from " + userName.getcompany() + ".claimsumm where tranid = ?";
            PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setString(1, rs.getString("summid"));
            ResultSet rs1 = pstm1.executeQuery();
            if (rs1.next()) {
                System.out.println("getClaimSumm set taskenq " + rs1.getString("taskclaim"));
                MemberClaims claimDet = new MemberClaims();
                claimDet.setClaimStatus(rs1.getString("taskenq"));
                claimDet.setClaimNr(rs1.getString("taskclaim"));
                claimDet.setDeceasedIni(rs1.getString("deceased"));
                claimDet.setClaimSur(rs1.getString("taskpay"));
                claimDet.setClaimId(rs1.getString("decid"));
                claimDet.setClaimRel(rs1.getString("lidno"));
                claimDet.setBenefName(ClaimTranId);                 // claim id
                claimDet.setBenefId(rs1.getString("tranid"));  // summ id
                list.add(claimDet);
            }
        }
        return list;
    }

    public static ArrayList<MemberClaimDoc> getClaimImage(Connection conn, UserAccount thisUser, String tranId) throws SQLException {
        System.out.println("getClaimImage " + tranId);

        String sql1 = "Select summid from " + thisUser.getcompany() + ".claims where claimnr = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, tranId);
        ResultSet rs1 = pstm1.executeQuery();

        String summId = "0";
        if (rs1.next()) {
            summId = rs1.getString("summid");
        }

        String sql = "Select * from " + thisUser.getcompany() + ".claimdoc where claimsumm = ? order by doc1user";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, summId);
        ResultSet rs = pstm.executeQuery();

        ArrayList<MemberClaimDoc> list = new ArrayList<MemberClaimDoc>();

        while (rs.next()) {
            MemberClaimDoc memDoc = new MemberClaimDoc();
            memDoc.setdoc1(rs.getString("doc1"));
            memDoc.setdoc1User(rs.getString("doc1user"));
            memDoc.setdoc1Date(rs.getString("doc1date"));
            memDoc.setwhatDoc(rs.getString("whatdoc"));
            memDoc.setnotNeeded(rs.getString("notNeeded"));
            list.add(memDoc);
        }
        return list;
    }

    public static MemberClaims getClaimDetails(Connection conn, UserAccount thisUser, String tranId) throws SQLException {
        System.out.println("getClaimDetails " + tranId);

        String sql1 = "Select * from " + thisUser.getcompany() + ".claims where tranid = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, tranId);
        ResultSet rs1 = pstm1.executeQuery();

        ArrayList<MemberClaims> list = new ArrayList<MemberClaims>();
        MemberClaims memClaim = new MemberClaims();

        if (rs1.next()) {

            memClaim.setClaimNr(rs1.getString("claimnr"));
            memClaim.setClaimDate(rs1.getString("claimdate"));
            memClaim.setDeceasedIni(rs1.getString("deceasedini"));
            memClaim.setDeceasedSur(rs1.getString("deceasedsur"));
            memClaim.setDateOfDeath(rs1.getString("dateofdeath"));
            memClaim.setlidNo(rs1.getString("lidno"));
            memClaim.setsummId(rs1.getString("summid"));
            memClaim.settombNr(rs1.getString("tombnr"));
            memClaim.setBenefName(rs1.getString("benefname"));
            memClaim.setBenefId(rs1.getString("benefid"));
            memClaim.settranId(rs1.getString("tranid"));
            memClaim.setdeceasedId(rs1.getString("deceasedid"));
            memClaim.setdecRel(rs1.getString("claimrelate"));
            memClaim.setClaimSur(rs1.getString("claimsur"));
            memClaim.setClaimId(rs1.getString("claimid"));
            memClaim.setClaimRel(rs1.getString("claimrel"));
            memClaim.setCause1(rs1.getString("causedeath"));
            memClaim.setCause2(rs1.getString("causedeath2"));
            memClaim.setclaimAm(rs1.getString("claimamount"));
            memClaim.setdateOfDeath(rs1.getString("dateofdeath"));
            memClaim.setgrocery(rs1.getString("grocery"));
            memClaim.setclaimTel(rs1.getString("claimtel"));
            memClaim.setcashFuneral(rs1.getString("cashfuneral"));
            memClaim.setbank(rs1.getString("bank"));
            memClaim.setclaimAdd1(rs1.getString("claimadd1"));
            memClaim.setfuneralAmount(rs1.getString("funeralamount"));
            memClaim.setbranchNr(rs1.getString("branchnr"));
            memClaim.setclaimAdd2(rs1.getString("claimadd2"));
            memClaim.setmemAge(rs1.getString("memage"));
            memClaim.setaccType(rs1.getString("acctipe"));
            memClaim.setclaimAdd3(rs1.getString("claimadd3"));
            memClaim.setpolDur(rs1.getString("polduration"));
            memClaim.setaccName(rs1.getString("accholder"));
            memClaim.setapprovalDate(rs1.getString("appovaldate"));
            memClaim.setaccNr(rs1.getString("accountnr"));
            memClaim.seteffDate(rs1.getString("effectivedate"));
            memClaim.setclaimStatus(rs1.getString("claimstatus"));
            memClaim.setclaimStat2(rs1.getString("claimstat2"));
            memClaim.setstoneIr(rs1.getString("stoneir"));
            memClaim.setclaimApp(rs1.getString("claimapp"));
            memClaim.setclaimSettled(rs1.getString("claimsettled"));
            memClaim.setcomments(rs1.getString("comments"));

            String tTipe = "Unknown";
            String sStat = "Unknown";
            String sDate = "";

            String sql2 = "select datadr, status, lidtipe,(select genericdescriptioneng from " + thisUser.getcompany() + ".generics where gengroupid='33' and genericid=lededata.lidtipe) as tipe, (select genericdescriptioneng from " + thisUser.getcompany() + ".generics where gengroupid='10' and genericid=lededata.status) as status1 from " + thisUser.getcompany() + ".lededata where lidno = ?";
            PreparedStatement pstm2 = conn.prepareStatement(sql2);
            pstm2.setString(1, rs1.getString("lidno"));
            ResultSet rs2 = pstm2.executeQuery();
            if (rs2.next()) {
                tTipe = rs2.getString("tipe");
                sStat = rs2.getString("status1");
                sDate = rs2.getString("datadr");
            }
            memClaim.setpolTipe(tTipe);
            memClaim.setstatus(sStat);
            memClaim.setstatusDate(sDate);

            list.add(memClaim);
        }
        return memClaim;
    }

    public static Member getMemberRecDetails(Connection conn, UserAccount userName, String member) throws SQLException {

        System.out.println("getMemberRecDetails " + member);
        String sql = "Select status, initialpayment, bettot, sur, ini, shortname, lidno, krediet from " + userName.getcompany() + ".lededata where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, member);

        ResultSet rs = pstm.executeQuery();
        Member members = new Member();
        if (rs.next()) {

            members.setlidno(rs.getString("lidno"));
            members.setsur(rs.getString("sur"));
            members.setini(rs.getString("ini"));
            members.setshortname(rs.getString("shortname"));

            Date date2 = new Date();
            Calendar cal2 = new GregorianCalendar();
            cal2.setTime(rs.getTimestamp("bettot"));

            String year2 = Integer.toString(cal2.get(Calendar.YEAR));
            String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
            String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
            if (month2.length() == 1) {
                month2 = "0" + month2;
            }
            if (day2.length() == 1) {
                day2 = "0" + day2;
            }
            Date today = new Date();
            Calendar caltoday = new GregorianCalendar();
            caltoday.setTime(today);
            if (caltoday.after(cal2)) {
                members.setbranch("after");  // today is after bettot
                if (caltoday.get(Calendar.MONTH) - 1 == cal2.get(Calendar.MONTH) && caltoday.get(Calendar.DAY_OF_MONTH) < 8) {
                    members.setpobox(Integer.toString(rs.getInt("initialpayment")));
                    members.setemail("0");
                    members.setcity("Member will be asked to sign declaration");
                }
                if (caltoday.get(Calendar.MONTH) - 1 == cal2.get(Calendar.MONTH) && caltoday.get(Calendar.DAY_OF_MONTH) > 7) {
                    members.setpobox(Integer.toString(rs.getInt("initialpayment") * 1));
                    members.setcity("Member will be asked to sign declaration");
                    members.setemail("1");
                }
                if (caltoday.get(Calendar.MONTH) - 1 == cal2.get(Calendar.MONTH) && caltoday.get(Calendar.DAY_OF_MONTH) > 14) {
                    members.setpobox(Integer.toString(rs.getInt("initialpayment") * 2));
                    members.setcity("Member will be asked to sign declaration");
                    members.setemail("1");
                }
                if (caltoday.get(Calendar.MONTH) - 2 == cal2.get(Calendar.MONTH) && caltoday.get(Calendar.DAY_OF_MONTH) > 7) {
                    members.setpobox(Integer.toString(rs.getInt("initialpayment") * 2));
                    members.setcity("Member will be asked to sign declaration");
                    members.setemail("1");
                }
                if (caltoday.get(Calendar.MONTH) - 3 == cal2.get(Calendar.MONTH) && caltoday.get(Calendar.DAY_OF_MONTH) > 7) {
                    members.setpobox(Integer.toString(rs.getInt("initialpayment") * 3));
                    members.setcity("Member will be asked to sign declaration");
                    members.setemail("1");
                }
            } else {
                members.setbranch("before"); //today is before bettot
                members.setpobox(rs.getString("initialpayment"));
            }
            members.setinitialPayment(rs.getString("initialPayment"));
            members.setbettot(year2 + "/" + month2 + "/" + day2);
            members.setkrediet(rs.getString("krediet"));
            members.setstatus(rs.getString("status"));

        }
        return members;
    }

    public static ArrayList<Generics> UpdateContact(Connection conn, UserAccount thisUser, String thisMember, String padd1, String padd2, String padd3, String pcode, String post1, String post2, String post3, String postcode, String phonecell, String phonework, String phonehome) throws SQLException {
        ArrayList<Generics> list = new ArrayList<Generics>();
        Generics generic1 = new Generics();
        generic1.setGenGroupId("failed");
        System.out.println("updateContact security " + thisMember + " " + thisUser.getsecurestr().substring(1, 2) + " " + padd1 + " " + post1);
        if (thisUser.getsecurestr().substring(1, 2).equals("1")) {
            System.out.println("updateContact " + thisMember);
            String sql1 = "update " + thisUser.getcompany() + ".lededata set pobox = ?, street = ? , city = ? , zip = ? , physline1 = ? , physline2 = ? , physline3 = ? , physcode = ? , telh = ? , telw = ? , opmaak = ? where lidno = ?";
            PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setString(1, post1);
            pstm1.setString(2, post2);
            pstm1.setString(3, post3);
            pstm1.setString(4, postcode);
            pstm1.setString(5, padd1);
            pstm1.setString(6, padd2);
            pstm1.setString(7, padd3);
            pstm1.setString(8, pcode);
            pstm1.setString(9, phonehome);
            pstm1.setString(10, phonework);
            pstm1.setString(11, phonecell);
            pstm1.setString(12, thisMember);

            pstm1.executeUpdate();
            generic1.setGenGroupId("success");

        } else {
            System.out.println("updateContact failed " + thisMember);
            generic1.setGenGroupId("failed");
        }
        list.add(generic1);
        return list;
    }

    public static ArrayList<Generics> UpdateAccount(Connection conn, UserAccount thisUser, String thisMember, String joindat, String claimdat, String coveramount, String bettot, String paypoint, String benefname, String benefid, String benefrelation, String benefdate, String mbranch, String paymeth, String accholder, String accNo, String deductDay, String bankName, String accType, String debitdate, String branchNr, String groupScheme, String empName1, String payerName, String empName2, String payerId, String stopOrderDate, String salNr) throws SQLException {
        ArrayList<Generics> list = new ArrayList<Generics>();
        Generics generic1 = new Generics();
        generic1.setGenGroupId("failed");
        // secure [4] from pos to pos , first pos = 0 , end pos excluded
        System.out.println("updateAccount security " + thisMember + " " + thisUser.getsecurestr().substring(3, 4) + " p " + paymeth);

        if (thisUser.getsecurestr().substring(3, 4).equals("1")) {
            String payMethNo = "0";
            if (paymeth.equals("Cash")) {
                payMethNo = "1";
            }
            if (paymeth.equals("Debit Order")) {
                payMethNo = "3";
            }
            if (paymeth.equals("Stop Order")) {
                payMethNo = "6";
            }
            if (paymeth.equals("DIRECT DEPOSIT")) {
                payMethNo = "2";
            }
            if (paymeth.equals("Staff Payment")) {
                payMethNo = "9";
            }
            if (paymeth.equals("Pensioners")) {
                payMethNo = "10";
            }
            String sql1 = "update " + thisUser.getcompany() + ".lededata set joindat = ?, eisdat = ? , branch = ? , coveramount = ? , bettot = ? , betmet = ? , paypoint = ? , benefname = ? , benefid = ? , benefrelation = ?, benefdate = ? where lidno = ?";
            PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setString(1, joindat);
            pstm1.setString(2, claimdat);
            pstm1.setString(3, mbranch);
            pstm1.setString(4, coveramount);
            pstm1.setString(5, bettot);
            pstm1.setString(6, payMethNo);
            pstm1.setString(7, paypoint);
            pstm1.setString(8, benefname);
            pstm1.setString(9, benefid);
            pstm1.setString(10, benefrelation);
            pstm1.setString(11, benefdate);
            pstm1.setString(12, thisMember);

            pstm1.executeUpdate();
            generic1.setGenGroupId("success");

            if (payMethNo == "3" || payMethNo == "6") {
                String sql2 = "select tranid from " + thisUser.getcompany() + ".tbldebitorder where lidno = ?";
                PreparedStatement pstm2 = conn.prepareStatement(sql2);
                pstm2.setString(1, thisMember);
                ResultSet rs2 = pstm2.executeQuery();
                if (rs2.next()) {  // have entry in tbldebit, must update
                    String sql3 = "update " + thisUser.getcompany() + ".tbldebitorder set rek_naam = ?, rek_no = ? , kere = ? , bankname = ? , tipe_rek = ? , dat1 = ? , takkode = ? , empname1 = ? , payername = ? , empname2 = ?, payerid = ?, salnr = ?  where lidno = ?";
                    PreparedStatement pstm3 = conn.prepareStatement(sql3);
                    pstm3.setString(1, accholder);
                    pstm3.setString(2, accNo);
                    pstm3.setString(3, deductDay);
                    pstm3.setString(4, bankName);
                    pstm3.setString(5, accType);
                    pstm3.setString(6, debitdate);
                    pstm3.setString(7, branchNr);
                    pstm3.setString(8, empName1);
                    pstm3.setString(9, payerName);
                    pstm3.setString(10, empName2);
                    pstm3.setString(11, payerId);
                    pstm3.setString(12, salNr);
                    pstm3.setString(13, thisMember);
                    pstm3.executeUpdate();

                } else { // no entry in tbldebit, insert now
                    String sql3 = "insert into " + thisUser.getcompany() + ".tbldebitorder ( lidno, rek_naam , rek_no , kere , bankname , tipe_rek , dat1 , takkode , empname1 , payername , empname2 , payrid , salnr) values ( ?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pstm3 = conn.prepareStatement(sql3);
                    pstm3.setString(1, accholder);
                    pstm3.setString(2, accNo);
                    pstm3.setString(3, deductDay);
                    pstm3.setString(4, bankName);
                    pstm3.setString(5, accType);
                    pstm3.setString(6, debitdate);
                    pstm3.setString(7, branchNr);
                    pstm3.setString(8, empName1);
                    pstm3.setString(9, payerName);
                    pstm3.setString(10, empName2);
                    pstm3.setString(11, payerId);
                    pstm3.setString(12, salNr);
                    pstm3.setString(13, thisMember);
                    pstm3.executeUpdate();
                }
            }
        } else {
            System.out.println("updateContact failed " + thisMember);
            generic1.setGenGroupId("failed");
        }
        list.add(generic1);
        return list;
    }

    public static ArrayList<MemberDepen> getOneDepen(Connection conn, UserAccount userName, String depenId, String member) throws SQLException {

        System.out.println("getOneDepen " + depenId + " security " + userName.getsecurestr().substring(3, 4));
        // secure [4] from pos to pos , first pos = 0 , end pos excluded
        MemberDepen memberdepen = new MemberDepen();

        if (!depenId.equals("0")) {
            String sql = "Select * from " + userName.getcompany() + ".afhank where tranid = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, depenId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                memberdepen.setTranid(rs.getString("tranid"));
                memberdepen.setini(rs.getString("ini"));
                memberdepen.setsur(rs.getString("sur"));
                if (rs.getString("verwskap").equals("1")) {
                    memberdepen.setverwskap("SPOUSE");
                }
                if (rs.getString("verwskap").equals("2")) {
                    memberdepen.setverwskap("CHILD");
                }
                if (rs.getString("verwskap").equals("3")) {
                    memberdepen.setverwskap("WIFE");
                }
                if (rs.getString("verwskap").equals("4")) {
                    memberdepen.setverwskap("HUSBAND");
                }
                if (rs.getString("verwskap").equals("5")) {
                    memberdepen.setverwskap("PARENT");
                }
                if (rs.getString("verwskap").equals("6")) {
                    memberdepen.setverwskap("STUDENT");
                }
                if (rs.getString("verwskap").equals("7")) {
                    memberdepen.setverwskap("CHILD - EXTRA");
                }
                if (rs.getString("verwskap").equals("8")) {
                    memberdepen.setverwskap("CHILD - DISABLED");
                }
                memberdepen.setlidno(rs.getString("lidno"));
                Date date2 = new Date();
                Calendar cal2 = new GregorianCalendar();
                cal2.setTime(rs.getTimestamp("gebdat"));
                String year2 = Integer.toString(cal2.get(Calendar.YEAR));
                String month2 = Integer.toString(cal2.get(Calendar.MONTH) + 1);
                String day2 = Integer.toString(cal2.get(Calendar.DAY_OF_MONTH));
                if (month2.length() == 1) {
                    month2 = "0" + month2;
                }
                if (day2.length() == 1) {
                    day2 = "0" + day2;
                }
                memberdepen.setsex("Female");
                memberdepen.setgebdat(year2 + "/" + month2 + "/" + day2);
                if (rs.getString("sex").equals("1")) {
                    memberdepen.setsex("Male");
                }
                memberdepen.setidno(rs.getString("idno"));
                memberdepen.setpremie(rs.getString("premie"));
                memberdepen.setstatus(rs.getString("status"));

                Calendar cal3 = new GregorianCalendar();
                cal3.setTime(rs.getTimestamp("joindate"));
                String year3 = Integer.toString(cal3.get(Calendar.YEAR));
                String month3 = Integer.toString(cal3.get(Calendar.MONTH) + 1);
                String day3 = Integer.toString(cal3.get(Calendar.DAY_OF_MONTH));
                if (month3.length() == 1) {
                    month3 = "0" + month3;
                }
                if (day3.length() == 1) {
                    day3 = "0" + day3;
                }
                memberdepen.setjoindate(year3 + "/" + month3 + "/" + day3);

                Calendar cal4 = new GregorianCalendar();
                cal4.setTime(rs.getTimestamp("statusdate"));
                String year4 = Integer.toString(cal4.get(Calendar.YEAR));
                String month4 = Integer.toString(cal4.get(Calendar.MONTH) + 1);
                String day4 = Integer.toString(cal4.get(Calendar.DAY_OF_MONTH));
                if (month4.length() == 1) {
                    month4 = "0" + month4;
                }
                if (day4.length() == 1) {
                    day4 = "0" + day4;
                }
                memberdepen.setstatusdate(year4 + "/" + month4 + "/" + day4);

            }
            if (userName.getsecurestr().substring(3, 4).equals("1")) {
                memberdepen.setage("Y");
            } else {
                memberdepen.setage("N");
            }
        } else {
            memberdepen.setlidno(member);
            memberdepen.setTranid("0");
            memberdepen.setjoindate("");
            if (userName.getsecurestr().substring(3, 4).equals("1")) {
                memberdepen.setage("Y");
            } else {
                memberdepen.setage("N");
            }
        }

        ArrayList<MemberDepen> list = new ArrayList<MemberDepen>();
        list.add(memberdepen);
        return list;
    }

    public static ArrayList<Generics> UpdateDepend(Connection conn, UserAccount thisUser, String thisMember, String tranid, String ini, String sur, String idno, String bdate, String joindate, String mrelate1, String gend1, String stat1, String statdate1) throws SQLException {
        ArrayList<Generics> list = new ArrayList<Generics>();
        Generics generic1 = new Generics();
        generic1.setGenGroupId("failed");
        System.out.println("updateDepend security " + thisMember + " " + thisUser.getsecurestr().substring(3, 4) + " " + tranid);
        if (thisUser.getsecurestr().substring(3, 4).equals("1")) {
            System.out.println("updateDepend " + thisMember);
            String thisRelate = "";
            if (mrelate1.equals("SPOUSE")) {
                thisRelate = "1";
            }
            if (mrelate1.equals("CHILD")) {
                thisRelate = "2";
            }
            if (mrelate1.equals("WIFE")) {
                thisRelate = "3";
            }
            if (mrelate1.equals("HUSBAND")) {
                thisRelate = "4";
            }
            if (mrelate1.equals("PARENT")) {
                thisRelate = "5";
            }
            if (mrelate1.equals("STUDENT")) {
                thisRelate = "6";
            }
            if (mrelate1.equals("CHILD - EXTRA")) {
                thisRelate = "7";
            }
            if (mrelate1.equals("CHILD - DISABLED")) {
                thisRelate = "8";
            }
            String thisGend = "";
            if (gend1.equals("Female")) {
                thisGend = "2";
            }
            if (gend1.equals("Male")) {
                thisGend = "1";
            }

            if (!tranid.equals("0")) {
                String sql1 = "update " + thisUser.getcompany() + ".afhank set sur = ?, ini = ? , idno = ? , gebdat = ? , joindate = ? , verwskap = ? , sex = ? , status = ? , statusdate = ? where lidno = ? and tranid = ?";
                PreparedStatement pstm1 = conn.prepareStatement(sql1);
                pstm1.setString(1, sur);
                pstm1.setString(2, ini);
                pstm1.setString(3, idno);
                pstm1.setString(4, bdate);
                pstm1.setString(5, joindate);
                pstm1.setString(6, thisRelate);
                pstm1.setString(7, thisGend);
                pstm1.setString(8, stat1);
                pstm1.setString(9, statdate1);
                pstm1.setString(10, thisMember);
                pstm1.setString(11, tranid);

                pstm1.executeUpdate();
            } else {
                String sql1 = "insert into " + thisUser.getcompany() + ".afhank (sur , ini , idno , gebdat , joindate , verwskap , sex , status , statusdate, lidno) Values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstm1 = conn.prepareStatement(sql1);
                pstm1.setString(1, sur);
                pstm1.setString(2, ini);
                pstm1.setString(3, idno);
                pstm1.setString(4, bdate);
                pstm1.setString(5, joindate);
                pstm1.setString(6, thisRelate);
                pstm1.setString(7, thisGend);
                pstm1.setString(8, stat1);
                pstm1.setString(9, statdate1);
                pstm1.setString(10, thisMember);
                pstm1.executeUpdate();
            }
            generic1.setGenGroupId("success");

        } else {
            System.out.println("updateContact failed " + thisMember);
            generic1.setGenGroupId("failed");
        }
        list.add(generic1);
        return list;
    }

    public static ArrayList<Generics> UpdateMemberNotes(Connection conn, UserAccount thisUser, String thisMember, String notedid, String newnote ) throws SQLException {
        ArrayList<Generics> list = new ArrayList<Generics>();
        Generics generic1 = new Generics();
        generic1.setGenGroupId("failed");
        System.out.println("updateMemberNotes security " + thisMember + " " + thisUser.getsecurestr().substring(10, 11));
        if (thisUser.getsecurestr().substring(10, 11).equals("1")) {
            System.out.println("updateNotes " + thisMember);
            String sql1 = "update " + thisUser.getcompany() + ".tblcomments set trancomment = ? where lidno = ? and tranid = ?";
            PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setString(1, newnote);
            pstm1.setString(2, thisMember);
            pstm1.setString(3, notedid);            

            pstm1.executeUpdate();
            generic1.setGenGroupId("success");

        } else {
            System.out.println("update notes failed " + thisMember);
            generic1.setGenGroupId("failed");
        }
        list.add(generic1);
        return list;
    }    
    
    
}
