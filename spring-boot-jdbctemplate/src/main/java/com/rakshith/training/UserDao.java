package com.rakshith.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	
	@Autowired
	JdbcTemplate template;
	 
	int getCountOfUsers() {
		return template.queryForObject("select count(*) from user",Integer.class);
	}

    String getUserName(int id) {
    	return template.queryForObject("select username from user where id=?", 
    			                      new Object[] {id},
    			                       String.class);
    }
    
    int  addUser(User user) {
    	String sql="insert into user values(?,?)";
    	return template.update(sql,new Object[] {user.getUserName(),user.getId()});
    	
    }
    User updateUser(User user,int id) {
    	
    	 String sql="update user set username=? ,id=? where id=?";
    	Integer verify= (template.update(sql,new Object[] {user.getUserName(),user.getId(),id}));
    	if(verify instanceof Integer) {
    	   return template.queryForObject("select * from user where id=?",new Object[] {user.getId()},
    			                          new org.springframework.jdbc.core.RowMapper<User>() {

											@Override
											public User mapRow(ResultSet rs, int rowNum) throws SQLException {
												// TODO Auto-generated method stub
											User newUser=new User();
											newUser.setUserName(rs.getString(1));
											newUser.setId(rs.getInt(2));
											return newUser;
											}
    		                                
    	   });
    	 }
    	else {
    		 return null;
    	}
    }	
    	
    

    int deleteUser(int id) {
    	String sql="delete from user where id=?";
    	return template.update(sql,new Object[] {id});
    }
    
    java.util.List<User> getAllUsers() {
    	return  template.query("Select * from user", 
    			new RowMapper<User>(){  
    	    @Override  
    	    public User mapRow(ResultSet rs, int rownumber) throws SQLException {  
    	    	User newUser=new User();
				newUser.setUserName(rs.getString(1));
				newUser.setId(rs.getInt(2));
				return newUser;
    	    }
    	       
			});
    }

}
