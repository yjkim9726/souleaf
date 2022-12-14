package com.souleaf.spring.common;

public class BoastPagination {
	//PageInfo 객체를 리턴해주는 메소드
		public static PageInfo getPageInfo(int currentPage, int listCount) {
			PageInfo pi = null;
			
			int pageLimit = 5; // 한 페이지에서 보여줄 네비게이션 수
			int boardLimit = 8; // 한 페이지에서 보여줄 게시글의 갯수 ?? 왜 안돼
			int maxPage;		// 전체 페이지 중 가장 마지막 페이지
			int startPage;		// 현재 페이지에서 시작하는 첫번째 페이지
			int endPage;		// 현재 페이지에서 끝나는 마지막 페이지
			
			maxPage = (int)((double)listCount/boardLimit + 0.9);
			startPage = (((int)((double)currentPage/pageLimit +0.9)) -1) * pageLimit +1;
			endPage = startPage + pageLimit -1;
			
			// 오류방지용
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			pi = new PageInfo(currentPage, boardLimit, pageLimit, startPage, endPage, listCount, maxPage);
			return pi;
		}
}
