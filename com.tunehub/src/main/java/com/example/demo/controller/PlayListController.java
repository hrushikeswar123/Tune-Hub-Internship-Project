package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.PlayList;
import com.example.demo.entity.Song;
import com.example.demo.service.PlayListService;
import com.example.demo.service.SongService;

@Controller
public class PlayListController {
	@Autowired
	SongService songService;
	
	@Autowired
	PlayListService playlistService;
	
	
	@GetMapping("/createPlayList")
	public String createPlay(Model model) {
		List <Song> songList=songService.fetcAllSongs();
		model.addAttribute("Song",songList);
		return "createPlayList";
	}
	
	@GetMapping("/addPlayList")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		playlistService.addPlayList(playlist);
		
		List<Song> songList=playlist.getSongs();
		for(Song s: songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
		}
		
		
		return"admin.html";
		
	}
	
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
		List<PlayList> allplaylist= playlistService.fetchAllPlaylist();
		model.addAttribute("allplaylist", allplaylist);
		return "displayplaylist";
		
	}

}
