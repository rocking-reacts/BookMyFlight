package com.bookmyflight.service;

import com.bookmyflight.entity.User;
import com.bookmyflight.exception.UserException;

public interface UserService {
	
	 int createUser(User user) throws UserException;
	
	 User fetchUserById(int user_id) throws UserException;
	
	
}
