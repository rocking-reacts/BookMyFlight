package com.bookmyflight.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyflight.entity.Booking;
import com.bookmyflight.entity.Flight;
import com.bookmyflight.entity.Passenger;
import com.bookmyflight.entity.Ticket;
import com.bookmyflight.entity.User;
import com.bookmyflight.exception.FlightException;
import com.bookmyflight.service.BookingService;
import com.bookmyflight.service.FlightService;


/**
 * @author Shivani Jadon
 * Controller for Booking and ticket generation
 */
@RestController
@RequestMapping("/book")
public class BookingController {

	@Autowired
	private BookingService bookservice;
	
	@Autowired
	private FlightService flightservice;
	
	@PostMapping(value = "/booking", consumes = "application/json")
	public String addBooking(@RequestBody Booking booking, @RequestParam String source, String destination, String date) throws FlightException {
		LocalDate dt=LocalDate.parse(date);
		Flight flight=flightservice.fetchFlight(source, destination, dt);
		booking.setFlight(flight);
		int bid = bookservice.addBooking(booking);
		return "Booking done with id " + bid;
	}
	
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
	@PostMapping(value = "/ticket/{userId}/{bookid}", consumes = "application/json")
	public String createBookingTicket(@RequestBody Ticket ticket, @PathVariable int userId, @PathVariable int bookid ) {
		
//		int bid = bookservice.addBooking(booking);
		LocalDate date = LocalDate.now();
		ticket.setBooking_date(date);
		int tid = bookservice.generateTicket(ticket, userId, bookid);
		return "Ticket generated for bookingid : " + bookid + "Ticket generated with id : " + tid + "Ticket generated for userid :" +userId ;
	}
	
//	@GetMapping
//	public String getTicket(@PathVariable int tid) {
//		return null;
//		
//	}
}
