package com.souleaf.spring.diary.store;

import java.util.ArrayList;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.member.domain.Member;

public interface DiaryStore {

		//로그인한 사용자 회원 정보뿌려주기
		public Member selectOneMember(int memberNo);
		// 다이어리 전체 내용 불러오기
		public ArrayList<Diary> selectAllDiary(int memberNo);
		// 물 줘야 하는 날 등록
	    public int insertWaterDiary(Diary diary);
		// 해당 날짜 클릭시 등록된 일기 보기
		public Diary selectOneDiary(int diaryNo);
		// 내 반려식물 전체 조회 
		public ArrayList<Companion> selectAllCompanion(int memberNo);
		// 일기 등록
		public int insertDiary(Diary diary);
		// 마지막 물 준 날 유무
		public Companion selectOneWaterDay(Companion companion);
		// 마지막 물 준날 기준으로 물주는 날 갱신 
		public int updateWater(Companion companion);
		// 일기 수정
		public int updateDiary(Diary diary);
		// 일기 삭제
		public int deleteDiary(Diary diary);
		
		// 방명록 전체 조회
		public ArrayList<Guestbook> selectAllGuestbook(int diaryNo);
		// 방명록 등록
		public int insertGuestbook(Guestbook guestbook);
		// 방명록 수정
		public int updateGuestbook(Guestbook guestbook);
		// 방명록 삭제
		public int deleteGuestbook(Guestbook guestbook);
		
		
		// 사진첩 리스트
		public ArrayList<Diary> selectPlantPicAll(int membeNo);

		// 다이어리에 기존의 물 줘야하는 날 삭제
		public int deleteReDiary(Diary diary);

		// 멤버별 다이어리 리스트 조회 
		public Diary selectByMemberDiary(Diary diary);
		
		
		// 사진첩 동영상변환 @빽범
		public ArrayList<Diary> selectAllPicOneComanion(Diary diary);
		
}
