package com.bookmyflight.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.Ticket;
import com.bookmyflight.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String username,String password);
	
}
