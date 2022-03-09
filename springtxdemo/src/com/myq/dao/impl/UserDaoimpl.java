package com.myq.dao.impl;

import com.myq.dao.UserDao;
import com.myq.pojo.Order;
import com.myq.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoimpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(User user) {
        String sql = "insert into users values(default,?,?)";
        Object[] args = new Object[]{user.getUsername(),user.getUsersex()};
        this.jdbcTemplate.update(sql,args);
    }

    @Override
    public void insertOrder(Order order) {
        String sql = "insert into orders values(default,?,null)";
        Object[] args= new Object[]{order.getOrderprice()};
        this.jdbcTemplate.update(sql, args);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
