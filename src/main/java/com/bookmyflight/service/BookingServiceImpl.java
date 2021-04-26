package com.bookmyflight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyflight.entity.Booking;
import com.bookmyflight.entity.Passenger;
import com.bookmyflight.entity.Ticket;
import com.bookmyflight.entity.User;
import com.bookmyflight.repo.BookingRepository;
import com.bookmyflight.repo.PassengerRepository;
import com.bookmyflight.repo.TicketRepository;
import com.bookmyflight.repo.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private BookingRepository brepo;
	
	@Autowired
	private PassengerRepository prepo;
	
	@Autowired
	private TicketRepository trepo;
	
	@Override
	public int addBooking(Booking booking) {
		brepo.save(booking);
		return booking.getBookingId();
	}

	@Override
	public void addPassenger(Passenger passenger, int bookingId) {
		Booking booking = brepo.findById(bookingId).get();
		booking.getPassengers().add(passenger);
		prepo.save(passenger);
//		return passenger.getPid();
	}

	@Override
	public int generateTicket(Ticket ticket, String username, int bookingId) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int generateTicket(Ticket ticket, String username, int bookingId) {
//		Booking booking = brepo.findById(bookingId).get();
//		User user = urepo.findById(username).get();
//		ticket.setBooking(booking);
//		ticket.setUser(user);
//	
//		trepo.save(ticket);
//		return ticket.getTicketNumber();
//	}

}
