package com.souleaf.spring.chat.store;

import java.util.ArrayList;

import com.souleaf.spring.chat.room.Chat;
import com.souleaf.spring.chat.room.Room;

public interface ChatStore {

	public ArrayList<Room> selectAllList(int memberNo); // 채팅방 리스트

	public int selectMaxRoomNum(); // 최신 채팅번호 취득

	public Room selectOneRoom(Room roominfo); // 선택한 룸 정보 가져오기

	public int insertChat(Chat chat); // 채팅 내용 저장
	
	public ArrayList<Chat> selectAllChat(int roomNumber); // 채팅 내용 가져오기

	public int insertRoom(Room room); // 룸 정보 저장

	public int selectCheckRoom(Room room); // 룸 정보 존재 여부

	public int updateRoom(Room room); // 마지막 채팅 내용

	public int updateRoom2(Room room); // 마지막 채팅 내용
}
