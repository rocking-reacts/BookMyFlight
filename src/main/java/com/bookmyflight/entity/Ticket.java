package com.bookmyflight.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Ankita Yadav
 * Ticket Entity stores ticket information 
 * like ticket_id, ticket_number, username [User], booking_id [Booking], booking_date, total_pay
 */

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ticket_number")
	private int ticketNumber;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	private LocalDate booking_date;
	private double total_pay;
	
	public Ticket() {
	}

	public Ticket(int ticket_number, LocalDate booking_date, double total_pay) {
		super();
	
		this.ticketNumber = ticket_number;
		this.booking_date = booking_date;
		this.total_pay = total_pay;
	}


	public int getTicket_number() {
		return ticketNumber;
	}

	public void setTicket_number(int ticket_number) {
		this.ticketNumber = ticket_number;
	}

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public double getTotal_pay() {
		return total_pay;
	}

	public void setTotal_pay(double total_pay) {
		this.total_pay = total_pay;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
}