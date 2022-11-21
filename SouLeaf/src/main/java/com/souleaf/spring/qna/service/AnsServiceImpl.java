package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.AnsSearch;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.store.AnsStore;

@Service
public class AnsServiceImpl implements AnsService{
	@Autowired
	private AnsStore aStore;

	

	@Override
	public Ans printAnsOne(int ansNo) {
		return aStore.selectOne(ansNo);
	}

	@Override
	public int registerAns(Ans ans) {
		return aStore.insertAns(ans);
	}

	@Override
	public int modifyAns(Ans ans) {
		return aStore.updateAns(ans);
	}

	@Override
	public int removeAns(int aId) {
		return aStore.deleteAns(aId);
	}
	

	@Override
	public int getListCount() {
		return aStore.selectListCount();
	}

	@Override
	public int addReadCount(int ansNo) {
		return aStore.addReadCount(ansNo);
	}

	@Override
	public ArrayList<Ans> printSearchAll(AnsSearch search) {
		ArrayList<Ans> searchList = aStore.selectSearchList(search);
		return searchList;
	}

//	@Override
//	public ArrayList<Ans> printAnsAll(PageInfo pi) {
//		return aStore.selectAllList(pi);
//	}

	@Override
	public ArrayList<Ans> printAnsAll() {
		// TODO Auto-generated method stub
		return aStore.selectAllList();
	}

}

