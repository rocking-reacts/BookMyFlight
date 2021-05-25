package com.bookmyflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.Passenger;

/**
 * @author Sai Likhita
 * 
 */
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
