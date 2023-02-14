package com.mulcam.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mulcam.study.entity.Map;

@Service
public interface MapService {

	List<Map> getMapList();
	
}
