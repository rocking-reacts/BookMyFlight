package com.bookmyflight.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Sahithi Kondeti
 * User entity stores user information
 * Like User name,User Fullname, User phone number and User email.
 */
@Entity
@Table(name="users")
public class User {
	
	@Id
	private String username;
	
	@Column(name="user_fullname")
	private String fname;
	
	private String email;
	
	private int phone;
	
	private int isadmin;
	
	private String password;
	
	
	
//	@OneToMany
//	@JoinColumn(name = "bookingid")
//	private List<Booking> booking = new ArrayList<Booking>();
//	
	public User() {
		
	}
	public User(int uid, String username, String fname, String email, int phone, int isadmin) {
		super();
		
		this.username = username;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.isadmin = isadmin;
	}
	
	public String getUname() {
		return username;
	}
	public void setUname(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public List<Booking> getBooking() {
//		return booking;
//	}
//	public void setBooking(List<Booking> booking) {
//		this.booking = booking;
//	}

}
 
