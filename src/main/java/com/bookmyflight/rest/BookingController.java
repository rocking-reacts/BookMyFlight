package com.bookmyflight.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyflight.entity.Booking;
import com.bookmyflight.entity.Passenger;
import com.bookmyflight.entity.Ticket;
import com.bookmyflight.entity.User;
import com.bookmyflight.service.BookingService;


/**
 * @author Shivani Jadon
 * Controller for Booking and ticket generation
 */
@RestController
public class BookingController {

	@Autowired
	private BookingService bookservice;
	
	
	/**
	 * @param passenger
	 * @param bid
	 * @return passenger id
	 * controller method to add passsengers in database
	 */
	@PostMapping(value = "/passenger/{bid}",  consumes = "application/json")
	public String addPassengers(@RequestBody Passenger passenger, @PathVariable int bid) {
		int pid = bookservice.addPassenger(passenger, bid);
		return "Passenger added with id : " + pid;
	}
	
	/**
	 * @param booking
	 * @param userId
	 * @param ticket
	 * @param user
	 * @return ticket number
	 * controller method to add booking and ticket details in database and generate ticket
	 */
	@PostMapping(value = "/ticket/{userId}", consumes = "application/json")
	public String createBookingTicket(@RequestBody Booking booking,
			@PathVariable int userId, @RequestBody Ticket ticket, @RequestBody User user) {
		
		int bid = bookservice.addBooking(booking);
		
		int tid = bookservice.generateTicket(ticket, userId, bid);
		return "Booking generated with id : " + bid + "Ticket generated with id : " + tid;
	}
}
