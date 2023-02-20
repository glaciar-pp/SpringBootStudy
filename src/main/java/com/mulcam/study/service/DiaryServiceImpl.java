package com.mulcam.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.study.dao.AnniversaryDao;
import com.mulcam.study.dao.DiaryBoardDao;
import com.mulcam.study.entity.Anniversary;
import com.mulcam.study.entity.DiaryBoard;
import com.mulcam.study.entity.DiaryDay;
import com.mulcam.study.entity.SchDay;

@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired private DiaryBoardDao diaryDao;
	@Autowired private AnniversaryDao annivDao;

	@Override
	public boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
		if (year % 100 == 0)
			return false;
		if (year % 4 == 0)
			return true;
		return false;
	}

	@Override
	public DiaryDay generateDiaryDay(String uid, String dDate, int date, int isOtherMonth) {
		List<Anniversary> annivList = annivDao.getAnnivList(dDate, dDate);
		List<DiaryBoard> diaryList = diaryDao.getDiaryBoardListByDate(uid, dDate);
		int day = Integer.parseInt(dDate.substring(6));
		int isHoliday = 0;
		List<String> aList = new ArrayList<>();
		for (Anniversary a: annivList) {
			aList.add(a.getAname());
			if (isHoliday == 0)
				isHoliday = a.getIsHoliday();
		}
		DiaryDay diaryDay = new DiaryDay(day, date, isHoliday, isOtherMonth, dDate, aList, diaryList);
		return diaryDay;
	}
	

}