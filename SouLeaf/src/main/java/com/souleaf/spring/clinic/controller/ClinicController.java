package com.souleaf.spring.clinic.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.common.ClinicPagination;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.companion.controller.CompanionController;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.plant.domain.Plant;

@Controller
public class ClinicController {
	@Autowired
	private ClinicService cService;
	
	private Logger log = LoggerFactory.getLogger(CompanionController.class);
	
	// 클리닉 리스트 페이지 이동 및 출력
	@RequestMapping(value="clinicListView.kh")
	public ModelAndView clinicListView(ModelAndView mv,@RequestParam(value = "page", required = false) Integer page ,@RequestParam(value = "count", required = false) Integer count, HttpServletRequest request) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		HttpSession session = request.getSession();
		session.setAttribute("nav", "clinic");
		session.setAttribute("fileName", "");
		mv.addObject("page",currentPage).addObject("count",currentCount).setViewName("clinic/clinicListView");
		return mv;
	}
	
	// 클리닉 리스트 출력
	@RequestMapping(value="clinicList.kh")
	public void getCuriosityList(HttpServletResponse response, @RequestParam(value = "page", required = false) Integer page) throws Exception {
		int currentPage = (page != null) ? page : 1;
		int listCount = cService.getClinicListCount();
		log.info("클리닉 카운트 : " + listCount);
		PageInfo pi = ClinicPagination.getPageInfo(currentPage, listCount);
		ArrayList<Clinic> cList = cService.printAllList(pi);
		log.info("클리닉 조회" + cList.toString());
		if(! cList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 클리닉 페이지 출력
	@RequestMapping(value="clinicPage.kh")
	public void getClinicPage(HttpServletResponse response, @RequestParam(value = "page", required = false) Integer page) throws Exception  {
		int currentPage = (page != null) ? page : 1;
		int listCount = cService.getClinicListCount();
		log.info("클리닉 카운트 : " + listCount);
		PageInfo pi = ClinicPagination.getPageInfo(currentPage, listCount);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(pi, response.getWriter());
	}
	
	// 클리닉 상세페이지 이동 및 출력
	@RequestMapping(value="clinicDetail.kh")
	public ModelAndView clinicDetailView(ModelAndView mv,@RequestParam("clinicNo") int clinicNo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, HttpSession session) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		cService.addViewCount(clinicNo);
		Clinic clinic = cService.printOne(clinicNo);
		log.info("클리닉 조회" + clinic.toString());
		
		// 좋아요 처리
		Member loginUser = (Member)session.getAttribute("loginUser");
		if (loginUser != null) {
		ClinicLike cLike = new ClinicLike();
		cLike.setClinicNo(clinicNo);
		cLike.setMemberNo(loginUser.getMemberNo());
		cLike = cService.printLike(cLike);
		mv.addObject("loginUser",loginUser);
		mv.addObject("cLike",cLike);
		}
		mv.addObject("page",currentPage).addObject("count",currentCount).addObject("clinic",clinic).setViewName("clinic/clinicDetail");
		return mv;
	}
	
	// 클리닉 등록화면 이동
	@RequestMapping(value="clinicWrite.kh")
	public String clinicWriterView() {
		return "clinic/clinicWrite";
	}
	
	// 클리닉 게시글 등록
	@RequestMapping(value="clinicRegister.kh", method = RequestMethod.POST)
	public ModelAndView clinicRegister(ModelAndView mv, Clinic clinic, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String clinicFileRename = (String)session.getAttribute("fileName");
		int memberNo = member.getMemberNo();
		clinic.setMemberNo(memberNo);	
		clinic.setClinicFileRename(clinicFileRename);
	
		int result = cService.registerClinic(clinic);
		log.info("클리닉 등록 :" + result);
		if(result > 0) {
			mv.setViewName("redirect:clinicListView.kh");
			session.setAttribute("fileName", "");
		}else {
			
		}
		return mv;
	}

	// 클리닉 수정화면 이동
	@RequestMapping(value="clinicModifyView.kh")
	public ModelAndView clinicUpdateView(ModelAndView mv,@RequestParam("clinicNo") int clinicNo,@ModelAttribute Clinic clinic, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		clinic = cService.printOne(clinicNo);
		log.info("클리닉 수정화면 이동 :" + clinic.toString());
		if(clinic != null) {
			mv.addObject("page",currentPage).addObject("count",currentCount).addObject("clinic",clinic).setViewName("clinic/clinicUpdate");
		}else {
			
		}
		return mv;
	}
	
	// 클리닉 게시글 수정
	@RequestMapping(value="clinicModify.kh",method = RequestMethod.POST)
	public ModelAndView clinicUpdate(ModelAndView mv, Clinic clinic, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model, HttpServletRequest request) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String clinicFileRename = (String)session.getAttribute("fileName");
		int memberNo = member.getMemberNo();
		clinic.setMemberNo(memberNo);	
		clinic.setClinicFileRename(clinicFileRename);
	
		int result = cService.modifyClinic(clinic);
		log.info("클리닉 수정화면 :" + result);
		if(result > 0) {
			mv.setViewName("redirect:clinicDetail.kh?clinicNo="+clinic.getClinicNo()+"&page="+currentPage+"&count="+currentCount);
			session.setAttribute("fileName", "");
		}else {
			
		}
		return mv;
	}
	
	// 클리닉 게시글 삭제
	@RequestMapping(value="clinicDelete.kh")
	public ModelAndView clinicDelete(ModelAndView mv, int clinicNo ,HttpServletRequest request) {
		int result = cService.removeClinic(clinicNo);
		log.info("클리닉 삭제 :" + result);
		if(result > 0) {
			cService.removeClinicReplys(clinicNo);
		}
		mv.setViewName("redirect:clinicListView.kh");
		return mv;
	}
	
	// 마이페이지 클리닉 게시글 삭제
		@RequestMapping(value="myClinicDelete.kh")
		public ModelAndView myClinicDelete(ModelAndView mv, int clinicNo ,HttpServletRequest request) {
			int result = cService.removeClinic(clinicNo);
			log.info("클리닉 삭제 :" + result);
			mv.setViewName("redirect:mypageBoard.kh");
			return mv;
		}
	
		// 클리닉 댓글 채택 출력
		@RequestMapping(value="clinicReplySelectionList.kh")
		public void clinicReplySelectionView(HttpServletResponse response,@RequestParam("clinicNo") int clinicNo, ClinicReply reply, Model model) throws Exception {
			ArrayList<ClinicReply> crOne = cService.printSelectionClinicReply(clinicNo);
			log.info("클리닉 댓글 :" + crOne.toString());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			gson.toJson(crOne, response.getWriter());
		}
		
		// 클리닉 댓글 채택 출력 
		@ResponseBody
		@RequestMapping(value="clinicReplySelectionModify.kh")
		public String clinicReplySelectionModify(HttpServletResponse response,@RequestParam("cliniccommentNo") int cliniccommentNo, ClinicReply reply, Model model) throws Exception {
			int result = cService.modifyReplySelection(cliniccommentNo);
			return result+"";
		}
		
		
	// 클리닉 댓글 리스트 출력
	@RequestMapping(value="clinicReplyList.kh")
	public void clinicReplyListView(HttpServletResponse response,@RequestParam("clinicNo") int clinicNo, ClinicReply reply, Model model) throws Exception {
		ArrayList<ClinicReply> crList = cService.printAllClinicReply(clinicNo);
		log.info("클리닉 댓글 :" + crList.toString());
		if(! crList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			gson.toJson(crList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 클리닉 댓글 등록
	@ResponseBody
	@RequestMapping(value="clinicReplyRegister.kh", method = RequestMethod.POST)
	public String clinicReplyRegister(@ModelAttribute ClinicReply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		reply.setMemberNo(loginUser.getMemberNo());
		int result = cService.registerClinicReply(reply);
		if(result > 0) {
			return result+"";
		}else {
			return result+"";
		}
	}
	
	// 클리닉 댓글 수정
	@ResponseBody
	@RequestMapping(value="clinicReplyModify.kh", method = RequestMethod.POST)
	public String clinicReplyModify(@ModelAttribute ClinicReply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		reply.setMemberNo(loginUser.getMemberNo());
		int result = cService.modifyClinicReply(reply);
		if(result > 0) {
			return result+"";
		}else {
			return result+"";
		}
	}
	
	// 클리닉 댓글 삭제
	@ResponseBody
	@RequestMapping(value="clinicReplyDelete.kh")
	public String clinicReplyDelete(@RequestParam("cliniccommentNo") int clinicNo, Model model) {
		int result = cService.removeClinicReply(clinicNo);
		return result+"";
	}
	
	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/clinic";
		// 저장 폴더 선택
		File folder = new File(savePath);
		// 폴더없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경하기 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		// indexof : 왼쪽부터 검색해서 .의 위치를 알려줌 , lastindexof : 오른쪽부터 .의 위치를 알려줌
		// abd.jpg => 확장자명을 가져오기 위해서 사용
		String renameFileName= sdf.format(new Date(System.currentTimeMillis()))+"."+originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		String filePath = folder +"/" + renameFileName;		
		
		// 파일 저장
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 리턴
		HttpSession session = request.getSession();
		session.setAttribute("fileName", renameFileName);
		return renameFileName;
	}
	
	// 저장된 파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
	// 클리닉 조회수 증가
	public ModelAndView clinicAddCount(ModelAndView mv, int clinicNo, Model model) {
		return null;
	}
	
	// 해시태그 출력
	public String getHashTagList(Plant plant, Model model) {
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="clinic_image.kh",method = RequestMethod.POST)
	public void clinic_image(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String server_file_name = saveFile(file, request);
		System.out.println("server file : " + server_file_name);
		
		out.println("resources/uploadFiles/clinic/"+server_file_name);
		out.close();
	
	}
	
    @RequestMapping("clickLike.kh")
    @ResponseBody
    public String clickLike(ModelAndView mv, @ModelAttribute ClinicLike clinicLike, HttpServletResponse response){
        log.info("request: /clickLike");

        int likeCheck = -1;
        try {
        	ClinicLike cLike = cService.printLike(clinicLike);
        	Clinic clinic = new Clinic();
            clinic.setClinicNo(clinicLike.getClinicNo());
            if(cLike == null) {
                //처음 좋아요 누른것 likecheck=1, 좋아요 빨간색이 되야됨
            	clinicLike.setLikeCheck(1);
            	cService.registerLike(clinicLike); //좋아요 테이블 인서트
            	cService.modifyRankLike(clinic); // 클리닉 좋아요 랭킹 포인트 + 1
            	likeCheck = 1;
            } else if(cLike.getLikeCheck() == 1) {
            	clinicLike.setLikeCheck(0);
            	cService. modifyLike(clinicLike); //좋아요 테이블 업데이트
            	cService.modifyRankunLike(clinic); // 클리닉 좋아요 랭킹 포인트 - 1
            	likeCheck = 0;
            } else {
            	clinicLike.setLikeCheck(1);
            	cService. modifyLike(clinicLike); //좋아요 테이블 업데이트
            	cService.modifyRankLike(clinic); // 클리닉 좋아요 랭킹 포인트 + 1
            	likeCheck = 1;
            }
            
        } catch (Exception e) {
            log.debug(e.getMessage());
            likeCheck = -1;
        }
        String check = Integer.toString(likeCheck);
        return check;
    }
    
    // 클리닉 검색
	@RequestMapping(value="clinicMainSearch.kh")
	public ModelAndView clinicMainSearch(ModelAndView mv,@RequestParam("searchValue") String search,@RequestParam(value = "page", required = false) Integer page ,@RequestParam(value = "count", required = false) Integer count,HttpServletRequest session) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;		
		session.setAttribute("nav", "clinic");
		session.setAttribute("fileName", "");
		mv.addObject("page",currentPage).addObject("count",currentCount).setViewName("clinic/clinicSearchListView");
		return mv;
	}
	
	// 클리닉 검색 리스트 출력
	@RequestMapping(value="clinicSearchList.kh")
	public void getClinicSearchList(HttpServletResponse response,@RequestParam("searchValue") String search, @RequestParam(value = "page", required = false) Integer page) throws Exception {
		int currentPage = (page != null) ? page : 1;
		System.out.println(search);
		int listCount = cService.getClinicSearchListCount(search);
		log.info("클리닉 검색 카운트 : " + listCount);
		PageInfo pi = ClinicPagination.getPageInfo(currentPage, listCount);
		ArrayList<Clinic> cList = cService.printAllSearchList(pi,search);
		log.info("클리닉 검색 조회" + cList.toString());
		if(! cList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 클리닉 검색 페이지 출력
	@RequestMapping(value="clinicSearchPage.kh")
	public void getClinicSearchPage(HttpServletResponse response,@RequestParam("searchValue") String search, @RequestParam(value = "page", required = false) Integer page) throws Exception  {
		int currentPage = (page != null) ? page : 1;
		int listCount = cService.getClinicSearchListCount(search);
		log.info("클리닉 써치 카운트 : " + listCount);
		PageInfo pi = ClinicPagination.getPageInfo(currentPage, listCount);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(pi, response.getWriter());
	}

}