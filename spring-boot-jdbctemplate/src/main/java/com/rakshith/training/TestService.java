package com.rakshith.training;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TestService {
	@Autowired 
	UserDao userDao;
	
	int getCountOfUsers()  {
		return userDao.getCountOfUsers();
	}
	String getUserName(int id) {
		return userDao.getUserName(id);
	}
    
	String addUser(User user) {
		if(userDao.addUser(user)==1) {
			return "user added sucessfullly";
		}
		else {
			return "we are not able to add user details";
		}
	
		
	}
	 User updateUser(User user,int id) {
		
	return userDao.updateUser(user,id);
	
		
	 }
     
	 String deleteUser(int id) {
		 if(userDao.deleteUser(id)==1) {
			 return "deleted sucessfully";
			 
		 }
		 else {
			 return "not deleted sucessfully";
		 }
	 }
	 
	java.util.List<User> getAllUsers(){
		return userDao.getAllUsers();
		 
	 }
	
	
}
