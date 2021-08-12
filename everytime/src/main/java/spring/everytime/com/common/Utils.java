package spring.everytime.com.common;

import javax.servlet.http.HttpSession;

import spring.everytime.com.model.domain.UserDomain;

public class Utils {
	
	//유저 세션
	UserDomain getUserDomain(HttpSession hs) {
		UserDomain vo = (UserDomain)hs.getAttribute("loginUser");
		return vo;
	}
	
	//시간처리 함수
	public static String timeFormat(String dateTime) {
		int time = Integer.parseInt(dateTime);
		String set_time = "";
		
		if(time < 60) {
			set_time = time + "초 전";
		} else if(time < 3600) { 
			set_time = time / 60 + "분 전";
		}  else if(time < 86400) {
			set_time = time / 3600+ "시간 전";
		}  else if(time < 604800) {
			set_time = time / 86400 + "일 전";
		}  else if(time < 2592000) {
			set_time = time / 604800 + "주 전";
		}  else if(time < 31104000) {
			set_time = time / 2592000 + "달 전";
		} else {
			set_time = time / 31104000 + "년 전";
		}
		
		return set_time;
	}

}
