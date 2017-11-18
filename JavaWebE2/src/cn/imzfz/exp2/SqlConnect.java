package cn.imzfz.exp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zfz on 2017/10/30.
 */
public class SqlConnect {
    private final static String URL = "jdbc:mysql://123.206.47.237:3306/zhangfangzi";
 //   private final static String URL = "jdbc:mysql://localhost:3306/zhangfangzi";
    private Statement statement;
    private Connection connection;

    public SqlConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("SQLLLLLL");
            connection = DriverManager.getConnection(URL, "cas", "MVpDYH1MaTQA2hGP");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, "cas", "MVpDYH1MaTQA2hGP");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
