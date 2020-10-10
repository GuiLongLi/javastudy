package com.util;

import java.sql.*;

/**
 新疆一个数据库类处理数据库操作
 * **/

public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/test?userunicuee=true&characterEncoding=utf8";
    static String username = "root";
    static String password = "root";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            System.out.println("init [sql驱动程序初始化失败!]");
            e.printStackTrace();
        }
    }
    public static int addUpdDele(String sql){
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        }catch (SQLException e){
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        }catch (SQLException e){
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }

}
