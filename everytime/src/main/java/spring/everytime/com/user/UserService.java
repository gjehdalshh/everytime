package spring.everytime.com.user;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private HttpSession hs;

	// 회원가입
	int insUser(UserDTO dto) {
		return mapper.insUser(dto);
	}

	// 로그인 db가져오기
	UserDomain selUser(UserDTO dto) {

		return mapper.selUser(dto);
	}

	// 로그인 검사
	int login(UserDTO dto) {
		UserDomain vo = selUser(dto);
		if (vo == null) {
			return 2;
		}
		if (!vo.getUser_pw().equals(dto.getClkPw())) {
			return 3;
		}
		hs.setAttribute("loginUser", vo);

		return 1;
	}

	// 유저 아이디 변경
	int idChange(UserDTO dto){

		UserDomain vo = mapper.selUserId(dto);
		if(dto.getUser_nm() ==  "") {
			return 2;
		}
		if(dto.getUser_id() == "") {
			return 3;
		}
		if(dto.getUser_pw() == "") {
			return 4;
		}
		if(!vo.getUser_nm().equals(dto.getUser_nm())) {
			return 5;
		}
		if(!vo.getUser_id().equals(dto.getUser_chkId())) {
			return 6;
		}
		if(!vo.getUser_pw().equals(dto.getUser_pw())) {
			return 7;
		}
		
		return mapper.idChange(dto);
	}
	
	// 유저 비밀번호 변경
	int pwChange(UserDTO dto) {
		UserDomain vo = mapper.selUserId(dto);
		if(dto.getUser_pw() == "") {
			return 2;
		}
		if(dto.getNew_pw() == "") {
			return 3;
		}
		if(dto.getNew_chkPw() == "") {
			return 4;
		}
		if(!vo.getUser_pw().equals(dto.getUser_pw())) {
			return 5;
		}
		if(!dto.getNew_pw().equals(dto.getNew_chkPw())) {
			return 6;
		}
		
		return mapper.pwChange(dto);
	}
	
	// 유저 이름 검색
	UserDomain selUserNm(UserDTO dto) {
		
		return mapper.selUserNm(dto);
	}
	
	// 유저 이름 설정
	int nmChange(UserDTO dto) {
		
		UserDomain vo = mapper.selUserNm(dto);
		
		int m_dt = Integer.parseInt(vo.getM_dt());
		// 일주일 후 변경 가능
		if(m_dt < 604800) {
			return 3;
		}
		if(vo.getUser_nm().equals(dto.getUser_nm())) {
			return 2;
		}
		return mapper.nmChange(dto);
	}
}
