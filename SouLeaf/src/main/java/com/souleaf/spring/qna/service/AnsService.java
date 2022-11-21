package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.AnsSearch;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

public interface AnsService {

	public ArrayList<Ans> printAnsAll();
	public Ans printAnsOne(int aId);
	public int registerAns(Ans ans);
	public int modifyAns(Ans ans);
	public int removeAns(int aId);
	public int getListCount();
	public int addReadCount(int ansNo);
	public ArrayList<Ans> printSearchAll(AnsSearch search);
	
}
