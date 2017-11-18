package cn.imzfz.exp2;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zfz on 2017/10/30.
 */
public class Result {
    private final static String TABLE = "Choice";
    private Map<String, String> tf = null;
    private Map<String, String> single = null;
    private Map<String, String> ans = new HashMap<>();
    private int score = 0;

    public Result() {
        tf = new HashMap<>();
        single = new HashMap<>();
    }

    public void connect() {
        try {
            SqlConnect connect = new SqlConnect();
            connect.setStatement(connect.getConnection().createStatement());
            ResultSet res = connect.getStatement().executeQuery("SELECT qid, qscore, ans FROM Question_title");
            while (res.next()) {
                ans.put(res.getString(1), res.getString(3));
            }
            res.close();
            connect.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTf(Map<String, String> tf) {
        this.tf = tf;
    }

    public void setSingle(Map<String, String> single) {
        this.single = single;
    }

    public void judge(ArrayList<String> list) {
        try {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                String count = list.get(i);
                if (tf.get(count) != null) {
                    if (ans.get(count).equals(tf.get(count))) {
                        System.out.println("test11");
                        score += 3;
                    }
                }
                if (single.get(count) != null) {
                    if (ans.get(count).equals(single.get(count))) {
                        score += 3;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getScore() {
        return score;
    }
}
