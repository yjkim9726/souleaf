package com.souleaf.spring.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MailSendService;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.security.service.MemberSha256;

@Controller
public class MemberController {

	@Inject
	JavaMailSender mailSender;
	@Autowired
	private MemberService mService;
	@Autowired
    private MailSendService mss;

	// 회원가입 폼
	@RequestMapping(value = "enrollView.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public String enrollView() {
		return "member/enrollView";
	}

	// 회원등록
	@RequestMapping(value = "memberRegister.kh", method = { RequestMethod.POST, RequestMethod.GET })
	public String memberRegister(@ModelAttribute Member member, Model model) {
		// 암호 확인
		System.out.println("첫번째:" + member.getMemberPw());
		// 비밀번호 암호화 (sha256
		String encryPassword = MemberSha256.encrypt(member.getMemberPw());
		member.setMemberPw(encryPassword);
		System.out.println("두번째:" + member.getMemberPw());
		int result = mService.registerMember(member);
		if (result > 0) {
			return "redirect:home.kh";
		} else {
			model.addAttribute("msg", "회원 가입 실패!!");
			return "common/errorPage";
		}

	}

	// 마이페이지 뷰
	@RequestMapping(value = "myInfo.kh", method = RequestMethod.GET)
	public String myPageView() {
		return "member/myPage";
	}

	// 회원수정 폼
	@RequestMapping(value = "memerModifyView.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberModifyView(HttpSession session, HttpServletRequest request, Model model) {
		session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		Member mOne = mService.printMember(memberNo);
		if (mOne != null) {

			model.addAttribute("mOne", mOne);
		} else {
			model.addAttribute("mOne", null);
		}
		return "member/memberModifyView";
	}
	@RequestMapping(value = "pwUpdateView.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public String pwUpdateView(HttpSession session, HttpServletRequest request, Model model) {
		session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		Member mOne = mService.printMember(memberNo);
		if (mOne != null) {

			model.addAttribute("mOne", mOne);
		} else {
			model.addAttribute("mOne", null);
		}
		return "member/pwUpdateView";
	}
	@RequestMapping(value = "pwUpdate.kh", method = RequestMethod.POST)
	public String modifyMember(@ModelAttribute Member member, Model model,
		HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String memberFileRename = (String) session.getAttribute("fileName");
		System.out.println("controller");
		int memberNo = loginUser.getMemberNo();
		member.setMemberNo(memberNo);
		// 암호 확인
				System.out.println("첫번째:" + member.getMemberPw());
				// 비밀번호 암호화 (sha256
				String encryPassword = MemberSha256.encrypt(member.getMemberPw());
				member.setMemberPw(encryPassword);
				System.out.println("두번째:" + member.getMemberPw());
				return encryPassword;
	}


	// 정보수정
	@RequestMapping(value = "memberModify.kh", method = RequestMethod.POST)
	public String modifyMember(@ModelAttribute Member member, Model model,
		@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
		HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String memberFileRename = (String) session.getAttribute("fileName");
		System.out.println("controller");
		int memberNo = loginUser.getMemberNo();
		member.setMemberMail(member.getMemberMail());
		member.setMemberNick(member.getMemberNick());
		member.setMemberIntro(member.getMemberIntro());
		member.setMemberNo(memberNo);
		

		// 암호 확인
//		System.out.println("첫번째:" + member.getMemberPw());
//		// 비밀번호 암호화 (sha256
//		String encryPassword = MemberSha256.encrypt(member.getMemberPw());
//		member.setMemberPw(encryPassword);
//		System.out.println("두번째:" + member.getMemberPw());
//		// 서버에 데이터를 저장하는 작업
		if (!uploadFile.getOriginalFilename().equals("")) {
			String renameFileName = saveFile(uploadFile, request);
			if (renameFileName != null) {
				member.setMemberPhoto(uploadFile.getOriginalFilename());
				member.setMemberFileRename(renameFileName);
			}
		} else {
			// 파일 삭제 후 업로드 (수정)
			if (uploadFile != null && !uploadFile.isEmpty()) {
				// 기존 파일 삭제
				if (member.getMemberPhoto() != "") {
					deleteFile(member.getMemberFileRename(), request);
				}
				// 새 파일 업로드
				String memberReFilename = saveFile(uploadFile, request);
				if (memberReFilename != null) {
					member.setMemberPhoto(uploadFile.getOriginalFilename());
					member.setMemberFileRename(memberReFilename);
				}
			}

		}

		int result = mService.modifyMember(member);
		if(result > 0) {
			return "redirect:mypage.kh";
		}
		return "redirect:mypage.kh";
		


	}
	// 저장된 파일 삭제
		public void deleteFile(String fileName, HttpServletRequest request) {
			String root = request.getSession().getServletContext().getRealPath("resuorces");
			String savePath = root + "/uploadFiles/member";
			File file = new File(savePath + "/" + fileName);
			if(file.exists()) {
				file.delete();
			}
		}


	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/member"; // /uploadFiles/diary 이런식으로

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

	// 회원 탈퇴   
	@RequestMapping(value = "memberDelete.kh", method = RequestMethod.GET)
	public String memberDelete(@RequestParam("memberId") String memberId) {
		int result = mService.deleteMember(memberId);
		if(result > 0) {
			return "redirect:logout.kh";			
		}else {
			return "";
		}

	}
	// 비밀번호 일치 여부 
	@ResponseBody  
	@RequestMapping(value = "checkMemberPw.kh", method = RequestMethod.POST)
	public String checkMemberPw(@ModelAttribute Member member) {
		Member memberchk = mService.checkMemberInfo(member.getMemberId()); // 디비에 저장된 암호환된 값 가져옴 
		String memberOriginalPw = memberchk.getMemberPw();
		
		String memberPw = member.getMemberPw(); // 내가 입력한 값
		String enterPassword = MemberSha256.encrypt(memberPw); // 내가 입력한 값을 다시 암호화 해줌
		
		if(!enterPassword.equals(memberOriginalPw)) {
			return "wrongPw";			
		}else {
			return "rigthPw";
		}
	}

//	@ResponseBody    
//	@RequestMapping(value="dupId.kh", method=RequestMethod.GET)
//	public String idDuplicateCheck(@RequestParam("memberId") String memberId) {
//		return String.valueOf(mService.checkIdDup(memberId));
//		
//	}
//	@RequestMapping(value="enrollView.kh", method=RequestMethod.POST)
//	public ModelAndView mailSendding(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException {
//		
//		Random r = new Random();
//		int dice = r.nextInt(4589362) + 49311; // 이메일로 받는 인증코드 부분 (난수)
//		
//		String setfrom = "jiny9003@gmail.com";
//		String tomail = request.getParameter("e_mail"); // 받는 사람 이메일
//		String title = "회원가입 인증 이메일 입니다."; // 제목
//		String content =
//				
//		 System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
//	        
//	     System.getProperty("line.separator")+
//	                
//	        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
//	        
//        +System.getProperty("line.separator")+
//	        
//         System.getProperty("line.separator")+
//	
//         " 인증번호는 " +dice+ " 입니다. "
//	        
//         +System.getProperty("line.separator")+
//	        
//          System.getProperty("line.separator")+
//		
//         "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
//		
//		  try {
//               MimeMessage message = mailSender.createMimeMessage();
//               MimeMessageHelper messageHelper = new MimeMessageHelper(message,
//                       true, "UTF-8");
//
//               messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
//               messageHelper.setTo(tomail); // 받는사람 이메일
//               messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
//               messageHelper.setText(content); // 메일 내용
//               
//               mailSender.send(message);
//           } catch (Exception e) {
//               System.out.println(e);
//           }
//           
//           ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
//           mv.setViewName("member/email_injeung");     //뷰의이름
//           mv.addObject("dice", dice);
//           
//           System.out.println("mv : "+mv);
//
//           response_email.setContentType("text/html; charset=UTF-8");
//           PrintWriter out_email = response_email.getWriter();
//           out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
//           out_email.flush();
//           
//           
//           return mv;
//           
//       }
//	
//	// 이메일 인증 페이지 맵핑 메소드
//	@RequestMapping("member/email.kh")
//	public String email() {
//		return "member/email";
//	}
//	
//	//이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
//    //내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
//    //틀리면 다시 원래 페이지로 돌아오는 메소드
//	
//	public ModelAndView join_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals) throws IOException {
//		
//		System.out.println("마지막 : email_injeung : " +email_injeung );
//		
//		System.out.println("마지막 : dice : "+dice);
//		
//		//페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("member/join.kh");
//		mv.addObject("e_mail",email_injeung);
//		if(email_injeung.equals(dice)) {
//			//인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
//		mv.setViewName("member/join");
//		mv.addObject("e_mail",email_injeung);
//		//만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
//        //한번더 입력할 필요가 없게 한다.
//		
//		  response_equals.setContentType("text/html; charset=UTF-8");
//          PrintWriter out_equals = response_equals.getWriter();
//          out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.');</script>");
//          out_equals.flush();
//  
//          return mv;
//		
//		}else if(email_injeung != dice) {
//			ModelAndView mv2 = new ModelAndView();
//			mv2.setViewName("member/email_injeung");
//			
//			response_equals.setContentType("text/html; charset=UTF-8");
//			PrintWriter out_equals = response_equals.getWriter();
//			out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
//            out_equals.flush();
//            return mv2;
//		}
//		return mv;
//	}

	// 회원 로그인 !!!!!!!!!!

	@RequestMapping(value = "loginView.kh", method = RequestMethod.GET)
	public String memberLoginView(HttpServletRequest request) {
		return "login";
	}
	
	// 로그인 하기
	@ResponseBody
	@RequestMapping(value = "login.kh", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, @ModelAttribute Member member, Model model) {
		// 암호 확인
		System.out.println("첫번째:" + member.getMemberPw());
		// 비밀번호 암호화 (sha256
		String encryPassword = MemberSha256.encrypt(member.getMemberPw());
		member.setMemberPw(encryPassword);
		System.out.println("두번째:" + member.getMemberPw());
		Member mOne = new Member(member.getMemberId(), member.getMemberPw());

		Member loginUser = mService.loginMember(mOne);

		if (loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			return "success";
		} else {
			return "fail";
		}
	}

	// 카카오 로그인 
	@ResponseBody
	@RequestMapping(value="kakaoLogin.kh", method = RequestMethod.POST)
	public String kakaoLogin(HttpServletRequest request, @ModelAttribute Member member, @RequestParam String token) {
		Member chkMember = mService.loginMember(member);
		int result = 0;
		if(chkMember == null) {
			result = mService.registerMember(member);
			chkMember = mService.loginMember(member);
		}
		if(chkMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", chkMember);
			session.setAttribute("token", token);
			return "success";			
		} else {
			return "fail";
		}
	}
	
	// 로그아웃
	@RequestMapping(value = "logout.kh", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:home.kh";
	}
	
	
	// 아이디 중복 검사
	@RequestMapping(value = "idCheck.kh", method = RequestMethod.POST)
	public void idDupleCheck(HttpServletResponse response, @ModelAttribute Member member)
			throws JsonIOException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 고정
		Integer result = 0; // 변수 값
		result = mService.checkIdDup(member.getMemberId()) > 0 ? 1 : 0;
		gson.toJson(result, response.getWriter()); // 변수명 넣고 보내기
	}

	// 닉네임 중복 검사
	@RequestMapping(value = "nickCheck.kh", method = RequestMethod.POST)
	public void nickDupleCheck(HttpServletResponse response, @ModelAttribute Member member)
			throws JsonIOException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 고정
		Integer result = 0; // 변수 값
		result = mService.checkNickDup(member.getMemberNick()) > 0 ? 1 : 0;
		gson.toJson(result, response.getWriter()); // 변수명 넣고 보내기
	}
	
	// 이메일 인증
	@RequestMapping(value = "emailAuthCheck.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public void emailAuthCheck(HttpServletResponse response, @ModelAttribute Member member)
			throws JsonIOException, IOException {
		System.out.println("메일");
		String authKey = mss.sendAuthMail(member.getMemberMail());
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 고정
		gson.toJson(Integer.parseInt(authKey), response.getWriter());
	}
	
	// 이메일 인증
	@RequestMapping(value = "emailAuthenticateView.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public String emailAuthenticateView(){
		return "member/emailAuthenticateView";
	}
	// 비밀번호 찾기 폼
	@RequestMapping(value = "findPwView.kh", method =  RequestMethod.GET)
	public String findPwView(HttpSession session) throws Exception{
		session.setAttribute("nav","");
		return "member/findPw";
	}
	// 아이디 찾기 폼
	@RequestMapping(value = "findIdView.kh", method =  RequestMethod.GET)
	public String findIdView(HttpSession session) throws Exception{
		session.setAttribute("nav","");
		return "member/findId";
	}
	// 아이디 찾기 이름이랑 이메일 받아와서 있는지 확인
	@RequestMapping(value = "findId.kh", method = RequestMethod.POST)
	public void findId(HttpServletResponse response, @ModelAttribute Member member) throws Exception {
		Member memberchk = mService.checkMember(member); // 내가 적은 이름이랑 이메일값을 가진 member 를 가지고 checkMember로 넘어감 
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		if(memberchk != null) { // 디비에 내가 적은 이름이랑 이메일값이 있으면 
			gson.toJson(memberchk ,response.getWriter());			
		} else {
			gson.toJson("null" ,response.getWriter());	
		}

	}
	@RequestMapping(value = "findPw.kh", method = RequestMethod.POST)
	public void findPw(HttpServletResponse response, @ModelAttribute Member member) throws Exception {
		Member memberchk = mService.checkMember(member); // 내가 적은 이름이랑 이메일값을 가진 member 를 가지고 checkMember로 넘어감 
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		if(memberchk != null) { // 디비에 내가 적은 이름이랑 이메일값이 있으면 
			gson.toJson(memberchk ,response.getWriter());			
		} else {
			gson.toJson("null" ,response.getWriter());	
		}
		
	}
	// 새 비밀번호 폼
	@RequestMapping(value = "newPwView.kh", method =RequestMethod.GET)
	public String newPw(@RequestParam String memberId, Model model) throws Exception{
		model.addAttribute("memberId",memberId);
		return "member/newPw";
	}
	// 패스워드 변경 확인
		@RequestMapping(value="newPw.kh" ,method=RequestMethod.POST)
		public String chagnePw(HttpServletResponse response,@ModelAttribute Member member ) throws Exception {
			String newPw = MemberSha256.encrypt(member.getMemberPw()); // 내가 입력한 값을 다시 암호화 해줌
			
			Member updateMem = new Member();
			updateMem.setMemberId(member.getMemberId());
			updateMem.setMemberMail(member.getMemberMail());
			updateMem.setMemberPw(newPw);
			int result = mService.modifyPw(updateMem);
			
			return "login";
		}
		// 이메일 인증
		@RequestMapping(value = "newPwEmail.kh", method = { RequestMethod.GET, RequestMethod.POST })
		public String newPwEmail(){
			return "member/newPwEmail";
		}
	}
