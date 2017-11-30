package cn.imzfz.model.impl;

import cn.imzfz.model.bean.Question;
import cn.imzfz.model.dao.DBConnection;
import cn.imzfz.model.dao.ResultDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zfz on 2017/11/28.
 */
public class ResultImpl implements ResultDao{

    private static final String TABLE = "info";
    private Map<String, Question> ansMap;
    private Map<String, String> subMap;
    private Connection connection;
    private Statement statement;


    public ResultImpl(Map<String, String> subMap){
        ansMap = new HashMap<>();
        this.subMap = subMap;
    }

    @Override
    public int judge() {
        int size = ansMap.size();
        int score = 0;
        for (int i = 1; i <= size; i++) {
            Question q = ansMap.get(i + "");
            String ans = subMap.get(i + "");
            if(q.getAnswer().equals(ans)){
                score += Integer.parseInt(q.getScore());
            }
        }
        return score;
    }

    @Override
    public void initJudge() {
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT qid, qscore, ans from " + TABLE + " ORDER by qid ASC");
            while(res.next()){
                ansMap.put(res.getString(1), new Question(res.getString(1), res.getInt(2),res.getString(3)));
            }
            System.out.println("ans list");
            res.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
