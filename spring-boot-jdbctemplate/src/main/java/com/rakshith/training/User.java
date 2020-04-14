package com.rakshith.training;

public class User {
 private String userName;
 private int id;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "User [userName=" + userName + ", id=" + id + "]";
}
 
 
}
