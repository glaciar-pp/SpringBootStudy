package com.mulcam.study.service;

import java.util.List;

import com.mulcam.study.entity.InfoBoard;

public interface InfoBoardService {

	public List<InfoBoard> getInfoBoardList(int page, String field, String query);
	
	public InfoBoard getInfoBoard(int infoBid);
	
	public void insertInfoBoard(InfoBoard infoBoard);
	
	public void updateInfoBoard(InfoBoard infoBoard);
	
	public void deleteInfoBoard(int infoBid);
	
	public int getInfoBoardCount(String field, String query);
	
	public void increaseViewCount(int infoBid);
	
	
}
