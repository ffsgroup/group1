package ffsutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.MemberRec;
import ffsbeans.MemReceipt;
import java.sql.Connection;
import ffsbeans.Member;

public class MemUtils {

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
