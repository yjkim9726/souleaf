package com.souleaf.spring.diary.service;

import java.util.ArrayList;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.member.domain.Member;

public interface DiaryService {
	
	//로그인한 사용자 회원 정보뿌려주기
	public Member printOneMember(int memberNo);
	
	// 다이어리 전체 내용 불러오기
	public ArrayList<Diary> printAllDiary(int memberNo);
	// 해당 날짜 클릭시 등록된 일기 보기
	public Diary printOneDiary(int diaryNo);
	
	// 물 줘야 하는 날 등록
	public int registerWaterDiary(Diary diary);
	
	// 내 반려식물 전체 조회 
	public ArrayList<Companion> printAllCompanion(int memberNo);
	// 일기 등록
	public int registerDiary(Diary diary);
	// 마지막 물 준 날 가져오기
	public Companion printOneWaterDay(Companion companion);
	// 마지막 물 준날 기준으로 물주는 날 갱신 
	public int modifyWater(Companion companion);
	// 일기 수정
	public int modifyDiary(Diary diary);
	// 일기 삭제
	public int removeDiary(Diary diary);
	
	// 방명록 전체 조회
	public ArrayList<Guestbook> printAllGuestbook(int diaryNo);
	// 방명록 등록
	public int registerGuestbook(Guestbook guestbook);
	// 방명록 수정
	public int modifyGuestbook(Guestbook guestbook);
	// 방명록 삭제
	public int removeGuestbook(Guestbook guestbook);
	
	
	// 사진첩 리스트
	public ArrayList<Diary> printPlantPicAll(int membeNo);

	// 다이어리에 기존의 물 줘야하는 날 삭제
	public int removeReDiary(Diary diary);

	// 멤버별 다이어리 리스트 조회 
	public Diary printByMemberDiary(Diary diary);

	
	// 사진첩 동영상변환 
	public ArrayList<Diary> printPicOneCompanion(Diary diary);

	
	
}
