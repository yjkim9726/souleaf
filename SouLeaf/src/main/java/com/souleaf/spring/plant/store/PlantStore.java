package com.souleaf.spring.plant.store;

import java.util.ArrayList;
import java.util.HashMap;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;

public interface PlantStore {
	public ArrayList<Plant> selectAllList();// 식물도감 리스트 출력
	public ArrayList<Plant> selectChoiceList(HashMap<String, String> plantSelect);// 식물도감 선택 리스트 출력
	public Plant selectOne(int plantNo);// 식물도감 상세보기
	public PlantInfo selectOneInfo(int plantNo);// 식물도감 상세정보 출력
	public ArrayList<PlantFile> selectFileList(int plantNo); // 식물도감 이미지 리스트 출력
	public int insertPlant(Plant plant);// 식물도감 기본정보 등록
	public int insertDetailPlant(PlantInfo plantInfo);// 식물도감 상세정보 등록
	public int updatePlant(Plant plant);// 식물도감 수정
	public int updateDetailPlant(PlantInfo plantInfo);// 식물도감 상세정보 수정
	public int deletePlant(int plantNo);// 식물도감 삭제
	public int deleteAdminPlant(String checkNo);// 식물 도감 삭제(관리자)
	public ArrayList<Plant> selectSearchAllList(String search);//식물도감 검색
	public int selectOnePlant();
	public int insertPlantFile(PlantFile pFile);// 식물도감 파일 등록
	public int deletePlantFile(PlantFile plantFile);// 식물도감 파일 삭제
	public ArrayList<Plant> selectMemberCompanion(int memberNo);//멤버 반려식물 리스트 출력
	public int selectOneName(String plantName);
	public ArrayList<Plant> selectHashListName(String tag);
	public int updatePlantPoint(Plant plant); // 식물 포인트
	public ArrayList<Plant> selectAllRank(); // 식물 랭크
}
