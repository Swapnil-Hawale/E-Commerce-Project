package com.sg.beans;

public class UserBean {
	
	int userId;
	String userEmail;
	String userPassword;
	String userName;
	String userGender;
	String userCity;
	
	public UserBean()
	{
		
	}
	public UserBean(String userEmail, String userPassword, String userName, String userGender, String userCity) {
		super();
	//	this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword=userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userCity = userCity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userEmail = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	
	

}
