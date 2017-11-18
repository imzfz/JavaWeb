package cn.imzfz.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by zfz on 2017/11/15.
 */
public class DBConnection {
    private Connection connection;
    private static final String URL = "jdbc:mysql://123.206.47.237:3306/zhangfangzi";
    private static final String SQLUSER = "cas";
    private static final String SQLPASS = "MVpDYH1MaTQA2hGP";

    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            System.out.println("找不到数据库驱动");
            e.printStackTrace();
        }
    }

    public Connection connection(String host, String username, String password, String port, String tableName){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + tableName, username, password);
        }catch (Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection connection(){
        try {
            connection = DriverManager.getConnection(URL, SQLUSER, SQLPASS);
        }catch (Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
        }
        return connection;
    }

    public void close(){
        try{
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
