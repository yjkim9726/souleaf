package com.souleaf.spring.boastLike.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boastLike.service.BoastLikeService;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.member.domain.Member;

//@Controller
public class BoastLikeController {
	
	private BoastLikeService bService;

	  
	
	/* Controller */
	// 좋아요 눌렀을때
//	@RequestMapping("/clickLike")
//	@ResponseBody
	/*
	 * public Map<String, Object> clickLike(@RequestParam Map<String, Object>
	 * commandMap) { System.out.println("request: /clickLike"); int resultCode = 1;
	 * int likecheck = 1; Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String, Object> likecntMap = new HashMap<String, Object>(); Map<String,
	 * Object> resultMap = new HashMap<String, Object>(); try { map =
	 * bService.likecheck(commandMap); if (map == null) { // 처음 좋아요 누른것 likecheck=1,
	 * 좋아요 빨간색이 되야됨 bService.insertLikeBtn(commandMap); // 좋아요 테이블 인서트
	 * bService.updateLikeCntPlus(commandMap); // bbs 테이블 업데이트 +1 resultCode = 1; }
	 * else if (Integer.parseInt(map.get("likecheck").toString()) == 0) { // 좋아요 처음은
	 * 아니고 취소했다가 다시 눌렀을때 likecheck=1, 좋아요 빨간색 되야됨 commandMap.put("likecheck",
	 * likecheck); bService.updateLikeCheck(commandMap); // 좋아요 테이블 업데이트
	 * bService.updateLikeCntPlus(commandMap); // bbs테이블 +1 resultCode = 1; } else {
	 * // 좋아요 취소한거 likecheck=0, 빈하트 되야됨 likecheck = 0; commandMap.put("likecheck",
	 * likecheck); bService.updateLikeCheck(commandMap);
	 * bService.updateLikeCntMinus(commandMap); resultCode = 0; } resultMap =
	 * bService.getLikeCnt(commandMap); // 해당 게시글 테이블의 likecnt칼럼 update가 끝난후
	 * likecnt값 가져옴 resultMap.put("likecheck", likecheck); } catch (Exception e) {
	 * System.out.println(e.getMessage()); resultCode = -1; }
	 * 
	 * resultMap.put("resultCode", resultCode); // resultCode가 1이면 빨간하트 0이면 빈하트
	 * return resultMap; }
	 */
	
//  ---------------------------------------------------------------------------------------
	/* JSP SCRIPT */
//	var bbsidx = ${bbsidx};
//	var useridx = ${useridx};
//	 
//	var btn_like = document.getElementById("btn_like");
// btn_like.onclick = function(){ changeHeart(); }
//	 
//	/* 좋아요 버튼 눌렀을떄 */
//	 function changeHeart(){ 
//	     $.ajax({
//	            type : "POST",  
//	            url : "/clickLike",       
//	            dataType : "json",   
//	            data : "bbsidx="+bbsidx+"&useridx="+useridx,
//	            error : function(){
//	                Rnd.alert("통신 에러","error","확인",function(){});
//	            },
//	            success : function(jdata) {
//	                if(jdata.resultCode == -1){
//	                    Rnd.alert("좋아요 오류","error","확인",function(){});
//	                }
//	                else{
//	                    if(jdata.likecheck == 1){
//	                        $("#btn_like").attr("src","/home/img/ico_like_after.png");
//	                        $("#likecnt").empty();
//	                        $("#likecnt").append(jdata.likecnt);
//	                    }
//	                    else if (jdata.likecheck == 0){
//	                        $("#btn_like").attr("src","/home/img/ico_like_before.png");
//	                        $("#likecnt").empty();
//	                        $("#likecnt").append(jdata.likecnt);
//	                        
//	                    }
//	                }
//	            }
//	        });
//	 }

}
