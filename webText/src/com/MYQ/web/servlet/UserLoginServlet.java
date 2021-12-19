package com.MYQ.web.servlet;

import com.MYQ.commons.Constants;
import com.MYQ.exception.UserNotFoundException;
import com.MYQ.pojo.users;
import com.MYQ.service.UserLoginService;
import com.MYQ.service.impLUserLoginService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理用户登录请求
 */
@WebServlet(urlPatterns = "/login.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String code = req.getParameter("code");
        try {
            HttpSession httpSession = req.getSession();
            String codetemp = (String) httpSession.getAttribute(Constants.VALIDATA_CODE_KEY);
            if (codetemp.equals(code)){
                UserLoginService userLoginService = new impLUserLoginService();
                users users = userLoginService.userLogin(username, userpwd);
                //建立客户端服务端会话状态
                httpSession.setAttribute(Constants.USER_SESSION_KEY, users);
                ServletContext servletContext = this.getServletContext();
                HttpSession temp = (HttpSession) servletContext.getAttribute(users.getUserid()+"");
                if (temp != null){
                    servletContext.removeAttribute(users.getUserid()+"");
                    //删除
                    temp.invalidate();
                }
                servletContext.setAttribute(users.getUserid()+"", httpSession);
                //使用重定向跳转首页
                resp.sendRedirect("main.jsp");
            }else {
                req.setAttribute(Constants.REQUEST_MSG, "验证码有误!请重新输入");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (UserNotFoundException e) {
            req.setAttribute("msg", e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
