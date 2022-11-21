package com.souleaf.spring.qna.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

public interface QnaService {
	public ArrayList<Qna> printQnaAll(PageInfo pi);
	public ArrayList<Qna> printSearchAll(QnaSearch search); 
	public Qna printQnaOne(int qId);
	public int registerQna(Qna qna);
	public int modifyQna(Qna qna);
	public int removeQna(int qId);
	public int getListCount();
	ArrayList<Qna> printQnaAll();
	public int addReadCount(int qnaNo);
	public ArrayList<Qna> printAdminAll();
	public int removeAdminQna(HashMap<String, String> map);
	public ArrayList<Qna> printAllMyQna(int memberNo, MypageInfo pi);
	public int getMyQnaListCount(int memberNo);
}
