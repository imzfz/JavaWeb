package cn.imzfz.model.dao;

import cn.imzfz.model.bean.Question;

import java.util.Map;

/**
 * Created by zfz on 2017/11/16.
 */
public interface QuestionDAO {
    void initQuestion();
    boolean addQuestion(Question question) throws Exception;
    boolean delQuestion(String id) throws Exception;
    boolean updateQuestion(Question question) throws Exception;
    Map<String, Question> getQuestionMap();
}
