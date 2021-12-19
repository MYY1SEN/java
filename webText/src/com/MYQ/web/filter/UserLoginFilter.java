package com.MYQ.web.filter;

import com.MYQ.commons.Constants;
import com.MYQ.pojo.users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 判断当前客户端浏览器是否登录
 */
@WebFilter(urlPatterns = {"*.do", "*.jsp"})
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        //判断当前请求的是否为login.do或者login.jsp
        if (uri.indexOf("login.jsp") != -1 || uri.indexOf("login.do") != -1
                || uri.indexOf("validateCode.do") != -1) {
            //允许用户登录
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            users user = (users) session.getAttribute(Constants.USER_SESSION_KEY);
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                request.setAttribute(Constants.REQUEST_MSG, "不登陆不好使!");
                request.getRequestDispatcher("login.jsp")
                        .forward(servletRequest, servletResponse);
            }
        }
    }
}
