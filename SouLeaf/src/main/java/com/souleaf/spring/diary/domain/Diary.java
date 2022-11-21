package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Diary {
	
	private int diaryNo;
	private String diaryTitle;
	private String diaryContent;
	private String diaryStartDate;
	private String diaryEndDate;
	private String diaryUpdate;
	private String diaryColor;
	private String diaryPicname;
	private String diaryRepicname;
	private int memberNo;
	private int companionNo;
	private String companionNick;
	private String diaryStatus;
	private String imgUrl;
	 
	public Diary() {}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public String getDiaryTitle() {
		return diaryTitle;
	}

	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiaryContent() {
		return diaryContent;
	}

	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}

	public String getDiaryStartDate() {
		return diaryStartDate;
	}

	public void setDiaryStartDate(String diaryStartDate) {
		this.diaryStartDate = diaryStartDate;
	}

	public String getDiaryEndDate() {
		return diaryEndDate;
	}

	public void setDiaryEndDate(String diaryEndDate) {
		this.diaryEndDate = diaryEndDate;
	}

	public String getDiaryUpdate() {
		return diaryUpdate;
	}

	public void setDiaryUpdate(String diaryUpdate) {
		this.diaryUpdate = diaryUpdate;
	}

	public String getdiaryColor() {
		return diaryColor;
	}

	public void setdiaryColor(String diaryColor) {
		this.diaryColor = diaryColor;
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(int companionNo) {
		this.companionNo = companionNo;
	}

	public String getCompanionNick() {
		return companionNick;
	}

	public void setCompanionNick(String companionNick) {
		this.companionNick = companionNick;
	}

	public String getDiaryStatus() {
		return diaryStatus;
	}

	public void setDiaryStatus(String diaryStatus) {
		this.diaryStatus = diaryStatus;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", diaryTitle=" + diaryTitle + ", diaryContent=" + diaryContent
				+ ", diaryStartDate=" + diaryStartDate + ", diaryEndDate=" + diaryEndDate + ", diaryUpdate="
				+ diaryUpdate + ", diaryColor=" + diaryColor + ", diaryPicname=" + diaryPicname + ", diaryRepicname="
				+ diaryRepicname + ", memberNo=" + memberNo + ", companionNo=" + companionNo + ", companionNick="
				+ companionNick + ", diaryStatus=" + diaryStatus + ", imgUrl=" + imgUrl + "]";
	}


}
