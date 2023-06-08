package com.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String Name;
	private String Email;
	private String PhoneNumber;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int iD, String name, String email, String phoneNumber) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + "]";
	}
	
	
	
}
