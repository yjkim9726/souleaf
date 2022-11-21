package com.souleaf.spring.mypage.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.mypage.domain.MyReply;

@Repository
public class MypageStoreLogic implements MypageStore{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Boast> selectAllMyBoast(int memberNo) {
		return (ArrayList)sqlSession.selectList("mypageMapper.selectAllMyBoast",memberNo);
	}

	@Override
	public ArrayList<Clinic> selectAllMyClinic(int memberNo) {
		return (ArrayList)sqlSession.selectList("mypageMapper.selectAllMyClinic",memberNo);
	}

	@Override
	public ArrayList<Curiosity> selectAllMyCuriosity(int memberNo) {
		return (ArrayList)sqlSession.selectList("mypageMapper.selectAllMyCuriosity", memberNo);
	}

	@Override
	public ArrayList<MyReply> selectAllMyReply(int memberNo) {
		return (ArrayList)sqlSession.selectList("mypageMapper.selectAllMyReply", memberNo);
	}


}
