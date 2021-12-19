package com.MYQ.dao.impL;

import com.MYQ.commons.JdbcUtils;
import com.MYQ.dao.UserManagerDao;
import com.MYQ.pojo.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManagerDaoimpL implements UserManagerDao {
    @Override
    public void insertuser(users user) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getconnection();
            //关闭事务自动提交
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement
                    ("insert into user values(default ,?,?,?,?,?) ");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getUserpwd());
            ps.setString(3, user.getUsersex());
            ps.setString(4, user.getPhonenumber());
            ps.setString(5, user.getQqnumber());
            //执行sql语句
            ps.execute();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackConnection(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    /**
     * 查询用户
     *
     * @param users
     * @return
     */
    @Override
    public List<users> selectUserByProperty(users users) {
        Connection con = null;
        List<users> list = new ArrayList<>();
        try {
            con = JdbcUtils.getconnection();
            String sql = this.createSql(users);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                users user = new users();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));
                user.setUsername(resultSet.getString("username"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(con);
        }
        return list;
    }

    //拼接sql语句
    private String createSql(users users) {
        StringBuffer stringBuffer = new StringBuffer("select * from user where 1 = 1");
        if (users.getUsersex() != null && users.getUsersex().length() > 0) {
            stringBuffer.append(" and usersex=" + users.getUsersex());
        }
        if (users.getPhonenumber() != null && users.getPhonenumber().length() > 0) {
            stringBuffer.append(" and phonenumber=" + users.getPhonenumber());
        }
        if (users.getQqnumber() != null && users.getQqnumber().length() > 0) {
            stringBuffer.append(" and qqnumber=" + users.getQqnumber());
        }
        if (users.getUsername() != null && users.getUsername().length() > 0) {
            stringBuffer.append(" and username='" + users.getUsername() + "'");
        }
        return stringBuffer.toString();
    }

    /**
     * 根据用户id查询
     *
     * @param userid
     * @return
     */
    @Override
    public users selectUserByUserid(int userid) {
        Connection con = null;
        users user = null;
        try {
            con = JdbcUtils.getconnection();
            PreparedStatement ps = con.prepareStatement("select * from user where userid = ?");
            ps.setInt(1, userid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user = new users();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));
                user.setUsername(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(con);
        }
        return user;
    }

    /**
     * 更新用户
     *
     * @param users
     */
    @Override
    public void updataUserByUserid(users users) {
        Connection con = null;
        try {
            con = JdbcUtils.getconnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("update user set username=?,usersex=?,phonenumber=?,qqnumber=?where userid=?");
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getUsersex());
            ps.setString(3, users.getPhonenumber());
            ps.setString(4, users.getQqnumber());
            ps.setInt(5, users.getUserid());
            ps.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackConnection(con);
        } finally {
            JdbcUtils.closeConnection(con);
        }
    }

    /**
     * 根据用户id删除
     * @param userid
     */
    @Override
    public void deleteUserByUserid(int userid) {
        Connection con = null;
        try {
            con = JdbcUtils.getconnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("delete from user where userid = ?");
            ps.setInt(1, userid);
            ps.execute();
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtils.rollbackConnection(con);
        }finally {
            JdbcUtils.closeConnection(con);
        }
    }
}
