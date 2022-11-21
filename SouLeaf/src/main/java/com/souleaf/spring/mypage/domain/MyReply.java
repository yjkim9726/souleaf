package com.souleaf.spring.mypage.domain;

import java.sql.Timestamp;

public class MyReply {
	private int replyNo;
	private int boardNo;
	private String replyType;
	private String replyContent;
	private Timestamp replyDate;	
	
	public MyReply() {
		// TODO Auto-generated constructor stub
	}

	public MyReply(int replyNo, int boardNo, String replyType, String replyContent, Timestamp replyDate) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.replyType = replyType;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getReplyType() {
		return replyType;
	}

	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "MyReply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", replyType=" + replyType + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + "]";
	}

	
}
