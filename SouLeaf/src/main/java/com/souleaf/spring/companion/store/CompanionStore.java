package com.souleaf.spring.companion.store;

import java.util.ArrayList;

import com.souleaf.spring.companion.domain.Companion;

public interface CompanionStore {

	public ArrayList<Companion> selectAllList();
	public Companion selectOne(int companionNo);
	public int insertCompanion(Companion companion);
	public int updateCompanion(Companion companion);
	public int deleteCompanion(int companionNo);
	public ArrayList<Companion> selectMemberCompanion(int memberNo);
}
