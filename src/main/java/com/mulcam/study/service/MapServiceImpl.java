package com.mulcam.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.study.dao.MapDao;
import com.mulcam.study.entity.Map;

@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private MapDao mapDao;
	
	@Override
	public List<Map> getMapList() {
		List<Map> list = mapDao.getMapList();
		return list;
	}

	@Override
	public List<Map> getSearchList(String searchWord) {
		List<Map> list = mapDao.getSearchList(searchWord);
		return list;
	}
	
}
