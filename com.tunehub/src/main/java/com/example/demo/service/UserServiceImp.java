package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public String addUser(User user) {
		repo.save(user);
		return "User Added Succesfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean validate(String email, String password) {
		User user= repo.findByEmail(email);
		if(password.equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		User user= repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {

		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

	

	
}
