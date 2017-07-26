package ffsutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ffsbeans.Generics;
import ffsbeans.UserAccount;
import java.sql.Connection;

public class SecureUtils {

    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

public static ArrayList<UserAccount> getAllActiveUser(Connection conn, String Username) throws SQLException {
        System.out.println("getAllUsers");
        String sql = "Select code, name, branch, tranid from users where lidno like '1%' order by name";

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
            User1.settaskenq(rs.getString("taskenq"));
            User1.settaskclaim(rs.getString("taskclaim"));
            User1.settaskpay(rs.getString("taskpay"));
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
        System.out.println("CreateUser " + name);
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

    public static ArrayList<Generics> delUser(Connection conn, String name) throws SQLException {
        System.out.println("delUser " + name);
        String result = "";
        String sql = "delete from users where name = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.executeUpdate();

        String sql1 = "select tranid from users where name = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, name);
        ResultSet rs = pstm1.executeQuery();

        if (rs.next()) {
            result = "not deleted";
        } else {
            result = "success";
        }
        ArrayList<Generics> list = new ArrayList<Generics>();

        Generics gen1 = new Generics();
        gen1.setGenericDescriptionEng(result);
        list.add(gen1);

        return list;
    }

    public static ArrayList<Generics> changePass(Connection conn, String name, String passw) throws SQLException {
        System.out.println("ChangePass " + name);
        String result = "";
        String sql = "update users set passw = ?, expire='2015/01/01' where name = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, passw);
        pstm.setString(2, name);
        pstm.executeUpdate();

        String sql2 = "select passw from users where name = ?";
        PreparedStatement pstm2 = conn.prepareStatement(sql2);
        pstm2.setString(1, name);
        ResultSet rs2 = pstm2.executeQuery();

        if (rs2.next()) {
            if (rs2.getString("passw").equals(passw) ) {
                result = "success";
            } else {
                result = "update failed";
            }
        } else {
            result = "user not found";
        }
        ArrayList<Generics> list = new ArrayList<Generics>();

        Generics gen1 = new Generics();
        gen1.setGenericDescriptionEng(result);
        list.add(gen1);

        return list;
    }

    public static ArrayList<Generics> logoff(Connection conn, String name) throws SQLException {
        System.out.println("logoff " + name);
        String result = "";
        String sql = "update users set loggedon = 'N' where name = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.executeUpdate();

        String sql2 = "select loggedon from users where name = ?";
        PreparedStatement pstm2 = conn.prepareStatement(sql2);
        pstm2.setString(1, name);
        ResultSet rs2 = pstm2.executeQuery();

        if (rs2.next()) {
            if (rs2.getString("loggedon").equals("N") ) {
                result = "success";
            } else {
                result = "Not logged off";
            }
        } else {
            result = "user not found";
        }
        ArrayList<Generics> list = new ArrayList<Generics>();

        Generics gen1 = new Generics();
        gen1.setGenericDescriptionEng(result);
        list.add(gen1);

        return list;
    }
    
        public static ArrayList<Generics> UpdateUser(Connection conn, String name, String secure) throws SQLException {
        System.out.println("UpdateUser " + name);
        String result = "";
        String sql = "update users set lidno = ? where name = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, secure);
        pstm.setString(2, name);
        pstm.executeUpdate();

            result = "success";

        ArrayList<Generics> list = new ArrayList<Generics>();

        Generics gen1 = new Generics();
        gen1.setGenericDescriptionEng(result);
        list.add(gen1);

        return list;
    }
    
}
