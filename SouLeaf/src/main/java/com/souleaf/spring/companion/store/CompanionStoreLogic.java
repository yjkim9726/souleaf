package com.souleaf.spring.companion.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.companion.domain.Companion;

@Repository
public class CompanionStoreLogic implements CompanionStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Companion> selectAllList() {
		return (ArrayList)sqlSession.selectList("companionMapper.selectAllList");
	}

	@Override
	public Companion selectOne(int companionNo) {
		return sqlSession.selectOne("companionMapper.selectOne", companionNo);
	}

	@Override
	public int insertCompanion(Companion companion) {
		return sqlSession.insert("companionMapper.insertcompanion", companion);
	}

	@Override
	public int updateCompanion(Companion companion) {
		return sqlSession.update("companionMapper.updatecompanion", companion);
	}

	@Override
	public int deleteCompanion(int companionNo) {
		return sqlSession.update("companionMapper.deletecompanion", companionNo);
	}

	@Override
	public ArrayList<Companion> selectMemberCompanion(int memberNo) {
		return (ArrayList)sqlSession.selectList("companionMapper.selectMemberCompanion", memberNo);
	}

}
