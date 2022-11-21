package com.souleaf.spring.admin.service;

import java.util.HashMap;

import com.souleaf.spring.admin.domain.MemberStatus;
import com.souleaf.spring.admin.domain.TotalCount;

public interface AdminService {

	public MemberStatus printMemberStatus();
	public int modifyMemberStatus(HashMap<String, String> map);
	public int printPlantCount();
	public int printMemberCount();
	public int printBoardCount();
	public int printQNACount();
	

}
