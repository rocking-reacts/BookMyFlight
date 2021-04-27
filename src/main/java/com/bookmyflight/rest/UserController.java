package com.bookmyflight.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyflight.bean.Login;
import com.bookmyflight.entity.User;
import com.bookmyflight.exception.UserException;
import com.bookmyflight.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	

//	{
//	    "userId": 0,
//	    "uname": "Polo",
//	    "fname": "Polo lo",
//	    "email": "polo@gmail.com",
//	    "phone": "9820212672",
//	    "isadmin": 0,
//	    "password": "Polo"
//	}
//	http://localhost:8980/createuser
	@PostMapping(value = "/createuser",consumes = "application/json")
	public String createUser(@RequestBody User user) throws UserException {
		user.setUname(user.getUname());
		int uid = userservice.createUser(user);
		return "User added successfully with username" + uid; 
	}
	
//	http://localhost:8980/get/1
	@GetMapping(value="/get/{uid}",produces="application/json")
	public User getUser(@PathVariable int uid) throws UserException {
		User u=userservice.fetchUserById(uid);
		return u; 
	}
	
	@PostMapping(value="/auth" ,consumes = "application/json",produces="application/json")
	public ResponseEntity<?> authenticate(@RequestBody Login login,HttpSession session) {
		
		User user=userservice.validate(login);
		if(user!=null) {
			session.setAttribute("USER", user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Invalid username or password",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	//destroy the session
		return "logged out successfully";
	}
	
}
