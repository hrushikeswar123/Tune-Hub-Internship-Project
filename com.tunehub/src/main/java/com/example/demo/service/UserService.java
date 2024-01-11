package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	
	String addUser(User user);
	boolean emailExists(String email);
	public boolean validate(String email, String password);
	public String getRole(String email);
	public User getUser(String email);
	public void updateUser(User user);

}
