package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.AnsSearch;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

public interface AnsStore {
	
	public ArrayList<Ans> selectAllList(); // 전체 리스트 출력
	public Ans selectOne(int aId);
	public int insertAns(Ans ans);
	public int updateAns(Ans ans);
	public int deleteAns(int aId);
	public ArrayList<Ans> selectSearchList(AnsSearch search);
	public int selectListCount();
	public int addReadCount(int ansNo);
}
