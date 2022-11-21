package com.souleaf.spring.boastLike.service;

import java.util.Map;

public interface BoastLikeService {

	Map<String, Object> likecheck(Map<String, Object> commandMap);

	void insertLikeBtn(Map<String, Object> commandMap);

	void updateLikeCntPlus(Map<String, Object> commandMap);

	void updateLikeCheck(Map<String, Object> commandMap);

	void updateLikeCntMinus(Map<String, Object> commandMap);

	Map<String, Object> getLikeCnt(Map<String, Object> commandMap);

}
