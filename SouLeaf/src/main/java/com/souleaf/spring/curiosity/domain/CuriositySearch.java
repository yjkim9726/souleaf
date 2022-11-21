package com.souleaf.spring.curiosity.domain;

public class CuriositySearch {
	   private String searchCondition;
	   private String searchValue;
	   
	   public CuriositySearch() {}

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
