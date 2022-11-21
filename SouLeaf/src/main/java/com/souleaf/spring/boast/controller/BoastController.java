package com.souleaf.spring.boast.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.common.BoastPagination;
import com.souleaf.spring.common.CuriosityPagination;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;
import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.companion.service.CompanionService;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.member.domain.Member;

@Controller
public class BoastController {

   @Autowired
   private BoastService bService;
   @Autowired
   private CompanionService cService;
  
   // 자랑하기 리스트 페이지 이동 및 출력 //////////
   @RequestMapping(value = "boastListView.kh", method = RequestMethod.GET)
   public ModelAndView boastListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,
         HttpServletRequest request) {
      HttpSession session = request.getSession();
      session.setAttribute("nav", "boast");
      session.setAttribute("fileName", "");
      int currentPage = (page != null) ? page : 1;
      int listCount = bService.getListCount();
      PageInfo pi = BoastPagination.getPageInfo(currentPage, listCount);
      ArrayList<Boast> bList = bService.printAll(pi);
      System.out.println(bList.toString());
      System.out.println("들어왔니?");
      if (!bList.isEmpty()) {
         mv.addObject("bList", bList);
         mv.addObject("pi", pi);
         mv.setViewName("Boast/boastListView");

      } else {
         mv.addObject("msg", "게시글 전체조회 실패");
         mv.setViewName("common/errorPage");
      }
      return mv;
   }

   // 자랑하기 리스트 출력
   /*
    * @RequestMapping(value="boastListView.kh") public void
    * getBoastList(HttpServletResponse response, @RequestParam(value = "page",
    * required = false) Integer page) throws Exception { int currentPage = (page !=
    * null) ? page : 1; int listCount = bService.getListCount(); PageInfo pi =
    * BoastPagination.getPageInfo(currentPage, listCount); ArrayList<Boast> bList =
    * bService.printAll(pi); if(! bList.isEmpty()) { Gson gson = new
    * GsonBuilder().setDateFormat("yyyy-MM-dd").create(); gson.toJson(bList,
    * response.getWriter()); }else { System.out.println("데이터가 없습니다"); } }
    */

   // 자랑하기 페이지 출력
   /*
    * @RequestMapping(value="boastPage.kh") public void
    * getBoastPage(HttpServletResponse response, @RequestParam(value = "page",
    * required = false) Integer page) throws Exception { int currentPage = (page !=
    * null) ? page : 1; int listCount = bService.getListCount(); PageInfo pi =
    * BoastPagination.getPageInfo(currentPage, listCount); Gson gson = new
    * GsonBuilder().setDateFormat("yyyy-MM-dd").create(); gson.toJson(pi,
    * response.getWriter()); }
    */

   // 자랑하기 상세페이지 이동 및 출력////////////
   @RequestMapping(value = "boastDetail.kh", method = { RequestMethod.GET, RequestMethod.POST })
   public ModelAndView boastDetailView(ModelAndView mv, @RequestParam("boastNo") int boastNo) {
      // 조회수 증가
      bService.addReadCount(boastNo);

      // 게시글 상세 조회
      Boast boast = bService.printOne(boastNo);
      if (boast != null) {
         // 메소드 체이닝 방식
         mv.addObject("boast", boast).setViewName("Boast/boastDetailView"); // 대소문자
      } else {
         mv.addObject("msg", "게시글 상세 조회 실패!!!!!!!!!!!!!");
         mv.setViewName("common/errorPage");
      }
      return mv;

   }

   // 자랑하기 등록화면 이동
   @RequestMapping(value = "boastWrite.kh") // 매핑 잘 확인하기
   public String boastWriterView( @RequestParam(value = "userNo", required = false) Integer userNo, Model model, HttpSession session) {
		/*
		 * Member member = (Member)session.getAttribute("loginUser"); int memberNo =
		 * member.getMemberNo();
		 */
	   int memberNo =  0;
	   if(userNo != null) {
		   Member member = (Member)session.getAttribute("loginUser");
		  memberNo =  member.getMemberNo();
	   }else {
		   memberNo =  0;
	   }
	   ArrayList<Companion> cList = cService.printmemberAll(memberNo);
	   if(! cList.isEmpty()) {
		   model.addAttribute("cList",cList);
		   return "Boast/boastWriteForm"; // 대소문자 확인 잘하기
	   }else {
		   model.addAttribute("cList","");
		   return "Boast/boastWriteForm"; // 대소문자 확인 잘하기
	   }
	   
   }

   
   // 자랑하기 게시글 등록
   @RequestMapping(value = "boastWrite.kh", method = RequestMethod.POST)
   public ModelAndView boastRegister(ModelAndView mv, @ModelAttribute Boast boast, @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest request) {

      HttpSession session = request.getSession();
      Member member = (Member) session.getAttribute("loginUser");
      String boastFileRename = (String)session.getAttribute("fileName");
      int memberNo = member.getMemberNo();
      boast.setMemberNo(memberNo);
      boast.setBoastFileRename(boastFileRename);
      int companionNo = boast.getCompanionNo();
      System.out.println("반려식물번호"+ companionNo);
      Companion cOne = cService.printOne(companionNo);
      boast.setPlantNo(cOne.getPlantNo());
     
      int result = bService.registerBoast(boast);   
      System.out.println(result);
      if (result > 0) {    	  
    	  mv.setViewName("redirect:boastListView.kh");
    	  session.setAttribute("fileName", "");
      } else {
       
      }
     return mv;
   }

   // 자랑하기 수정화면 이동

   // 자랑하기 수정화면 이동 2

   /*
    * @RequestMapping(value="boastUpdate.kh") public ModelAndView
    * boastUpdateView(ModelAndView mv,@RequestParam("boastNo") int
    * boastNo,@ModelAttribute Boast boast, @RequestParam(value = "page", required =
    * false) Integer page, @RequestParam(value = "count", required = false) Integer
    * count, Model model) { int currentPage = (page != null) ? page : 1; int
    * currentCount = (count != null) ? count : 0; boast =
    * bService.printOne(boastNo); if(boast != null) {
    * mv.addObject("page",currentPage).addObject("count",currentCount).addObject(
    * "boast",boast).setViewName("Boast/boastUpdateView"); }else {
    * 
    * } return mv; }
    */

   // 자랑하기 게시글 수정 1
   /*
    * @RequestMapping(value = "boastUpdate.kh", method = RequestMethod.POST) public
    * ModelAndView boastUpdate(ModelAndView mv, @ModelAttribute Boast boast,
    * MultipartHttpServletRequest multipartRequest, HttpServletRequest request,
    * Model model) { List<MultipartFile> bList =
    * multipartRequest.getFiles("ufile"); String root =
    * request.getSession().getServletContext().getRealPath("resources");
    * 
    * String filePath = root + "/uploadFiles/boast"; // 설정파일로 뺀다. File folder = new
    * File(filePath); if (!folder.exists()) { folder.mkdir(); } int result =
    * bService.modifyBoast(boast);
    * 
    * if (result > 0) { mv.setViewName("redirect:boastListView.kh"); } else {
    * mv.setViewName("common/errorPage"); } return mv; }
    */

   // 자랑하기 게시글 수정 
   @RequestMapping(value = "boastUpdate.kh", method = RequestMethod.POST)
   public ModelAndView boastUpdate(ModelAndView mv, Boast boast,
         @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
         @RequestParam(value = "page", required = false) Integer page,
         @RequestParam(value = "count", required = false) Integer count, Model model, HttpServletRequest request) {
      int currentPage = (page != null) ? page : 1;
      int currentCount = (count != null) ? count : 0;
      HttpSession session = request.getSession();
      Member member = (Member) session.getAttribute("loginUser");
      String boastFileRename = (String)session.getAttribute("fileName");
      int memberNo = member.getMemberNo();
      boast.setMemberNo(memberNo);
      boast.setBoastFileRename(boastFileRename);
      int companionNo = boast.getCompanionNo();
      System.out.println("반려식물번호"+ companionNo);
      Companion cOne = cService.printOne(companionNo);
      boast.setPlantNo(cOne.getPlantNo());
      int result = bService.modifyBoast(boast);
      System.out.println(result);
      if (result > 0) {
         mv.setViewName("redirect:boastDetail.kh?boastNo=" + boast.getBoastNo());
         session.setAttribute("fileName", "");
      } else {

      }
      return mv;
   }

   // 자랑하기 수정화면 이동
   @RequestMapping(value = "boastUpdateView.kh")
   public ModelAndView boastUpdateView(ModelAndView mv, @RequestParam("boastNo") int boastNo,
         @ModelAttribute Boast boast, @RequestParam(value = "page", required = false) Integer page,
         @RequestParam(value = "count", required = false) Integer count, Model model,HttpSession session) {
      int currentPage = (page != null) ? page : 1;
      int currentCount = (count != null) ? count : 0;
      Member member = (Member)session.getAttribute("loginUser");
	  int memberNo =  member.getMemberNo();
      ArrayList<Companion> cList = cService.printmemberAll(memberNo);
      Boast bOne = bService.printOne(boastNo);
      if (boast != null) {
         mv.addObject("page", currentPage).addObject("count", currentCount).addObject("boast", bOne).addObject("cList", cList)
               .setViewName("Boast/boastUpdateView");
      } else {

      }
      return mv;
   }

   // 자랑하기 게시글 삭제
   @RequestMapping(value = "boastDelete.kh", method = RequestMethod.GET)
   public String boastDelete(@RequestParam("boastNo") int boastNo, Model model, HttpServletRequest request) {
	   System.out.println(boastNo);
		int result = bService.removeBoast(boastNo);
		if(result > 0) {
			bService.removeBoastReplys(boastNo);
			return "redirect:boastListView.kh";
		}else {
			return "redirect:boastListView.kh";			
		}
   }

   // 자랑하기 댓글 리스트 출력

   // @ResponseBody

   @RequestMapping(value = "boastReplyList.kh")
   public void boastReplyListView(HttpServletResponse response, @RequestParam("boastNo") int boastNo, BoastReply reply,
         Model model) throws Exception {
      ArrayList<BoastReply> brList = bService.printAllBoastReply(boastNo);
      if (!brList.isEmpty()) {
         Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
         gson.toJson(brList, response.getWriter());
      } else {
         System.out.println("데이터가 없습니다");
      }
   }

   // 자랑하기 댓글 등록
   @ResponseBody
   @RequestMapping(value = "boastReplyRegister.kh", method = RequestMethod.POST)
   public String boastReplyRegister(@ModelAttribute BoastReply reply, HttpSession session) {
      Member loginUser = (Member) session.getAttribute("loginUser");
      reply.setMemberNo(loginUser.getMemberNo());
      int result = bService.registerBoastReply(reply);
      if (result > 0) {
         return result + "";
      } else {
         return result + "";
      }
   }
   
   // 자랑하기 답글 등록
   @ResponseBody
   @RequestMapping(value = "boastReReplyRegister.kh", method = RequestMethod.POST)
   public String boastReReplyRegister(@ModelAttribute BoastReply reply, HttpSession session) {
      Member loginUser = (Member) session.getAttribute("loginUser");
      reply.setMemberNo(loginUser.getMemberNo());
      int result = bService.registerBoastReReply(reply);
      if (result > 0) {
         return result + "";
      } else {
         return result + "";
      }
   }

   /*
    * public ModelAndView boastReplyRegister(ModelAndView mv, int boastNo,
    * BoastReply reply, MultipartFile uploadFile, Model model) { return null; }
    */
   // 자랑하기 댓글 수정

   @ResponseBody

   @RequestMapping(value = "boastReplyModify.kh", method = RequestMethod.POST)
   public String boastReplyModify(@ModelAttribute BoastReply reply, HttpSession session) {
      Member loginUser = (Member) session.getAttribute("loginUser");
      reply.setMemberNo(loginUser.getMemberNo());
      int result = bService.modifyBoastReply(reply);
      if (result > 0) {
         return result + "";
      } else {
         return result + "";
      }
   }

   // public ModelAndView boastReplyUpdate(ModelAndView mv, int boastNo, BoastReply
   // reply, MultipartFile uploadFile,
   // Model model) {
   // return null;

   // }

   // 자랑하기 댓글 삭제
   @ResponseBody
   @RequestMapping(value = "boastReplyDelete.kh", method = RequestMethod.POST)
   public String boastReplyDelete(@ModelAttribute BoastReply reply, HttpSession session) {
	   Member loginUser = (Member) session.getAttribute("loginUser");
	      reply.setMemberNo(loginUser.getMemberNo());
	      int result = bService.removeBoastReply(reply);
	      if (result > 0) {
	          return result + "";
	       } else {
	          return result + "";
	       }
	    }
   // 자랑하기 대댓글 삭제
   @ResponseBody
   @RequestMapping(value = "boastReReplyDelete.kh", method = RequestMethod.POST)
   public String boastReReplyDelete(@ModelAttribute BoastReply reply, HttpSession session) {
	   Member loginUser = (Member) session.getAttribute("loginUser");
	      reply.setMemberNo(loginUser.getMemberNo());
	      int result = bService.removeBoastReReply(reply);
	      if (result > 0) {
	          return result + "";
	       } else {
	          return result + "";
	       }
	    }

   // 파일 저장
   public String saveFile(MultipartFile file, HttpServletRequest request) {
      // 파일 저장 경로 설정
      String root = request.getSession().getServletContext().getRealPath("resources");
      String savePath = root + "/uploadFiles/boast";
      // 저장 폴더 선택
      File folder = new File(savePath);
      // 폴더없으면 자동 생성
      if (!folder.exists()) {
         folder.mkdir();
      }
      // 파일명 변경하기
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      String originalFileName = file.getOriginalFilename();
      String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "."
            + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
      // a.bc.jpg
      String filePath = folder + "/" + renameFileName;
      // 파일저장
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
   
	@ResponseBody
	@RequestMapping(value="boast_summer_image.kh",method = RequestMethod.POST)
	public void summer_image(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String server_file_name = saveFile(file, request);
		System.out.println("server file : " + server_file_name);
		
		out.println("resources/uploadFiles/boast/"+server_file_name);
		out.close();
		
	
	}
   

   // 저장된 파일 삭제
   public void deleteFile(String fileName, HttpServletRequest request) {

   }

   // 자랑하기 조회수 증가

   public ModelAndView boastAddReadCount(ModelAndView mv, int boastNo, Model model) {
      return null;
   }

   // 해시태그 출력
   public String getHashTagList(Boast boast, Model model) {
      return "";
   }

   // 자랑하기 좋아요 
   @ResponseBody
   @RequestMapping(value="boastLike.kh")
   public String boastLike(@ModelAttribute Boast boast, Model model) {
	   System.out.println(boast.toString());
	   int addCheck = bService.getLikeAddCheck(boast);
	   int result = 0;
	   if(addCheck > 0) {
		   int likeCheck = bService.getLikeCheck(boast);
		   if(likeCheck > 0) {
			   boast.setBoastLike(0);
			    result = bService.modifyBoastLike(boast);
		   }else {
			   boast.setBoastLike(1);
			    result = bService.modifyBoastLike(boast);
		   }
	   }else {
		    result = bService.registerBoastLike(boast);
	   }
      return result+"";
   }
   
   // 자랑하기 좋아요 수
   @ResponseBody
   @RequestMapping(value="getLikeCount.kh")
   public String getLikeCount(@RequestParam("boastNo") int boastNo, Model model) {
	  int count = bService.getLikeCount(boastNo);
      return count+"";
   }
   
   // 자랑하기 좋아요 체크
   @ResponseBody
   @RequestMapping(value="getLikeCheck.kh")
   public String getLikeCheck(@ModelAttribute Boast boast, Model model) {
	  int check = bService.getLikeCheck(boast);
      return check+"";
   }
   

   // 자랑하기 대댓글 등록

   // 자랑하기 대댓글 수정

   // 자랑하기 대댓글 삭제
}