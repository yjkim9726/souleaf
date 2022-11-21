package com.souleaf.spring.boast.store;

import java.util.ArrayList;
import java.util.HashMap;

import com.souleaf.spring.boast.domain.BoFile;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.PlantInfo;


public interface BoastStore {

	  
	public ArrayList<Boast> selectAll();
	public ArrayList<Boast> selectAllList(PageInfo pi);// .
	public int selectListCount(); // 전체 수 조회수.
	public ArrayList<Boast> selectSearchList(BoastSearch search); //검색조회
	public int addReadCount(int boastNo); //.
	
	public Boast selectOne(int boastNo); // 상세 조회.
	public int insertBoast(Boast boast); //.
	public int updateBoast(Boast boast); //.
	public int deleteBoast(int boastNo); //.
	public int deleteAdminBoast(HashMap<String, String> map); //. 게시글삭제 (관리자)
	
	public ArrayList<BoastReply> selectAllBoastReply(int boastNo); //.
	public int insertBoastReply(BoastReply reply); //.
	public int insertBoastReReply(BoastReply reply); //.
	public int updateBoastReply(BoastReply reply); //.
	public int deleteBoastReply(BoastReply reply); //.
	public int deleteBoastReReply(BoastReply reply); //.
	public int selectLikeCount(int boastNo); // 좋아요 수
	public int selectLikeAddCheck(Boast boast); //
	public int insertBoastLike(Boast boast);
	public int updateBoastLike(Boast boast);
	public int selectLikeCheck(Boast boast); //
	public int updateLike(Boast boast); // 좋아요
	//ArrayList<BoastReply> selectAllBoastreply(int boastNo);
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	public ArrayList<Boast> selectAllNo();
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public int updatePoint(int boastNo);
	
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public ArrayList<Boast> selectRank();
	
	// 마이페이지

	public int selectMyBoastListCount(int memberNo);

	public ArrayList<Boast> selectAllMyBoast(int memberNo, MypageInfo pi);

	public int getMySearchCount(MypageSearch search);

	public ArrayList<Boast> selectSearchAllList(MypageSearch search, MypageInfo pi);

	public int deleteMyBoast(HashMap<String, String> map);
	public void deleteBoastReplys(int boastNo);
	
	public ArrayList<Boast> selectAllRank();
	public int getBoastReReply(int boastNo);
	
	
}
