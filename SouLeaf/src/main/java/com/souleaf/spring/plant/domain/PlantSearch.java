package com.souleaf.spring.plant.domain;

public class PlantSearch {
	   private String searchCondition;
	   private String searchValue;
	   
	   public PlantSearch() {}

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
