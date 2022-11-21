package com.souleaf.spring.boast.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.boast.domain.BoFile;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;



public interface BoastService {
	//public ArrayList<Boast> printAll(PageInfo pi);// 게시글 전체출력.
	public ArrayList<Boast> printAll(PageInfo pi);
	public ArrayList<Boast> printSearchAll(BoastSearch search); // 게시글 검색
	public Boast printOne(int boastNo);// 게시글 상세조회 .
	public int modifyBoast(Boast boast);// 게시글 수정.
	public int removeBoast(int boastNo);// 게시글 삭제 .
	public int removeAdminBoast(HashMap<String, String> map);// 게시글 삭제 .(관리자) 
	public ArrayList<Boast> printAllhashTagList(); // 해시태그 출력
	public int addReadCount(int boastNo); // 게시글 상세 조회시 조회수 증가.
	public ArrayList<BoastReply> printAllBoastReply(int boastNo); // 댓글 전체 출력.
	public int registerBoastReply(BoastReply reply); // 댓글 등록.
	public int registerBoastReReply(BoastReply reply); // 답글 등록.
	public int modifyBoastReply(BoastReply reply); // 댓글 수정.
	public int removeBoastReply(BoastReply reply); // 댓글 삭제.
	public int removeBoastReReply(BoastReply reply); // 대댓글 삭제.
	
	public int getLikeCount(int boastNo); // 좋아요 수
	public int getLikeAddCheck(Boast boast); // 좋아요 존재 체크
	public int getLikeCheck(Boast boast); // 좋아요 체크
	public int registerBoastLike(Boast boast);
	public int modifyBoastLike(Boast boast);
	public int modifyLike(Boast boast); // 좋아요
	public int getListCount(); // 게시물 갯수 조회
	
	
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	public ArrayList<Boast> printAllNo(); // 게시글NO만 취득
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public int pointReset(int boastNo); // 좋아요 포인트 리셋
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public ArrayList<Boast> printRank();
//	ArrayList<Boast> printAll();
	//int removeBoastReply(BoastReply reply);
	ArrayList<Boast> printAll();
	public int removeFile(BoFile boFile);
	int registerBoast(Boast boast);

	// 마이페이지

	public int getMyBoastListCount(int memberNo);

	public ArrayList<Boast> printAllMyBoast(int memberNo, MypageInfo pi);

	public int getMySearchCount(MypageSearch search);

	public ArrayList<Boast> printSearchAllList(MypageSearch search, MypageInfo pi);

	public int removeMyBoast(HashMap<String, String> map);
	public void removeBoastReplys(int boastNo);
	
	public ArrayList<Boast> printAllRank();
	public int getReplyCount(int boastNo);
	
	
	
	

}
