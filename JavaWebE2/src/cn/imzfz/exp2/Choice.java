package cn.imzfz.exp2;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static cn.imzfz.exp2.SqlConnect.*;

/**
 * Created by zfz on 2017/10/30.
 */
public class Choice {
    private Map<String, Object> list = new HashMap<>();
    private final static String TABLE = "Choice";


    public Choice() {
    }

    public void connect() {
        try {
            SqlConnect connect = new SqlConnect();
            connect.setStatement(connect.getConnection().createStatement());
            ResultSet res = connect.getStatement().
                    executeQuery("SELECT * FROM Choice ORDER BY qid ASC ");
            while (res.next()) {
                switch (res.getString(9)) {
                    case "tf":
                        list.put(res.getString(8), new TrueOrFalse());
                        break;
                    case "select":
                        list.put(res.getString(8), new Select(res.getString(2),
                                res.getString(3), res.getString(4), res.getString(5)));
                        break;
                }
            }
            System.out.println("choice");
            res.close();
            connect.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void select(String id) {
        try {
            SqlConnect connect = new SqlConnect();
            connect.setStatement(connect.getConnection().createStatement());
            ResultSet res = connect.getStatement().executeQuery("SELECT choiceA, choiceB, choiceC, choiceD, qid FROM " + TABLE + " WHERE qid=" + id +" ORDER by qid ASC");
            while (res.next()) {
                System.out.println(res.getString(1) + "aaa");
                list.put(res.getString(5),
                        new Select(res.getString(1),
                                res.getString(2),
                                res.getString(3),
                                res.getString(4)));
            }
            res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TorF(String id){
        try {
            SqlConnect connect = new SqlConnect();
            connect.setStatement(connect.getConnection().createStatement());
            ResultSet res = connect.getStatement().executeQuery("SELECT choiceYes, choiceNo, qid FROM " + TABLE + " WHERE qid=" + id + " ORDER by qid ASC");
            while (res.next()) {
                System.out.println(res.getString(3) + "bbb");
                list.put(res.getString(3),
                        new TrueOrFalse());
            }
            res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public Map<String, Object> getList() {
        return list;
    }
}
