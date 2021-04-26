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
	@Column(name="ticket_id")
	private int tid;
	
	private int ticket_number;
	
	@OneToOne
	@JoinColumn(name = "user_name")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;
	
	private LocalDate booking_date;
	private double total_pay;
	
	public Ticket() {
	}

	public Ticket(int tid, int ticket_number, LocalDate booking_date, double total_pay) {
		super();
		this.tid = tid;
		this.ticket_number = ticket_number;
		this.booking_date = booking_date;
		this.total_pay = total_pay;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getTicket_number() {
		return ticket_number;
	}

	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
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

	
}
