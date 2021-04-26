package com.bookmyflight.service;

import com.bookmyflight.entity.User;
import com.bookmyflight.exception.UserException;

public interface UserService {
	
	 String createUser(User user) throws UserException;
	
	 User fetchUserByUsername(String username) throws UserException;
	
	
}
