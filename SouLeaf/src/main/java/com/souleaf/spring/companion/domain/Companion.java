package com.souleaf.spring.companion.domain;

import java.sql.Date;

public class Companion {
	
	private int companionNo; // 반려식물번호
	private int plantNo; // 식물번호
	private int memberNo; // 회원번호
	private String companionNick; // 애칭
	private Date companionDate; // 등록일
	private Date companionUpdate; // 수정일
	private String companionPicName; // 식물 원본 사진
	private String companionRepicName; // 식물 저장 사진
	private String companionLastWater; // 마지막 물 준날
	private String companionNeedWater; // 물 줘야하는 날
	
	// 추가 get/set
	private String plantName; // 식물명
	private String plantWater; // 물 주기
	
	public Companion() {}

	public int getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(int companionNo) {
		this.companionNo = companionNo;
	}

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCompanionNick() {
		return companionNick;
	}

	public void setCompanionNick(String companionNick) {
		this.companionNick = companionNick;
	}

	public Date getCompanionDate() {
		return companionDate;
	}

	public void setCompanionDate(Date companionDate) {
		this.companionDate = companionDate;
	}

	public Date getCompanionUpdate() {
		return companionUpdate;
	}

	public void setCompanionUpdate(Date companionUpdate) {
		this.companionUpdate = companionUpdate;
	}

	public String getCompanionPicName() {
		return companionPicName;
	}

	public void setCompanionPicName(String companionPicName) {
		this.companionPicName = companionPicName;
	}

	public String getCompanionRepicName() {
		return companionRepicName;
	}

	public void setCompanionRepicName(String companionRepicName) {
		this.companionRepicName = companionRepicName;
	}

	public String getCompanionLastWater() {
		return companionLastWater;
	}

	public void setCompanionLastWater(String companionLastWater) {
		this.companionLastWater = companionLastWater;
	}

	public String getCompanionNeedWater() {
		return companionNeedWater;
	}

	public void setCompanionNeedWater(String companionNeedWater) {
		this.companionNeedWater = companionNeedWater;
	}
	
	public String getPlantWater() {
		return plantWater;
	}

	public void setPlantWater(String plantWater) {
		this.plantWater = plantWater;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	@Override
	public String toString() {
		return "Companion [companionNo=" + companionNo + ", plantNo=" + plantNo + ", memberNo=" + memberNo
				+ ", companionNick=" + companionNick + ", companionDate=" + companionDate + ", companionUpdate="
				+ companionUpdate + ", companionPicName=" + companionPicName + ", companionRepicName="
				+ companionRepicName + ", companionLastWater=" + companionLastWater + ", companionNeedWater="
				+ companionNeedWater + "]";
	}

}
