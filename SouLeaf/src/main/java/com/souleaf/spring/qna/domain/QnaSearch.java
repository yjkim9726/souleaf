package com.souleaf.spring.qna.domain;

public class QnaSearch {

	private String searchCondition;
	private String searchValue;
	
	public QnaSearch() {}

	
	
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
	
	
}
