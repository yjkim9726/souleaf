package com.souleaf.spring.qna.domain;

import java.sql.Date;
import java.util.ArrayList;

public class Ans {
	
	private int ansNo;
	private int memberNo;
	private String ansTitle;
	private String ansContent;
	private Date ansDate;
	private int qnaNo;
	
	public Ans() {
		// TODO Auto-generated constructor stub
	}

	public Ans(int ansNo, int memberNo, String ansTitle, String ansContent, Date ansDate, int qnaNo) {
		super();
		this.ansNo = ansNo;
		this.memberNo = memberNo;
		this.ansTitle = ansTitle;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.qnaNo = qnaNo;
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getAnsTitle() {
		return ansTitle;
	}

	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	@Override
	public String toString() {
		return "Ans [ansNo=" + ansNo + ", memberNo=" + memberNo + ", ansTitle=" + ansTitle + ", ansContent="
				+ ansContent + ", ansDate=" + ansDate + ", qnaNo=" + qnaNo + "]";
	}

	
}
