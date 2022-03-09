package com.myq.springbootjdbc.dao.impl;

import com.myq.springbootjdbc.dao.UserDao;
import com.myq.springbootjdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 持久层
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 预更新用户
     *
     * @param userid
     * @return
     */
    @Override
    public User selectUserById(Integer userid) {
        User user = new User();
        String sql = "select * from users where userid = ?";
        Object[] arr = new Object[]{userid};
        this.jdbcTemplate.query(sql, arr, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setUsername(rs.getString("username"));
                user.setUserpwd(rs.getString("userpwd"));
                user.setUserid(rs.getInt("userid"));
            }
        });
        return user;
    }

    /**
     * 查询
     *
     * @return
     */
    @Override
    public List<User> findUserAll() {
        String sql = "select * from users";
        return this.jdbcTemplate.query(sql, new RowMapper<User>() {
            /**
             * 结果集映射
             * @param rs
             * @param rowNum
             * @return
             * @throws SQLException
             */
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setUserpwd(rs.getString("userpwd"));
                return user;
            }
        });
    }

    @Override
    public void insertUser(User user) {
        String sql = "insert into users(username,userpwd) values(?,?)";
        this.jdbcTemplate.update(sql, user.getUsername(), user.getUserpwd());
    }
}
