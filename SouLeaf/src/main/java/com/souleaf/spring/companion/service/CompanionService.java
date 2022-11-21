package com.souleaf.spring.companion.service;

import java.util.ArrayList;

import com.souleaf.spring.companion.domain.Companion;

public interface CompanionService {

	public ArrayList<Companion> printAll(); // 반려식물 전체 조회
	public Companion printOne(int companionNo); // 반려식물 상세 조회
	public int registerCompanion(Companion companion); // 반려식물 등록
	public int modifyCompanion(Companion companion); // 반려식물 수정
	public int removeCompanion(int companionNo); // 반려식물 삭제
	public ArrayList<Companion> printmemberAll(int memberNo); // 회원 반려식물 조회
}
