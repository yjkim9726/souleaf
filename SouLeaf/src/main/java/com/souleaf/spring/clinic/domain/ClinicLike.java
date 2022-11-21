package com.souleaf.spring.clinic.domain;

public class ClinicLike {
	
	private int likeNo;
	private int clinicNo;
	private int memberNo;
	private int likeCheck;
	
	public ClinicLike() {
	}

	public ClinicLike(int likeNo, int clinicNo, int memberNo, int likeCheck) {
		super();
		this.likeNo = likeNo;
		this.clinicNo = clinicNo;
		this.memberNo = memberNo;
		this.likeCheck = likeCheck;
	}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
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

	public int getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}

	@Override
	public String toString() {
		return "ClinicLike [likeNo=" + likeNo + ", clinicNo=" + clinicNo + ", memberNo=" + memberNo + ", likeCheck="
				+ likeCheck + "]";
	}

}
