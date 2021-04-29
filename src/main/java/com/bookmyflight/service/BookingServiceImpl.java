package com.bookmyflight.service;

import java.util.ArrayList;
import java.util.List;

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


/**
 * @author Shivani Jadon
 * Service to add passenger, booking and ticket details in database
 */
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
	
	/**
	 * this method saves the booking entity in the database
	 */
	
	@Override
	public int addBooking(Booking booking) {
		brepo.save(booking);
		return booking.getBookingId();
	}

	/**
	 * this method saves the passenger entity in the database
	 * passengers are referenced by booking entity
	 */
	@Override
	public int addPassenger(Passenger passenger, int bookingId) {
		Booking booking = brepo.findById(bookingId).get();
		booking.getPassengers().add(passenger);
		passenger.setBooking(booking);
		prepo.save(passenger);
		return passenger.getPid();
	}

	/**
	 * this method saves the ticket entity in the database
	 * ticket entity references user and booking entity
	 */
	@Override
	public Ticket generateTicket(Ticket ticket, int userId, int bookingId) {
		Booking booking = brepo.findById(bookingId).get();
		User user = urepo.findById(userId).get();
		ticket.setBooking(booking);
		ticket.setUser(user);
	
		trepo.save(ticket);
		return ticket;
	}

	
	@Override
	public List<Ticket> getTicket(int uid) {
		User user=urepo.findById(uid).get();
		List<Ticket> tlist=trepo.findByUser(user);
		tlist.forEach(System.out::println);
		return tlist;
	}

	@Override
	public Booking getBookingById(int bid) {
		
		return brepo.findById(bid).get();
	}

//	@Override
//	public List<Ticket> getTicket(int ticketNumber) {
//		List<Ticket> ticketArray = new ArrayList<Ticket>();
//		List<Ticket> ticketList = trepo.findAll();
//		Ticket ticket = trepo.findById(ticketNumber).get();
//		int uid = ticket.getUser().getUserId();
//		for (Ticket ticketL : ticketList) {
//			if (ticketL.getUser().getUserId() == uid){
//				ticketArray.add(ticketL);
//			}
//		}
//		return ticketArray;
//	}


}