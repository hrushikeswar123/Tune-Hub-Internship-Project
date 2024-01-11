package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UserServiceImp service;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute User user
	/*
	 * @RequestParam("username") String username,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("email") String email,
	 * 
	 * @RequestParam("gender") String gender,
	 * 
	 * @RequestParam("role") String role,@RequestParam("address") String address
	 */
	) {
		boolean userStatus = service.emailExists(user.getEmail());
		if (userStatus == false) {
			service.addUser(user);
		} else {
			System.out.println("User already Exist");
		}
		return "index.html";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
		
		//Session started for User
		session.setAttribute("email",email);
		
		
		if(email.equals("")){
			return "login.html";
		}
		else if(service.validate(email,password)==true) {
			
			if(service.getRole(email).equals("Admin")) {
				return "admin.html";
			}
			else {
				return "customerhome.html";
			}
		}else {
			return "login.html";
		}
	}
	
	@GetMapping("/pay")
	public String pay(@RequestParam String email) {
		
		boolean paymentStatus=false; ///Api payment
		
		if(paymentStatus ==true) {
			User user=service.getUser(email);
			user.setPremium(true);
			
			service.updateUser(user);
		}
		
		return "login.html";
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "login.html";
		
	}
}
