package com.feast.PotLuckFoods.model;

//import java.util.Date;
import java.sql.Date;

public class User {
	private int userId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private String userName;
	private String password;
	private String role;
	private Date createDate;
	private Date lastLogin;
	
	
	public User() {
		
	}
	
	public User(int userId,String name, String email, String phoneNumber, String address, String userName,String password, String role,Date createDate, Date lastLogin) {
		
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.createDate = createDate;
		this.lastLogin = lastLogin;
		
	}
	
public User(String name, String email, String phoneNumber, String address, String userName,String password, String role) {
		
//		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.role = role;
//		this.createDate = createDate;
//		this.lastLogin = lastLogin;
		
	}

public User(String name, String email, String phoneNumber, String userName,String password) {
	
//	this.userId = userId;
	this.name = name;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.userName = userName;
	this.password = password;

	
}
	


	public int getUserId() {
		return userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
