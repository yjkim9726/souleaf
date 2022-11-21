package com.souleaf.spring.curiosity.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.curiosity.store.CuriosityStore;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;
@Service
public class CuriosityServiceImpl implements CuriosityService {
	@Autowired
	private CuriosityStore cStore;

	@Override
	public int getCuriosityListCount() {
		return cStore.selectCuriosityListCount();
	}
	
	@Override
	public ArrayList<Curiosity> printAllList(PageInfo pi) {
		return cStore.selectAllList(pi);
	}

	@Override
	public Curiosity printOne(int curiosityNo) {
		return cStore.selectOne(curiosityNo);
	}

	@Override
	public int registerCuriosity(Curiosity curiosity) {
		return cStore.insertCuriosity(curiosity);
	}

	@Override
	public int modifyCuriosity(Curiosity curiosity) {
		return cStore.updateCuriosity(curiosity);
	}

	@Override
	public int removeCuriosity(int curiosityNo) {
		return cStore.deleteCuriosity(curiosityNo);
	}


	@Override
	public ArrayList<Plant> printAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CuriosityReply> printAllCuriosityReply(int curiosityNo) {
		return cStore.selectAllCuriosityReply(curiosityNo);
	}

	@Override
	public int registerCuriosityReply(CuriosityReply reply) {
		return cStore.insertCuriosityReply(reply);
	}

	@Override
	public int modifyCuriosityReply(CuriosityReply reply) {
		return cStore.updateCuriosityReply(reply);
	}

	@Override
	public int removeCuriosityReply(int curicommentNo) {
		return cStore.deleteCuriosityReply(curicommentNo);
	}

	@Override
	public void addViewCount(int curiosityNo) {
		cStore.updateViewCount(curiosityNo);
		
	}

	// 마이페이지
	
	@Override
	public ArrayList<Curiosity> printAllMyCuriosity(int memberNo, MypageInfo pi) {
		return cStore.selectAllMyCuriosity(memberNo,pi);
	}

	@Override
	public ArrayList<Curiosity> printSearchAllList(MypageSearch search,MypageInfo pi) {
		return cStore.selectSearchAllList(search,pi);
	}

	@Override
	public int getMyCuriosityListCount(int memberNo) {
		return cStore.selectMyCuriosityListCount(memberNo);
	}

	@Override
	public ArrayList<Curiosity> printAll() {
		return cStore.selectAll();
	}

	@Override
	public int getMySearchCount(MypageSearch search) {
		// TODO Auto-generated method stub
		return cStore.getMySearchCount(search);
	}

	@Override
	public int removeMyCuriosity(HashMap<String, String> map) {
		return cStore.deleteMyCuriosity(map);
	}

	@Override
	public void removeCuriosityReplys(int curiosityNo) {
		cStore.deleteCuriosityReplys(curiosityNo);
		
	}
	

}
