package com.souleaf.spring.admin.domain;

public class TotalCount {
	private int plantCount;
	private int memberCount;
	private int boardCount;
	private int qnaCount;
	
	public TotalCount() {
		// TODO Auto-generated constructor stub
	}

	public TotalCount(int plantCount, int memberCount, int boardCount, int qnaCount) {
		super();
		this.plantCount = plantCount;
		this.memberCount = memberCount;
		this.boardCount = boardCount;
		this.qnaCount = qnaCount;
	}

	public int getPlantCount() {
		return plantCount;
	}

	public void setPlantCount(int plantCount) {
		this.plantCount = plantCount;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getQnaCount() {
		return qnaCount;
	}

	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}

	@Override
	public String toString() {
		return "TotalCount [plantCount=" + plantCount + ", memberCount=" + memberCount + ", boardCount=" + boardCount
				+ ", qnaCount=" + qnaCount + "]";
	}
	
	
}
