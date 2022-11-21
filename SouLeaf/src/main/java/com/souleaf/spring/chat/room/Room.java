package com.souleaf.spring.chat.room;

import java.sql.Date;

public class Room {

	private int roomNumber; // 채팅 번호
	private String roomName; // 채팅 이름
	private int memberNo; // 멤버 넘버
	private String memberNick; // 멤버 닉네임
	private int withMemberNo; // 상대 멤버 넘버
	private String withMemberNick; // 멤버 닉네임
	private String roomStatus; // 채팅방 활성화
	private Date lastChatDate; // 마지막 채팅 날짜
	private String lastChatMessage; // 마지막 채팅 메시지
	private String withMemberPick; // 상대 이미지

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int roomNumber, String roomName, int memberNo, String memberNick, int withMemberNo,
			String withMemberNick, String roomStatus, Date lastChatDate, String lastChatMessage,
			String withMemberPick) {
		super();
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.withMemberNo = withMemberNo;
		this.withMemberNick = withMemberNick;
		this.roomStatus = roomStatus;
		this.lastChatDate = lastChatDate;
		this.lastChatMessage = lastChatMessage;
		this.withMemberPick = withMemberPick;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public int getWithMemberNo() {
		return withMemberNo;
	}

	public void setWithMemberNo(int withMemberNo) {
		this.withMemberNo = withMemberNo;
	}

	public String getWithMemberNick() {
		return withMemberNick;
	}

	public void setWithMemberNick(String withMemberNick) {
		this.withMemberNick = withMemberNick;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Date getLastChatDate() {
		return lastChatDate;
	}

	public void setLastChatDate(Date lastChatDate) {
		this.lastChatDate = lastChatDate;
	}

	public String getLastChatMessage() {
		return lastChatMessage;
	}

	public void setLastChatMessage(String lastChatMessage) {
		this.lastChatMessage = lastChatMessage;
	}

	public String getWithMemberPick() {
		return withMemberPick;
	}

	public void setWithMemberPick(String withMemberPick) {
		this.withMemberPick = withMemberPick;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + ", memberNo=" + memberNo + ", memberNick="
				+ memberNick + ", withMemberNo=" + withMemberNo + ", withMemberNick=" + withMemberNick + ", roomStatus="
				+ roomStatus + ", lastChatDate=" + lastChatDate + ", lastChatMessage=" + lastChatMessage
				+ ", withMemberPick=" + withMemberPick + "]";
	}

}
