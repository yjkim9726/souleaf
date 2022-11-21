package com.souleaf.spring.diary.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.member.domain.Member;

@Repository
public class DiaryStoreLogic implements DiaryStore{
	
	@Autowired
	private SqlSession sqlSession;

	//로그인한 사용자 회원 정보뿌려주기
	@Override
	public Member selectOneMember(int memberNo) {
		return sqlSession.selectOne("diaryMapper.selectOneMember", memberNo);
	}
	
	// 다이어리 전체 내용 불러오기
	@Override
	public ArrayList<Diary> selectAllDiary(int memberNo) {
		return (ArrayList)sqlSession.selectList("diaryMapper.selectAllDairy",memberNo);
	}
	// 해당 날짜 클릭시 등록된 일기 보기
	@Override
	public Diary selectOneDiary(int diaryNo) {
		return sqlSession.selectOne("diaryMapper.selectOneDiary", diaryNo);
	}
	// 필요없음~!
	// 내 반려식물 전체 조회
	@Override
	public ArrayList<Companion> selectAllCompanion(int memberNo) {
		return (ArrayList)sqlSession.selectList("diaryMapper.selectAllCompanion", memberNo);
	}
	// 일기 등록
	@Override
	public int insertDiary(Diary diary) {
		sqlSession.insert("diaryMapper.insertDiary", diary);
		return diary.getDiaryNo();
	}
	// 마지막 물 준 날 유무
	@Override
	public Companion selectOneWaterDay(Companion companion) {
		return sqlSession.selectOne("diaryMapper.selectOneWaterDay", companion);
	}
	// 마지막 물 준날 기준으로 물주는 날 갱신 
	@Override
	public int updateWater(Companion companion) {
		return sqlSession.update("diaryMapper.updateWaterDay", companion);
	}
	// 물 줘야 하는 날 등록
	@Override
	public int insertWaterDiary(Diary diary) {
      return sqlSession.insert("diaryMapper.insertWaterDiary",diary);
	}
	// 일기 수정
	@Override
	public int updateDiary(Diary diary) {
		return sqlSession.update("diaryMapper.updateDiary", diary);
	}
	// 일기 삭제
	@Override
	public int deleteDiary(Diary diary) {
		return sqlSession.delete("diaryMapper.deleteDiary", diary);
	}
	// 방명록 전체 조회
	@Override
	public ArrayList<Guestbook> selectAllGuestbook(int memberDiary) {
		return (ArrayList)sqlSession.selectList("diaryMapper.selectGuestbookList", memberDiary);
	}
	// 방명록 등록
	@Override
	public int insertGuestbook(Guestbook guestbook) {
		return sqlSession.insert("diaryMapper.insertGuestbook",guestbook);
	}
	// 방명록 수정
	@Override
	public int updateGuestbook(Guestbook guestbook) {
		return sqlSession.update("diaryMapper.updateGuestbook", guestbook);
	}
	// 방명록 삭제
	@Override
	public int deleteGuestbook(Guestbook guestbook) {
		return sqlSession.delete("diaryMapper.deleteGuestbook", guestbook);
	}
	// 사진첩 리스트
	@Override
	public ArrayList<Diary> selectPlantPicAll(int diaryNo) {
		return (ArrayList)sqlSession.selectList("diaryMapper.selectPlantPicAll", diaryNo);
	}
	// 다이어리에 기존의 물 줘야하는 날 삭제
	@Override
	public int deleteReDiary(Diary diary) {
		return sqlSession.delete("diaryMapper.deleteReDiary", diary);
	}

	// 멤버별 다이어리 리스트 조회 
	@Override
	public Diary selectByMemberDiary(Diary diary) {
		return sqlSession.selectOne("diaryMapper.selectByMemberDiary", diary);
	}

	// 사진 동영상 변환
	@Override
	public ArrayList<Diary> selectAllPicOneComanion(Diary diary) {
		return (ArrayList)sqlSession.selectList("diaryMapper.selectAllPicOneComanion",diary);
	}

}
