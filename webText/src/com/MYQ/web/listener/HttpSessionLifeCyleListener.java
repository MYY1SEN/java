package com.MYQ.web.listener;

import com.MYQ.commons.Constants;
import com.MYQ.pojo.users;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 解决HttpSession被反复销毁的问题
 */
@WebListener
public class HttpSessionLifeCyleListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //获取servletcontext对象，将所对应httpsession删除
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        users user = (users) session.getAttribute(Constants.USER_SESSION_KEY);
        servletContext.removeAttribute(user.getUserid()+"");
    }
}
