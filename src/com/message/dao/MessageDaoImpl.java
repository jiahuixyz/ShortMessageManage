package com.message.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.message.pojo.Message;


public class MessageDaoImpl extends BaseDao implements MessageDao {

	@Override
	public Message getMessageById(int id) {
		Message message=null;
		String sql="SELECT * FROM MESSAGE_0807 WHERE ID=?";
		try {
			rs=query(sql, id);
			if(rs.next()) {
				message=new Message();
				message.setId(rs.getInt("ID"));
				message.setSendId(rs.getInt("SEND_ID"));
				message.setSendTime(rs.getDate("SEND_TIME"));
				message.setAcceptId(rs.getInt("ACCEPT_ID"));
				message.setAcceptTime(rs.getDate("ACCEPT_TIME"));
				message.setTheme(rs.getString("THEME"));
				message.setContent(rs.getString("CONTENT"));
				message.setIfAccept(rs.getInt("IF_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return message;
	}

	@Override
	public int getTotalRow() {
		int result=0;
		String sql="SELECT COUNT(*) N FROM MESSAGE_0807";
		try {
			rs=query(sql);
			if(rs.next()) {
				result=rs.getInt("N");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}

	@Override
	public List<Message> getListByIndex(int index, int pageRow,int userId) {
		List<Message> list=new ArrayList<>();
		Message message=null;
		String sql="SELECT * FROM MESSAGE_0807 WHERE ACCEPT_ID=? LIMIT ?,?";
		try {
			rs=query(sql,userId,(index-1)*pageRow,pageRow);
			while(rs.next()) {
				message=new Message();
				message.setId(rs.getInt("ID"));
				message.setSendId(rs.getInt("SEND_ID"));
				message.setSendTime(rs.getDate("SEND_TIME"));
				message.setAcceptId(rs.getInt("ACCEPT_ID"));
				message.setAcceptTime(rs.getDate("ACCEPT_TIME"));
				message.setTheme(rs.getString("THEME"));
				message.setContent(rs.getString("CONTENT"));
				message.setIfAccept(rs.getInt("IF_CONTENT"));
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return list;
	}

	@Override
	public int deleteMessageById(int id) {
		int result=0;
		String sql="DELETE FROM MESSAGE_0807 WHERE ID=?";
		try {
			result=alter(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}

	@Override
	public int insertMessage(Message m) {
		int result=0;
		String sql="INSERT INTO MESSAGE_0807\r\n" + 
				"(SEND_ID,ACCEPT_ID,SEND_TIME,ACCEPT_TIME,THEME,CONTENT,IF_CONTENT) VALUE\r\n" + 
				"(?,?,?,?,?,?,?);";
		Object[] obj= {m.getSendId(),m.getAcceptId(),m.getSendTime(),m.getAcceptTime(),
				m.getTheme(),m.getContent(),m.getIfAccept()};
		try {
			result=alter(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}

	@Override
	public int updateMessageById(int ifAccept,int id) {
		int result=0;
		String sql="UPDATE MESSAGE_0807 SET IF_CONTENT=? WHERE ID=?";
		try {
			result=alter(sql,ifAccept,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}

	@Override
	public List<Message> getListByIndexAndAcceptId(int index, int pageRow, int userId) {
		List<Message> list=new ArrayList<>();
		Message message=null;
		String sql="SELECT * FROM MESSAGE_0807 WHERE SEND_ID=? LIMIT ?,?";
		try {
			rs=query(sql,userId,(index-1)*pageRow,pageRow);
			while(rs.next()) {
				message=new Message();
				message.setId(rs.getInt("ID"));
				message.setSendId(rs.getInt("SEND_ID"));
				message.setSendTime(rs.getDate("SEND_TIME"));
				message.setAcceptId(rs.getInt("ACCEPT_ID"));
				message.setAcceptTime(rs.getDate("ACCEPT_TIME"));
				message.setTheme(rs.getString("THEME"));
				message.setContent(rs.getString("CONTENT"));
				message.setIfAccept(rs.getInt("IF_CONTENT"));
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return list;
	}
}
