package com.bookmyflight.service;

import java.util.Collection;
import java.util.List;

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
		List<User> users=(List)fetchAllUsers();
		User user_temp=null;
		for(User u:users)
		{
			if(u.getUname().equals(user.getUname()) && (u.getEmail().equals(user.getEmail())) )
				user_temp=u;
		}
		
		if(user_temp!=null) {
		userrepo.save(user);
		return user.getUserId();
		}else
			throw new UserException("User already exist with userId " + user_temp.getUserId());
	}

	

	@Override
	public User fetchUserById(int user_id) throws UserException {
		List<User> users=(List)fetchAllUsers();
		User user_temp=null;
		for(User u:users)
		{
			if(u.getUserId()==user_id)
				user_temp=u;
		}
		if(user_temp!=null)
			return userrepo.findById(user_id).get();
		
		else throw new UserException("User not found with the UserId " + user_id);
				
	}

	@Override
	public User validate(Login login) {
		User user=userrepo.findUser(login.getUsername(), login.getPassword());
		return user;
	}
    
	@Override
	public Collection<User> fetchAllUsers() {
		List<User> users=userrepo.findAll();
		return users;
	}
}
