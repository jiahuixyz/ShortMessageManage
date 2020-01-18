package com.message.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.message.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    public UserDaoImpl() {
    }

    @Override
    public User queryByName(String username) {
        User user = null;
        String sql = "SELECT * FROM USER_0807 WHERE USERNAME=?";
        try {
            rs = query(sql, username);
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setFriendList(rs.getString("FRIEND_LIST"));
                user.setCreateTime(rs.getDate("CREATE_TIME"));
                user.setMailAccount(rs.getString("MAIL_ACCOUNT"));
                user.setId(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return user;
    }

    @Override
    public int addUser(User user) {
        int result = 0;
        String sql = "INSERT INTO USER_0807(USERNAME,PASSWORD,FRIEND_LIST,CREATE_TIME,MAIL_ACCOUNT)"
                + " VALUE(?,?,?,?,?)";
        Object[] obj = {user.getUsername(), user.getPassword(),
                user.getFriendList(), user.getCreateTime(), user.getMailAccount()};
        try {
            result = alter(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    @Override
    public int deleteUser(String username) {
        int result = 0;
        String sql = "Delete FORM USER_0807 WHERE USERNAME=?";
        try {
            result = alter(sql, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    @Override
    public User queryById(int id) {
        User user = null;
        String sql = "SELECT * FROM USER_0807 WHERE ID=?";
        try {
            rs = query(sql, id);
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setFriendList(rs.getString("FRIEND_LIST"));
                user.setCreateTime(rs.getDate("CREATE_TIME"));
                user.setMailAccount(rs.getString("MAIL_ACCOUNT"));
                user.setId(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return user;
    }

    @Override
    public List<User> queryUserList() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user_0807";

        try {
            rs = query(sql);
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setFriendList(rs.getString("FRIEND_LIST"));
                user.setCreateTime(rs.getDate("CREATE_TIME"));
                user.setMailAccount(rs.getString("MAIL_ACCOUNT"));
                user.setId(rs.getInt("ID"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
