package com.mulcam.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.study.entity.Song;

@Mapper
public class SongDao {
	
	@Select("select * from song")
	public List<Song> getSongList();
	
}
