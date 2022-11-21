package com.souleaf.spring.plant.domain;

import java.sql.Date;

public class Plant {
	private  int plantNo;
	private String plantName;
	private String plantEngname;
	private String plantPlantae;
	private String plantKind;
	private String plantProperty;
	private String plantLeaf;
	private String plantDetail;
	private String plantWater;
	private String plantEnvi;
	private String plantHumidity;
	private Date plantDate;
	private int plantCount;
	private int plantPoint;
	private String plantFileName;
	private String plantFileRename;
	private String plantStatus;
	
	
	
	public Plant() {
		// TODO Auto-generated constructor stub
	}



	public int getPlantNo() {
		return plantNo;
	}



	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}



	public String getPlantName() {
		return plantName;
	}



	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}



	public String getPlantEngname() {
		return plantEngname;
	}



	public void setPlantEngname(String plantEngname) {
		this.plantEngname = plantEngname;
	}



	public String getPlantPlantae() {
		return plantPlantae;
	}



	public void setPlantPlantae(String plantPlantae) {
		this.plantPlantae = plantPlantae;
	}



	public String getPlantKind() {
		return plantKind;
	}



	public void setPlantKind(String plantKind) {
		this.plantKind = plantKind;
	}



	public String getPlantProperty() {
		return plantProperty;
	}



	public void setPlantProperty(String plantProperty) {
		this.plantProperty = plantProperty;
	}



	public String getPlantLeaf() {
		return plantLeaf;
	}



	public void setPlantLeaf(String plantLeaf) {
		this.plantLeaf = plantLeaf;
	}



	public String getPlantDetail() {
		return plantDetail;
	}



	public void setPlantDetail(String plantDetail) {
		this.plantDetail = plantDetail;
	}



	public String getPlantWater() {
		return plantWater;
	}



	public void setPlantWater(String plantWater) {
		this.plantWater = plantWater;
	}



	public String getPlantEnvi() {
		return plantEnvi;
	}



	public void setPlantEnvi(String plantEnvi) {
		this.plantEnvi = plantEnvi;
	}



	public String getPlantHumidity() {
		return plantHumidity;
	}



	public void setPlantHumidity(String plantHumidity) {
		this.plantHumidity = plantHumidity;
	}



	public Date getPlantDate() {
		return plantDate;
	}



	public void setPlantDate(Date plantDate) {
		this.plantDate = plantDate;
	}



	public int getPlantCount() {
		return plantCount;
	}



	public void setPlantCount(int plantCount) {
		this.plantCount = plantCount;
	}



	public int getPlantPoint() {
		return plantPoint;
	}



	public void setPlantPoint(int plantPoint) {
		this.plantPoint = plantPoint;
	}



	public String getPlantFileName() {
		return plantFileName;
	}



	public void setPlantFileName(String plantFileName) {
		this.plantFileName = plantFileName;
	}



	public String getPlantFileRename() {
		return plantFileRename;
	}



	public void setPlantFileRename(String plantFileRename) {
		this.plantFileRename = plantFileRename;
	}



	public String getPlantStatus() {
		return plantStatus;
	}



	public void setPlantStatus(String plantStatus) {
		this.plantStatus = plantStatus;
	}



	@Override
	public String toString() {
		return "Plant [plantNo=" + plantNo + ", plantName=" + plantName + ", plantEngname=" + plantEngname
				+ ", plantPlantae=" + plantPlantae + ", plantKind=" + plantKind + ", plantProperty=" + plantProperty
				+ ", plantLeaf=" + plantLeaf + ", plantDetail=" + plantDetail + ", plantWater=" + plantWater
				+ ", plantEnvi=" + plantEnvi + ", plantHumidity=" + plantHumidity + ", plantDate=" + plantDate
				+ ", plantCount=" + plantCount + ", plantPoint=" + plantPoint + ", plantFileName=" + plantFileName
				+ ", plantFileRename=" + plantFileRename + ", plantStatus=" + plantStatus + "]";
	}

	
}
