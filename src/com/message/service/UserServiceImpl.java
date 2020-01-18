package com.message.service;

import com.message.dao.UserDao;
import com.message.dao.UserDaoImpl;
import com.message.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao ud;

    public UserServiceImpl() {
        ud = new UserDaoImpl();
    }

    @Override
    public boolean login(String username, String password) {
        User user = ud.queryByName(username);
        if (user == null) {
            return false;
        }

        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户已存在返回-1
     * 注册成功返回1
     * 失败返回0
     */
    @Override
    public int register(User user) {
        User temp = ud.queryByName(user.getUsername());
        if (temp != null) {
            return -1;
        }
        return ud.addUser(user);
    }

    @Override
    public User getUser(String username) {
        return ud.queryByName(username);
    }

    @Override
    public List<User> getUserList() {
        return ud.queryUserList();
    }

    @Override
    public User getUserById(int id) {
        return ud.queryById(id);
    }
}
