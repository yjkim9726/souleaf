package com.souleaf.spring.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.souleaf.spring.admin.domain.MemberStatus;
import com.souleaf.spring.admin.domain.TotalCount;
import com.souleaf.spring.admin.service.AdminService;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.service.CuriosityService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.service.PlantService;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.service.QnaService;

@Controller
public class AdminController {
	@Autowired
	private AdminService aService;
	@Autowired
	private QnaService qService;
	@Autowired
	private PlantService pService;
	@Autowired
	private MemberService mService;
	@Autowired
	private BoastService bService;
	@Autowired
	private CuriosityService cService;
	@Autowired
	private ClinicService nService;
	
	// 관리자 메인
	@RequestMapping(value = "adminHome.kh", method = RequestMethod.GET)
	public String adminHome(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "admin");
		TotalCount totalCount = new TotalCount();
		totalCount.setPlantCount(aService.printPlantCount());
		totalCount.setMemberCount(aService.printMemberCount());
		totalCount.setBoardCount(aService.printBoardCount());
		totalCount.setQnaCount(aService.printQNACount());
		model.addAttribute("totalCount",totalCount);
		return "admin/adminHome";
	}
	// 도감 관리 이동 및 출력
	@RequestMapping(value = "adminPlant.kh", method = RequestMethod.GET)
	public ModelAndView adminPlant(ModelAndView mv,HttpSession session) {
		session.setAttribute("nav", "admin");
		ArrayList<Plant> pList = pService.printAllList();
		mv.addObject("pList",pList).setViewName("admin/adminPlant");
		return mv;
	}
	// 도감 삭제
	@RequestMapping(value="adminPlantDelete.kh")
	public String adminPlantDelete(@RequestParam("plant-check") String[] checkBox) {
		String checkNo = "";
		for(String no : checkBox) {
			if(no.equals(checkBox[checkBox.length-1])) {
				checkNo += no;
			}else {
				checkNo += no+",";
			}
		}
		int result = pService.removeAdminPlant(checkNo);
		if(result > 0) {
			return "redirect:adminPlant.kh";
		}else {
			return "redirect:adminPlant.kh";
		}
	}
	// 회원 관리 이동 및 출력
		@RequestMapping(value = "adminMember.kh", method = RequestMethod.GET)
		public ModelAndView adminMember(ModelAndView mv,HttpSession session) {			
			session.setAttribute("nav", "admin");
			ArrayList<Member> mList = mService.selectAll();
			MemberStatus mStatus = aService.printMemberStatus();
			mv.addObject("mList",mList).addObject("mStatus",mStatus).setViewName("admin/adminMember");
			return mv;
		}
		// 멤버 상태변경
		@RequestMapping(value="adminMemberState.kh")
		public String adminMemberDelete(@RequestParam("member-check") String[] checkBox, @RequestParam("status") String status) {
			String checkNo = "";
			for(String no : checkBox) {
				if(no.equals(checkBox[checkBox.length-1])) {
					checkNo += no;
				}else {
					checkNo += no+",";
				}
			}
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", status);
			map.put("checkNo", checkNo);
			int result = aService.modifyMemberStatus(map);
			return "redirect:adminMember.kh";
		}
		// 게시글 관리 이동
		@RequestMapping(value = "adminBoard.kh", method = RequestMethod.GET)
		public ModelAndView adminBoard(ModelAndView mv, HttpSession session) {
			session.setAttribute("nav", "admin");
			mv.setViewName("admin/adminBoard");
			return mv;
		}
		
		// 자랑하기 리스트 출력
		@RequestMapping(value="adminBoastList.kh")
		public void getBoastList(HttpServletResponse response) throws Exception {
			ArrayList<Boast> bList = bService.printAll();			
			HashMap<String, ArrayList<Boast>> map = new HashMap<String, ArrayList<Boast>>();
			map.put("data", bList);
			if(! bList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(map, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
		// 자랑하기 삭제
		@ResponseBody
		@RequestMapping(value="adminBoastDelete.kh")
		public String adminBoastDelete(@RequestParam("checkNo") String checkNo) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("checkNo", checkNo);
			int result = bService.removeAdminBoast(map);			
			return result+"";
		}
		
		// 궁금해요 리스트 출력
		@RequestMapping(value="adminCuriosityList.kh")
		public void getCuriosityList(HttpServletResponse response) throws Exception {
			ArrayList<Curiosity> cList = cService.printAll();		
			HashMap<String, ArrayList<Curiosity>> map = new HashMap<String, ArrayList<Curiosity>>();
			map.put("data", cList);
			if(! cList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(map, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
		
		// 궁금해요 삭제
		@ResponseBody
		@RequestMapping(value="adminCuriosityDelete.kh")
		public String adminCuriosityDelete(@RequestParam("checkNo") String checkNo) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("chkNo", checkNo);
			int result = cService.removeMyCuriosity(map);			
			return result+"";
		}
		
		// 클리닉 리스트 출력
		@RequestMapping(value="adminClinicList.kh")
		public void getClinicList(HttpServletResponse response) throws Exception {
			ArrayList<Clinic> nList = nService.printAll();		
			HashMap<String, ArrayList<Clinic>> map = new HashMap<String, ArrayList<Clinic>>();
			map.put("data", nList);
			if(! nList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(map, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
		// 클리닉 삭제
		@ResponseBody
		@RequestMapping(value="adminClinicDelete.kh")
		public String adminClinicDelete(@RequestParam("checkNo") String checkNo) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("chkNo", checkNo);
			int result = nService.removeAdminClinic(map);		
			return result+"";
		}
		// qna 관리 이동
		@RequestMapping(value="adminQna.kh", method = RequestMethod.GET) 
		public String adminQna() {
			return "admin/adminQna";
		
			
		}
		// qna 리스트 출력
		@RequestMapping(value="adminQnaList.kh")
		public void getQnaList(HttpServletResponse response) throws Exception {
			ArrayList<Qna> qList = qService.printAdminAll();		
			HashMap<String, ArrayList<Qna>> map = new HashMap<String, ArrayList<Qna>>();
			map.put("data", qList);
			if(! qList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(map, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
		// qna 삭제
				@ResponseBody
				@RequestMapping(value="adminQnaDelete.kh")
				public String adminQnaDelete(@RequestParam("checkNo") String checkNo) {
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("chkNo", checkNo);
					System.out.println(checkNo);
					int result = qService.removeAdminQna(map);
					return result+"";
				}
}
