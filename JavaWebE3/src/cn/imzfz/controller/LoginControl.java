package cn.imzfz.controller;

import cn.imzfz.model.bean.Check;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zfz on 2017/11/10.
 */
public class LoginControl extends HttpServlet implements Filter {
    private FilterConfig fc;
    private final static String indexPage = "/index.jsp";
    private final static String questionPage = "/question";
    private final static String editQuestionPage = "/editquestion";
    private final static String editUserPage = "/edituser";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("password");

        user = user.trim();
        pass = pass.trim();

        boolean valid = new Check(user, pass).isValid();
        if (valid) {
            resp.sendRedirect(questionPage);
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("password", pass);
        } else {
            req.getSession().setAttribute("login", "用户名或密码错误");
            resp.sendRedirect(indexPage);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        HttpServletResponse hsp = (HttpServletResponse) servletResponse;
        System.out.println("do filter");
        if (hsr.getSession().getAttribute("user") == null) {
            hsr.getRequestDispatcher(indexPage).forward(hsr, hsp);
        } else {
            String remoteURI = hsr.getRequestURI();
            if (remoteURI.contains(indexPage) || remoteURI.equals("/")) {
                hsp.sendRedirect(questionPage);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}
