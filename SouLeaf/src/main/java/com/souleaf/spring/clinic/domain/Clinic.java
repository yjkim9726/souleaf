package com.souleaf.spring.clinic.domain;

import java.sql.Date;

public class Clinic {
	private int clinicNo;
	private String clinicContent;
	private String clinicFileName;
	private Date clinicDate;
	private Date clinicUpdate;
	private int memberNo;
	private String clinicFileRename;
	private String clinicStatus;
	private int clinicCount;
	private String clinicContents;
	private int clinicLike;
	private String memberNick;
	private String memberFileRename;
	private int replyCount;
	private int num;
	private String clinicPlace;
	private String clinicHowWater;
	private String clinicLastPot;

	public Clinic() {
	}

	public Clinic(int clinicNo, String clinicContent, String clinicFileName, Date clinicDate, Date clinicUpdate,
			int memberNo, String clinicFileRename, String clinicStatus, int clinicCount, String clinicContents,
			int clinicLike, String memberNick, String memberFileRename, int replyCount, int num, String clinicPlace,
			String clinicHowWater, String clinicLastPot) {
		super();
		this.clinicNo = clinicNo;
		this.clinicContent = clinicContent;
		this.clinicFileName = clinicFileName;
		this.clinicDate = clinicDate;
		this.clinicUpdate = clinicUpdate;
		this.memberNo = memberNo;
		this.clinicFileRename = clinicFileRename;
		this.clinicStatus = clinicStatus;
		this.clinicCount = clinicCount;
		this.clinicContents = clinicContents;
		this.clinicLike = clinicLike;
		this.memberNick = memberNick;
		this.memberFileRename = memberFileRename;
		this.replyCount = replyCount;
		this.num = num;
		this.clinicPlace = clinicPlace;
		this.clinicHowWater = clinicHowWater;
		this.clinicLastPot = clinicLastPot;
	}

	public int getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(int clinicNo) {
		this.clinicNo = clinicNo;
	}

	public String getClinicContent() {
		return clinicContent;
	}

	public void setClinicContent(String clinicContent) {
		this.clinicContent = clinicContent;
	}

	public String getClinicFileName() {
		return clinicFileName;
	}

	public void setClinicFileName(String clinicFileName) {
		this.clinicFileName = clinicFileName;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public Date getClinicUpdate() {
		return clinicUpdate;
	}

	public void setClinicUpdate(Date clinicUpdate) {
		this.clinicUpdate = clinicUpdate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getClinicFileRename() {
		return clinicFileRename;
	}

	public void setClinicFileRename(String clinicFileRename) {
		this.clinicFileRename = clinicFileRename;
	}

	public String getClinicStatus() {
		return clinicStatus;
	}

	public void setClinicStatus(String clinicStatus) {
		this.clinicStatus = clinicStatus;
	}

	public int getClinicCount() {
		return clinicCount;
	}

	public void setClinicCount(int clinicCount) {
		this.clinicCount = clinicCount;
	}

	public String getClinicContents() {
		return clinicContents;
	}

	public void setClinicContents(String clinicContents) {
		this.clinicContents = clinicContents;
	}

	public int getClinicLike() {
		return clinicLike;
	}

	public void setClinicLike(int clinicLike) {
		this.clinicLike = clinicLike;
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

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getClinicPlace() {
		return clinicPlace;
	}

	public void setClinicPlace(String clinicPlace) {
		this.clinicPlace = clinicPlace;
	}

	public String getClinicHowWater() {
		return clinicHowWater;
	}

	public void setClinicHowWater(String clinicHowWater) {
		this.clinicHowWater = clinicHowWater;
	}

	public String getClinicLastPot() {
		return clinicLastPot;
	}

	public void setClinicLastPot(String clinicLastPot) {
		this.clinicLastPot = clinicLastPot;
	}

	@Override
	public String toString() {
		return "Clinic [clinicNo=" + clinicNo + ", clinicContent=" + clinicContent + ", clinicFileName="
				+ clinicFileName + ", clinicDate=" + clinicDate + ", clinicUpdate=" + clinicUpdate + ", memberNo="
				+ memberNo + ", clinicFileRename=" + clinicFileRename + ", clinicStatus=" + clinicStatus
				+ ", clinicCount=" + clinicCount + ", clinicContents=" + clinicContents + ", clinicLike=" + clinicLike
				+ ", memberNick=" + memberNick + ", memberFileRename=" + memberFileRename + ", replyCount=" + replyCount
				+ ", num=" + num + ", clinicPlace=" + clinicPlace + ", clinicHowWater=" + clinicHowWater
				+ ", clinicLastPot=" + clinicLastPot + "]";
	}

	
}
