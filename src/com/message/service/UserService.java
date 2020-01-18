package com.message.service;

import com.message.pojo.User;

import java.util.List;

public interface UserService {

    public boolean login(String username, String password);

    public int register(User user);

    public User getUser(String username);

    /**
     * ����id��ѯ�û�
     *
     * @param id �û�id
     * @return
     */
    public User getUserById(int id);

    /**
     * ��ѯȫ���û�
     *
     * @return
     */
    public List<User> getUserList();

}
