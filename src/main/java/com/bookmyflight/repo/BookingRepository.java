package com.bookmyflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.Booking;

/**
 * 
 * @author Shivam
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
