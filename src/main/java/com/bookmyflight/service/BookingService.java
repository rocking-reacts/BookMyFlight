package com.bookmyflight.service;

import com.bookmyflight.entity.Booking;
import com.bookmyflight.entity.Passenger;
import com.bookmyflight.entity.Ticket;

public interface BookingService {
	
	int addBooking(Booking booking);
	
	int addPassenger(Passenger passenger, int bookingId);
	
	int generateTicket(Ticket ticket, int userId, int bookingId);
}
