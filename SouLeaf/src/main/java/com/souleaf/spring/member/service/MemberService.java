package com.souleaf.spring.member.service;

import java.util.ArrayList;
import java.util.List;

import com.souleaf.spring.member.domain.Member;

public interface MemberService {
	public ArrayList<Member> selectAll(); // 멤버전체출력
	public Member loginMember(Member member); // 로그인
	public int checkIdDup(String memberId);
	public int registerMember(Member member);
	public int modifyMember(Member member);
	public int deleteMember(String memberId);
	public Member printMember(int memberNo);
	public int checkNickDup(String memberNick);
	public Member checkMemberInfo(String memberId);
	public Member checkMember(Member member);
	public int modifyPw(Member updateMem);

	
}

