package com.souleaf.spring.chat.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.chat.room.Chat;
import com.souleaf.spring.chat.room.Room;

@Repository
public class ChatStoreLogic implements ChatStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Room> selectAllList(int memberNo) {
		return (ArrayList)sqlSession.selectList("roomMapper.selectAllList",memberNo);
	}

	// 최신 채팅번호 취득
	@Override
	public int selectMaxRoomNum() {
		return sqlSession.selectOne("roomMapper.selectMaxRoomNum");
	}

	// 선택한 룸 정보 가져오기
	@Override
	public Room selectOneRoom(Room roominfo) {
		return sqlSession.selectOne("roomMapper.selectOneRoom", roominfo);
	}

	// 채팅 내용 저장
	@Override
	public int insertChat(Chat chat) {
		return sqlSession.insert("roomMapper.insertChat", chat);
	}
	
	// 채팅 내용 가져오기
	@Override
	public ArrayList<Chat> selectAllChat(int roomNumber) {
		return (ArrayList)sqlSession.selectList("roomMapper.selectAllChat",roomNumber);
	}

	@Override
	public int insertRoom(Room room) {
		// TODO Auto-generated method stub
		return sqlSession.insert("roomMapper.insertRoom", room);
	}

	@Override
	public int selectCheckRoom(Room room) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("roomMapper.selectCheckRoom", room);
	}

	@Override
	public int updateRoom(Room room) {
		// TODO Auto-generated method stub
		return sqlSession.update("roomMapper.updateRoom", room);
	}

	@Override
	public int updateRoom2(Room room) {
		// TODO Auto-generated method stub
		return sqlSession.update("roomMapper.updateRoom2", room);
	}

}
