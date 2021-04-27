package com.bookmyflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findUser(String username,String password);
}
