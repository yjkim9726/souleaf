package com.souleaf.spring;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.boastLike.domain.BoastLike;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.service.PlantService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	PlantService pService;
	@Autowired
	BoastService bService;
	@Autowired
	MemberService mService;
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.kh", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "home");
		
		ArrayList<Plant> pList = pService.printAllRank();
		ArrayList<Plant> pRankList = new ArrayList<Plant>();
		Plant pRank = new Plant();
		if (pList != null) {
			for(int i =0; i <3; i++) {
				// 식물도감에서 식물검색해서 첫번째 값 가져옴
				ArrayList<PlantFile> pfList = pService.printFileList(pList.get(i).getPlantNo());
				log.info("플랜트 파일 리스트" + pfList);
				loopOut:
				for(PlantFile pFile : pfList) {
					if(pFile.getPlantFileRename() != null) {
						pRank = pList.get(i);
						pRank.setPlantFileRename(pFile.getPlantFileRename());
						break loopOut;
					}
				}
				pRankList.add(pRank);
			}
			mv.addObject("pRank",pRankList);
		}
		ArrayList<Boast> bList = bService.printAllRank();
		ArrayList<Boast> bRankList = new ArrayList<Boast>();
		Boast bRank = new Boast();
		if (bList != null) {
			for(int i =0; i <3; i++) {
				bRank = bList.get(i);
				bRank.setBoastLike(bService.getLikeCount(bRank.getBoastNo()));
				bRank.setBoastReplyCount(bService.getReplyCount(bRank.getBoastNo()));
				Member member = mService.printMember(bRank.getMemberNo());
				bRank.setMemberNick(member.getMemberNick());
				Plant plant = pService.printOne(bRank.getPlantNo());
				bRank.setPlantName(plant.getPlantName());
				bRankList.add(bRank);
			}
			mv.addObject("bRank",bRankList);
		}
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="intro.kh", method = RequestMethod.GET)
	public String intro(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "intro");
		return "intro";
	}
	
}
