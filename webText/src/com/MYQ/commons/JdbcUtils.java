package com.MYQ.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        ResourceBundle bundle  = ResourceBundle.getBundle("db");
        driver = bundle.getString("jdbc.driver");
        url = bundle.getString("jdbc.url");
        username = bundle.getString("jdbc.username");
        password = bundle.getString("jdbc.password");
        //加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取链接方法
    public  static Connection getconnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //关闭链接方法
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //事务回滚
    public static void rollbackConnection(Connection conn){
        try {
            conn.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
