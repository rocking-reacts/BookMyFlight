package com.bookmyflight.rest;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

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
//	    "username": "Polo",
//	    "fname": "Polo lo",
//	    "email": "polo@gmail.com",
//	    "phone": "9820212672",
//	    "isadmin": 0,
//	    "password": "Polo"
//	}
//	http://localhost:8980/createuser
	@PostMapping(value = "/createuser",consumes = "application/json")
	public String createUser(@RequestBody User user) {
	
		Encoder encoder=Base64.getEncoder();
		String encrypt=encoder.encodeToString(user.getPassword().getBytes());
		user.setPassword(encrypt);
		int uid;
		try {
			uid = userservice.createUser(user);
			return "User added successfully with user id" + uid; 
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ""+e.getMessage();
		}
		
	}
	
//	http://localhost:8980/get/1
	@GetMapping(value="/get/{uid}",produces="application/json")
	public ResponseEntity<?> getUser(@PathVariable int uid)  {
		
		User u=null;
		 try {
			u=userservice.fetchUserById(uid);
			Decoder decoder=Base64.getDecoder();
			String password=new String(decoder.decode(u.getPassword()));
			System.out.println("Password is"+password);
			return new ResponseEntity<User>(u,HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}

	}
	
//	http://localhost:8980/auth
//	{
//		"username":"Polo",
//		"password":"Polo"
//	}
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