package com.souleaf.spring.boast.domain;

import java.sql.Date;

public class Boast {

	private int boastNo; // 글번호
	private String boastTitle; // 글제목
	private String boastContent; // 글내용
	private String boastCount; // 조회수
	private Date boastDate; // 작성일
	private Date boastUpdate; // 수정일
	private int memberNo; // 회원번호
	private String memberNick; // 작성자 닉네임
	private String memberFileRename; // 작성자 사진
	private int boastPoint; // 랭킹포인트
	private String boastStatus; // 상태
	private int plantNo; // 식물번호
	private int companionNo; // 반려식물번호
	private String plantName; // 식물네임
	private String boastFileName; // 사진이름  // 
	private String boastFileRename; // 서버사진이름 //
	private String boastContents; // 썸머노트내용 //
	private int boastReplyCount; // 댓글수
	private int boastLike;
	private int num;
	
	public Boast() {}

	public Boast(int boastNo, String boastTitle, String boastContent, String boastCount, Date boastDate,
			Date boastUpdate, int memberNo, String memberNick, String memberFileRename, int boastPoint,
			String boastStatus, int plantNo, int companionNo, String plantName, String boastFileName,
			String boastFileRename, String boastContents, int boastReplyCount, int boastLike, int num) {
		super();
		this.boastNo = boastNo;
		this.boastTitle = boastTitle;
		this.boastContent = boastContent;
		this.boastCount = boastCount;
		this.boastDate = boastDate;
		this.boastUpdate = boastUpdate;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.memberFileRename = memberFileRename;
		this.boastPoint = boastPoint;
		this.boastStatus = boastStatus;
		this.plantNo = plantNo;
		this.companionNo = companionNo;
		this.plantName = plantName;
		this.boastFileName = boastFileName;
		this.boastFileRename = boastFileRename;
		this.boastContents = boastContents;
		this.boastReplyCount = boastReplyCount;
		this.boastLike = boastLike;
		this.num = num;
	}

	public int getBoastNo() {
		return boastNo;
	}

	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}

	public String getBoastTitle() {
		return boastTitle;
	}

	public void setBoastTitle(String boastTitle) {
		this.boastTitle = boastTitle;
	}

	public String getBoastContent() {
		return boastContent;
	}

	public void setBoastContent(String boastContent) {
		this.boastContent = boastContent;
	}

	public String getBoastCount() {
		return boastCount;
	}

	public void setBoastCount(String boastCount) {
		this.boastCount = boastCount;
	}

	public Date getBoastDate() {
		return boastDate;
	}

	public void setBoastDate(Date boastDate) {
		this.boastDate = boastDate;
	}

	public Date getBoastUpdate() {
		return boastUpdate;
	}

	public void setBoastUpdate(Date boastUpdate) {
		this.boastUpdate = boastUpdate;
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

	public int getBoastPoint() {
		return boastPoint;
	}

	public void setBoastPoint(int boastPoint) {
		this.boastPoint = boastPoint;
	}

	public String getBoastStatus() {
		return boastStatus;
	}

	public void setBoastStatus(String boastStatus) {
		this.boastStatus = boastStatus;
	}

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public int getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(int companionNo) {
		this.companionNo = companionNo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getBoastFileName() {
		return boastFileName;
	}

	public void setBoastFileName(String boastFileName) {
		this.boastFileName = boastFileName;
	}

	public String getBoastFileRename() {
		return boastFileRename;
	}

	public void setBoastFileRename(String boastFileRename) {
		this.boastFileRename = boastFileRename;
	}

	public String getBoastContents() {
		return boastContents;
	}

	public void setBoastContents(String boastContents) {
		this.boastContents = boastContents;
	}

	public int getBoastReplyCount() {
		return boastReplyCount;
	}

	public void setBoastReplyCount(int boastReplyCount) {
		this.boastReplyCount = boastReplyCount;
	}

	public int getBoastLike() {
		return boastLike;
	}

	public void setBoastLike(int boastLike) {
		this.boastLike = boastLike;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Boast [boastNo=" + boastNo + ", boastTitle=" + boastTitle + ", boastContent=" + boastContent
				+ ", boastCount=" + boastCount + ", boastDate=" + boastDate + ", boastUpdate=" + boastUpdate
				+ ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", memberFileRename=" + memberFileRename
				+ ", boastPoint=" + boastPoint + ", boastStatus=" + boastStatus + ", plantNo=" + plantNo
				+ ", companionNo=" + companionNo + ", plantName=" + plantName + ", boastFileName=" + boastFileName
				+ ", boastFileRename=" + boastFileRename + ", boastContents=" + boastContents + ", boastReplyCount="
				+ boastReplyCount + ", boastLike=" + boastLike + ", num=" + num + "]";
	}

	
}


	





	

			