package com.souleaf.spring.curiosity.domain;

import java.sql.Timestamp;

public class CuriosityReply {
	private int curicommentNo;
	private String curicommentContent;
	private Timestamp curicommentDate;
	private String curicommentStatus;
	private int curiosityNo;
	private int memberNo;
	private String memberNick;
	private String memberFileRename;
	
	public CuriosityReply() {
		// TODO Auto-generated constructor stub
	}

	public CuriosityReply(int curicommentNo, String curicommentContent, Timestamp curicommentDate,
			String curicommentStatus, int curiosityNo, int memberNo, String memberNick, String memberFileRename) {
		super();
		this.curicommentNo = curicommentNo;
		this.curicommentContent = curicommentContent;
		this.curicommentDate = curicommentDate;
		this.curicommentStatus = curicommentStatus;
		this.curiosityNo = curiosityNo;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.memberFileRename = memberFileRename;
	}

	public int getCuricommentNo() {
		return curicommentNo;
	}

	public void setCuricommentNo(int curicommentNo) {
		this.curicommentNo = curicommentNo;
	}

	public String getCuricommentContent() {
		return curicommentContent;
	}

	public void setCuricommentContent(String curicommentContent) {
		this.curicommentContent = curicommentContent;
	}

	public Timestamp getCuricommentDate() {
		return curicommentDate;
	}

	public void setCuricommentDate(Timestamp curicommentDate) {
		this.curicommentDate = curicommentDate;
	}

	public String getCuricommentStatus() {
		return curicommentStatus;
	}

	public void setCuricommentStatus(String curicommentStatus) {
		this.curicommentStatus = curicommentStatus;
	}

	public int getCuriosityNo() {
		return curiosityNo;
	}

	public void setCuriosityNo(int curiosityNo) {
		this.curiosityNo = curiosityNo;
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

	public String getMemberFileRename() {
		return memberFileRename;
	}

	public void setMemberFileRename(String memberFileRename) {
		this.memberFileRename = memberFileRename;
	}

	@Override
	public String toString() {
		return "CuriosityReply [curicommentNo=" + curicommentNo + ", curicommentContent=" + curicommentContent
				+ ", curicommentDate=" + curicommentDate + ", curicommentStatus=" + curicommentStatus + ", curiosityNo="
				+ curiosityNo + ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", memberFileRename="
				+ memberFileRename + "]";
	}

	
}
