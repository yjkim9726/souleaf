package com.souleaf.spring.diary.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.PersistenceExceptionTranslationInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.companion.service.CompanionService;
import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.service.DiaryService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.service.PlantService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	@Autowired
	private CompanionService cService;
	
	@Autowired
	private PlantService pService;
	
	@Autowired
	private MemberService mService;
	
	// 상단의 성장일기 클릭시 화면 이동
	@RequestMapping(value="diaryMainView.kh")
	public ModelAndView diaryView(ModelAndView mv, HttpSession session,@RequestParam("memberNo") int memberNo) {
		session.setAttribute("nav", "");
		ArrayList<Plant> pList = pService.printMemberCompanion(memberNo);
		mv.addObject("pList", pList);
		mv.setViewName("diary/diaryMain");
		return mv;
	}
	
	// 다른 사람 성장일기 들어가기
	// requsetParam : 다른사람 일기를 들어갈때 그 일기의 주인의 memberNo
	@RequestMapping(value="diaryMainOtherView.kh")
	public ModelAndView diaryviewOther(ModelAndView mv, @RequestParam("memberDiary") int memberNo, HttpSession session) {
		Member member = mService.printMember(memberNo);
		ArrayList<Plant> pList = pService.printMemberCompanion(memberNo);
		session.setAttribute("nav", "");
		mv.addObject("pList", pList);
		mv.addObject("member", member);
		mv.addObject("memberDiary", memberNo);
		mv.setViewName("diary/diaryMainOther");
		return mv;
	}
	
	// 내 반려식물 닉네임 불러오기
	@RequestMapping(value="myCompanionList.kh", method=RequestMethod.GET)
	public void companionList(HttpServletResponse response,@RequestParam("memberNo") int memberNo) throws Exception {
		// 반려식물 전체 가져오는 메소드 = printAll()
		ArrayList<Companion> cList = cService.printmemberAll(memberNo);
		System.out.println();
		if(!cList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cList, response.getWriter());
		} else {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cList, response.getWriter());
		}
	}	
	
	// 일기 달력에 뿌려주는 리스트 가져오기
	// 물주는날은 어떻게 가져올까??
	// diaryNo은 어떻게 가져올까??
	@RequestMapping(value="diaryList.kh",method=RequestMethod.GET)
	public void diaryList(HttpServletResponse response, @RequestParam("memberNo") int memberNo) throws Exception {
		ArrayList<Diary> dList = dService.printAllDiary(memberNo);
		if(!dList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(dList, response.getWriter());
		} else {
			System.out.println("일기리스트 가 없습니다.");
		}
	} 
	
	// 이놈은 필요없다!
	// 일기 상세 불러오기
	@RequestMapping(value="detailDiary.kh", method=RequestMethod.POST)
	public ModelAndView diaryDetailView(ModelAndView mv, @RequestParam("diaryNo") int diaryNo) {	
		try {
			Diary diary = dService.printOneDiary(diaryNo);
			mv.addObject("diary",diary).setViewName("redirect:dirayMainView.kh");
		}catch(Exception e){
			e.printStackTrace();
			mv.setViewName("redirect:dirayMainView.kh");
		}
		return null;
	}
	
   // 일기 등록하기
   @RequestMapping(value="addDiary.kh", method=RequestMethod.POST)
   public String registerDiary(@ModelAttribute Diary diary, @RequestParam("companionLastWater") String companionLastWater, @RequestParam("companionNo") int companionNo, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile ,HttpServletRequest request, HttpSession session ) throws Exception {
      try {
         // 서버에 데이터를 저장하는 작업
         if (!uploadFile.getOriginalFilename().equals("")) {
            String renameFileName = saveFile(uploadFile, request);
            if (renameFileName != null) {
               diary.setDiaryPicname(uploadFile.getOriginalFilename());
               diary.setDiaryRepicname(renameFileName);
            }
         }
         Member loginUser = (Member) session.getAttribute("loginUser");
         diary.setMemberNo(loginUser.getMemberNo());
         int diaryNo = dService.registerDiary(diary);
         // if 일기 등록 성공
         if (diaryNo > 0) {
            // 반려식물 정보 취득
            Companion companion = cService.printOne(diary.getCompanionNo());
            // 물 줘야하는날 SET
            companion.setCompanionLastWater(companionLastWater);
            // 데이터 포멧
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // 캘린더 선언
            Calendar cal = Calendar.getInstance();
            Date date = (Date) sdf.parse(companionLastWater);
            // 물준날 세팅
            cal.setTime(date);
            // Plant 줄주기 대입
            Plant plant = pService.printOne(companion.getPlantNo());
            int plantWater = Integer.parseInt(plant.getPlantWater());
            // 물준날 + 물주기 날짜
            cal.add(Calendar.DATE, plantWater);
            // set 물 주는날
            String dateToStr = sdf.format(cal.getTime());
            companion.setCompanionNeedWater(dateToStr);
            // 물 줘야 하는 날 수정
            cService.modifyCompanion(companion);

            // 기존의 물줘야 하는 날 다이어리 삭제
            Diary reDiary = new Diary();
            reDiary.setDiaryStatus("W");
            reDiary.setCompanionNo(companion.getCompanionNo());
            reDiary.setMemberNo(diary.getMemberNo());
            dService.removeReDiary(reDiary);

            // 지우고 새로운 물 줘야하는날 등록
            reDiary.setDiaryStartDate(dateToStr);
            reDiary.setDiaryTitle(companion.getCompanionNick() + " 물줘!");
            reDiary.setdiaryColor("#4d638c");
            reDiary.setImgUrl("resources/images/watericon.png");
            dService.registerDiary(reDiary);
            return "redirect:diaryMainView.kh?memberNo="+diary.getMemberNo();
         }
      } catch (Exception e) {
         e.printStackTrace();
      } 
      return "redirect:diaryMainView.kh?memberNo="+diary.getMemberNo();
   }
	
	// 파일 저장하기
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/diary";
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
		return renameFileName;
	}
	
	// 이건 필요없어 아마도..
	public String diaryModifyView() {
		return null;
	};
	
	// 일기 수정하기
	@ResponseBody
	@RequestMapping(value = "diaryUpdate.kh", method = RequestMethod.POST)
	public String diaryUpdate(@ModelAttribute Diary diary,
			@RequestParam("companionLastWater") String companionLastWater, HttpServletRequest request,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) {
		try {

			// 파일 삭제 후 업로드 (수정)
			if (uploadFile != null && !uploadFile.isEmpty()) {
				// 기존 파일 삭제
				if (diary.getDiaryPicname() != "") {
					deleteFile(diary.getDiaryRepicname(), request);
				}
				// 새 파일 업로드
				String diaryRepicname = saveFile(uploadFile, request);
				if (diaryRepicname != null) {
					diary.setDiaryPicname(uploadFile.getOriginalFilename());
					diary.setDiaryRepicname(diaryRepicname);
				}
			}
			int result = dService.modifyDiary(diary);
			// if 일기 등록 성공
			if (result > 0) {
				// 반려식물 정보 가져오기
				Companion companion = cService.printOne(diary.getCompanionNo());
				companion.setCompanionLastWater(companionLastWater);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 캘린더 선언
				Calendar cal = Calendar.getInstance();
				Date date = (Date) sdf.parse(companionLastWater);
				// 물준날 세팅
				cal.setTime(date);
				// Plant 줄주기 대입
				Plant plant = pService.printOne(companion.getPlantNo());
				int plantWater = Integer.parseInt(plant.getPlantWater());
				// 물준날 + 물주기 날짜
				cal.add(Calendar.DATE, plantWater);
				// set 물 주는날
				String dateToStr = sdf.format(cal.getTime());
				companion.setCompanionNeedWater(dateToStr);
				// 물 줘야 하는 날 수정
				cService.modifyCompanion(companion);

				// 기존의 물줘야 하는 날 다이어리 삭제
				Diary reDiary = new Diary();
				reDiary.setDiaryStatus("W");
				reDiary.setCompanionNo(companion.getCompanionNo());
				reDiary.setMemberNo(diary.getMemberNo());
				dService.removeReDiary(reDiary);

				// 지우고 새로운 물 줘야하는날 등록
				reDiary.setDiaryStartDate(dateToStr);
				reDiary.setDiaryTitle(companion.getCompanionNick() + " 물줘!");
				reDiary.setdiaryColor("#4d638c");
				reDiary.setImgUrl("resources/images/watericon.png");
				dService.registerDiary(reDiary);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
 	// 일기 삭제하기
	@RequestMapping(value = "diaryDelete.kh", method = RequestMethod.GET)
	public void diaryDelete(@ModelAttribute Diary diary, @RequestParam("diaryRepicname") String diaryRepicname,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultYN = "";
		HashMap<String, Object> diaryMap = new HashMap<String, Object>();
		try {
			// 업로드된 파일 삭제
			if (diaryRepicname != "") {
				deleteFile(diaryRepicname, request);
			}
			dService.removeDiary(diary);
			resultYN = "success";
		} catch (Exception e) {
			e.printStackTrace();
			resultYN = "fail";
		} finally {
			diaryMap.put("resultYN", resultYN);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 날짜 포맷 변경!
			// ArrayList에서 gson형태로 변환시켜준다.
			gson.toJson(diaryMap, response.getWriter());
		}
	}
	
	// 저장된 파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resuorces");
		String savePath = root + "/uploadFiles/diary";
		File file = new File(savePath + "/" + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
	
	// 일기 등록 웅앵,.,,
	public void changeWater(int companionNo, int memberNo) throws Exception {
		Companion companion = cService.printOne(companionNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 캘린더 선언
		Calendar cal = Calendar.getInstance();
		Date date = (Date) sdf.parse(companion.getCompanionLastWater());
		// 물준날 세팅
		cal.setTime(date);
		// Plant 줄주기 대입
		Plant plant = pService.printOne(companion.getPlantNo());
		int plantWater = Integer.parseInt(plant.getPlantWater());
		// 물준날 + 물주기 날짜
		cal.add(Calendar.DATE, plantWater);
		// set 물 주는날 
		String dateToStr = sdf.format(cal.getTime());
		companion.setCompanionNeedWater(dateToStr);
		// 물 줘야 하는 날 수정
		cService.modifyCompanion(companion);
		
		// 기존의 물줘야 하는 날 다이어리 삭제
		Diary reDiary = new Diary();
		reDiary.setDiaryStatus("W");
		reDiary.setCompanionNo(companionNo);
		reDiary.setMemberNo(memberNo);
		dService.removeReDiary(reDiary);
		
		// 지우고 새로운 물 줘야하는날 등록
		reDiary.setDiaryStartDate(dateToStr);
		reDiary.setDiaryTitle(companion.getCompanionNick()+" 물줘!");
		reDiary.setdiaryColor("#4d638c");
		reDiary.setImgUrl("resources/images/watericon.png");
		dService.registerDiary(reDiary);
			
	}
	
	// 방명록 전체 조회
	@RequestMapping(value="guestbookList.kh", method=RequestMethod.GET)
	public void guestbookList(HttpServletResponse response, HttpSession session ,@RequestParam("memberDiary") int memberDiary) throws JsonIOException, IOException {
		ArrayList<Guestbook> gList = dService.printAllGuestbook(memberDiary);
		if(!gList.isEmpty()) {
			//gson을 사용해 결과리스트 리턴(response)하기
			//gson이란? Java Object를 쉽게 JSON으로 변환시켜주는 라이브러리
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 날짜 포맷 변경!
			//ArrayList에서 gson형태로 변환시켜준다.
			gson.toJson(gList, response.getWriter());
		} else {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 날짜 포맷 변경!
			//ArrayList에서 gson형태로 변환시켜준다.
			gson.toJson("null", response.getWriter());
		}
	}
	// 방명록 등록
	@ResponseBody
	@RequestMapping(value="regiseterGuestbook.kh", method=RequestMethod.POST)
	public String registerGuestbook(@ModelAttribute Guestbook guestbook, @RequestParam("memberDiary") int memberDiary, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		guestbook.setMemberNo(loginUser.getMemberNo());
		guestbook.setMemberDiary(memberDiary);
		int result = dService.registerGuestbook(guestbook);
		if(result > 0) {
			return "success";
		} else {
			return "fail";			
		}
	}
	
	// 방명록 수정
	@ResponseBody
	@RequestMapping(value="modifyGuestbook.kh",method=RequestMethod.POST)
	public String guestbookUpdate(@ModelAttribute Guestbook guestbook) {
		int result = dService.modifyGuestbook(guestbook);
		if(result >0) {
			return "success";
		} else {
			return "fail";			
		}
	}
	
	// 방명록 삭제
	@ResponseBody
	@RequestMapping(value="deleteGuestbook.kh", method = RequestMethod.GET)
	public String guestbookDelete(@ModelAttribute Guestbook guestbook) {
		int result = dService.removeGuestbook(guestbook);
		if(result >0) {
			return "success";
		} else {
			return "false";
		}
	}
	
	// 사진첩 리스트 불러오기
	@RequestMapping(value="diaryPicList.kh", method=RequestMethod.GET)
	public void diaryPicList(HttpServletResponse response, @RequestParam("memberNo") int memberNo) throws Exception {
		ArrayList<Diary> dList = dService.printPlantPicAll(memberNo);
		if(!dList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(dList,response.getWriter());
		} else {
			System.out.println("사진데이터가 없습니다.");			
		}
	}
	// 사진 동영상 변환...@빽범
	@RequestMapping(value="diaryPicVideo.kh", method=RequestMethod.GET)
	public void diaryPicOneCompanion(HttpServletResponse response, @ModelAttribute Diary diary) throws Exception {
		ArrayList<Diary> dList = dService.printPicOneCompanion(diary);
		if(!dList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(dList,response.getWriter());
		} else {
			System.out.println("해당 식물의 사진이 존재하지 않습니다.");			
		}
	}
}
