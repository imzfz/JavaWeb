package cn.imzfz.model.impl;

import cn.imzfz.model.bean.Question;
import cn.imzfz.model.dao.DBConnection;
import cn.imzfz.model.dao.QuestionDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zfz on 2017/10/26.
 */
public class QuestionList implements QuestionDAO{
    private static final String TABLE = "info";
    private Map<String, Question> questionMap;
    private Connection connection;
    private Statement statement;
    private Question question;
    private static final String QUERY =  "qid, qtitle, qscore, type";

    public QuestionList() {
        questionMap = new HashMap<>();
    }

    @Override
    public void initQuestion(){
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * from " + TABLE + " ORDER by qid ASC");
            while(res.next()){
                question = new Question(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4));
                questionMap.put(res.getString(1), question);
            }
            System.out.println("question list");
            res.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean addQuestion(Question question) {
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            statement.execute("INSERT INTO Question_title(qid, qtitle, qscore, ans) VALUES ('"+
                    question.getId() + "','" +
                    question.getTitle() + "','" +
                    question.getScore() + "','" +
                    question.getAnswer() +
                    "')");
            statement.close();
            return true;
        }catch (Exception e){
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delQuestion(int id) {
        return false;
    }

    @Override
    public boolean updateQuestion(int id) {
        return false;
    }

    @Override
    public Map<String, Question> getQuestionMap() {
        return questionMap;
    }
}
