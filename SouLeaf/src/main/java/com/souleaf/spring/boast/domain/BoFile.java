package com.souleaf.spring.boast.domain;

import java.sql.Date;

public class BoFile {

	private int bofileNo;
	private String bofileName; //
	private String bofilePath;
	private long boFileSize;
	private Date bofileDate;
	private int boastNo;
	private String bofileRename; //
	
	public BoFile() {
		
		
	}

	public BoFile(int bofileNo, String bofileName, String bofilePath, long boFileSize, Date bofileDate, int boastNo,
			String bofileRename) {
		super();
		this.bofileNo = bofileNo;
		this.bofileName = bofileName;
		this.bofilePath = bofilePath;
		this.boFileSize = boFileSize;
		this.bofileDate = bofileDate;
		this.boastNo = boastNo;
		this.bofileRename = bofileRename;
	}

	public int getBofileNo() {
		return bofileNo;
	}

	public void setBofileNo(int bofileNo) {
		this.bofileNo = bofileNo;
	}

	public String getBofileName() {
		return bofileName;
	}

	public void setBofileName(String bofileName) {
		this.bofileName = bofileName;
	}

	public String getBofilePath() {
		return bofilePath;
	}

	public void setBofilePath(String bofilePath) {
		this.bofilePath = bofilePath;
	}

	public long getBoFileSize() {
		return boFileSize;
	}

	public void setBoFileSize(long boFileSize) {
		this.boFileSize = boFileSize;
	}

	public Date getBofileDate() {
		return bofileDate;
	}

	public void setBofileDate(Date bofileDate) {
		this.bofileDate = bofileDate;
	}

	public int getBoastNo() {
		return boastNo;
	}

	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}

	public String getBofileRename() {
		return bofileRename;
	}

	public void setBofileRename(String bofileRename) {
		this.bofileRename = bofileRename;
	}

	@Override
	public String toString() {
		return "BoFile [bofileNo=" + bofileNo + ", bofileName=" + bofileName + ", bofilePath=" + bofilePath
				+ ", boFileSize=" + boFileSize + ", bofileDate=" + bofileDate + ", boastNo=" + boastNo
				+ ", bofileRename=" + bofileRename + "]";
	}


	
	
}
