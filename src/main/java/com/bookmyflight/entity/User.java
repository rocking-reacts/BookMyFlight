package com.bookmyflight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Sahithi Kondeti
 * User entity stores user information
 * Like User name,User Fullname, User phone number and User email.
 */
@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="user_name",length=10)
	private String uname;
	
	@Column(name="user_fullname",length=20)
	private String fname;
	
	@Column(name="email",length=15)
	private String email;
	
	@Column(name="phone", length=10)
	private int phone;
	
	@Column(name="isadmin")
	private int isadmin;
	
	
	@OneToOne
	//@JoinColumn(name = "bookingId")
	private Booking booking;
	
	public User() {
		
	}
	public User(int uid, String uname, String fname, String email, int phone, int isadmin) {
		super();
		
		this.uname = uname;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.isadmin = isadmin;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	
	
	
	
	
	

}
 
