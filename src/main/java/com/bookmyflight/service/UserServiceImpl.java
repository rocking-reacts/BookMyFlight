package com.bookmyflight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyflight.entity.User;
import com.bookmyflight.exception.UserException;
import com.bookmyflight.repo.UserRepository;

/**
 * @author Sahithi Kondeti
 * UserServiceImpl will perform operations:
 * Like creating User and fetching the user by user name.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public String createUser(User user) throws UserException {
		userrepo.save(user);
		return user.getUname();
	}

	@Override
	public User fetchUserByUsername(String username) throws UserException {
		return userrepo.findById(username).get();
	}

}
