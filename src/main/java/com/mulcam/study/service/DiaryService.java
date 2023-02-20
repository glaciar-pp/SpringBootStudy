package com.mulcam.study.service;

import com.mulcam.study.entity.DiaryDay;

public interface DiaryService {

	boolean isLeapYear(int year);
	
	DiaryDay generateDiaryDay(String uid, String dDate, int date, int isOtherMonth);
}
