package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController {
	@GetMapping("/login")
	public String login() {
		return "login.html";
		
	}
	@GetMapping("/registration")
	public String register() {
		return "registration.html";
		
	}
	@GetMapping("/loginpage")
	public String css() {
		return "loginpage.css";
	}
	 @GetMapping("/newsong")
	 public String newsong() {
		return "newsong.html";
		 
	 }
}
