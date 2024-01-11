package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String username;
	String password;
	String gender;
	String email;
	String address;
	String role;
	
	boolean isPremium;

	public User() {
		super();
	}
	
	

	public User(int id, String username, String password, String gender, String email, String address, String role,
			boolean isPremium) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.role = role;
		this.isPremium = isPremium;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", email=" + email + ", address=" + address + ", role=" + role + ", isPremium=" + isPremium + "]";
	}
	

}
