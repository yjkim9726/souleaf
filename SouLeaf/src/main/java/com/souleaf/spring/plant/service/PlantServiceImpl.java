package com.souleaf.spring.plant.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.store.PlantStore;
@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlantStore pStore;

	@Override
	public ArrayList<Plant> printAllList() {
		return pStore.selectAllList();
	}

	@Override
	public Plant printOne(int plantNo) {
		return pStore.selectOne(plantNo);
	}

	@Override
	public int registerPlant(Plant plant, PlantInfo plantInfo, List<MultipartFile> fList, String filePath) {
		int result = 0;
		int basicResult = 0;
		int detailResult = 0;
		int fileResult = 1;
		
		basicResult = pStore.insertPlant(plant);
		detailResult = pStore.insertDetailPlant(plantInfo);
		int plantNo = pStore.selectOnePlant();
		int fileNo = 0;
		for(MultipartFile mf : fList) {
			fileNo ++;
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			 String originalFilename = mf.getOriginalFilename(); //파일명
			 String renameFilename = fileNo+sdf.format(new Date(System.currentTimeMillis()))+"."+originalFilename.substring(originalFilename.lastIndexOf(".")+1);// 서버파일명
	         String fileFullPath = filePath+"/"+renameFilename; //파일 전체 경로
	         long fileSize = mf.getSize(); // 파일사이즈
	         try {
	                //파일 저장
	                PlantFile pFile = new PlantFile(originalFilename, fileFullPath, fileSize, plantNo, renameFilename);
	                fileResult *= pStore.insertPlantFile(pFile);
	                mf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
	     
	            } catch (Exception e) {
	                System.out.println("postTempFile_ERROR======>"+fileFullPath);
	                e.printStackTrace();
	            }
		}
		result = basicResult * detailResult * fileResult;
		return result;
	}

	@Override
	public int modifyPlant(Plant plant, PlantInfo plantInfo, List<MultipartFile> fList, String filePath) {
		int result = 0;
		int basicResult = 0;
		int detailResult = 0;
		int fileResult = 1;
		
		basicResult = pStore.updatePlant(plant);
		detailResult = pStore.updateDetailPlant(plantInfo);
		int plantNo = plant.getPlantNo();
		int fileNo = 0;
			for(MultipartFile mf : fList) {
				if(mf.getOriginalFilename() != "") {
					fileNo ++;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String originalFilename = mf.getOriginalFilename(); //파일명
					String renameFilename = fileNo+sdf.format(new Date(System.currentTimeMillis()))+"."+originalFilename.substring(originalFilename.lastIndexOf(".")+1);// 서버파일명
					String fileFullPath = filePath+"/"+renameFilename; //파일 전체 경로
					long fileSize = mf.getSize(); // 파일사이즈
					try {
						//파일 저장
						PlantFile pFile = new PlantFile(originalFilename, fileFullPath, fileSize, plantNo,renameFilename);
						fileResult *= pStore.insertPlantFile(pFile);
						mf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
					} catch (Exception e) {
						System.out.println("postTempFile_ERROR======>"+fileFullPath);
						e.printStackTrace();
					}
				}
			}
		result = basicResult * detailResult * fileResult;
		return result;
	}

	@Override
	public int removePlant(int plantNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Plant> printSearchAllList(String search) {
		return pStore.selectSearchAllList(search);
	}

	@Override
	public PlantInfo printOneInfo(int plantNo) {
		return pStore.selectOneInfo(plantNo);
	}

	@Override
	public ArrayList<PlantFile> printFileList(int plantNo) {
		return pStore.selectFileList(plantNo);
	}

	@Override
	public int removeFile(PlantFile plantFile) {
		return pStore.deletePlantFile(plantFile);
	}

	@Override
	public ArrayList<Plant> printSelectList(HashMap<String, String> plantSelect) {
		return pStore.selectChoiceList(plantSelect);
	}

	@Override
	public ArrayList<Plant> printMemberCompanion(int memberNo) {
		return pStore.selectMemberCompanion(memberNo);
	}

	@Override
	public int removeAdminPlant(String checkNo) {
		return pStore.deleteAdminPlant(checkNo);
	}

	@Override
	public int printOneName(String plantName) {
		return pStore.selectOneName(plantName);
	}

	@Override
	public ArrayList<Plant> printHashListName(String tag) {
		return pStore.selectHashListName(tag);
	}

	@Override
	public int modifyPlantPoint(Plant plant) {
		return pStore.updatePlantPoint(plant);
	}

	@Override
	public ArrayList<Plant> printAllRank() {
		return pStore.selectAllRank();
	}
	

}
