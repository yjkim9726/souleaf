package com.souleaf.spring.boastLike.store;

import java.util.Map;

public interface BoastLikeStore {

	Map<String, Object> likecheck(Map<String, Object> commandMap);

	void insertLikeBtn(Map<String, Object> commandMap);

	void updateLikeCntPlus(Map<String, Object> commandMap);

	void updateLikeCheck(Map<String, Object> commandMap);

	void updateLikeCntMinus(Map<String, Object> commandMap);

	Map<String, Object> getLikeCnt(Map<String, Object> commandMap);
	
}
