package com.message.service;

import com.message.pojo.User;

import java.util.List;

public interface UserService {

    public boolean login(String username, String password);

    public int register(User user);

    public User getUser(String username);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return
     */
    public User getUserById(int id);

    /**
     * 查询全部用户
     *
     * @return
     */
    public List<User> getUserList();

}
