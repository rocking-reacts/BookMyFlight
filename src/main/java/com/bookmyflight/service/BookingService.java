package com.bookmyflight.service;

import com.bookmyflight.entity.Booking;
import com.bookmyflight.entity.Passenger;
import com.bookmyflight.entity.Ticket;

public interface BookingService {
	
	int addBooking(Booking booking);
	
	void addPassenger(Passenger passenger, int bookingId);
	
	int generateTicket(Ticket ticket, String username, int bookingId);
}
