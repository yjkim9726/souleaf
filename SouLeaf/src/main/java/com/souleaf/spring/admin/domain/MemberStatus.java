package com.souleaf.spring.admin.domain;

public class MemberStatus {
	private int statusY;
	private int statusN;
	
	public MemberStatus() {
		// TODO Auto-generated constructor stub
	}

	public MemberStatus(int statusY, int statusN) {
		super();
		this.statusY = statusY;
		this.statusN = statusN;
	}

	public int getStatusY() {
		return statusY;
	}

	public void setStatusY(int statusY) {
		this.statusY = statusY;
	}

	public int getStatusN() {
		return statusN;
	}

	public void setStatusN(int statusN) {
		this.statusN = statusN;
	}

	@Override
	public String toString() {
		return "MemberStatus [statusY=" + statusY + ", statusN=" + statusN + "]";
	}
	
}
