package com.message.dao;

import com.message.pojo.User;

import java.util.List;

public interface UserDao {
	
	public User queryByName(String username);
	
	public int addUser(User user);
	
	public int deleteUser(String username);
	
	public User queryById(int id);

	/**
	 * ��ѯȫ���û�
	 * @return
	 */
	public List<User> queryUserList();
}
