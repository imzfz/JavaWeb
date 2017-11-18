package cn.imzfz.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zfz on 2017/11/18.
 */
public class DecodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        HttpServletResponse hsp = (HttpServletResponse) servletResponse;
        hsr.setCharacterEncoding("UTF-8");
        hsp.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("do filter111");
    }

    @Override
    public void destroy() {

    }
}
