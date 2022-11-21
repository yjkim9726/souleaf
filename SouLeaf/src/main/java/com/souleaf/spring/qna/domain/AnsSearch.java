package com.souleaf.spring.qna.domain;

public class AnsSearch {
	
	private String searchCondition;
	private String searchValue;
	
	public AnsSearch() {}



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
