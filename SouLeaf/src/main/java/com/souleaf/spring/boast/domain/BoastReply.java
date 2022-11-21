package com.souleaf.spring.boast.domain;

import java.sql.Timestamp;

public class BoastReply {

	private int bocommentNo; // 댓글 번호
	private int boastNo; // 게시글 번호
	private String bocommentContent; // 댓글 내용
	private Timestamp bocommentDate; // 댓글 작성일 
	private int memberNo; // 멤버번호
	private String memberNick; // 멤버 닉네임
	private String bocommentStatus; // 상태값
	private int  bocommentParentNo; // 댓글 부모 번호
	private int bocommentDepth; // 댓글 단계 
	
	
	public BoastReply() {}


	public BoastReply(int bocommentNo, int boastNo, String bocommentContent, Timestamp bocommentDate, int memberNo,
			String memberNick, String bocommentStatus, int bocommentParentNo, int bocommentDepth) {
		super();
		this.bocommentNo = bocommentNo;
		this.boastNo = boastNo;
		this.bocommentContent = bocommentContent;
		this.bocommentDate = bocommentDate;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.bocommentStatus = bocommentStatus;
		this.bocommentParentNo = bocommentParentNo;
		this.bocommentDepth = bocommentDepth;
	}


	public int getBocommentNo() {
		return bocommentNo;
	}


	public void setBocommentNo(int bocommentNo) {
		this.bocommentNo = bocommentNo;
	}


	public int getBoastNo() {
		return boastNo;
	}


	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}


	public String getBocommentContent() {
		return bocommentContent;
	}


	public void setBocommentContent(String bocommentContent) {
		this.bocommentContent = bocommentContent;
	}


	public Timestamp getBocommentDate() {
		return bocommentDate;
	}


	public void setBocommentDate(Timestamp bocommentDate) {
		this.bocommentDate = bocommentDate;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberNick() {
		return memberNick;
	}


	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}


	public String getBocommentStatus() {
		return bocommentStatus;
	}


	public void setBocommentStatus(String bocommentStatus) {
		this.bocommentStatus = bocommentStatus;
	}


	public int getBocommentParentNo() {
		return bocommentParentNo;
	}


	public void setBocommentParentNo(int bocommentParentNo) {
		this.bocommentParentNo = bocommentParentNo;
	}


	public int getBocommentDepth() {
		return bocommentDepth;
	}


	public void setBocommentDepth(int bocommentDepth) {
		this.bocommentDepth = bocommentDepth;
	}


	@Override
	public String toString() {
		return "BoastReply [bocommentNo=" + bocommentNo + ", boastNo=" + boastNo + ", bocommentContent="
				+ bocommentContent + ", bocommentDate=" + bocommentDate + ", memberNo=" + memberNo + ", memberNick="
				+ memberNick + ", bocommentStatus=" + bocommentStatus + ", bocommentParentNo=" + bocommentParentNo
				+ ", bocommentDepth=" + bocommentDepth + "]";
	}


	
	
	
}
