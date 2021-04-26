package com.bookmyflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
