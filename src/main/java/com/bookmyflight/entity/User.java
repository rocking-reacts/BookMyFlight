package com.bookmyflight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int uid;
	@Column(name="user_name")
	private String uname;
	@Column(name="user_fullname")
	private String fname;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private int phone;
	@Column(name="isadmin")
	private int isadmin;
	
	public User() {
		
	}
	public User(int uid, String uname, String fname, String email, int phone, int isadmin) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.isadmin = isadmin;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
 
