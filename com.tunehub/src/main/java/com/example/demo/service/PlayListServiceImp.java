package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlayList;
import com.example.demo.repository.PlayListRepository;
@Service
public class PlayListServiceImp implements PlayListService{
	@Autowired
	PlayListRepository repo;

	@Override
	public void addPlayList(PlayList playlist) {
		repo.save(playlist);
	}

	@Override
	public List<PlayList> fetchAllPlaylist() {
		return repo.findAll();
	}

}
