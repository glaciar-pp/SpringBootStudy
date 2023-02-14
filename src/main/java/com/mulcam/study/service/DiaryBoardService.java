package com.mulcam.study.service;

import java.util.List;

import com.mulcam.study.entity.DiaryBoard;

public interface DiaryBoardService {

	List<DiaryBoard> getDiaryBoardList();
	DiaryBoard getDiaryBoard(int did);
	void insertDiaryBoard(DiaryBoard diaryBoard);
	
	//=============2/3a 2줄 추가
	void updateDiaryBoard(DiaryBoard diaryBoard);
		
	void deleteDiaryBoard(int did);
	

		
}
