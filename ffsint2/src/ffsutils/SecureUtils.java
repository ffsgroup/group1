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

public class SecureUtils {

    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    public static ArrayList<UserAccount> getAllUsers(Connection conn, String Username) throws SQLException {
        System.out.println("getAllUsers");
        String sql = "Select code, name, branch, tranid from users order by name";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            UserAccount User1 = new UserAccount();
            User1.setcode(rs.getString("Code"));
            User1.setUserName(rs.getString("name"));
            User1.setbranch(rs.getString("branch"));
            User1.setTranId(rs.getString("tranid"));
            list.add(User1);
        }
        return list;
    }

    public static ArrayList<UserAccount> getUser(Connection conn, String tranid, String Username) throws SQLException {
        System.out.println("getUser " + tranid);
        String sql = "Select * from users where tranid = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tranid);

        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            UserAccount User1 = new UserAccount();
            User1.setcode(rs.getString("Code"));
            User1.setUserName(rs.getString("name"));
            User1.setbranch(rs.getString("branch"));
            User1.setTranId(rs.getString("tranid"));
            User1.setsecurestr(rs.getString("lidno"));
            list.add(User1);
        }
        return list;
    }

    public static ArrayList<Generics> getBranch(Connection conn) throws SQLException {
        System.out.println("getBranch ");
        String sql = "Select branchname from branch order by branchname";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            Generics gen1 = new Generics();
            gen1.setGenericDescriptionEng(rs.getString("branchname"));
            list.add(gen1);
        }
        return list;
    }

    public static ArrayList<Generics> createUser(Connection conn, String name, String user, String branch) throws SQLException {
        System.out.println("CreateUser " + name );
        String result = "";
        String sql = "select tranid from users where code = ? or name = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user);
        pstm.setString(2, name);
        ResultSet rs = pstm.executeQuery();
        
        if (rs.next()) {
          result = "user exist";
        } else {
        String sql2 = "insert into users (code, name, passw, lidno, branch, loggedon, logout, remind1) values(?,?,?,'1000',?,'N','200','Remember to check : Tasks assigned by me')";
        PreparedStatement pstm2 = conn.prepareStatement(sql2);
        pstm2.setString(1, user);
        pstm2.setString(2, name);
        pstm2.setString(3, user);
        pstm2.setString(4, branch);
        pstm2.executeUpdate();
        result = "success";
        }
        ArrayList<Generics> list = new ArrayList<Generics>();
        
            Generics gen1 = new Generics();
            gen1.setGenericDescriptionEng(result);
            list.add(gen1);
       
        return list;
    }
    
   public static ArrayList<UserAccount> getAllUser(Connection conn, String Username) throws SQLException {
        System.out.println("getUser");
        String sql = "Select name from users order by name";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            UserAccount User1 = new UserAccount();
            User1.setUserName(rs.getString("name"));
            list.add(User1);
        }
        return list;
    }    
    
}
