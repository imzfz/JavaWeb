package cn.imzfz.exp2;

import java.io.Serializable;
import java.sql.ResultSet;

import static cn.imzfz.exp2.SqlConnect.*;

/**
 * Created by zfz on 2017/10/26.
 */
public class Check implements Serializable{
    private String uid;
    private String user;
    private String pass;
    private final static String TABLE = "Users";
    private final static String UNAME = "user_name";
    private final static String UPASS = "user_pass";

    public Check(){
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isValid(){
        try {
            SqlConnect connect = new SqlConnect();
            connect.setStatement(connect.getConnection().createStatement());
            ResultSet res = connect.getStatement().
                    executeQuery("SELECT * from " + TABLE + " WHERE user_name = '" + user + "'");
            while(res.next()){
                if(res.getString(2).equals(user) && res.getString(3).equals(pass)){
                    return true;
                }
            }
            System.out.println("check");
            res.close();
            connect.getConnection().close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
