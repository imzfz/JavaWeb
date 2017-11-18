package cn.imzfz.model.servlet;

import cn.imzfz.model.dao.ChoiceDAO;
import cn.imzfz.model.dao.QuestionDAO;
import cn.imzfz.model.impl.ChoiceList;
import cn.imzfz.model.impl.QuestionList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zfz on 2017/11/15.
 */
public class QuestionServlet extends HttpServlet {

    private QuestionDAO ql;
    private ChoiceDAO choice;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ql = new QuestionList();
        choice = new ChoiceList();
        ql.initQuestion();
        choice.initChoice();
        System.out.println("Question servlet");
        req.setAttribute("ql", ql.getQuestionMap());
        req.setAttribute("cho", choice.getList());
        if(req.getRequestURI().equals("/question")) {
            req.getRequestDispatcher("/question.jsp").forward(req, resp);
        }
        if(req.getRequestURI().equals("/editquestion")){
            req.getRequestDispatcher("/editquestion.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
