package com.mulcam.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.study.dao.SongDao;
import com.mulcam.study.entity.Song;

@Service
public class SongServiceImpl implements SongService{
	
	@Autowired private SongDao songDao;

	@Override
	public List<Song> getSongList() {
		List<Song> list = songDao.getSongList();
		return list;
	}

}
