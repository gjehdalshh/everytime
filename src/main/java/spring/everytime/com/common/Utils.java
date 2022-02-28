package spring.everytime.com.common;

import javax.servlet.http.HttpSession;

import spring.everytime.com.model.domain.BoardDomain;
import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.BoardDTO;

public class Utils {

	// 페이징
	public static BoardDomain Paging(BoardDomain vo) {

		int list = 10, pageNow = 0, total = 0, pageCount = 0,
				rest = 0, first = 0, last = 0, pageFirst = 1,
				pageLast = 0;

		pageNow = vo.getPageNow();
		total = vo.getListCount();
		rest = total % list;
		
		if (rest == 0) {
			pageCount = total / list;
		} else {
			pageCount = (total / list) + 1;
		}
		last = pageNow * list;
		first = last - 10;

		pageFirst = vo.getPageFirst();
		pageLast = pageFirst + 4;

		vo.setTotal(total);
		vo.setRest(rest);
		vo.setPageCount(pageCount);
		vo.setLast(last);
		vo.setFirst(first);
		vo.setPageNow(pageNow);
		vo.setPageFirst(pageFirst);
		vo.setPageLast(pageLast);
		
		return vo;
	}

	// 유저 세션
	UserDomain getUserDomain(HttpSession hs) {
		UserDomain vo = (UserDomain) hs.getAttribute("loginUser");
		return vo;
	}

	// 시간처리 함수
	public static String timeFormat(String dateTime) {
		int time = Integer.parseInt(dateTime);
		String set_time = "";

		if (time < 60) {
			set_time = time + "초 전";
		} else if (time < 3600) {
			set_time = time / 60 + "분 전";
		} else if (time < 86400) {
			set_time = time / 3600 + "시간 전";
		} else if (time < 604800) {
			set_time = time / 86400 + "일 전";
		} else if (time < 2592000) {
			set_time = time / 604800 + "주 전";
		} else if (time < 31104000) {
			set_time = time / 2592000 + "달 전";
		} else {
			set_time = time / 31104000 + "년 전";
		}

		return set_time;
	}

}
