package com.souleaf.spring.boastLike.domain;

public class BoastLike {

	private int likeNo;
	private int boastNo;
	private int memberNo;
	private String likeCheck;

	public BoastLike() {}

	public BoastLike(int likeNo, int boastNo, int memberNo, String likeCheck) {
		super();
		this.likeNo = likeNo;
		this.boastNo = boastNo;
		this.memberNo = memberNo;
		this.likeCheck = likeCheck;
	}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public int getBoastNo() {
		return boastNo;
	}

	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(String likeCheck) {
		this.likeCheck = likeCheck;
	}

	@Override
	public String toString() {
		return "BoastLike [likeNo=" + likeNo + ", boastNo=" + boastNo + ", memberNo=" + memberNo + ", likeCheck="
				+ likeCheck + "]";
	}


}
