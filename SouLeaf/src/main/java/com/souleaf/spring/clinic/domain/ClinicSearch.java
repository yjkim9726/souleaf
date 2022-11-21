package com.souleaf.spring.clinic.domain;

public class ClinicSearch {
   private String searchCondition;
   private String searchValue;
   
   public ClinicSearch() {}

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

	@Override
	public String toString() {
		return "ClinicSearch [searchCondition=" + searchCondition + ", searchValue=" + searchValue + "]";
	}
	   
	   
	
}
