package com.message.dao;

import java.util.List;

import com.message.pojo.Message;

public interface MessageDao {

	public Message getMessageById(int id);
	
	public int getTotalRow();
	
	public List<Message> getListByIndex(int index,int pageRow,int userId);

	public List<Message> getListByIndexAndAcceptId(int index,int pageRow,int userId);
	
	public int deleteMessageById(int id);
	
	public int insertMessage(Message m);
	
	public int updateMessageById(int ifAccept,int id);
}
