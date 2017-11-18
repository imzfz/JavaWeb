package cn.imzfz.model.servlet;

import cn.imzfz.model.bean.Question;
import cn.imzfz.model.bean.Select;
import cn.imzfz.model.bean.TrueOrFalse;
import cn.imzfz.model.impl.ChoiceList;
import cn.imzfz.model.impl.QuestionList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zfz on 2017/11/17.
 */
public class UpdateQuestionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("newId");
        String title = req.getParameter("newTitle");
        String type = req.getParameter("question_type");
        String choiceA = req.getParameter("newA");
        String choiceB = req.getParameter("newB");
        String choiceC = req.getParameter("newC");
        String choiceD = req.getParameter("newD");
        String score= req.getParameter("score");
        String answer = req.getParameter("answer");
        Question q;
        Select s;
        TrueOrFalse tf;
        QuestionList ql;
        ChoiceList cl;

        System.out.println("id " + id + " title " + title + " score " + score + " ans " + answer + " type " + type);

        switch (type){
            case "select":
                q = new Question(title, score, answer);
                q.setId(id);
                s = new Select(choiceA, choiceB, choiceC, choiceD);
                ql = new QuestionList();
                cl = new ChoiceList();
                if(ql.addQuestion(q)) {
                    cl.addChoice(q, s);
                }
            case "tf":
                System.out.println("判断判断判断");
                q = new Question(title, score, answer);
                q.setId(id);
                tf = new TrueOrFalse();
                ql = new QuestionList();
                cl = new ChoiceList();
                if(ql.addQuestion(q)){
                    cl.addChoice(q, tf);
                }
        }
        resp.sendRedirect("/editquestion");
    }
}
