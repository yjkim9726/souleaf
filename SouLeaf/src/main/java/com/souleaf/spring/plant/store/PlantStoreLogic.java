package com.souleaf.spring.plant.store;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
@Repository
public class PlantStoreLogic implements PlantStore{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Plant> selectAllList() {
		return (ArrayList)sqlSession.selectList("plantMapper.selectAll");
	}

	@Override
	public Plant selectOne(int plantNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("plantMapper.selectPlant", plantNo);
	}
	
	@Override
	public PlantInfo selectOneInfo(int plantNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("plantMapper.selectPlantInfo",plantNo);
	}

	@Override
	public ArrayList<PlantFile> selectFileList(int plantNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("plantMapper.selectFileList",plantNo);
	}

	@Override
	public int insertPlant(Plant plant) {
		return sqlSession.insert("plantMapper.insertPlant", plant);
	}

	@Override
	public int insertDetailPlant(PlantInfo plantInfo) {
		return sqlSession.insert("plantMapper.insertPlantDetail", plantInfo);
	}

	@Override
	public int updatePlant(Plant plant) {
		return sqlSession.update("plantMapper.updatePlant",plant);
	}

	@Override
	public int deletePlant(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Plant> selectSearchAllList(String search) {
		return (ArrayList)sqlSession.selectList("plantMapper.selectSearch", search);
	}

	@Override
	public int selectOnePlant() {
		return sqlSession.selectOne("plantMapper.plantNo");
	}

	@Override
	public int insertPlantFile(PlantFile pFile) {
		
		return sqlSession.insert("plantMapper.insertPlantFile",pFile);
	}

	@Override
	public int updateDetailPlant(PlantInfo plantInfo) {
		return sqlSession.update("plantMapper.updatePlantDetail",plantInfo);
	}

	@Override
	public int deletePlantFile(PlantFile plantFile) {
		return sqlSession.delete("plantMapper.deleteFile",plantFile);
	}

	@Override
	public ArrayList<Plant> selectChoiceList(HashMap<String, String> plantSelect) {
		return (ArrayList)sqlSession.selectList("plantMapper.selectChoiceList", plantSelect);
	}

	@Override
	public ArrayList<Plant> selectMemberCompanion(int memberNo) {
		return (ArrayList)sqlSession.selectList("plantMapper.selectMemberCompanion", memberNo);
	}

	@Override
	public int deleteAdminPlant(String checkNo) {
		return sqlSession.update("plantMapper.deleteAdminPlant", checkNo);
	}

	@Override
	public int selectOneName(String plantName) {
		return sqlSession.selectOne("plantMapper.selectOneName", plantName);
	}

	@Override
	public ArrayList<Plant> selectHashListName(String tag) {
		return (ArrayList)sqlSession.selectList("plantMapper.selectHashList", tag);
	}

	@Override
	public int updatePlantPoint(Plant plant) {
		// TODO Auto-generated method stub
		return sqlSession.update("plantMapper.updatePlantPoint", plant);
	}

	@Override
	public ArrayList<Plant> selectAllRank() {
		return (ArrayList)sqlSession.selectList("plantMapper.selectAllRank");
	}

	

	
	


}
