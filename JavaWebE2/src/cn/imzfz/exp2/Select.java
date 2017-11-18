package cn.imzfz.exp2;

/**
 * Created by zfz on 2017/11/1.
 */
public class Select {
    private String id;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;

    public Select(String choiceA, String choiceB, String choiceC, String choiceD) {
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
