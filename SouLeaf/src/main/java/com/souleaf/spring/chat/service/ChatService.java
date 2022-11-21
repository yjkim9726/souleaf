package com.souleaf.spring.chat.service;

import java.util.ArrayList;

import com.souleaf.spring.chat.room.Chat;
import com.souleaf.spring.chat.room.Room;

public interface ChatService {

	public ArrayList<Room> printAllList(int memberNo); // 채팅방 리스트

	public int printMaxRoomNum(); // 최신 채팅번호 취득

	public Room printOneRoom(Room roominfo); // 선택한 룸 정보 가져오기

	public int registerChat(Chat chat); // 채팅 내용 저장
	
	public ArrayList<Chat> printAllChat(int roomNumber); // 채팅 내용 가져오기

	public int registerRoom(Room room); // 방 정보 저장

	public int printCheckRoom(Room room); // 방 존재 여부 확인

	public int modifyRoom(Room room); // 마지막 채팅 내용 표시

	public int modifyRoom2(Room room); // 마지막 채팅 내용 표시
}
