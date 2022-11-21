package com.souleaf.spring.plant.domain;

public class PlantInfo {

	private int plantNo;
	private int plantinfoNo;
	private String piLightInfo; // 빛 정보
	private String piLightContents; // 빛 내용
	private String piTempInfo; // 온도 정보
	private String piTempContents; // 온도 내용
	private String piHumidityInfo; // 습도 정보
	private String piHumidityContents; // 습도 내용
	private String piWaterInfo; // 물 정보 
	private String piWaterContents; // 물 내용
	private String piEarthInfo; // 흙 정보
	private String piEarthContents; // 흙 내용
	private String piBunting; // 분갈이시기
	
	public PlantInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public int getPlantinfoNo() {
		return plantinfoNo;
	}

	public void setPlantinfoNo(int plantinfoNo) {
		this.plantinfoNo = plantinfoNo;
	}

	public String getPiLightInfo() {
		return piLightInfo;
	}

	public void setPiLightInfo(String piLightInfo) {
		this.piLightInfo = piLightInfo;
	}

	public String getPiLightContents() {
		return piLightContents;
	}

	public void setPiLightContents(String piLightContents) {
		this.piLightContents = piLightContents;
	}

	public String getPiTempInfo() {
		return piTempInfo;
	}

	public void setPiTempInfo(String piTempInfo) {
		this.piTempInfo = piTempInfo;
	}

	public String getPiTempContents() {
		return piTempContents;
	}

	public void setPiTempContents(String piTempContents) {
		this.piTempContents = piTempContents;
	}

	public String getPiHumidityInfo() {
		return piHumidityInfo;
	}

	public void setPiHumidityInfo(String piHumidityInfo) {
		this.piHumidityInfo = piHumidityInfo;
	}

	public String getPiHumidityContents() {
		return piHumidityContents;
	}

	public void setPiHumidityContents(String piHumidityContents) {
		this.piHumidityContents = piHumidityContents;
	}

	public String getPiWaterInfo() {
		return piWaterInfo;
	}

	public void setPiWaterInfo(String piWaterInfo) {
		this.piWaterInfo = piWaterInfo;
	}

	public String getPiWaterContents() {
		return piWaterContents;
	}

	public void setPiWaterContents(String piWaterContents) {
		this.piWaterContents = piWaterContents;
	}

	public String getPiEarthInfo() {
		return piEarthInfo;
	}

	public void setPiEarthInfo(String piEarthInfo) {
		this.piEarthInfo = piEarthInfo;
	}

	public String getPiEarthContents() {
		return piEarthContents;
	}

	public void setPiEarthContents(String piEarthContents) {
		this.piEarthContents = piEarthContents;
	}

	public String getPiBunting() {
		return piBunting;
	}

	public void setPiBunting(String piBunting) {
		this.piBunting = piBunting;
	}

	@Override
	public String toString() {
		return "PlantInfo [plantNo=" + plantNo + ", plantinfoNo=" + plantinfoNo + ", piLightInfo=" + piLightInfo
				+ ", piLightContents=" + piLightContents + ", piTempInfo=" + piTempInfo + ", piTempContents="
				+ piTempContents + ", piHumidityInfo=" + piHumidityInfo + ", piHumidityContents=" + piHumidityContents
				+ ", piWaterInfo=" + piWaterInfo + ", piWaterContents=" + piWaterContents + ", piEarthInfo="
				+ piEarthInfo + ", piEarthContents=" + piEarthContents + ", piBunting=" + piBunting + "]";
	}

	
}
