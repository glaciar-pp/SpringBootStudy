package com.mulcam.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.study.entity.DiaryBoard;

@Mapper
public interface DiaryBoardDao {
	// sql내의 table명 수정시 여기도 확인 (diary_Board에서 diaboard로 바뀜)
	// 2/9 sql내의 table명 한번 더 바뀜 (diaboard -> diaryboard로 바뀜)
	 @Select("SELECT d.did, d.uid, d.title, d.content, d.modTime, "
	 		+ "d.files, u.uname from diaryboard AS d " 
	 		+ "JOIN users AS u ON d.uid=u.uid "
	 		+ "WHERE d.isDeleted=0 ORDER BY did DESC")
	 List<DiaryBoard> getDiaryBoardList();
	 
	 @Select("select * from diaryboard where did=#{did}")
	 DiaryBoard getDiaryBoard(int did);
	 
	 @Insert("insert into diaryboard values(default,#{uid},#{title},#{content},default,default,#{files})")
	 void insertDiaryBoard(DiaryBoard diaryborad);  //<-2/3a-1  d-> diaryBoard 로 수정
	 //===2/1까지 write부분까지 dao 작성==== 
	 
	 //===아래부터는 2/3a 추가
	 @Update("UPDATE diaryboard SET ${field}=${field}+1 WHERE did=#{did}")
	 void increaseCount(int did, String field);

	 @Update("UPDATE diaryboard SET title=#{title}, content=#{content}, "
			+ " modTime=NOW(), files=#{files} WHERE did=#{did}")
	 void updateDiaryBoard(DiaryBoard diaBoard);

	 @Update("UPDATE diaryboard SET isDeleted=1 WHERE did=#{did}")
	 void deleteDiaryBoard(int did);	 
	 
	 @Select("SELECT COUNT(did) FROM diaryboard AS d "  //확인필요 
				+ "	JOIN users AS u"
				+ "	ON d.uid=u.uid"
				+ "	WHERE d.isDeleted=0 AND ${field} LIKE #{query}")
	 public int getDiaryBoardCount(String field, String query);
}
