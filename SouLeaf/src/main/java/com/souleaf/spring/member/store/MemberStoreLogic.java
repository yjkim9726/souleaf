package com.souleaf.spring.member.store;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.store.MemberStore;
@Repository
public class MemberStoreLogic implements MemberStore {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Member> selectAll() {
		return (ArrayList)sqlSession.selectList("memberMapper.selectAll");
	}

	@Override
	public int checkIdDup(String memberId) {
		return sqlSession.selectOne("memberMapper.checkIdDup", memberId);
	}

	@Override
	public int insertMember(Member member) {
		int result = sqlSession.insert("memberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(Member member) {
		int result = sqlSession.update("memberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		return sqlSession.delete("memberMapper.deleteMember", memberId);
	}

	@Override
	public Member loginMember(Member member) {
		
		return sqlSession.selectOne("memberMapper.loginMember" , member);
	}

	@Override
	public Member selectMember(int memberNo) {
		return sqlSession.selectOne("memberMapper.selectMember", memberNo);
	}

	@Override
	public int checkNickDup(String memberNick) {
		return sqlSession.selectOne("memberMapper.checkNickDup", memberNick);
	}

	@Override
	public Member checkMemberInfo(String memberId) {
		return sqlSession.selectOne("memberMapper.checkMemberPw", memberId);
	}


	@Override
	public Member checkMember(Member member) {
		return sqlSession.selectOne("memberMapper.checkMember", member);

	}

	@Override
	public int updatePw(Member updateMem) {
		return sqlSession.update("memberMapper.updatePw", updateMem);
	}
}
