package com.souleaf.spring.clinic.domain;

import java.sql.Timestamp;

public class ClinicReply {
	private int  cliniccommentNo;
	private String cliniccommentContent;
	private Timestamp cliniccommentDate;
	private String cliniccommentStatus;
	private String cliniccommentSelection;
	private int clinicNo;
	private int memberNo;
	private String memberNick;
	private String memberFileRename;
	
	public ClinicReply() {
	}

	public ClinicReply(int cliniccommentNo, String cliniccommentContent, Timestamp cliniccommentDate,
			String cliniccommentStatus, String cliniccommentSelection, int clinicNo, int memberNo, String memberNick,
			String memberFileRename) {
		super();
		this.cliniccommentNo = cliniccommentNo;
		this.cliniccommentContent = cliniccommentContent;
		this.cliniccommentDate = cliniccommentDate;
		this.cliniccommentStatus = cliniccommentStatus;
		this.cliniccommentSelection = cliniccommentSelection;
		this.clinicNo = clinicNo;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.memberFileRename = memberFileRename;
	}

	public int getCliniccommentNo() {
		return cliniccommentNo;
	}

	public void setCliniccommentNo(int cliniccommentNo) {
		this.cliniccommentNo = cliniccommentNo;
	}

	public String getCliniccommentContent() {
		return cliniccommentContent;
	}

	public void setCliniccommentContent(String cliniccommentContent) {
		this.cliniccommentContent = cliniccommentContent;
	}

	public Timestamp getCliniccommentDate() {
		return cliniccommentDate;
	}

	public void setCliniccommentDate(Timestamp cliniccommentDate) {
		this.cliniccommentDate = cliniccommentDate;
	}

	public String getCliniccommentStatus() {
		return cliniccommentStatus;
	}

	public void setCliniccommentStatus(String cliniccommentStatus) {
		this.cliniccommentStatus = cliniccommentStatus;
	}

	public String getCliniccommentSelection() {
		return cliniccommentSelection;
	}

	public void setCliniccommentSelection(String cliniccommentSelection) {
		this.cliniccommentSelection = cliniccommentSelection;
	}

	public int getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(int clinicNo) {
		this.clinicNo = clinicNo;
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
		return "ClinicReply [cliniccommentNo=" + cliniccommentNo + ", cliniccommentContent=" + cliniccommentContent
				+ ", cliniccommentDate=" + cliniccommentDate + ", cliniccommentStatus=" + cliniccommentStatus
				+ ", cliniccommentSelection=" + cliniccommentSelection + ", clinicNo=" + clinicNo + ", memberNo="
				+ memberNo + ", memberNick=" + memberNick + ", memberFileRename=" + memberFileRename + "]";
	}

	

}
