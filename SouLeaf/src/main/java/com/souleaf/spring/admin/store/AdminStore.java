package com.souleaf.spring.admin.store;

import java.util.HashMap;

import com.souleaf.spring.admin.domain.MemberStatus;
import com.souleaf.spring.admin.domain.TotalCount;

public interface AdminStore {

	public MemberStatus selectMemberStatus();
	public int updateMemberStatus(HashMap<String, String> map);
	public int selectPlantCount();
	public int selectMemberCount();
	public int selectBoardCount();
	public int selectQNACount();
}
