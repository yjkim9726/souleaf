package com.souleaf.spring.qna.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.AnsSearch;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.service.AnsService;
import com.souleaf.spring.qna.service.QnaService;

@Controller
public class AnsController {
	@Autowired
	private QnaService qService;
	@Autowired
	private AnsService aService;
	private Logger log = LoggerFactory.getLogger(AnsController.class);
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		log.info("get index");
	}
	
	// 관리자 전체 조회
	@RequestMapping(value="ansListView.kh", method=RequestMethod.GET)
	public ModelAndView ansList(ModelAndView mv, @RequestParam(value= "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		try {
//			int listCount = aService.getListCount();
//			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
//			ArrayList<Ans> aList = aService.printAnsAll(pi);
//			mv.addObject("aList", aList);
//			mv.addObject("pi", pi);
			mv.setViewName("ans/ansListView");
			log.info("AnS 전체 조회 성공");
		}catch (Exception e) {
			e.printStackTrace();
			log.info("AnS 전체 조회 실패");
			
		}
		return mv;
	}
	
	// AnS 상세 조회
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView ansDetail(ModelAndView mv, @RequestParam("ansNo") int ansNo) {
		try {
			aService.addReadCount(ansNo);
			Ans ans = aService.printAnsOne(ansNo);
			mv.addObject("ans", ans);
			mv.setViewName("ans/ansDetailView");
			log.info("AnS 상세 조회 성공");
		}catch (Exception e) {
			e.printStackTrace();
			log.info("AnS 상세 조회 실패");
		}
			return mv;
		
	}
	
	// AnS 검색
	
	@RequestMapping(value = "ansSearch.kh", method = RequestMethod.GET)
	public ModelAndView ansSearch(ModelAndView mv, @ModelAttribute AnsSearch search) {
		try {
			ArrayList<Ans> searchList = aService.printSearchAll(search);
			mv.addObject("aList", searchList);
			mv.addObject("search", search);
			log.info("AnS 검색 성공");
		}catch (Exception e) {
			e.printStackTrace();
			log.info("AnS 검색 실패");
		}
		
		return mv;
		
	}
		
	
	@RequestMapping(value="ansWriteView.kh", method=RequestMethod.GET)
	public String ansWriteView(@RequestParam("qnaNo") int qnaNo, Model model) {
		Qna qna = qService.printQnaOne(qnaNo);
		model.addAttribute("qnaNo", qnaNo);
		model.addAttribute("qna", qna);
		return "ans/ansWriteView";
	}
	@RequestMapping(value="ansUpdateView.kh", method=RequestMethod.GET)
	public String ansUpdateView(@RequestParam("qnaNo") int qnaNo, Model model) {
		Qna qna = qService.printQnaOne(qnaNo);
		Ans ans = aService.printAnsOne(qnaNo);
		model.addAttribute("qnaNo", qnaNo);
		model.addAttribute("qna", qna);
		model.addAttribute("ans", ans);
		
		return "ans/ansUpdateView";
	}
	@RequestMapping(value = "ansRegister.kh", method = RequestMethod.POST)
	public ModelAndView ansRegister(ModelAndView mv, @ModelAttribute Ans ans, HttpSession session, HttpServletRequest request) {
		Member member = (Member)session.getAttribute("loginUser");
		int memberNo = member.getMemberNo();
		ans.setMemberNo(memberNo);
		int result = 0;
		String path = "";
		System.out.println(ans.toString());
		result = aService.registerAns(ans);
		if(result > 0 ) {
			path = "redirect:qnaListView.kh";
		}else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "ansRegister.kh";
		}
		mv.setViewName(path);
		return mv;
	}
	
	// AnS 수정
	@RequestMapping(value= "ansModify.kh", method = RequestMethod.POST)
	public ModelAndView ansModifyView(ModelAndView mv, @ModelAttribute Ans ans) {
			int result = aService.modifyAns(ans);
			if(result > 0) {
				
				mv.setViewName("redirect:adminQna.kh");
			}
			return mv;

	}
	@RequestMapping(value= "ansDelete.kh", method=RequestMethod.GET)
	public String qnaDelete(Model model, @RequestParam("ansNo") int ansNo) {
		int result = aService.removeAns(ansNo);
		if(result > 0) {
			return "redirect:ansList.kh";
		}else {
			model.addAttribute("msg", "AnS 삭제 실패 ");
			log.info("AnS 삭제 실패");
			return "redirect:ansList.kh";
		}
		
	}
}

