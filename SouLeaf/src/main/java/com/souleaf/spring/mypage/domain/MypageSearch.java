package com.souleaf.spring.mypage.domain;

public class MypageSearch {
	private String searchCondition;
	private String searchValue;
	private int memberNo;
	
	public MypageSearch() {}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "MypageSearch [searchCondition=" + searchCondition + ", searchValue=" + searchValue + ", memberNo="
				+ memberNo + "]";
	}

	
}
