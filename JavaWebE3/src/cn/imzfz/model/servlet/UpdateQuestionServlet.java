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

    String id;
    String title;
    String type;
    String choiceA;
    String choiceB;
    String choiceC;
    String choiceD;
    String score;
    String answer;
    String delId[];

    /**
     * post方法获取表单数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getParameter("newId");
        title = req.getParameter("newTitle");
        type = req.getParameter("question_type");
        choiceA = req.getParameter("newA");
        choiceB = req.getParameter("newB");
        choiceC = req.getParameter("newC");
        choiceD = req.getParameter("newD");
        score = req.getParameter("score");
        answer = req.getParameter("answer");
        delId = req.getParameterValues("checkbox");
        String doWhat = req.getRequestURI();

        System.out.println(id + " " + title + " " + type + " " + choiceA + " " + choiceB);
        try {
            switch (doWhat) {
                case "/insert":
                    add();
                    break;
                case "/update":
                    update();
                    break;
                case "/delete":
                    delete();
                    break;
                default:
                    resp.sendRedirect("/index.jsp");
            }
            resp.sendRedirect("/editquestion");
        } catch (Exception e) {
            System.out.println("数据更新失败");
            req.setAttribute("error", "数据更新失败");
            resp.sendRedirect("errorpage.jsp");
        }
/*        switch (type){
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
        resp.sendRedirect("/editquestion");*/
    }

    public void add() throws Exception {
        Question q;
        Select s;
        TrueOrFalse tf;
        QuestionList ql;
        ChoiceList cl;

        //对题目类型分类
        switch (type) {
            case "select":
                q = new Question(title, score, answer);
                q.setId(id);
                s = new Select(choiceA, choiceB, choiceC, choiceD);
                ql = new QuestionList();
                cl = new ChoiceList();
                if (ql.addQuestion(q)) {
                    cl.addChoice(q, s);
                }
                break;
            case "tf":
                System.out.println("判断判断判断");
                q = new Question(title, score, answer);
                q.setId(id);
                tf = new TrueOrFalse();
                ql = new QuestionList();
                cl = new ChoiceList();
                if (ql.addQuestion(q)) {
                    cl.addChoice(q, tf);
                }
                break;
        }
    }

    public void update() throws Exception{
        Question q;
        Select s;
        TrueOrFalse tf;
        QuestionList ql;
        ChoiceList cl;

        //对题目类型分类
        switch (type) {
            case "select":
                q = new Question(title, score, answer);
                q.setId(id);
                s = new Select(choiceA, choiceB, choiceC, choiceD);
                ql = new QuestionList();
                cl = new ChoiceList();
                if (ql.updateQuestion(q)) {
                    cl.updateChoice(q, s);
                }
                break;
            case "tf":
                q = new Question(title, score, answer);
                q.setId(id);
                tf = new TrueOrFalse();
                ql = new QuestionList();
                cl = new ChoiceList();
                if (ql.updateQuestion(q)) {
                    cl.updateChoice(q, tf);
                }
                break;
        }
    }

    public void delete() throws Exception{
        QuestionList ql = new QuestionList();
        ChoiceList cl = new ChoiceList();

        if (delId != null && delId.length > 0) {
            for (int i = 0; i < delId.length; i++) {
                if (cl.delChoice(delId[i]))
                    ql.delQuestion(delId[i]);
            }
        }


    }
}
