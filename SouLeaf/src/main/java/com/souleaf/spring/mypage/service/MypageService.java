package com.souleaf.spring.mypage.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.mypage.domain.MyReply;
import com.souleaf.spring.mypage.domain.MypageSearch;

public interface MypageService {	
	
	public ArrayList<Boast> printAllMyBoast(int memberNo);
	
	public ArrayList<Clinic> printAllMyClinic(int memberNo);
	
	public ArrayList<Curiosity> printAllMyCuriosity(int memberNo);

	public ArrayList<Curiosity> printSearchAllList(HashMap<String, Object> map);

	public ArrayList<MyReply> printAllMyReply(int memberNo);

}
