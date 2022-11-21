package com.souleaf.spring.clinic.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.clinic.store.ClinicStore;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;

@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	private ClinicStore cStore;
	
	@Override
	public int getClinicListCount() {
		return cStore.selectClinicListCount();
	}
	
	@Override
	public ArrayList<Clinic> printAllList(PageInfo pi) {
		return cStore.selectAllList(pi);
	}

	@Override
	public Clinic printOne(int clinicNo) {
		return cStore.selectOne(clinicNo);
	}

	@Override
	public int registerClinic(Clinic clinic) {
		return cStore.insertClinic(clinic);
	}

	@Override
	public int modifyClinic(Clinic clinic) {
		return cStore.updateClinic(clinic);
	}

	@Override
	public int removeClinic(int clinicNo) {
		// TODO Auto-generated method stub
		return cStore.deleteClinic(clinicNo);
	}
	
	// 클리닉 좋아요 랭크 포인트 +1 
	@Override
	public int modifyRankLike(Clinic clinic) {
		return cStore.updateRankLike(clinic);
	}
	
	// 클리닉 좋아요 랭크 포인트 -1 
	@Override
	public int modifyRankunLike(Clinic clinic) {
		return cStore.updateRankunLike(clinic);
	}

	@Override
	public ArrayList<Clinic> printSearchAllList(ClinicSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plant> printAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicReply> printAllClinicReply(int clinicNo) {
		return cStore.selectAllClinicReply(clinicNo);
	}

	@Override
	public int registerClinicReply(ClinicReply reply) {
		return cStore.insertClinicReply(reply);
	}

	@Override
	public int modifyClinicReply(ClinicReply reply) {
		return cStore.updateClinicReply(reply);
	}

	@Override
	public int removeClinicReply(int clinicNo) {
		return cStore.deleteClinicReply(clinicNo);
	}

	@Override
	public void addViewCount(int clinicNo) {
		cStore.updateViewCount(clinicNo);
		
	}

	@Override
	public ArrayList<Clinic> printAll() {
		return cStore.selectAll();
	}

	@Override
	public int removeAdminClinic(HashMap<String, String> map) {
		return cStore.deleteAdminClinic(map);
	}
	
	// 마이페이지
	
	@Override
	public int getMyClinicListCount(int memberNo) {
		return cStore.selectMyClinicListCount(memberNo);
	}

	@Override
	public ArrayList<Clinic> printAllMyClinic(int memberNo, MypageInfo pi) {
		return cStore.selectAllMyClinic(memberNo,pi);
	}

	@Override
	public int getMySearchCount(MypageSearch search) {
		// TODO Auto-generated method stub
		return cStore.getMySearchCount(search);
	}

	@Override
	public ArrayList<Clinic> printSearchAllList(MypageSearch search, MypageInfo pi) {
		return cStore.selectSearchAllList(search,pi);
	}

	@Override
	public int removeMyClinic(HashMap<String, String> map) {
		return cStore.deleteMyClinic(map);
	}
	
	// 좋아요 확인
	@Override
	public ClinicLike printLike(ClinicLike clinicLike) {
		return cStore.selectLike(clinicLike);
	}
	
	// 좋아요 초기 등록
	@Override
	public int registerLike(ClinicLike clinicLike) {
		return cStore.insertLike(clinicLike);
		
	}
	
	// 좋아요 수정
	@Override
	public int modifyLike(ClinicLike clinicLike) {
		return cStore.updateLike(clinicLike);
	}

	@Override
	public ArrayList<Plant> printSearchAllList(String search) {
		return cStore.selectSearchAllList(search);
	}

	@Override
	public int getClinicSearchListCount(String search) {
		return cStore.selectClinicSearchListCount(search);
	}

	@Override
	public ArrayList<Clinic> printAllSearchList(PageInfo pi, String search) {
		return cStore.selectAllSearchList(pi, search);
	}

	@Override
	public ArrayList<ClinicReply> printSelectionClinicReply(int clinicNo) {
		return cStore.selectSelectionClinicReply(clinicNo);
	}

	@Override
	public int modifyReplySelection(int cliniccommentNo) {
		return cStore.updateReplySelection(cliniccommentNo);
	}

	@Override
	public void removeClinicReplys(int clinicNo) {
		cStore.deleteClinicReplys(clinicNo);
	}
	
}
