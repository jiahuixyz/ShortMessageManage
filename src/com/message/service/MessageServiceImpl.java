package com.message.service;

import java.util.List;

import com.message.dao.MessageDao;
import com.message.dao.MessageDaoImpl;
import com.message.dao.UserDao;
import com.message.dao.UserDaoImpl;
import com.message.pojo.Message;
import com.message.pojo.Page;
import com.message.pojo.User;

public class MessageServiceImpl implements MessageService {

	private MessageDao ms;
	private UserDao ud;
	
	public MessageServiceImpl() {
		ms=new MessageDaoImpl();
		ud=new UserDaoImpl();
	}

	/**
	 * 根据收件人ID查询分页
	 */
	@Override
	public Page getPage(int index, int pageRow,int userId) {
		Page page=new Page();
		int totalRow=ms.getTotalRow();
		List<Message> list=ms.getListByIndex(index, pageRow,userId);
		for(Message m:list) {
			User sendUser=ud.queryById(m.getSendId());
			User acceptUser=ud.queryById(m.getAcceptId());
			m.setSendUser(sendUser);
			m.setAcceptUser(acceptUser);
		}
		page.setIndex(index);
		page.setPageRow(pageRow);
		page.setTotalRow(totalRow);
		page.setListMessage(list);
		return page;
	}

	@Override
	public Message getMessage(int id) {
		Message message=ms.getMessageById(id);
		User sendUser=ud.queryById(message.getSendId());
		User acceptUser=ud.queryById(message.getAcceptId());
		message.setSendUser(sendUser);
		message.setAcceptUser(acceptUser);
		return message;
	}

	@Override
	public boolean deleteMessageById(int...id) {
		int t=0;
		for(int i=0;i<id.length;i++) {
			t+=ms.deleteMessageById(id[0]);
		}
		if(t==id.length) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean insertMessage(Message... message) {
		int t=0;
		for(int i=0;i<message.length;i++) {
			t+=ms.insertMessage(message[0]);
		}
		if(t==message.length) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void updateMessageIfAccept(int id) {
		ms.updateMessageById(0, id);
	}

	@Override
	public Page getPageOther(int index, int pageRow, int userId) {
		Page page=new Page();
		int totalRow=ms.getTotalRow();
		List<Message> list=ms.getListByIndexAndAcceptId(index, pageRow, userId);
		for(Message m:list) {
			User sendUser=ud.queryById(m.getSendId());
			User acceptUser=ud.queryById(m.getAcceptId());
			m.setSendUser(sendUser);
			m.setAcceptUser(acceptUser);
		}
		page.setIndex(index);
		page.setPageRow(pageRow);
		page.setTotalRow(totalRow);
		page.setListMessage(list);
		return page;
	}
}
