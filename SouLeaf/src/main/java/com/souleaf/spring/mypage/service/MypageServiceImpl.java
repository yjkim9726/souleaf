package com.souleaf.spring.mypage.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.store.CuriosityStore;
import com.souleaf.spring.mypage.domain.MyReply;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.mypage.store.MypageStore;

@Service
public class MypageServiceImpl implements MypageService{

	
	@Autowired
	private MypageStore mStore;
	
	@Autowired
	private CuriosityStore cStore;
	
	@Override
	public ArrayList<Boast> printAllMyBoast(int memberNo) {
		return mStore.selectAllMyBoast(memberNo);
	}

	@Override
	public ArrayList<Clinic> printAllMyClinic(int memberNo) {
		return mStore.selectAllMyClinic(memberNo);
	}

	@Override
	public ArrayList<Curiosity> printAllMyCuriosity(int memberNo) {
		return mStore.selectAllMyCuriosity(memberNo);
	}

	@Override
	public ArrayList<Curiosity> printSearchAllList(HashMap<String, Object> map) {
		return null;
	}

	@Override
	public ArrayList<MyReply> printAllMyReply(int memberNo) {
		return mStore.selectAllMyReply(memberNo);
	}


}
