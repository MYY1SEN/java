package com.MYQ.web.servlet;

import com.MYQ.pojo.users;
import com.MYQ.service.UserManageService;
import com.MYQ.service.UserManageServiceimpL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 处理用户管理请求
 */
@WebServlet(urlPatterns = "/userManager.do")
public class UserManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if ("addUser".equals(flag)) {
            this.addUser(req, resp);
        } else if ("findUser".equals(flag)) {
            this.findUser(req, resp);
        } else if ("preUpdate".equals(flag)) {
            this.preUpdate(req, resp);
        }else if ("modifyUser".equals(flag)){
            this.modifyUser(req,resp);
        }else {
            this.Dropusers(req,resp);
        }
    }

    /**
     * 删除用户
     * @param req
     * @param resp
     */
    private void Dropusers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userid = req.getParameter("userid");
        try {
            UserManageService userManageService = new UserManageServiceimpL();
            userManageService.jropUsers(Integer.parseInt(userid));
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    /**
     * 更新用户
     * @param req
     * @param resp
     */
    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userid = req.getParameter("userid");
        users users = this.createUsers(req);
        users.setUserid(Integer.parseInt(userid));
        try {
            UserManageService userManageService = new UserManageServiceimpL();
            userManageService.modifyUsers(users);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    /**
     * 预更新查询
     *
     * @param req
     * @param resp
     */
    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userid = req.getParameter("userid");
        try {
            UserManageService userManageService = new UserManageServiceimpL();
            users user = userManageService.findUserByUserid(Integer.parseInt(userid));
            req.setAttribute("user", user);
            req.getRequestDispatcher("usermanager/updateUser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    /**
     * 处理查询用户请求
     *
     * @param req
     * @param resp
     */
    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        users users = this.createUsers(req);
        try {
            UserManageService userManageService = new UserManageServiceimpL();
            List<users> list = userManageService.findUsers(users);
            req.setAttribute("list", list);
            req.getRequestDispatcher("usermanager/viewUser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    //处理添加用户请求
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        users users = this.createUsers(req);
        try {
            UserManageService userManageService = new UserManageServiceimpL();
            userManageService.adduser(users);
            resp.sendRedirect("ok.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    //获取用户提交数据
    private users createUsers(HttpServletRequest req) {
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String usersex = req.getParameter("usersex");
        String phonenumber = req.getParameter("phonenumber");
        String qqnumber = req.getParameter("qqnumber");
        users users = new users();
        users.setUsername(username);
        users.setUserpwd(userpwd);
        users.setUsersex(usersex);
        users.setPhonenumber(phonenumber);
        users.setQqnumber(qqnumber);
        return users;
    }
}
