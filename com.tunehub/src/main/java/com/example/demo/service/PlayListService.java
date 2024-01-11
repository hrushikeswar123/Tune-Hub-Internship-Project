package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PlayList;

public interface PlayListService {

	void addPlayList(PlayList playlist);

	List<PlayList> fetchAllPlaylist();

}
