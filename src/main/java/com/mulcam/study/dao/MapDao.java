package com.mulcam.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.study.entity.Map;

@Mapper
public interface MapDao {
	
	@Select("select * from map")
	public List<Map> getMapList();

	@Select("SELECT * FROM map WHERE addr like CONCAT('%', #{searchWord} ,'%') ORDER BY addr desc;")
	public List<Map> getSearchList(String searchWord);
}
