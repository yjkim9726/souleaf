package com.souleaf.spring.qna.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.member.store.MemberStore;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.store.QnaStore;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaStore qStore;

	@Override
	public ArrayList<Qna> printQnaAll(PageInfo pi) {
		return qStore.selectAllList(pi);
	}

	@Override
	public ArrayList<Qna> printSearchAll(QnaSearch search) {
		ArrayList<Qna> searchList = qStore.selectSearchList(search);
		return searchList;
	}

	@Override
	public Qna printQnaOne(int qnaNo) {
		return qStore.selectOne(qnaNo);
	}

	@Override
	public int registerQna(Qna qna) {
		return qStore.insertQna(qna);
	}

	@Override
	public int modifyQna(Qna qna) {
		return qStore.updateQna(qna);
	}

	@Override
	public int removeQna(int qnaNo) {
		return qStore.deleteQna(qnaNo);
	}

	@Override
	public int getListCount() {
		return qStore.selectListCount();
	}

	@Override
	public int addReadCount(int qnaNo) {
		return qStore.addReadCount(qnaNo);
	}

	@Override
	public ArrayList<Qna> printQnaAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Qna> printAdminAll() {
		return qStore.selectAdminAll();
	}

	@Override
	public int removeAdminQna(HashMap<String, String> map) {
		return qStore.deleteAdminQna(map);
	}
	
	
	// 마이페이지
	@Override
	public ArrayList<Qna> printAllMyQna(int memberNo, MypageInfo pi) {
		return qStore.selectAllMyQna(memberNo,pi);
	}

	@Override
	public int getMyQnaListCount(int memberNo) {
		return qStore.selectMyQnaCount(memberNo);
	}


}
