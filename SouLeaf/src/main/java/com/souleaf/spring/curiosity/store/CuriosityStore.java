package com.souleaf.spring.curiosity.store;

import java.util.ArrayList;
import java.util.HashMap;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;

public interface CuriosityStore {
	public ArrayList<Curiosity> selectAll();
	public int selectCuriosityListCount();
	public ArrayList<Curiosity> selectAllList(PageInfo pi);// 게시글 출력
	public Curiosity selectOne(int curiosityNo);// 게시글 상세보기
	public int insertCuriosity(Curiosity curiosity);// 게시글 등록
	public int updateCuriosity(Curiosity curiosity);// 게시글 수정
	public int deleteCuriosity(int curiosityNo);// 게시글 삭제
	public void deleteCuriosityReplys(int curiosityNo); // 게시글 삭제 시 댓글 삭제
	public ArrayList<Plant> selectAllhashTagList();// 해시태그 출력
	public int addReadCount(int curiosityNo);// 조회수증가
	public ArrayList<CuriosityReply> selectAllCuriosityReply(int curiosityNo);// 댓글 전체 출력
	public int insertCuriosityReply(CuriosityReply reply); // 댓글 등록
	public int updateCuriosityReply(CuriosityReply reply); // 댓글 수정
	public int deleteCuriosityReply(int curicommentNo); // 댓글 삭제
	public void updateViewCount(int curiosityNo); // 조회수 증가
	
	// 마이페이지
	public ArrayList<Curiosity> selectAllMyCuriosity(int memberNo, MypageInfo pi); // 내가 쓴 게시글 목록
	public ArrayList<Curiosity> selectSearchAllList(MypageSearch search, MypageInfo pi);// 검색
	public int selectMyCuriosityListCount(int memberNo); // 내가 쓴 리스트 갯수 가져오기 
	public int getMySearchCount(MypageSearch search);
	public int deleteMyCuriosity(HashMap<String, String> map);
}
