package com.souleaf.spring.boast.domain;

public class BoastSearch {

	private String searchCondition;
	private String searchValue;
	
	public BoastSearch() {}

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
