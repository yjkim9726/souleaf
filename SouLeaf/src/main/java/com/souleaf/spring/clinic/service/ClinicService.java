package com.souleaf.spring.clinic.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;

public interface ClinicService {
	public ArrayList<Clinic> printAll();
	public int getClinicListCount(); // 게시글 갯수 
	public int getClinicSearchListCount(String search); // 검색 게시글 갯수 
	public ArrayList<Clinic> printAllList(PageInfo pi);// 게시글 출력
	public ArrayList<Clinic> printAllSearchList(PageInfo pi, String search); // 검색 게시글 출력
	public Clinic printOne(int clinicNo);// 게시글 상세보기
	public int registerClinic(Clinic clinic);// 게시글 등록
	public int modifyClinic(Clinic clinic);// 게시글 수정
	public int removeClinic(int clinicNo);// 게시글 삭제
	public int modifyRankLike(Clinic clinic); // 클리닉 좋아요 랭크 포인트 +1 
	public int modifyRankunLike(Clinic clinic); // 클리닉 좋아요 랭크 포인트 -11 
	
	public ArrayList<Clinic> printSearchAllList(ClinicSearch search);// 검색
	public ArrayList<Plant> printAllhashTagList();// 해시태그 출력
	public int addReadCount(int ClinicNo);// 조회수증가
	
	public ArrayList<ClinicReply> printAllClinicReply(int clinicNo);// 댓글 전체 출력
	public int registerClinicReply(ClinicReply reply); // 댓글 등록
	public int modifyClinicReply(ClinicReply reply); // 댓글 수정
	public int removeClinicReply(int clinicNo); // 댓글 삭제
	public void addViewCount(int clinicNo); // 조회수 증가
	public ClinicLike printLike(ClinicLike clinicLike); // 좋아요 확인
	public int registerLike(ClinicLike clinicLike); // 좋아요 초기 등록
	public int modifyLike(ClinicLike clinicLike);// 좋아요 수정
	public int removeAdminClinic(HashMap<String, String> map) ;
	
	public ArrayList<ClinicReply> printSelectionClinicReply(int clinicNo); // 채택댓글
	public int modifyReplySelection(int cliniccommentNo); // 채택하기
	
	// 마이페이지
	public int getMyClinicListCount(int memberNo); // 게시글 개수 가져오기
	public ArrayList<Clinic> printAllMyClinic(int memberNo, MypageInfo pi); // 게시글 리스트 출력 
	public int getMySearchCount(MypageSearch search); // 검색한 게시글 개수 가져오기
	public ArrayList<Clinic> printSearchAllList(MypageSearch search, MypageInfo pi); // 검색한 게시글 리스트 출력
	public int removeMyClinic(HashMap<String, String> map);
	
	public ArrayList<Plant> printSearchAllList(String search); //클리닉 검색
	public void removeClinicReplys(int clinicNo);
	
	

}
