package com.souleaf.spring.diary.domain;

public class CalendarView {
	private int diaryNo;
	private String memberNo;
	private String title;
	private String start;
	private String end;
	private String color;
	private String constraint;
	private String image_url;
	private String companionLastwater;
	private String companionNeedwater;	
	private String companionNick;
	private String diaryPicname;
	private String diaryRepicname;
	private int companionNo;
	
	public CalendarView() {}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConstraint() {
		return constraint;
	}

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}


	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getCompanionLastwater() {
		return companionLastwater;
	}

	public void setCompanionLastwater(String companionLastwater) {
		this.companionLastwater = companionLastwater;
	}

	public String getCompanionNeedwater() {
		return companionNeedwater;
	}

	public void setCompanionNeedwater(String companionNeedwater) {
		this.companionNeedwater = companionNeedwater;
	}

	public String getCompanionNick() {
		return companionNick;
	}

	public void setCompanionNick(String companionNick) {
		this.companionNick = companionNick;
	}

	public String getDiaryPicname() {
		return diaryPicname;
	}

	public void setDiaryPicname(String diaryPicname) {
		this.diaryPicname = diaryPicname;
	}

	public String getDiaryRepicname() {
		return diaryRepicname;
	}

	public void setDiaryRepicname(String diaryRepicname) {
		this.diaryRepicname = diaryRepicname;
	}

	public int getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(int companionNo) {
		this.companionNo = companionNo;
	}

	@Override
	public String toString() {
		return "CalendarView [diaryNo=" + diaryNo + ", memberNo=" + memberNo + ", title=" + title + ", start=" + start
				+ ", end=" + end + ", color=" + color + ", constraint=" + constraint + ", image_url=" + image_url
				+ ", companionLastwater=" + companionLastwater + ", companionNeedwater=" + companionNeedwater
				+ ", companionNick=" + companionNick + ", diaryPicname=" + diaryPicname + ", diaryRepicname="
				+ diaryRepicname + ", companionNo=" + companionNo + "]";
	}

	
}
