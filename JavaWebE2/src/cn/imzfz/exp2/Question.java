package cn.imzfz.exp2;

import com.oracle.tools.packager.Log;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

import static cn.imzfz.exp2.SqlConnect.*;

/**
 * Created by zfz on 2017/10/26.
 */
public class Question{
    private static final String TABLE = "Question_title";
    private ArrayList<String> qId;
    private ArrayList<String> qTitle;
    private ArrayList<String> qScore;

    public Question() {
        qId = new ArrayList<>();
        qTitle = new ArrayList<>();
        qScore = new ArrayList<>();
    }

    public void connect(){
        try {
            SqlConnect connect = new SqlConnect();
            connect.setStatement(connect.getConnection().createStatement());
            ResultSet res = connect.getStatement().executeQuery("SELECT * from " + TABLE + " ORDER by qid ASC");
            while(res.next()){
                qId.add(res.getString(1));
                qTitle.add(res.getString(2));
                qScore.add(res.getString(3));
            }
            System.out.println("question");
            res.close();
            connect.getConnection().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getqId() {
        return qId;
    }

    public ArrayList<String> getqTitle() {
        return qTitle;
    }

    public ArrayList<String> getqScore() {
        return qScore;
    }
}
