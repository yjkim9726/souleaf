package com.souleaf.spring.clinic.store;

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

public interface ClinicStore {
	public ArrayList<Clinic> selectAll();
	public int selectClinicListCount();
	public int selectClinicSearchListCount(String search);
	public ArrayList<Clinic> selectAllList(PageInfo pi);// 게시글 출력
	public ArrayList<Clinic> selectAllSearchList(PageInfo pi, String search); // 검색 게시글 출력
	public Clinic selectOne(int clinicNo);// 게시글 상세보기
	public int insertClinic(Clinic clinic);// 게시글 등록
	public int updateClinic(Clinic clinic);// 게시글 수정
	public int deleteClinic(int clinicNo);// 게시글 삭제
	public int updateRankLike(Clinic clinic); // 클리닉 좋아요 랭크 포인트 +1
	public int updateRankunLike(Clinic clinic); // 클리닉 좋아요 랭크 포인트 -1

	public ArrayList<Clinic> selectSearchAllList(ClinicSearch search);// 검색
	public ArrayList<Plant> selectAllhashTagList();// 해시태그 출력
	public int addReadCount(int clinicNo);// 조회수증가
	
	public ArrayList<ClinicReply> selectAllClinicReply(int clinicNo);// 댓글 전체 출력
	public int insertClinicReply(ClinicReply reply); // 댓글 등록
	public int updateClinicReply(ClinicReply reply); // 댓글 수정
	public int deleteClinicReply(int clinicNo); // 댓글 삭제
	public void updateViewCount(int clinicNo); // 조회수 증가
	public ClinicLike selectLike(ClinicLike clinicLike); // 좋아요 확인
	public int insertLike(ClinicLike clinicLike); // 좋아요 초기 등록
	public int updateLike(ClinicLike clinicLike); // 좋아요 수정
	public int deleteAdminClinic(HashMap<String, String> map) ;
	
	public ArrayList<ClinicReply> selectSelectionClinicReply(int clinicNo); // 채택댓글
	public int updateReplySelection(int cliniccommentNo); // 채택하기
	
	// 마이페이지
	public int selectMyClinicListCount(int memberNo);
	public ArrayList<Clinic> selectAllMyClinic(int memberNo, MypageInfo pi);
	public int getMySearchCount(MypageSearch search);
	public ArrayList<Clinic> selectSearchAllList(MypageSearch search, MypageInfo pi);
	public int deleteMyClinic(HashMap<String, String> map);
	public ArrayList<Plant> selectSearchAllList(String search); //클리닉 검색
	public void deleteClinicReplys(int clinicNo);
	
}
