package com.souleaf.spring.boast.store;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.boast.domain.BoFile;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.boast.domain.BoastSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.PlantInfo;



@Repository
public class BoastStoreLogic implements BoastStore {

@Autowired
	private SqlSession sqlSession;
	
	  
	@Override
	public int selectListCount() {
		//
		return sqlSession.selectOne("boastMapper.selectListCount");
	}

	@Override
	public ArrayList<Boast> selectAllList(PageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("boastMapper.selectAllList", null, rowBounds);
	}
	
//	@Override
//	public ArrayList<Boast> selectAllList(PageInfo pi) {//
//		int offset = (pi.getCurrentPage() - 1) * pi.getPageLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getPageLimit());
//		return (ArrayList)sqlSession.selectList("boastMapper.selectAllList", null, rowBounds);
//	}
	
//	@Override
//	public ArrayList<Boast> selectAllList() {
//		return (ArrayList)sqlSession.selectList("boastMapper.selectAll");
//	}

	
	@Override
	public ArrayList<Boast> selectSearchList(BoastSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boast selectOne(int boastNo) {
		// 
		return sqlSession.selectOne("boastMapper.selectOne", boastNo);
	}

	@Override
	public int addReadCount(int boastNo) {
		// 
		return sqlSession.update("boastMapper.updateCount", boastNo);
	}
	
	@Override
	public int insertBoast(Boast boast) {
		// 
		return sqlSession.insert("boastMapper.insertBoast", boast);
	}

	@Override
	public int updateBoast(Boast boast) {
		// 
		return sqlSession.update("boastMapper.updateBoast", boast);
	}

	@Override
	public int deleteBoast(int boastNo) {
		// 
		return sqlSession.update("boastMapper.deleteBoast", boastNo);
	}
	
	@Override
	public ArrayList<BoastReply> selectAllBoastReply(int boastNo) {
		// 
		return (ArrayList)sqlSession.selectList("boastMapper.selectBoastReply",boastNo);
	}
	
	@Override
	public int insertBoastReply(BoastReply reply) {
		// 
		return sqlSession.insert("boastMapper.insertBoastReply", reply);
	}
	
	@Override
	public int updateBoastReply(BoastReply reply) {
		// 
		return sqlSession.update("boastMapper.updateReply", reply);
	}
	
	@Override
	public int deleteBoastReply(BoastReply reply) {
		// 
		return sqlSession.delete("boastMapper.deleteBoastReply", reply);
	}
	
	@Override
	public int deleteBoastReReply(BoastReply reply) {
		// 
		return sqlSession.delete("boastMapper.deleteBoastReReply", reply);
	}
	
	
	
	
	
	
	
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @since 2021.8.15
	 */
	@Override
	public ArrayList<Boast> selectAllNo() {
		return (ArrayList)sqlSession.selectList("boastMapper.selectAllNo");
	}
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	@Override
	public int updatePoint(int boastNo) {
		return sqlSession.update("boastMapper.updatePoint", boastNo);
	}
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	@Override
	public ArrayList<Boast> selectRank() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("boastMapper.selectRank");
	}

	@Override
	public ArrayList<Boast> selectAll() {
		return (ArrayList)sqlSession.selectList("boastMapper.selectAll");
	}

	@Override
	public int deleteAdminBoast(HashMap<String, String> map) {
		return sqlSession.update("boastMapper.deleteAdminBoast", map);
	}

	@Override
	public int insertBoastReReply(BoastReply reply) {
		return sqlSession.insert("boastMapper.insertBoastReReply", reply);
	}

	@Override
	public int selectLikeCount(int boastNo) {
		return sqlSession.selectOne("boastMapper.selectLikeCount", boastNo);
	}

	@Override
	public int updateLike(Boast boast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectLikeCheck(Boast boast) {
		return sqlSession.selectOne("boastMapper.selectLikeCheck", boast);
	}

	@Override
	public int selectLikeAddCheck(Boast boast) {
		return sqlSession.selectOne("boastMapper.selectLikeAddCheck", boast);
	}

	@Override
	public int insertBoastLike(Boast boast) {
		return sqlSession.insert("boastMapper.insertLike", boast);
	}

	@Override
	public int updateBoastLike(Boast boast) {
		return sqlSession.update("boastMapper.updateLike", boast);
	}

	

	// 마이페이지

	@Override

	public int selectMyBoastListCount(int memberNo) {

	return sqlSession.selectOne("boastMapper.selectMyListCount", memberNo);

	}

	@Override

	public ArrayList<Boast> selectAllMyBoast(int memberNo, MypageInfo pi) {

	int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();

	// 없이 쿼리문을 실행한다고 하면 전체 게시물을 가져오는데

	// 내가 원하는 게시물 만큼만가져온다 그래서 사용

	RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());

	return (ArrayList)sqlSession.selectList("boastMapper.selectAllMyBoast",memberNo, rowBounds);

	}

	@Override

	public int getMySearchCount(MypageSearch search) {

	// **TODO** Auto-generated method stub

	return sqlSession.selectOne("boastMapper.getMySearchCount", search);

	}

	@Override

	public ArrayList<Boast> selectSearchAllList(MypageSearch search, MypageInfo pi) {

	int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();

	RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());

	return (ArrayList)sqlSession.selectList("boastMapper.selectMySearchAllList", search,rowBounds);

	}

	@Override

	public int deleteMyBoast(HashMap<String, String> map) {

	return sqlSession.update("boastMapper.deleteMyBoast", map);

	}

	@Override
	public void deleteBoastReplys(int boastNo) {
		sqlSession.update("boastMapper.deleteReplys",boastNo);
	}

	@Override
	public ArrayList<Boast> selectAllRank() {
		return (ArrayList)sqlSession.selectList("boastMapper.selectAllRank");
	}

	@Override
	public int getBoastReReply(int boastNo) {
		return sqlSession.selectOne("boastMapper.getBoastReReply", boastNo);
	}




}
