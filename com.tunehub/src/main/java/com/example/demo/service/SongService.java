package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Song;

public interface SongService {
	public void addSong(Song song);

	public List<Song> fetcAllSongs();

	public boolean songExists(String name);
	
	public void updateSong(Song song);

}
