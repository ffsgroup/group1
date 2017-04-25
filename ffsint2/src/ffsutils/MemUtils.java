package ffsutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.Product;
import ffsbeans.Diary;
import ffsbeans.Generics;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import ffsbeans.DiaryImag;
import ffsbeans.UserAccount;
import java.sql.Connection;
import ffsbeans.Member;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import java.io.*;
import java.text.SimpleDateFormat;

public class MemUtils {

   public static ArrayList<Member> getMember(Connection conn, String thisMember, String userName) throws SQLException {

System.out.println("member get " +thisMember);
        String sql = "Select * from lededata where lidno = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,thisMember);
        
        
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
    

}
