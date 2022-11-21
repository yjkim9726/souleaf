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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.service.AnsService;
import com.souleaf.spring.qna.service.QnaService;

@Controller
public class QnaController {
	@Autowired
	private AnsService aService;
	@Autowired
	private QnaService qService;
	private Logger log = LoggerFactory.getLogger(QnaController.class);

	// 관리자가 볼땐 전체조회가 필요
	@RequestMapping(value = "qnaListView.kh", method = RequestMethod.GET)
	public ModelAndView qnaListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page, HttpSession session) {
		session.setAttribute("nav", "qna");
		int currentPage = (page != null) ? page : 1;
		try {
			int listCount = qService.getListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<Qna> qList = qService.printQnaAll(pi);
			ArrayList<Ans> aList = aService.printAnsAll();
			System.out.println(qList);
			mv.addObject("qList", qList);
			mv.addObject("aList", aList);
			mv.addObject("pi", pi);
			mv.setViewName("qna/qnaListView");
//			log.info("QnA 전체 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			//log.info("QnA 전체 조회 실패");
		}
		return mv;
	}

	// QnA 상세 조회
	@RequestMapping(value = "qnaDetail.kh", method = RequestMethod.GET)
	public ModelAndView qnaDetail(ModelAndView mv, @RequestParam("qnaNo") int qnaNo) {

		try {

			qService.addReadCount(qnaNo);
			Qna qna = qService.printQnaOne(qnaNo);
			mv.addObject("qna", qna);
			mv.setViewName("qna/qnaDetailView");
			log.info("QnA 상세 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("QnA 상세 조회 실패");
		}

		return mv;
	}

	// QnA 검색
	@RequestMapping(value = "qnaSearch.kh", method = RequestMethod.GET)
	public ModelAndView qnaSearch(ModelAndView mv, @ModelAttribute QnaSearch search) {
		try {

			ArrayList<Qna> searchList = qService.printSearchAll(search);
			mv.addObject("qList", searchList);
			mv.addObject("search", search);
			log.info("QnA 검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("QnA 검색 실패");
		}
		return mv;
	}

	// QnA 등록화면
	@RequestMapping(value = "qnaWriteView.kh", method = { RequestMethod.POST, RequestMethod.GET })
	public String qnaWriteView() {
		return "qna/qnaWriteView";
	}
	
	// QnA 등록기능
	@RequestMapping(value = "qnaRegister.kh", method = RequestMethod.POST)
	public ModelAndView qnaRegister(ModelAndView mv, @ModelAttribute Qna qna, HttpSession session, HttpServletRequest request) {
		Member member = (Member)session.getAttribute("loginUser");
		int memberNo = member.getMemberNo();
		qna.setMemberNo(memberNo);
		int result = 0;
		String path = "";
		result = qService.registerQna(qna);
		if(result > 0 ) {
			path = "redirect:qnaListView.kh";
		}else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "qnaRegister.kh";
		}
		mv.setViewName(path);
		return mv;
	}

	// QnA 수정화면
	@RequestMapping(value= "qnaModifyView.kh", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView qnaModifyView(ModelAndView mv, @RequestParam("qnaNo") int qnaNo) {
		try {

			Qna qna = qService.printQnaOne(qnaNo);
			mv.addObject("qna", qna);
			mv.setViewName("qna/qnaUpdateView");
			log.info("QnA 게시글 수정 페이지로 이동");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("QnA 게시글 수정 페이지로 이동 실패");
		}
		return mv;

	}
	@RequestMapping(value="qnaUpdate.kh", method=RequestMethod.POST)
	public ModelAndView qnaModify(ModelAndView mv, @ModelAttribute Qna qna) {
		int result = qService.modifyQna(qna);
		System.out.println(result);
		if(result > 0) {
			mv.setViewName("redirect:qnaListView.kh");
			
		}else {
			mv.setViewName("redirect:qnaListView.kh");
		}
		return mv;
		
	}
	// QnA 삭제
	@RequestMapping(value= "qnaDelete.kh", method=RequestMethod.GET)
	public String qnaDelete(Model model, @RequestParam("qnaNo") int qnaNo) {
		int result = qService.removeQna(qnaNo);
		if(result > 0) {
			return "redirect:mypageBoard.kh";
		}else {
			model.addAttribute("msg", "QnA 삭제 실패 ");
			log.info("QnA 삭제 실패");
			return "redirect:qnaList.kh";
		}
		
		
	}
}
