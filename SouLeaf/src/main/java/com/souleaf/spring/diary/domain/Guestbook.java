package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Guestbook {
	
	private int guestbookNo;
	private String guestbookContent;
	private String guestbookDate;
	private String guestbookUpdate;
	private int memberNo;
	private int memberDiary;
	private String memberNick;
	private String memberFileRename;
	
	public Guestbook() {}

	public int getGuestbookNo() {
		return guestbookNo;
	}

	public void setGuestbookNo(int guestbookNo) {
		this.guestbookNo = guestbookNo;
	}

	public String getGuestbookContent() {
		return guestbookContent;
	}

	public void setGuestbookContent(String guestbookContent) {
		this.guestbookContent = guestbookContent;
	}

	public String getGuestbookDate() {
		return guestbookDate;
	}

	public void setGuestbookDate(String guestbookDate) {
		this.guestbookDate = guestbookDate;
	}

	public String getGuestbookUpdate() {
		return guestbookUpdate;
	}

	public void setGuestbookUpdate(String guestbookUpdate) {
		this.guestbookUpdate = guestbookUpdate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getMemberDiary() {
		return memberDiary;
	}

	public void setMemberDiary(int memberDiary) {
		this.memberDiary = memberDiary;
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
		return "Guestbook [guestbookNo=" + guestbookNo + ", guestbookContent=" + guestbookContent + ", guestbookDate="
				+ guestbookDate + ", guestbookUpdate=" + guestbookUpdate + ", memberNo=" + memberNo + ", memberDiary="
				+ memberDiary + ", memberNick=" + memberNick + ", memberFileRename=" + memberFileRename + "]";
	}

	
	
	
	
}
