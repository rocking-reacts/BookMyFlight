package com.bookmyflight.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int bookingId;
	@Column(name="seats")
	private int numberOfSeatsToBook;
	private int payStatus;
	
	@OneToOne
	@JoinColumn(name = "flightNumber")
	private Flight flight;
	
	@OneToMany
	@JoinColumn(name = "pass_id")
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getNumberOfSeatsToBook() {
		return numberOfSeatsToBook;
	}
	public void setNumberOfSeatsToBook(int numberOfSeatsToBook) {
		this.numberOfSeatsToBook = numberOfSeatsToBook;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
