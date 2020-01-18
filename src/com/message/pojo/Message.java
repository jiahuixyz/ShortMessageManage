package com.message.pojo;

import java.util.Date;

public class Message {

	private int sendId;
	private int acceptId;
	private Date sendTime;
	private Date acceptTime;
	private int id;
	private String theme;
	private String content;
	private int ifAccept;	
	private User sendUser;
	private User acceptUser;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int sendId, int acceptId, Date sendTime, Date acceptTime, int id, String theme, String content,
			int ifAccept, User sendUser, User acceptUser) {
		super();
		this.sendId = sendId;
		this.acceptId = acceptId;
		this.sendTime = sendTime;
		this.acceptTime = acceptTime;
		this.id = id;
		this.theme = theme;
		this.content = content;
		this.ifAccept = ifAccept;
		this.sendUser = sendUser;
		this.acceptUser = acceptUser;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public int getAcceptId() {
		return acceptId;
	}
	public void setAcceptId(int acceptId) {
		this.acceptId = acceptId;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIfAccept() {
		return ifAccept;
	}
	public void setIfAccept(int ifAccept) {
		this.ifAccept = ifAccept;
	}
	public User getSendUser() {
		return sendUser;
	}
	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}
	public User getAcceptUser() {
		return acceptUser;
	}
	public void setAcceptUser(User acceptUser) {
		this.acceptUser = acceptUser;
	}

	
}
