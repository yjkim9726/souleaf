package com.souleaf.spring.diary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.store.DiaryStore;
import com.souleaf.spring.member.domain.Member;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryStore dStore;
	
	//로그인한 사용자 회원 정보뿌려주기
	@Override
	public Member printOneMember(int memberNo) {
		return dStore.selectOneMember(memberNo);
	}
	
	// 다이어리 전체 내용 불러오기
	@Override
	public ArrayList<Diary> printAllDiary(int memberNo) {
		return dStore.selectAllDiary(memberNo);
	}
	
	// 해당 날짜 클릭시 등록된 일기 보기
	@Override
	public Diary printOneDiary(int diaryNo) {
		return dStore.selectOneDiary(diaryNo);
	}
	
	// 필요없음~!
	// 내 반려식물 전체 조회
	@Override
	public ArrayList<Companion> printAllCompanion(int memberNo) {
		return dStore.selectAllCompanion(memberNo);
	}
	// 일기 등록
	@Override
	public int registerDiary(Diary diary) {
		return dStore.insertDiary(diary);
	}
	// 마지막 물 준 날 가져오기
	@Override
	public Companion printOneWaterDay(Companion companion) {
		// TODO Auto-generated method stub
		return null;
	}
	// 마지막 물 준날 기준으로 물주는 날 갱신 
	@Override
	public int modifyWater(Companion companion) {
		// TODO Auto-generated method stub
		return 0;
	}
	// 일기 수정 
	@Override
	public int modifyDiary(Diary diary) {
		return dStore.updateDiary(diary);
	}
	// 일기 삭제
	@Override
	public int removeDiary(Diary diary) {
		return dStore.deleteDiary(diary);
	}
	
	// 방명록 전체 조회
	@Override
	public ArrayList<Guestbook> printAllGuestbook(int memberDiary) {
		return dStore.selectAllGuestbook(memberDiary);
	}
	// 방명록 등록
	@Override
	public int registerGuestbook(Guestbook guestbook) {
		return dStore.insertGuestbook(guestbook);
	}
	// 방명록 수정
	@Override
	public int modifyGuestbook(Guestbook guestbook) {
		return dStore.updateGuestbook(guestbook);
	}
	// 방명록 삭제
	@Override
	public int removeGuestbook(Guestbook guestbook) {
		return dStore.deleteGuestbook(guestbook);
	}
	
	// 사진첩 리스트
	@Override
	public ArrayList<Diary> printPlantPicAll(int membeNo) {
		return dStore.selectPlantPicAll(membeNo);
	}

	// 다이어리에 기존의 물 줘야하는 날 삭제
	@Override
	public int removeReDiary(Diary diary) {
		return dStore.deleteReDiary(diary);
	}

	// 멤버별 다이어리 리스트 조회 
	@Override
	public Diary printByMemberDiary(Diary diary) {
		return dStore.selectByMemberDiary(diary);
	}
	
	
    // 사진 동영상 변환
	@Override
	public ArrayList<Diary> printPicOneCompanion(Diary diary) {
		return dStore.selectAllPicOneComanion(diary);
	}

	// 물 줘야 하는 날 등록
	@Override
	public int registerWaterDiary(Diary diary) {
      return dStore.insertWaterDiary(diary);
	}


}
