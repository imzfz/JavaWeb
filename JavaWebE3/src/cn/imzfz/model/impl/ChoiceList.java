package cn.imzfz.model.impl;


import cn.imzfz.model.bean.Question;
import cn.imzfz.model.dao.ChoiceDAO;
import cn.imzfz.model.dao.DBConnection;
import cn.imzfz.model.bean.Select;
import cn.imzfz.model.bean.TrueOrFalse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zfz on 2017/10/30.
 */
public class ChoiceList implements ChoiceDAO{
    private Map<String, Object> list;
    private final static String TABLE = "ChoiceList";
    private Connection connection;
    private Statement statement;


    public ChoiceList() {
        list = new HashMap<>();
        DBConnection con = new DBConnection();
        connection = con.connection();
    }

    @Override
    public void initChoice() {
        try {
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Choice ORDER BY qid ASC ");
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
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addChoice(Question question, Select select) throws Exception{
        try {
            String t = question.getId();
            System.out.println("idddd " + t);
            int id = Integer.parseInt(t);
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            statement.execute("INSERT INTO Choice(choiceA, choiceB, choiceC, choiceD, qid, `type`) VALUES ('"+
                    select.getChoiceA() + "','" + select.getChoiceB() + "','" + select.getChoiceC() + "','" + select.getChoiceD() +
                    "','" + id + "'," + "'select'" +
                    ")");
            statement.close();
            return true;
        }catch (Exception e){
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delChoice(String id) throws Exception{
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            statement.execute("DELETE FROM Choice" + " WHERE qid='" + id + "'");
            statement.close();
            return true;
        }catch (Exception e){
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateChoice(Question question, Select select) throws Exception{
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            statement.execute("UPDATE Choice SET choiceA='" + select.getChoiceA() +
                    "', choiceB='" + select.getChoiceB() +
                    "', choiceC='" + select.getChoiceC() +
                    "', choiceD='" + select.getChoiceD() +
                    "', choiceYes=NULL, " + "choiceNo=NULL" +
                    ", `type`='" + "select" + "' WHERE qid='" + question.getId() + "'");
            statement.close();
            return true;
        }catch (Exception e){
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateChoice(Question question, TrueOrFalse trueOrFalse) {
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            statement.execute("UPDATE Choice SET choiceYes='" + "对" +
                    "', choiceNo='" + "错" +
                    "', `type`='" + "tf" +
                    "', choiceA=NULL, " + "choiceB=NULL, " + "choiceC=NULL, " + "choiceD=NULL " +
                    " WHERE qid='" + question.getId() + "'");
            statement.close();
            return true;
        }catch (Exception e){
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addChoice(Question question, TrueOrFalse trueOrFalse) {
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            statement.execute("INSERT INTO Choice(choiceYes, choiceNo, qid, `type`) VALUES ('"+
                    trueOrFalse.getChoiceYes() + "','" +
                    trueOrFalse.getChoiceNo() + "','" +
                    question.getId() + "'," + "'tf'" +
                    ")");
            statement.close();
            return true;
        }catch (Exception e){
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return false;
    }

    public Map<String, Object> getList() {
        return list;
    }
}
