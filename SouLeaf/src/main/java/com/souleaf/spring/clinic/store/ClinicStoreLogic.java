package com.souleaf.spring.clinic.store;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;


@Repository
public class ClinicStoreLogic implements ClinicStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectClinicListCount() {
		return sqlSession.selectOne("clinicMapper.selectListCount");
	}
	
	@Override
	public ArrayList<Clinic> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); 
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAllList", null, rowBounds);
	}

	@Override
	public Clinic selectOne(int clinicNo) {
		return sqlSession.selectOne("clinicMapper.selectClinic",clinicNo);
	}

	@Override
	public int insertClinic(Clinic clinic) {
		return sqlSession.insert("clinicMapper.insertClinic", clinic);
	}

	@Override
	public int updateClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		return sqlSession.update("clinicMapper.updateClinic", clinic);
	}

	@Override
	public int deleteClinic(int clinicNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("clinicMapper.deleteClinic", clinicNo);
	}
	
	// 클리닉 좋아요 랭크 포인트 + 1
	@Override
	public int updateRankLike(Clinic clinic) {
		return sqlSession.update("clinicMapper.updateRankLike", clinic);
	}
	
	// 클리닉 좋아요 랭크 포인트 - 1
	@Override
	public int updateRankunLike(Clinic clinic) {
		return sqlSession.update("clinicMapper.updateRankunLike", clinic);
	}

	@Override
	public ArrayList<Clinic> selectSearchAllList(ClinicSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plant> selectAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicReply> selectAllClinicReply(int clinicNo) {
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAllReplyList",clinicNo);
	}

	@Override
	public int insertClinicReply(ClinicReply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("clinicMapper.insertReply", reply);
	}

	@Override
	public int updateClinicReply(ClinicReply reply) {
		return sqlSession.update("clinicMapper.updateReply", reply);
	}

	@Override
	public int deleteClinicReply(int clinicNo) {
		return sqlSession.update("clinicMapper.deleteReply", clinicNo);
	}

	@Override
	public void updateViewCount(int clinicNo) {
		sqlSession.update("clinicMapper.updateViewCount",clinicNo);
		
	}

	@Override
	public ArrayList<Clinic> selectAll() {
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAll");
	}

	@Override
	public int deleteAdminClinic(HashMap<String, String> map) {
		return sqlSession.delete("clinicMapper.deleteAdminClinic", map);
	}

	// 마이페이지
	@Override
	public ArrayList<Clinic> selectAllMyClinic(int memberNo, MypageInfo pi) {
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		// 없이 쿼리문을 실행한다고 하면 전체 게시물을 가져오는데 
		// 내가 원하는 게시물 만큼만가져온다 그래서 사용
		RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAllMyClinic",memberNo, rowBounds);
	}

	@Override
	public int selectMyClinicListCount(int memberNo) {
		return sqlSession.selectOne("clinicMapper.selectMyListCount", memberNo);
	}

	@Override
	public int getMySearchCount(MypageSearch search) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("clinicMapper.getMySearchCount", search);
	}

	@Override
	public ArrayList<Clinic> selectSearchAllList(MypageSearch search, MypageInfo pi) {
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("clinicMapper.selectMySearchAllList", search,rowBounds);
	}

	@Override
	public int deleteMyClinic(HashMap<String, String> map) {
		return sqlSession.update("clinicMapper.deleteMyClinic", map);
	}
	
	// 좋아요 확인
	@Override
	public ClinicLike selectLike(ClinicLike clinicLike) {
		return sqlSession.selectOne("clinicMapper.selectlike", clinicLike);
	}

	// 좋아요 초기 등록
	@Override
	public int insertLike(ClinicLike clinicLike) {
		return sqlSession.insert("clinicMapper.insertlike", clinicLike);
	}

	// 좋아요 수정
	@Override
	public int updateLike(ClinicLike clinicLike) {
		return sqlSession.update("clinicMapper.updatelike", clinicLike);
	}

	@Override
	public ArrayList<Plant> selectSearchAllList(String search) {
		return (ArrayList)sqlSession.selectList("clinicMapper.selectSearchAllList", search);
	}

	@Override
	public int selectClinicSearchListCount(String search) {
		return sqlSession.selectOne("clinicMapper.selectSearchListCount",search);
	}

	@Override
	public ArrayList<Clinic> selectAllSearchList(PageInfo pi, String search) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); 
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("clinicMapper.selectSearchList", search, rowBounds);
	}

	@Override
	public ArrayList<ClinicReply> selectSelectionClinicReply(int clinicNo) {
		return (ArrayList)sqlSession.selectList("clinicMapper.selectSelectionReply", clinicNo);
	}

	@Override
	public int updateReplySelection(int cliniccommentNo) {
		return sqlSession.update("clinicMapper.updateSelectionReply",cliniccommentNo);
	}

	@Override
	public void deleteClinicReplys(int clinicNo) {
		sqlSession.update("clinicMapper.deleteReplys", clinicNo);
	}

}
