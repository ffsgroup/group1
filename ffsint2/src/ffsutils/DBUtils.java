package ffsutils;

import java.util.ArrayList;
import ffsbeans.Product;
import ffsbeans.Diary;
import ffsbeans.Generics;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import ffsbeans.DiaryImag;
import ffsbeans.UserAccount;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import java.io.*;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

        String sql = "Select a.name, a.Passw, a.lidno from Users a "
                + " where a.code = ? and a.passw= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(rs.getString("name"));
            user.setPassword(password);
            user.setsecurestr(rs.getString("lidno"));
            return user;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {

        String sql = "Select a.Name, a.Passw, a.lidno from Users a " + " where a.code = ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);

        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String password = rs.getString("Password");

            UserAccount user = new UserAccount();
            user.setUserName(rs.getString("name"));
            user.setPassword(password);
            user.setsecurestr(rs.getString("lidno"));
            return user;
        }
        return null;
    }

    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Price from Product a ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("Code");
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);
        }
        return list;
    }

    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }

    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "Update Product set Name =?, Price=? where Code=? ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();
    }

    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());

        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "Delete from Product where Code= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, code);

        pstm.executeUpdate();
    }

    public static ArrayList<Diary> getDiary(Connection conn, String thisDate, String userName, String thisUser) throws SQLException {
        String tranid = "";
        String user = "";
        String desc1 = "";
        String ShortDate = "";
        Integer hour;
        int minute;
        Date date1;
        Calendar calendar;
        System.out.println("thisUser1:" + thisUser);
        String leftRemoved = thisUser.replaceAll("^\\s+", "");
        String rightRemoved = leftRemoved.replaceAll("\\s+$", "");

        System.out.println("thisUser2:" + rightRemoved);

        String sql = "Select Tranid, User, Desc1, sdate from Diary where (sdate > ?) and (sdate < ?) and (user = ?) order by sdate asc";
        System.out.println(sql);
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, thisDate + " 00:00");
        pstm.setString(2, thisDate + " 23:59");
        pstm.setString(3, rightRemoved);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Diary> list = new ArrayList<Diary>();

        if (rs.next()) {
            System.out.println("Diary etries found ");
            date1 = rs.getTime("sdate");
            calendar = new GregorianCalendar();
            calendar.setTime(date1);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);

            while (hour < 8) {  // insert row, add row
                System.out.println("Diary before 8 ");
                ShortDate = String.valueOf(hour) + ":" + String.valueOf(minute);
                tranid = rs.getString("tranid");
                user = rs.getString("user");
                desc1 = rs.getString("desc1");
                Diary diary = new Diary();
                diary.setTranid(tranid);
                diary.setUser(user);
                diary.setDesc1(desc1);
                diary.setShortDate(ShortDate);
                list.add(diary);
                rs.next();
                if (rs.isLast() || rs.isAfterLast()) {
                    System.out.println("after last ");
                    hour = 0;
                    minute = 0;
                } else {
                    //  rs.next();
                    date1 = rs.getTime("sdate");
                    calendar.setTime(date1);
                    hour = calendar.get(Calendar.HOUR_OF_DAY);
                    minute = calendar.get(Calendar.MINUTE);
                    System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                }
            }

            if (String.valueOf(hour).equals("8") && minute < 30) {
                System.out.println("if Diary between 8 and 30 ");
                while (String.valueOf(hour).equals("8") && minute < 30) {
                    System.out.println("while diary between 8 and 30 ");
                    ShortDate = "08:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary1 = new Diary();
                    diary1.setTranid(tranid);
                    diary1.setUser(user);
                    diary1.setDesc1(desc1);
                    diary1.setShortDate(ShortDate);
                    list.add(diary1);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                System.out.println("no diary between 8 and 30");
                ShortDate = "08:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary2 = new Diary();
                diary2.setTranid(tranid);
                diary2.setUser(user);
                diary2.setDesc1(desc1);
                diary2.setShortDate(ShortDate);
                list.add(diary2);
            }

            if (String.valueOf(hour).equals("8") && minute > 29) {
                while (String.valueOf(hour).equals("8") && minute > 29) {
                    ShortDate = "08:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "08:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("9") && minute < 30) {
                while (String.valueOf(hour).equals("9") && minute < 30) {
                    ShortDate = "09:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "09:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("9") && minute > 29) {
                while (String.valueOf(hour).equals("9") && minute > 29) {
                    ShortDate = "09:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "09:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("10") && minute < 30) {
                while (String.valueOf(hour).equals("10") && minute < 30) {
                    ShortDate = "10:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "10:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("10") && minute > 29) {
                while (String.valueOf(hour).equals("10") && minute > 29) {
                    ShortDate = "10:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "10:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("11") && minute < 30) {
                while (String.valueOf(hour).equals("11") && minute < 30) {
                    ShortDate = "11:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "11:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("11") && minute > 29) {
                while (String.valueOf(hour).equals("11") && minute > 29) {
                    ShortDate = "11:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "11:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("12") && minute < 30) {
                while (String.valueOf(hour).equals("12") && minute < 30) {
                    ShortDate = "12:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "12:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("12") && minute > 29) {
                while (String.valueOf(hour).equals("12") && minute > 29) {
                    ShortDate = "12:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "12:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("13") && minute < 30) {
                while (String.valueOf(hour).equals("13") && minute < 30) {
                    ShortDate = "13:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "13:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("13") && minute > 29) {
                while (String.valueOf(hour).equals("13") && minute > 29) {
                    ShortDate = "13:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "13:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("14") && minute < 30) {
                while (String.valueOf(hour).equals("14") && minute < 30) {
                    ShortDate = "14:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "14:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("14") && minute > 29) {
                while (String.valueOf(hour).equals("14") && minute > 29) {
                    ShortDate = "14:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "14:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("15") && minute < 30) {
                while (String.valueOf(hour).equals("15") && minute < 30) {
                    ShortDate = "15:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "15:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("15") && minute > 29) {
                while (String.valueOf(hour).equals("15") && minute > 29) {
                    ShortDate = "15:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "15:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("16") && minute < 30) {
                while (String.valueOf(hour).equals("16") && minute < 30) {
                    ShortDate = "16:00";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "16:00";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            if (String.valueOf(hour).equals("16") && minute > 29) {
                while (String.valueOf(hour).equals("16") && minute > 29) {
                    ShortDate = "16:30";
                    tranid = rs.getString("tranid");
                    user = rs.getString("user");
                    desc1 = rs.getString("desc1");
                    Diary diary3 = new Diary();
                    diary3.setTranid(tranid);
                    diary3.setUser(user);
                    diary3.setDesc1(desc1);
                    diary3.setShortDate(ShortDate);
                    list.add(diary3);
                    rs.next();
                    if (rs.isLast() || rs.isAfterLast()) {
                        System.out.println("after last ");
                        hour = 0;
                        minute = 0;
                    } else {
                        //  rs.next();
                        date1 = rs.getTime("sdate");
                        calendar.setTime(date1);
                        hour = calendar.get(Calendar.HOUR_OF_DAY);
                        minute = calendar.get(Calendar.MINUTE);
                        System.out.println("not after last " + rs.getString("tranid") + " " + hour + " " + minute + " " + rs.getDate("sdate"));
                    }
                }
            } else {
                ShortDate = "16:30";
                tranid = "";
                user = "";
                desc1 = "";
                Diary diary4 = new Diary();
                diary4.setTranid(tranid);
                diary4.setUser(user);
                diary4.setDesc1(desc1);
                diary4.setShortDate(ShortDate);
                list.add(diary4);
            }

            while (rs.next()) {
                date1 = rs.getDate("sdate");
                calendar.setTime(date1);
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                ShortDate = "08:30";
                ShortDate = String.valueOf(hour) + ":" + String.valueOf(minute);
                tranid = rs.getString("tranid");
                user = rs.getString("user");
                desc1 = rs.getString("desc1");
                Diary diary3 = new Diary();
                diary3.setTranid(tranid);
                diary3.setUser(user);
                diary3.setDesc1(desc1);
                diary3.setShortDate(ShortDate);
                list.add(diary3);
            }

        } else {
            // no entries
            tranid = "";
            user = "";
            desc1 = "";
            ShortDate = "08:00";
            Diary diary = new Diary();
            diary.setTranid(tranid);
            diary.setUser(user);
            diary.setDesc1(desc1);
            diary.setShortDate(ShortDate);
            list.add(diary);

            ShortDate = "08:30";
            Diary diary1 = new Diary();
            diary1.setTranid(tranid);
            diary1.setUser(user);
            diary1.setDesc1(desc1);
            diary1.setShortDate(ShortDate);
            list.add(diary1);

            ShortDate = "09:00";
            Diary diary2 = new Diary();
            diary2.setTranid(tranid);
            diary2.setUser(user);
            diary2.setDesc1(desc1);
            diary2.setShortDate(ShortDate);
            list.add(diary2);

            ShortDate = "09:30";
            Diary diary3 = new Diary();
            diary3.setTranid(tranid);
            diary3.setUser(user);
            diary3.setDesc1(desc1);
            diary3.setShortDate(ShortDate);
            list.add(diary3);

            ShortDate = "10:00";
            Diary diary4 = new Diary();
            diary4.setTranid(tranid);
            diary4.setUser(user);
            diary4.setDesc1(desc1);
            diary4.setShortDate(ShortDate);
            list.add(diary4);

            ShortDate = "10:30";
            Diary diary5 = new Diary();
            diary5.setTranid(tranid);
            diary5.setUser(user);
            diary5.setDesc1(desc1);
            diary5.setShortDate(ShortDate);
            list.add(diary5);

            ShortDate = "11:00";
            Diary diary6 = new Diary();
            diary6.setTranid(tranid);
            diary6.setUser(user);
            diary6.setDesc1(desc1);
            diary6.setShortDate(ShortDate);
            list.add(diary6);

            ShortDate = "11:30";
            Diary diary7 = new Diary();
            diary7.setTranid(tranid);
            diary7.setUser(user);
            diary7.setDesc1(desc1);
            diary7.setShortDate(ShortDate);
            list.add(diary7);

            ShortDate = "12:00";
            Diary diary8 = new Diary();
            diary8.setTranid(tranid);
            diary8.setUser(user);
            diary8.setDesc1(desc1);
            diary8.setShortDate(ShortDate);
            list.add(diary8);

            ShortDate = "12:30";
            Diary diary9 = new Diary();
            diary9.setTranid(tranid);
            diary9.setUser(user);
            diary9.setDesc1(desc1);
            diary9.setShortDate(ShortDate);
            list.add(diary9);

            ShortDate = "13:00";
            Diary diary10 = new Diary();
            diary10.setTranid(tranid);
            diary10.setUser(user);
            diary10.setDesc1(desc1);
            diary10.setShortDate(ShortDate);
            list.add(diary10);

            ShortDate = "13:30";
            Diary diary11 = new Diary();
            diary11.setTranid(tranid);
            diary11.setUser(user);
            diary11.setDesc1(desc1);
            diary11.setShortDate(ShortDate);
            list.add(diary11);

            ShortDate = "14:00";
            Diary diary12 = new Diary();
            diary12.setTranid(tranid);
            diary12.setUser(user);
            diary12.setDesc1(desc1);
            diary12.setShortDate(ShortDate);
            list.add(diary12);

            ShortDate = "14:30";
            Diary diary13 = new Diary();
            diary13.setTranid(tranid);
            diary13.setUser(user);
            diary13.setDesc1(desc1);
            diary13.setShortDate(ShortDate);
            list.add(diary13);

            ShortDate = "15:00";
            Diary diary14 = new Diary();
            diary14.setTranid(tranid);
            diary14.setUser(user);
            diary14.setDesc1(desc1);
            diary14.setShortDate(ShortDate);
            list.add(diary14);

            ShortDate = "15:30";
            Diary diary15 = new Diary();
            diary15.setTranid(tranid);
            diary15.setUser(user);
            diary15.setDesc1(desc1);
            diary15.setShortDate(ShortDate);
            list.add(diary15);

            ShortDate = "16:00";
            Diary diary16 = new Diary();
            diary16.setTranid(tranid);
            diary16.setUser(user);
            diary16.setDesc1(desc1);
            diary16.setShortDate(ShortDate);
            list.add(diary16);

            ShortDate = "16:30";
            Diary diary17 = new Diary();
            diary17.setTranid(tranid);
            diary17.setUser(user);
            diary17.setDesc1(desc1);
            diary17.setShortDate(ShortDate);
            list.add(diary17);

        }
        return list;
    }

    public static ArrayList<Diary> getOneDiary(Connection connconn, UserAccount loginedUser, String tranid1) throws SQLException {
        System.out.println("getOneDiary " + tranid1);
        String sql = "Select * from Diary a where a.tranid =?";

        PreparedStatement pstm = connconn.prepareStatement(sql);
        pstm.setString(1, tranid1);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Diary> list = new ArrayList<Diary>();
        while (rs.next()) {
            String tranid = rs.getString("tranid");
            String user = rs.getString("user");
            String desc1 = rs.getString("desc1");
            String locat = rs.getString("locat");

            Date date = new Date();
            Calendar calendar = new GregorianCalendar();

            calendar.setTime(rs.getTimestamp("sdate"));
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
            String sdate = thistime;

            calendar.setTime(rs.getTimestamp("edate"));
            String year1 = Integer.toString(calendar.get(Calendar.YEAR));
            String month1 = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            String day1 = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
            String hour1 = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
            String minute1 = Integer.toString(calendar.get(Calendar.MINUTE));
            int length5 = month1.length();
            if (length5 == 1) {
                month1 = "0" + month1;
            }
            int length6 = day1.length();
            if (length6 == 1) {
                day1 = "0" + day1;
            }
            int length7 = hour1.length();
            if (length7 == 1) {
                hour1 = "0" + hour1;
            }
            int length8 = minute1.length();
            if (length8 == 1) {
                minute1 = "0" + minute1;
            }
            String thistime1 = year1 + "/" + month1 + "/" + day1 + " " + hour1 + ":" + minute1;
            String edate = thistime1;
            String task = rs.getString("taskid");
            String notes = rs.getString("notes");
            String comm = rs.getString("comm");
            String user1 = rs.getString("user1");

            String user2 = rs.getString("user2");
            String user3 = rs.getString("user3");
            String user4 = rs.getString("user4");
            String user5 = rs.getString("user5");
            String user6 = rs.getString("user6");
            String user7 = rs.getString("user7");
            String user8 = rs.getString("user8");
            String user9 = rs.getString("user9");
            String user10 = rs.getString("user10");
            String user1ans = rs.getString("user1ans");
            String user2ans = rs.getString("user2ans");
            String user3ans = rs.getString("user3ans");
            String user4ans = rs.getString("user4ans");
            String user5ans = rs.getString("user5ans");
            String user6ans = rs.getString("user6ans");
            String user7ans = rs.getString("user7ans");
            String user8ans = rs.getString("user8ans");
            String user9ans = rs.getString("user9ans");
            String user10ans = rs.getString("user10ans");

            Diary diary = new Diary();
            diary.setTranid(tranid);
            diary.setUser(user);
            diary.setDesc1(desc1);
            diary.setsdate(sdate);
            diary.setedate(edate);
            diary.setlocat(locat);
            diary.settask(task);
            diary.setnotes(notes);
            diary.setcomm(comm);
            diary.setuser1(user1);
            diary.setuser2(user2);
            diary.setuser3(user3);
            diary.setuser4(user4);
            diary.setuser5(user5);
            diary.setuser6(user6);
            diary.setuser7(user7);
            diary.setuser8(user8);
            diary.setuser9(user9);
            diary.setuser10(user10);
            diary.setuser1ans(user1ans);
            diary.setuser2ans(user2ans);
            diary.setuser3ans(user3ans);
            diary.setuser4ans(user4ans);
            diary.setuser5ans(user5ans);
            diary.setuser6ans(user6ans);
            diary.setuser7ans(user7ans);
            diary.setuser8ans(user8ans);
            diary.setuser9ans(user9ans);
            diary.setuser10ans(user10ans);

            list.add(diary);
        }
        return list;
    }

    public static ArrayList<Generics> DiaryLocate(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '44'";

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

    public static ArrayList<Generics> DiaryRespond(Connection conn) throws SQLException {
        String sql = "Select a.GenericDescriptionEng from Generics a where GenGroupId = '45'";

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

    public static ArrayList<UserAccount> DiaryUsers(Connection conn) throws SQLException {
        String sql = "Select Name from users where lidno like '1%' order by name";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            String name = rs.getString("name");

            UserAccount useraccount = new UserAccount();
            useraccount.setUserName(name);

            list.add(useraccount);
        }
        return list;
    }

    public static ArrayList<DiaryImag> getDiaryImag(Connection connconn, String tranid1) throws SQLException {
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
            tranid2 = tranid1.substring(tranid1.length() - 1);
        }
        System.out.println("getDiaryImag " + tranid2 + " " + tranid1);
        String sql = "Select * from diaryimag" + tranid2 + " where diaryid =?";

        PreparedStatement pstm = connconn.prepareStatement(sql);
        pstm.setString(1, tranid1);

        ResultSet rs = pstm.executeQuery();
        ArrayList<DiaryImag> list = new ArrayList<DiaryImag>();
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

            DiaryImag diaryimag = new DiaryImag();
            diaryimag.setTranid(Tranid);
            diaryimag.setUser(User);
            diaryimag.setImageDesc(ImageDesc);
            diaryimag.setImageType(ImageType);
            diaryimag.setDateUp(DateUp);

            list.add(diaryimag);
        }
        return list;
    }

    public static ArrayList<DiaryImag> getDiaryUpImag(Connection connconn, String tranid1, String userName, String Description, String filetype, FileItem thisfile) throws SQLException {

        String tranid2;
        Integer comp = 2;
        Integer tranlen = tranid1.length();
        int retval = comp.compareTo(tranlen);
        if (retval > 0) {
            tranid2 = "0" + tranid1;
        } else if (retval < 0) {
            tranid2 = tranid1.substring(tranid1.length() - 1);
        } else {
            tranid2 = tranid1;
        }
        System.out.println("getDiaryUpImag " + userName + " size " + String.valueOf(thisfile.getSize()) + ' ' + filetype);
        PreparedStatement pstm2 = null;
        pstm2 = connconn.prepareStatement("insert into diaryimag" +tranid2 +" (user, dateup,imagedesc, diaryid, imagetype, imag1) values (?, current_timestamp, ? , '" + tranid1 + "' ,'" + filetype + "', ?)");
        pstm2.setString(1, userName);
        pstm2.setString(2, Description);
        try {
            pstm2.setBinaryStream(3, thisfile.getInputStream(), (int) thisfile.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer temp1 = pstm2.executeUpdate();        
        String sql = "Select * from diaryimag" + tranid2 + " where diaryid =?";

        PreparedStatement pstm = connconn.prepareStatement(sql);
        pstm.setString(1, tranid1);

        ResultSet rs = pstm.executeQuery();
        ArrayList<DiaryImag> list = new ArrayList<DiaryImag>();
        System.out.println("1");
        while (rs.next()) {
            System.out.println("2 " + rs.getString("tranid"));
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

            DiaryImag diaryimag = new DiaryImag();
            diaryimag.setTranid(Tranid);
            diaryimag.setUser(User);
            diaryimag.setImageDesc(ImageDesc);
            diaryimag.setImageType(ImageType);
            diaryimag.setDateUp(DateUp);

            list.add(diaryimag);
        }
        return list;
    }

    public static ArrayList<Generics> NewDiary(Connection connconn, String tranid, String userName, String diarysumm, String startdate, String enddate, String locat, String diarytask, String diarynotes, String duser1, String duser2, String duser3, String duser4, String duser5, String duser6, String duser7, String duser8, String duser9, String duser10, String resp1, String resp2, String resp3, String resp4, String resp5, String resp6, String resp7, String resp8, String resp9, String resp10, String fromuser) throws SQLException {

        System.out.println("username " + userName + " tranid " + tranid);

        if (tranid.equals("0")) {
            System.out.println("insert diary" + userName + " tranid " + tranid);
            PreparedStatement pstm2 = null;
            pstm2 = connconn.prepareStatement("insert into diary(user, sdate, edate, locat, desc1, notes,datedone, taskid, doneby, user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user1ans,user2ans,user3ans,user4ans,user5ans,user6ans,user7ans,user8ans,user9ans,user10ans) values (?, ?, ? , ? ,?, ?, current_timestamp, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pstm2.setString(1, userName);
            pstm2.setString(2, startdate);
            pstm2.setString(3, enddate);
            pstm2.setString(4, locat);
            pstm2.setString(5, diarysumm);
            pstm2.setString(6, diarynotes);

            pstm2.setString(7, diarytask);
            pstm2.setString(8, userName);

            pstm2.setString(9, duser1);

            pstm2.setString(10, duser2);
            pstm2.setString(11, duser3);
            pstm2.setString(12, duser4);
            pstm2.setString(13, duser5);
            pstm2.setString(14, duser6);
            pstm2.setString(15, duser7);
            pstm2.setString(16, duser8);
            pstm2.setString(17, duser9);
            pstm2.setString(18, duser10);
            pstm2.setString(19, resp1);
            pstm2.setString(20, resp2);
            pstm2.setString(21, resp3);
            pstm2.setString(22, resp4);
            pstm2.setString(23, resp5);
            pstm2.setString(24, resp6);
            pstm2.setString(25, resp7);
            pstm2.setString(26, resp8);
            pstm2.setString(27, resp9);
            pstm2.setString(28, resp10);

            Integer temp1 = pstm2.executeUpdate();
        }
        if (!tranid.equals("0")) {
            String sql = "Select * from Diary a where a.tranid =?";

            PreparedStatement pstm = connconn.prepareStatement(sql);
            pstm.setString(1, tranid);

            ResultSet rs = pstm.executeQuery();
            String thistime = "";
            String thistime1 = "";
            String comm = "";
            if (rs.next()) {
                comm = rs.getString("comm");
                Date date = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(rs.getTimestamp("sdate"));
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
                thistime = year + "/" + month + "/" + day + " " + hour + ":" + minute;

                calendar.setTime(rs.getTimestamp("edate"));
                String year1 = Integer.toString(calendar.get(Calendar.YEAR));
                String month1 = Integer.toString(calendar.get(Calendar.MONTH) + 1);
                String day1 = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
                String hour1 = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
                String minute1 = Integer.toString(calendar.get(Calendar.MINUTE));
                int length5 = month1.length();
                if (length5 == 1) {
                    month1 = "0" + month1;
                }
                int length6 = day1.length();
                if (length6 == 1) {
                    day1 = "0" + day1;
                }
                int length7 = hour1.length();
                if (length7 == 1) {
                    hour1 = "0" + hour1;
                }
                int length8 = minute1.length();
                if (length8 == 1) {
                    minute1 = "0" + minute1;
                }
                thistime1 = year1 + "/" + month1 + "/" + day1 + " " + hour1 + ":" + minute1;
            }

            if (!startdate.equals(thistime) || !enddate.equals(thistime1)) {
                // times changed insert comment
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                String strTime = sdfTime.format(now);

                if (comm.equals("null")) {
                    comm = "";
                }
                String newcomm = comm + "~Diary times changed~ Old Start " + thistime + " New Start " + startdate + "~Old End " + thistime1 + " New End " + enddate + "~" + userName + " " + date + " " + strTime + "~______________________";

                String sql1 = "update diary set comm = ? where tranid = ?";

                PreparedStatement pstm2 = connconn.prepareStatement(sql1);

                pstm2.setString(1, newcomm);
                pstm2.setString(2, tranid);
                pstm2.executeUpdate();
            }

            PreparedStatement pstm2 = null;
            pstm2 = connconn.prepareStatement("update diary set sdate = ? , edate = ? , locat = ? , desc1 = ? , notes = ? , taskid = ? where tranid = ?");
            pstm2.setString(1, startdate);
            pstm2.setString(2, enddate);
            pstm2.setString(3, locat);
            pstm2.setString(4, diarysumm);
            pstm2.setString(5, diarynotes);
            pstm2.setString(6, diarytask);
            pstm2.setString(7, tranid);

            Integer temp1 = pstm2.executeUpdate();
        }

        ArrayList<Generics> list = new ArrayList<Generics>();
        return list;
    }

    public static ArrayList<Generics> SavePeople(Connection connconn, String tranid, String userName, String duser1, String duser2, String duser3, String duser4, String duser5, String duser6, String duser7, String duser8, String duser9, String duser10, String resp1, String resp2, String resp3, String resp4, String resp5, String resp6, String resp7, String resp8, String resp9, String resp10, String fromuser) throws SQLException {

        System.out.println("username " + userName + " people " + tranid);

        if (!tranid.equals("0") && (userName.equals(fromuser))) {
            PreparedStatement pstm2 = null;
            pstm2 = connconn.prepareStatement("update diary set user1 =?,user2=?,user3=?,user4=?,user5=?,user6=?,user7=?,user8=?,user9=?,user10=?,user1ans=?,user2ans=?,user3ans=?, user4ans=?,user5ans=?,user6ans=?,user7ans=?,user8ans=?,user9ans=?,user10ans=? where tranid = ?");
            pstm2.setString(1, duser1);
            pstm2.setString(2, duser2);
            pstm2.setString(3, duser3);
            pstm2.setString(4, duser4);
            pstm2.setString(5, duser5);
            pstm2.setString(6, duser6);
            pstm2.setString(7, duser7);
            pstm2.setString(8, duser8);
            pstm2.setString(9, duser9);
            pstm2.setString(10, duser10);
            pstm2.setString(11, resp1);
            pstm2.setString(12, resp2);
            pstm2.setString(13, resp3);
            pstm2.setString(14, resp4);
            pstm2.setString(15, resp5);
            pstm2.setString(16, resp6);
            pstm2.setString(17, resp7);
            pstm2.setString(18, resp8);
            pstm2.setString(19, resp9);
            pstm2.setString(20, resp10);
            pstm2.setString(21, tranid);
            Integer temp1 = pstm2.executeUpdate();
        }

        ArrayList<Generics> list = new ArrayList<Generics>();
        return list;
    }

    public static ArrayList<Diary> DiarySaveComm(Connection conn, UserAccount user, String comments, String tranid) throws SQLException, InterruptedException {

        String sql = "Select a.comm from diary a where tranid = ?";
        System.out.println("Diarycomm2 " + comments);
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tranid);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            Date now = new Date();
            String strTime = sdfTime.format(now);

            String oldcomm = rs.getString("comm");
            String newcomm = rs.getString("comm") + "~" + comments + "~" + user.getUserName() + " " + date + " " + strTime + "~______________________";

            String sql1 = "update diary set comm = ? where tranid = ?";

            PreparedStatement pstm2 = conn.prepareStatement(sql1);

            pstm2.setString(1, newcomm);
            pstm2.setString(2, tranid);
            pstm2.executeUpdate();

        }

        Thread.sleep(1000);

        String sql3 = "Select a.comm from diary a where tranid = ?";

        PreparedStatement pstm3 = conn.prepareStatement(sql3);
        pstm3.setString(1, tranid);

        ResultSet rs3 = pstm3.executeQuery();

        ArrayList<Diary> list = new ArrayList<Diary>();
        if (rs3.next()) {
            String diarycomm = rs.getString("comm");

            Diary diary = new Diary();
            diary.setcomm(diarycomm);

            list.add(diary);
        }
        return list;
    }

    public static ArrayList<UserAccount> DiaryAvails(Connection conn, UserAccount loginedUser) throws SQLException {
        String sql = "Select a.diary1, a.diary2, a.diary3, a.diary4, a.diary5, a.diary6, a.diary7, a.diary8, a.diary9, a.diary10 from users a where name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, loginedUser.getUserName());
        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            String UserName = rs.getString("diary1");
            if ((UserName != null) && (UserName.length() > 1)) {
                UserAccount useraccount = new UserAccount();
                useraccount.setUserName(UserName);
                list.add(useraccount);
            }

            String UserName2 = rs.getString("diary2");
            if ((UserName2 != null) && (UserName2.length() > 1)) {
                UserAccount useraccount2 = new UserAccount();
                useraccount2.setUserName(UserName2);
                list.add(useraccount2);
            }

            String UserName3 = rs.getString("diary3");
            if ((UserName3 != null) && (UserName3.length() > 1)) {
                UserAccount useraccount3 = new UserAccount();
                useraccount3.setUserName(UserName3);
                list.add(useraccount3);
            }

            String UserName4 = rs.getString("diary4");
            if ((UserName4 != null) && (UserName4.length() > 1)) {
                UserAccount useraccount4 = new UserAccount();
                useraccount4.setUserName(UserName4);
                list.add(useraccount4);
            }

            String UserName5 = rs.getString("diary5");
            if ((UserName5 != null) && (UserName5.length() > 1)) {
                UserAccount useraccount5 = new UserAccount();
                useraccount5.setUserName(UserName5);
                list.add(useraccount5);
            }

            String UserName6 = rs.getString("diary6");
            if ((UserName6 != null) && (UserName6.length() > 1)) {
                UserAccount useraccount6 = new UserAccount();
                useraccount6.setUserName(UserName6);
                list.add(useraccount6);
            }

            String UserName7 = rs.getString("diary7");
            if ((UserName7 != null) && (UserName7.length() > 1)) {
                UserAccount useraccount7 = new UserAccount();
                useraccount7.setUserName(UserName7);
                list.add(useraccount7);
            }

            String UserName8 = rs.getString("diary8");
            if ((UserName8 != null) && (UserName8.length() > 1)) {
                UserAccount useraccount8 = new UserAccount();
                useraccount8.setUserName(UserName8);
                list.add(useraccount8);
            }

            String UserName9 = rs.getString("diary9");
            if ((UserName9 != null) && (UserName9.length() > 1)) {
                UserAccount useraccount9 = new UserAccount();
                useraccount9.setUserName(UserName9);
                list.add(useraccount9);
            }

            String UserName10 = rs.getString("diary10");
            if ((UserName10 != null) && (UserName10.length() > 1)) {
                UserAccount useraccount10 = new UserAccount();
                useraccount10.setUserName(UserName10);
                list.add(useraccount10);
            }
        }
        return list;
    }

    public static ArrayList<UserAccount> DiaryUsersSett(Connection conn, String loginedUser) throws SQLException {
        String sql = "Select diary1, diary2, diary3, diary4, diary5, diary6, diary7, diary8, diary9, diary10 from users where name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, loginedUser);

        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        if (rs.next()) {
            String name = rs.getString("diary1");
            UserAccount useraccount = new UserAccount();
            useraccount.setUserName(name);
            list.add(useraccount);

            String name2 = rs.getString("diary2");
            UserAccount useraccount2 = new UserAccount();
            useraccount2.setUserName(name2);
            list.add(useraccount2);

            String name3 = rs.getString("diary3");
            UserAccount useraccount3 = new UserAccount();
            useraccount3.setUserName(name3);
            list.add(useraccount3);

            String name4 = rs.getString("diary4");
            UserAccount useraccount4 = new UserAccount();
            useraccount4.setUserName(name4);
            list.add(useraccount4);

            String name5 = rs.getString("diary5");
            UserAccount useraccount5 = new UserAccount();
            useraccount5.setUserName(name5);
            list.add(useraccount5);

            String name6 = rs.getString("diary6");
            UserAccount useraccount6 = new UserAccount();
            useraccount6.setUserName(name6);
            list.add(useraccount6);

            String name7 = rs.getString("diary7");
            UserAccount useraccount7 = new UserAccount();
            useraccount7.setUserName(name7);
            list.add(useraccount7);

            String name8 = rs.getString("diary8");
            UserAccount useraccount8 = new UserAccount();
            useraccount8.setUserName(name8);
            list.add(useraccount8);

            String name9 = rs.getString("diary9");
            UserAccount useraccount9 = new UserAccount();
            useraccount9.setUserName(name9);
            list.add(useraccount9);

            String name10 = rs.getString("diary10");
            UserAccount useraccount10 = new UserAccount();
            useraccount10.setUserName(name10);
            list.add(useraccount10);

        }
        return list;
    }

    public static ArrayList<UserAccount> DiaryUsersAvail(Connection conn, String loginedUser) throws SQLException {
        String sql = "Select name from users where diary1=? or diary2=? or diary3=? or diary4=? or diary5=? or diary6=? or diary7=? or diary8=? or diary9=? or diary10=? order by name";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, loginedUser);
        pstm.setString(2, loginedUser);
        pstm.setString(3, loginedUser);
        pstm.setString(4, loginedUser);
        pstm.setString(5, loginedUser);
        pstm.setString(6, loginedUser);
        pstm.setString(7, loginedUser);
        pstm.setString(8, loginedUser);
        pstm.setString(9, loginedUser);
        pstm.setString(10, loginedUser);

        ResultSet rs = pstm.executeQuery();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            String name = rs.getString("name");
            UserAccount useraccount = new UserAccount();
            useraccount.setUserName(name);
            list.add(useraccount);
        }
        return list;
    }

    public static ArrayList<Diary> DiaryFile(Connection conn, String tranid, String diaryid) throws SQLException, FileNotFoundException, IOException {
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

        String sql = "Select * from diaryimag" + tranid2 + " where tranid = ? and diaryid = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, diaryid);
        pstm.setString(2, tranid);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Diary> list = new ArrayList<Diary>();
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

            Diary diary = new Diary();
            diary.setlocat(thisFile);
            list.add(diary);

        }
        return list;
    }

    public static ArrayList<Generics> getDiarySet(Connection conn, String loginedUser) throws SQLException {
        String sql = "Select name, lidno from users where name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, loginedUser);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            // this below 0,1 is wrong, must repace with correct setting
            String name = rs.getString("lidno").substring(0, 1);
            Generics generics = new Generics();
            generics.setGenGroupId(name);
            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getDiaryGen(Connection conn, String loginedUser) throws SQLException {
        String sql = "Select * from generics where gengroupid = '44' or gengroupid = '45'";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String genericdescriptioneng = rs.getString("GenericDescriptionENG");
            String gengroupid = rs.getString("gengroupid");
            String genericid = rs.getString("genericid");
            Generics generics = new Generics();
            generics.setGenGroupId(gengroupid);
            generics.setGenericId(genericid);
            generics.setGenericDescriptionEng(genericdescriptioneng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getDiaryLocat(Connection conn, String loginedUser, String thisLocat) throws SQLException {

        String sql1 = "delete from generics where gengroupid = '44' and genericdescriptioneng = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, thisLocat);
        pstm1.executeUpdate();

        String sql = "Select * from generics where gengroupid = '44'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String genericdescriptioneng = rs.getString("GenericDescriptionENG");
            String gengroupid = rs.getString("gengroupid");
            String genericid = rs.getString("genericid");
            Generics generics = new Generics();
            generics.setGenGroupId(gengroupid);
            generics.setGenericId(genericid);
            generics.setGenericDescriptionEng(genericdescriptioneng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> getDiaryResp(Connection conn, String loginedUser, String thisLocat) throws SQLException {

        String sql1 = "delete from generics where gengroupid = '45' and genericdescriptioneng = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, thisLocat);
        pstm1.executeUpdate();

        String sql = "Select * from generics where gengroupid = '45'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String genericdescriptioneng = rs.getString("GenericDescriptionENG");
            String gengroupid = rs.getString("gengroupid");
            String genericid = rs.getString("genericid");
            Generics generics = new Generics();
            generics.setGenGroupId(gengroupid);
            generics.setGenericId(genericid);
            generics.setGenericDescriptionEng(genericdescriptioneng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> AddDiaryLocat(Connection conn, String loginedUser, String thisLocat) throws SQLException {

        String sql1 = "insert into generics (gengroupid, genericdescriptioneng) values ('44', ?)";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, thisLocat);
        pstm1.executeUpdate();

        String sql = "Select * from generics where gengroupid = '44'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String genericdescriptioneng = rs.getString("GenericDescriptionENG");
            String gengroupid = rs.getString("gengroupid");
            String genericid = rs.getString("genericid");
            Generics generics = new Generics();
            generics.setGenGroupId(gengroupid);
            generics.setGenericId(genericid);
            generics.setGenericDescriptionEng(genericdescriptioneng);

            list.add(generics);
        }
        return list;
    }

    public static ArrayList<Generics> AddDiaryResp(Connection conn, String loginedUser, String thisLocat) throws SQLException {

        String sql1 = "insert into generics (gengroupid, genericdescriptioneng) values ('45', ?)";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, thisLocat);
        pstm1.executeUpdate();

        String sql = "Select * from generics where gengroupid = '45'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Generics> list = new ArrayList<Generics>();
        while (rs.next()) {
            String genericdescriptioneng = rs.getString("GenericDescriptionENG");
            String gengroupid = rs.getString("gengroupid");
            String genericid = rs.getString("genericid");
            Generics generics = new Generics();
            generics.setGenGroupId(gengroupid);
            generics.setGenericId(genericid);
            generics.setGenericDescriptionEng(genericdescriptioneng);

            list.add(generics);
        }
        return list;
    }

}
