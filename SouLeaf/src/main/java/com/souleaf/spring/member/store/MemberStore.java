package com.souleaf.spring.member.store;

import java.util.ArrayList;
import java.util.List;

import com.souleaf.spring.member.domain.Member;

public interface MemberStore {
	public ArrayList<Member> selectAll(); // 멤버전체출력
	public int checkIdDup(String memberId);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String memberId);
	public Member loginMember(Member member); // 로그인
	public Member selectMember(int memberNo);
	public int checkNickDup(String memberNick);
	public Member checkMemberInfo(String memberId);
	public Member checkMember(Member member);
	public int updatePw(Member updateMem);
}
