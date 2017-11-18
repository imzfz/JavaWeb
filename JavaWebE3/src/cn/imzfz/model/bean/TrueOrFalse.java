package cn.imzfz.model.bean;

/**
 * Created by zfz on 2017/11/1.
 */
public class TrueOrFalse {
    private String id;
    private final String choiceYes = "对";
    private final String choiceNo = "错";

    public TrueOrFalse(){

    }

    public String getChoiceYes() {
        return choiceYes;
    }

    public String getChoiceNo() {
        return choiceNo;
    }
}
