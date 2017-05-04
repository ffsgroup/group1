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
            String thistime = year + "/" + month + "/" + day ;
           members.setrecruitdate(thistime);
            
            members.settroustat(rs.getString("troustat"));
            members.setgebdat(rs.getString("gebdat"));
            members.setaanstdat(rs.getString("aanstdat"));
            members.setjoindat(rs.getString("joindat"));
            members.setorgid(rs.getString("orgid"));
             members.setlidtipe(rs.getString("lidtipe"));
              members.settaal(rs.getString("taal"));
              members.setcancode(rs.getString("cancode"));
                members.setstatus(rs.getString("status"));
                members.setinitialPayment(rs.getString("initialPayment"));
              
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
