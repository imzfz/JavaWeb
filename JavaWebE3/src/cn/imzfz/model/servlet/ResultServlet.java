package cn.imzfz.model.servlet;

import cn.imzfz.model.bean.Question;
import cn.imzfz.model.impl.ResultImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zfz on 2017/11/28.
 */
public class ResultServlet extends HttpServlet {
    int total = 0;
    Map<String, String> submit = new HashMap<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        total = Integer.parseInt(req.getParameter("totalId"));
        int score;
        for(int i = 1; i <= total; i++){
            String single[] = req.getParameterValues("single_" + i);
            String tf[] = req.getParameterValues("tf_" + i);
            if(single != null){
                submit.put(i + "", single[0]);
            }

            if(tf != null){
                submit.put(i + "", tf[0]);
            }
        }
        ResultImpl result = new ResultImpl(submit);
        result.initJudge();
        score = result.judge();
        req.getSession().setAttribute("score", score);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    public Map<String, String> getSubmit() {
        return submit;
    }
}
