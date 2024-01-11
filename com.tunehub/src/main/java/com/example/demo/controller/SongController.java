package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Song;
import com.example.demo.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService service;
		
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		boolean songExists=service.songExists(song.getName());
		if(songExists==false) {
			service.addSong(song);	
			System.out.println("Added successfully");
			return "admin.html";
		}else {
			System.out.println("Already Exist");
			return "null";
		}
		
		
	}
	
	@GetMapping("/viewsong")
	public String viewSong(Model model) {
		List <Song> songList=service.fetcAllSongs();
		model.addAttribute("song", songList);
		
		return "displaysong";
		
	}
	
	
	@GetMapping("/playsong")
	public String playsong(Model model) {
		boolean premiumUser = true;
		
		if(premiumUser) {
			List<Song> songList =service.fetcAllSongs();
			model.addAttribute("song", songList);
			
			return "displaysong.html";
			
		}else {
			return "paymentpage.html";
		}
		
	}
	
	

}
