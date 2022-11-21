package com.souleaf.spring.admin.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.admin.domain.MemberStatus;
import com.souleaf.spring.admin.domain.TotalCount;
import com.souleaf.spring.admin.store.AdminStore;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminStore aStore;

	@Override
	public MemberStatus printMemberStatus() {
		return aStore.selectMemberStatus();
	}

	@Override
	public int modifyMemberStatus(HashMap<String, String> map) {
		return aStore.updateMemberStatus(map);
	}

	@Override
	public int printPlantCount() {
		return aStore.selectPlantCount();
	}

	@Override
	public int printMemberCount() {
		return aStore.selectMemberCount();
	}

	@Override
	public int printBoardCount() {
		return aStore.selectBoardCount();
	}

	@Override
	public int printQNACount() {
		return aStore.selectQNACount();
	}

	
}
