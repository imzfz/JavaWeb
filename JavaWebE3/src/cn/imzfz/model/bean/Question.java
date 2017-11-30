package cn.imzfz.model.bean;

/**
 * Created by zfz on 2017/11/15.
 */
public class Question {
    private String id = "";
    private String title = "";
    private String score = "";
    private String type = "";
    private String answer = "";

    public Question(String id, String title, String score, String answer, String type){
        this.id = id;
        this.title = title;
        this.score = score;
        this.type = type;
        this.answer = answer;
    }

    public Question(String title, String score, String answer){
        this.title = title;
        this.score = score;
        this.answer = answer;
    }

    public Question(String id, int score, String answer){
        this.title = id;
        this.score = score + "";
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getScore() {
        return score;
    }

    public String getType() {
        return type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(String id) {
        this.id = id;
    }
}
