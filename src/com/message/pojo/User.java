package com.message.pojo;

import java.util.Date;

public class User {

	private String username;
	private String password;
	private String friendList;
	private Date createTime;
	private String mailAccount;
	private int id;
	public User() {
		super();
	}
	public User(String username, String password, String friendList, Date createTime, String mailAccount, int id) {
		super();
		this.username = username;
		this.password = password;
		this.friendList = friendList;
		this.createTime = createTime;
		this.mailAccount = mailAccount;
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFriendList() {
		return friendList;
	}
	public void setFriendList(String friendList) {
		this.friendList = friendList;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getMailAccount() {
		return mailAccount;
	}
	public void setMailAccount(String mailAccount) {
		this.mailAccount = mailAccount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
