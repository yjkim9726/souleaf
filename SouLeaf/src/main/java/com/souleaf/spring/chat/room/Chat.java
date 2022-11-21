package com.souleaf.spring.chat.room;

import java.sql.Date;

public class Chat {
	private int chatNo; // 채팅 넘버
	private int roomNumber; // 룸 넘버
	private String roomName; // 룸 이름
	private int memberNo; // 멤버 번호
	private String memberNick; // 멤버 닉네임
	private int withMemberNo; // 상대방 번호
	private String withMemberNick; // 상대방 닉네임
	private String msg; // 메시지
	private String chatDate; // 입력 날짜

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chat(int chatNo, int roomNumber, String roomName, int memberNo, String memberNick, int withMemberNo,
			String withMemberNick, String msg, String chatDate) {
		super();
		this.chatNo = chatNo;
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.withMemberNo = withMemberNo;
		this.withMemberNick = withMemberNick;
		this.msg = msg;
		this.chatDate = chatDate;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getChatDate() {
		return chatDate;
	}

	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	@Override
	public String toString() {
		return "Chat [chatNo=" + chatNo + ", roomNumber=" + roomNumber + ", roomName=" + roomName + ", memberNo="
				+ memberNo + ", memberNick=" + memberNick + ", withMemberNo=" + withMemberNo + ", withMemberNick="
				+ withMemberNick + ", msg=" + msg + ", chatDate=" + chatDate + "]";
	}

}
