package com.souleaf.spring.qna.domain;

import java.sql.Date;

public class Qna {

	private int qnaNo;
	private int memberNo;
	private String memberNick;
	private Date qnaUpdate; // 몹쓸놈
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private String qnaStatus;
	private int qnaCount;
	private String ansNo;
	private int num;
	private String ansContent;
	
	public Qna() {
	}

	public Qna(int qnaNo, int memberNo, String memberNick, Date qnaUpdate, String qnaTitle, String qnaContent,
			Date qnaDate, String qnaStatus, int qnaCount, String ansNo, int num, String ansContent) {
		super();
		this.qnaNo = qnaNo;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.qnaUpdate = qnaUpdate;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaStatus = qnaStatus;
		this.qnaCount = qnaCount;
		this.ansNo = ansNo;
		this.num = num;
		this.ansContent = ansContent;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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

	public Date getQnaUpdate() {
		return qnaUpdate;
	}

	public void setQnaUpdate(Date qnaUpdate) {
		this.qnaUpdate = qnaUpdate;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaStatus() {
		return qnaStatus;
	}

	public void setQnaStatus(String qnaStatus) {
		this.qnaStatus = qnaStatus;
	}

	public int getQnaCount() {
		return qnaCount;
	}

	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}

	public String getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(String ansNo) {
		this.ansNo = ansNo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", qnaUpdate="
				+ qnaUpdate + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaDate=" + qnaDate
				+ ", qnaStatus=" + qnaStatus + ", qnaCount=" + qnaCount + ", ansNo=" + ansNo + ", num=" + num
				+ ", ansContent=" + ansContent + "]";
	}


}
