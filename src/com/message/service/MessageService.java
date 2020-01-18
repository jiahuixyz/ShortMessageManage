package com.message.service;

import com.message.pojo.Message;
import com.message.pojo.Page;

public interface MessageService {

	
	public Page getPage(int index,int pageRow,int userId);
	
	public Page getPageOther(int index,int pageRow,int userId);
	
	public Message getMessage(int id);
	
	public boolean deleteMessageById(int...id);
	
	public boolean insertMessage(Message...message);
	
	public void updateMessageIfAccept(int id);
	
}
