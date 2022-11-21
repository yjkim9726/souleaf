package com.souleaf.spring.member.domain;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberName;
	private String memberPhone;
	private String memberMail;
	private String memberPhoto;
	private Date memberJoin;
	private Date memberOut;
	private String memberIntro;
	private String memberStatus;
	private String memberFileRename;
	private String memberFileName;
	public Member() {}
	
		
	

	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}




	public Member(int memberNo, String memberId, String memberPw, String memberNick, String memberName,
			String memberPhone, String memberMail, String memberPhoto, Date memberJoin, Date memberOut,
			String memberIntro, String memberStatus, String memberFileRename, String memberFileName) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNick = memberNick;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberMail = memberMail;
		this.memberPhoto = memberPhoto;
		this.memberJoin = memberJoin;
		this.memberOut = memberOut;
		this.memberIntro = memberIntro;
		this.memberStatus = memberStatus;
		this.memberFileRename = memberFileRename;
		this.memberFileName = memberFileName;
	}




	public int getMemberNo() {
		return memberNo;
	}




	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}




	public String getMemberId() {
		return memberId;
	}




	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}




	public String getMemberPw() {
		return memberPw;
	}




	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}




	public String getMemberNick() {
		return memberNick;
	}




	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}




	public String getMemberName() {
		return memberName;
	}




	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}




	public String getMemberPhone() {
		return memberPhone;
	}




	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}




	public String getMemberMail() {
		return memberMail;
	}




	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}




	public String getMemberPhoto() {
		return memberPhoto;
	}




	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}




	public Date getMemberJoin() {
		return memberJoin;
	}




	public void setMemberJoin(Date memberJoin) {
		this.memberJoin = memberJoin;
	}




	public Date getMemberOut() {
		return memberOut;
	}




	public void setMemberOut(Date memberOut) {
		this.memberOut = memberOut;
	}




	public String getMemberIntro() {
		return memberIntro;
	}




	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}




	public String getMemberStatus() {
		return memberStatus;
	}




	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}




	public String getMemberFileRename() {
		return memberFileRename;
	}




	public void setMemberFileRename(String memberFileRename) {
		this.memberFileRename = memberFileRename;
	}




	public String getMemberFileName() {
		return memberFileName;
	}




	public void setMemberFileName(String memberFileName) {
		this.memberFileName = memberFileName;
	}




	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberNick="
				+ memberNick + ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", memberMail="
				+ memberMail + ", memberPhoto=" + memberPhoto + ", memberJoin=" + memberJoin + ", memberOut="
				+ memberOut + ", memberIntro=" + memberIntro + ", memberStatus=" + memberStatus + ", memberFileRename="
				+ memberFileRename + ", memberFileName=" + memberFileName + "]";
	}



}
