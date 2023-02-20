package com.mulcam.study.service;

import java.util.List;

import com.mulcam.study.entity.Anniversary;

public interface AnniversaryService {
	
	List<Anniversary> getDayAnnivList(String sdate);

	List<Anniversary> getAnnivDays(String start, String end);
	
}