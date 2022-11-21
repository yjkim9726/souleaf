package com.souleaf.spring.companion.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.companion.store.CompanionStore;

@Service
public class CompanionServiceImpl implements CompanionService{
	
	@Autowired
	private CompanionStore companionStore;
	
	
	@Override
	public ArrayList<Companion> printAll() {
		return companionStore.selectAllList();
	}

	@Override
	public Companion printOne(int companionNo) {
		return companionStore.selectOne(companionNo);
	}

	@Override
	public int registerCompanion(Companion companion) {
		return companionStore.insertCompanion(companion);
	}

	@Override
	public int modifyCompanion(Companion companion) {
		return companionStore.updateCompanion(companion);
	}

	@Override
	public int removeCompanion(int companionNo) {
		return companionStore.deleteCompanion(companionNo);
	}

	@Override
	public ArrayList<Companion> printmemberAll(int memberNo) {
		return companionStore.selectMemberCompanion(memberNo);
	}

}
