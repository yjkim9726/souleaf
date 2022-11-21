package com.souleaf.spring.admin.store;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.admin.domain.MemberStatus;
import com.souleaf.spring.admin.domain.TotalCount;
@Repository
public class AdminStoreLogic implements AdminStore {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberStatus selectMemberStatus() {
		return sqlSession.selectOne("adminMapper.selectMemberStatus");
	}

	@Override
	public int updateMemberStatus(HashMap<String, String> map) {
		return sqlSession.update("adminMapper.updateMemberStatus", map);
	}

	@Override
	public int selectPlantCount() {
		return sqlSession.selectOne("adminMapper.selectPlantCount");
	}

	@Override
	public int selectMemberCount() {
		return sqlSession.selectOne("adminMapper.selectMemberCount");
	}

	@Override
	public int selectBoardCount() {
		return sqlSession.selectOne("adminMapper.selectBoardCount");
	}

	@Override
	public int selectQNACount() {
		return sqlSession.selectOne("adminMapper.selectQnaCount");
	}

	
	
}
