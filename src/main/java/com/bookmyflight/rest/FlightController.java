package com.bookmyflight.rest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyflight.entity.Flight;
import com.bookmyflight.exception.FlightException;
import com.bookmyflight.service.FlightService;

@EnableTransactionManagement
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService fservice;
	
	@PostMapping(value = "/add",consumes = "application/json")
	public String addFlight(@RequestBody Flight flight) {
		try {
			int id=fservice.addFlight(flight);
			return "Flight added with flight number "+id;
		} catch (FlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ""+e.getMessage();
		}
		
	}
	
	@GetMapping(value="/fetchall",produces="application/json")
	public Collection<Flight> serachFlights(){
		return fservice.fetchAll();	
	}
	
	@GetMapping(value="/fetch",produces="application/json")  
	public Flight serachFlight(@RequestParam String source,@RequestParam String destination,@RequestParam String date) {
		try {
			LocalDate dt=LocalDate.parse(date);
			Flight flight=fservice.fetchFlight(source, destination, dt);
			return flight;
		} catch (FlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping(value="/remove",produces="application/json")
	public String removeFlight(@RequestBody Flight flight) {
		fservice.removeFlight(flight);
		return "flight removed with id"+flight.getFlightNumber();
		
	}
	
	@PutMapping(value="/update",produces="application/json")
	public String updateDestination(@RequestBody Flight flight) {
		try {
			int id=fservice.updateFlight(flight);
			return "Flight updated with id "+id;
		} catch (FlightException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ""+e.getMessage();
		}
	}
}
