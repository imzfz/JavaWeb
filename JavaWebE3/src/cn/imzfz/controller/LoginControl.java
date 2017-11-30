package cn.imzfz.controller;

import cn.imzfz.model.bean.Check;
import cn.imzfz.model.bean.User;
import cn.imzfz.model.dao.UserDao;
import cn.imzfz.model.impl.UserImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by zfz on 2017/11/10.
 */
public class LoginControl extends HttpServlet implements Filter {
    private FilterConfig fc;
    private final static String indexPage = "/index.jsp";
    private final static String questionPage = "/question";
    private final static String editQuestionPage = "/editquestion";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("password");

        user = user.trim();
        pass = pass.trim();

        User user1 = new User(user, pass);
        UserDao uImpl = new UserImpl();

        if (uImpl.isValid(user1)) {
            if (user1.getAuth() == 0) {
                resp.sendRedirect(questionPage);
            }
            if (user1.getAuth() == 1) {
                resp.sendRedirect(editQuestionPage);
            }
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("password", pass);
            req.getSession().setAttribute("auth", user1.getAuth());
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
            if(remoteURI.equals("result.jsp")){
                hsp.sendRedirect("/");
            }
            if (remoteURI.contains(indexPage) || remoteURI.equals("/") || remoteURI.contains(editQuestionPage)) {
                if ((int) hsr.getSession().getAttribute("auth") == 0) {
                    System.out.println("testtttttt");
                    hsp.sendRedirect(questionPage);
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}
