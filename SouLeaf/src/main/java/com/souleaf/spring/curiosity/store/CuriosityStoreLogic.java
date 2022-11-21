package com.souleaf.spring.curiosity.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;
@Repository
public class CuriosityStoreLogic implements CuriosityStore{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectCuriosityListCount() {
		return sqlSession.selectOne("curiosityMapper.selectListCount");
	}
	
	@Override
	public ArrayList<Curiosity> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); 
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllList", null, rowBounds);
	}

	@Override
	public Curiosity selectOne(int curiosityNo) {
		return sqlSession.selectOne("curiosityMapper.selectCuriosity",curiosityNo);
	}

	@Override
	public int insertCuriosity(Curiosity curiosity) {
		return sqlSession.insert("curiosityMapper.insertCuriosity", curiosity);
	}

	@Override
	public int updateCuriosity(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return sqlSession.update("curiosityMapper.updateCuriosity", curiosity);
	}

	@Override
	public int deleteCuriosity(int curiosityNo) {
		return sqlSession.update("curiosityMapper.deleteCuriosity", curiosityNo);
	}


	@Override
	public ArrayList<Plant> selectAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CuriosityReply> selectAllCuriosityReply(int curiosityNo) {
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllReplyList",curiosityNo);
	}

	@Override
	public int insertCuriosityReply(CuriosityReply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("curiosityMapper.insertReply", reply);
	}

	@Override
	public int updateCuriosityReply(CuriosityReply reply) {
		return sqlSession.update("curiosityMapper.updateReply", reply);
	}

	@Override
	public int deleteCuriosityReply(int curicommentNo) {
		return sqlSession.update("curiosityMapper.deleteReply", curicommentNo);
	}

	@Override
	public void updateViewCount(int curiosityNo) {
		sqlSession.update("curiosityMapper.updateViewCount",curiosityNo);
	}

	
	// 마이페이지 
	
	@Override
	public ArrayList<Curiosity> selectAllMyCuriosity(int memberNo, MypageInfo pi) {
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		// 없이 쿼리문을 실행한다고 하면 전체 게시물을 가져오는데 
		// 내가 원하는 게시물 만큼만가져온다 그래서 사용
		RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllMyCuriosity",memberNo, rowBounds);
	}
	

	@Override
	public ArrayList<Curiosity> selectSearchAllList(MypageSearch search, MypageInfo pi) {
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		// 없이 쿼리문을 실행한다고 하면 전체 게시물을 가져오는데 
		// 내가 원하는 게시물 만큼만가져온다 그래서 사용
		RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());
 		return (ArrayList)sqlSession.selectList("curiosityMapper.selectSearchAllList", search,rowBounds);
	}

	@Override
	public int selectMyCuriosityListCount(int memberNo) {
		return sqlSession.selectOne("curiosityMapper.selectMyListCount", memberNo);
	}

	@Override
	public ArrayList<Curiosity> selectAll() {
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAll");
	}

	@Override
	public int getMySearchCount(MypageSearch search) {
		return sqlSession.selectOne("curiosityMapper.getMySearchCount", search);
	}

	@Override
	public int deleteMyCuriosity(HashMap<String, String> map) {
		return sqlSession.update("curiosityMapper.deleteMyCuriosity", map);
	}

	@Override
	public void deleteCuriosityReplys(int curiosityNo) {
		sqlSession.update("curiosityMapper.deleteReplys", curiosityNo);
	}
	
	

}
