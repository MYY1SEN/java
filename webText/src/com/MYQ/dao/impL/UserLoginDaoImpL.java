package com.MYQ.dao.impL;

import com.MYQ.commons.JdbcUtils;
import com.MYQ.dao.UserLoginDao;
import com.MYQ.pojo.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDaoImpL implements UserLoginDao {
    /**
     * 用户登录的数据库查询
     *
     * @param username
     * @param userpwd
     * @return
     */
    @Override
    public users selectUsersByUsernameandUserpwd(String username, String userpwd) {
        users users = null;
        Connection conn = null;
        try {
            conn = JdbcUtils.getconnection();
            PreparedStatement ps = conn.prepareStatement("select * from user " +
                    "where username= ? and userpwd= ?");
            ps.setString(1, username);
            ps.setString(2, userpwd);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                users = new users();
                users.setUsersex(resultSet.getString("usersex"));
                users.setUserpwd(resultSet.getString("userpwd"));
                users.setUsername(resultSet.getString("username"));
                users.setUserid(resultSet.getInt("userid"));
                users.setPhonenumber(resultSet.getString("phonenumber"));
                users.setQqnumber(resultSet.getString("qqnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return users;
    }
}
