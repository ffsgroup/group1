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

 
 
}