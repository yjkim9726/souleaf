package com.souleaf.spring.plant.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.service.PlantService;
@Controller
public class PlantController {
	@Autowired
	private PlantService pService;
	
		// 식물도감 리스트 페이지 이동 및 출력
		@RequestMapping(value="plantListView.kh")
		public ModelAndView plantListView(ModelAndView mv, HttpServletRequest request, @RequestParam(value = "kind", required = false) String kindValue, @RequestParam(value = "property", required = false) String proValue,@RequestParam(value = "leaf", required = false) String leafValue ) {
			String kind = (kindValue != null) ? kindValue : "0";
			String property = (proValue != null) ? proValue : "0";
			String leaf = (leafValue != null) ? leafValue : "0";
			HttpSession session = request.getSession();
			session.setAttribute("nav", "plant");
			mv.addObject("kind",kind).addObject("property",property).addObject("leaf",leaf).setViewName("plant/plantListView");
			
			return mv;
		}
		
		// 식물도감 리스트 출력
		@RequestMapping(value="plantList.kh")
		public void getPlantList(HttpServletResponse response, @RequestParam("current") int current) throws Exception {
			ArrayList<Plant> pList = pService.printAllList();
			if(! pList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(pList, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
		
		@RequestMapping(value="plantSelect.kh")
		public void getPlantSelectList(HttpServletResponse response,@RequestParam("plantKind") String plantKind,@RequestParam("plantProperty") String plantProperty,@RequestParam("plantLeaf") String plantLeaf) throws Exception{
			HashMap<String, String> plantSelect = new HashMap<String, String>();
			plantSelect.put("plantKind", plantKind);
			plantSelect.put("plantProperty", plantProperty);
			plantSelect.put("plantLeaf", plantLeaf);
			
			ArrayList<Plant> pList = pService.printSelectList(plantSelect);
			if(!pList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(pList, response.getWriter());
			}else {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(pList, response.getWriter());
				System.out.println("데이터가 없습니다");
			}
		}
		
		// 식물도감 검색페이지 이동 및 출력
		@RequestMapping(value="plantSearch.kh")
		public ModelAndView plantSearchView(ModelAndView mv,@RequestParam("search") String search,HttpServletRequest session) {
			session.setAttribute("nav", "plant");
			ArrayList<Plant> pList = pService.printSearchAllList(search);
			if(! pList.isEmpty()) {
				mv.addObject("pList",pList).setViewName("plant/plantSearchView");
			}else {
				mv.addObject("pList",null).addObject("search",search).setViewName("plant/plantSearchView");
			}
			return mv;
		}
		
		
		// 식물도감 상세페이지 이동 및 출력
		@RequestMapping(value="plantDetail.kh")
		public ModelAndView plantDetailView(ModelAndView mv,@RequestParam("plantNo") int plantNo,HttpSession session) {
			session.setAttribute("nav", "plant");
			Plant plant = pService.printOne(plantNo);
			PlantInfo pInfo = pService.printOneInfo(plantNo);
			ArrayList<PlantFile> pfList = pService.printFileList(plantNo);
			mv.addObject("plant",plant);
			mv.addObject("pInfo",pInfo);
			mv.addObject("pfList",pfList);
			mv.setViewName("plant/plantDetail");
			return mv;
		}
		
		// 식물도감 상세페이지 이동 및 출력
		@RequestMapping(value="plantDetailName.kh")
		public ModelAndView plantDetailNameView(ModelAndView mv,@RequestParam("plantName") String plantName,HttpSession session) {
			session.setAttribute("nav", "plant");
			int plantNo = pService.printOneName(plantName);
			Plant plant = pService.printOne(plantNo);
			PlantInfo pInfo = pService.printOneInfo(plantNo);
			ArrayList<PlantFile> pfList = pService.printFileList(plantNo);
			mv.addObject("plant",plant);
			mv.addObject("pInfo",pInfo);
			mv.addObject("pfList",pfList);
			mv.setViewName("plant/plantDetail");
			return mv;
		}
		
		
		// 식물도감 등록화면 이동
		@RequestMapping(value="plantWrite.kh")
		public String plantWriterView() {
			return "plant/plantWrite";
		}
		
		    
		// 식물도감 게시글 등록
		@RequestMapping(value="plantRegister.kh", method = RequestMethod.POST)
		public ModelAndView plantRegister(ModelAndView mv, @ModelAttribute Plant plant, @ModelAttribute PlantInfo plantInfo, MultipartHttpServletRequest multipartRequest, HttpServletRequest request,Model model) {
			List<MultipartFile> fList = multipartRequest.getFiles("ufile");
			  String root = request.getSession().getServletContext().getRealPath("resources");
			  
		      String filePath = root+"/uploadFiles/plant"; //설정파일로 뺀다.
		        File folder = new File(filePath);
		        if(!folder.exists()) {
		        	folder.mkdir();
		        }
		        int result = pService.registerPlant(plant, plantInfo, fList, filePath);
		       
			if(result > 0) {
				mv.setViewName("redirect:adminPlant.kh");
			}else {
				mv.setViewName("common/errorPage");
			}
			return mv;
		}

		// 식물도감 수정화면 이동
		@RequestMapping(value="plantUpdateView.kh")
		public ModelAndView plantUpdateView(ModelAndView mv, @RequestParam("plantNo") int plantNo, Model model) {
			Plant plant = pService.printOne(plantNo);
			PlantInfo pInfo = pService.printOneInfo(plantNo);
			ArrayList<PlantFile> pfList = pService.printFileList(plantNo);
			mv.addObject("plant",plant);
			mv.addObject("pInfo",pInfo);
			mv.addObject("pfList",pfList);
			mv.setViewName("plant/plantUpdate");
			return mv;
		}
		
		// 식물도감 게시글 수정
		@RequestMapping(value="plantUpdate.kh", method = RequestMethod.POST)
		public ModelAndView plantUpdate(ModelAndView mv, @ModelAttribute Plant plant, @ModelAttribute PlantInfo plantInfo, MultipartHttpServletRequest multipartRequest, HttpServletRequest request,Model model) {
			List<MultipartFile> fList = multipartRequest.getFiles("ufile");
			  String root = request.getSession().getServletContext().getRealPath("resources");
			  
		      String filePath = root+"/uploadFiles/plant"; //설정파일로 뺀다.
		        File folder = new File(filePath);
		        if(!folder.exists()) {
		        	folder.mkdir();
		        }
		        int result = pService.modifyPlant(plant, plantInfo, fList, filePath);
		       
			if(result > 0) {
				mv.setViewName("redirect:adminPlant.kh");
			}else {
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
		
		// 식물도감 게시글 삭제
		public String plantDelete(int plantNo, Model model, HttpServletRequest request) {
			return "";
		}
		
		
		// 파일 저장
		public String saveFile(MultipartFile file, HttpServletRequest request) {
			return "";
		}
		
		// 저장된 파일 삭제
		@ResponseBody
		@RequestMapping(value="deleteFile.kh")
		public String deleteFile(@ModelAttribute PlantFile plantFile,HttpServletRequest request,HttpServletResponse reponse) {
			deleteFile(plantFile.getPlantFileRename(),request);
			int result = pService.removeFile(plantFile);
			if(result > 0) {
				return result+"";
				
			}else {
				return result+"";
			}
		}
	
		//  파일 삭제
		public void deleteFile(String fileName,HttpServletRequest request) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "/uploadFiles/plant";
			File file = new File(savePath + "/" +fileName);
			if(file.exists()) {
				file.delete();
			}
		}
	

}
