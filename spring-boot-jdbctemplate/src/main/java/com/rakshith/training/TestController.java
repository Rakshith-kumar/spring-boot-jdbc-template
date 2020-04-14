package com.rakshith.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class TestController {
	
	
	@Autowired 
	TestService service;
	@RequestMapping("/count")
	Integer countOfUsers() {
		return service.getCountOfUsers();
		
	}
	
	@RequestMapping("/users/{id}")
	String getUserName(@PathVariable Integer id) {
		return service.getUserName(id);
		
	}
	@org.springframework.web.bind.annotation.PostMapping("/users")
	  String addUser(@org.springframework.web.bind.annotation.RequestBody User user) {
		  return service.addUser(user);
	  }
	
	@PutMapping("/users/update/{id}")
	User updateUser(@RequestBody User user,@PathVariable int  id) {
		User newUser=service.updateUser(user, id);
		
		return newUser;
	}
	
	@DeleteMapping("delete/{id}")
	String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
	@GetMapping("/getAllUsers")
	public java.util.List<User> getAllUsers(){
		return service.getAllUsers();
		
	}
	  
	

}
