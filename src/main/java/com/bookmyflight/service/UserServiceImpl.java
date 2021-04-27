package com.bookmyflight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyflight.bean.Login;
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
	public int createUser(User user) throws UserException {
		userrepo.save(user);
		return user.getUserId();
	}

	@Override
	public User fetchUserById(int user_id) throws UserException {
		return userrepo.findById(user_id).get();
	}

	@Override
	public User validate(Login login) {
		// TODO Auto-generated method stub
		User user=userrepo.findUser(login.getUsername(), login.getPassword());
		return user;
	}

}
