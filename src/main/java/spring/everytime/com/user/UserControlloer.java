package spring.everytime.com.user;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.everytime.com.model.UserEntity;
import spring.everytime.com.model.dto.UserDTO;

@Controller
public class UserControlloer {
	
	@Autowired
	private UserService service;
	
	@Autowired
	HttpSession hs;
	
	//jsp 연결
	@GetMapping("/user/login")
	public void login() {}
	
	//아자스 통신 로그인
	@ResponseBody
	@PostMapping("/user/loginProc")
	public Map<String, Object> loginProc(@RequestBody UserDTO dto) {
		
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.login(dto));
		
		return val;
	}
	
	@GetMapping("/logout")
	public String logout() {
		hs.invalidate();
		return "redirect:/user/login";
	}
	
	//jsp 연결
	@GetMapping("/user/join")
	public void join() {}
	
	//post방식 회원가입
	@PostMapping("/user/join")
	public String joinProc(Model model, UserDTO dto) {
		service.insUser(dto);
		return "redirect:/user/login";
	}
	
	// 유저 정보
	@GetMapping("/user/myProfile")
	public void myProfile() {}
	
	// 아이디 변경, 비밀번호 변경
	@GetMapping("/user/idChange")
	public void idChange(Model model, UserDTO dto) {
		model.addAttribute("selUserNm", service.selUserNm(dto));
	}
	
	// 아이디 변경
	@ResponseBody
	@PostMapping("/user/idChange")
	public Map<String, Object> idChangeProc(@RequestBody UserDTO dto){
		
		Map<String, Object> val = new HashMap<String, Object>();
		
		val.put("result", service.idChange(dto));
		
		return val;
	}
	
	// 비밀번호 변경
	@ResponseBody
	@PostMapping("/user/pwChange")
	public Map<String, Object> pwChangeProc(@RequestBody UserDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.pwChange(dto));
		
		return val;
	}
	
	// 유저 이름 설정
	@ResponseBody
	@PostMapping("/user/nmChange")
	public Map<String, Object> nmChangeProc(@RequestBody UserDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.nmChange(dto));
		
		return val;
	} 
	
	// 유저, 에브리타임 정보
	@GetMapping("/user/myProfileInfo")
	public void myProfileInfo(UserDTO dto) {
		
	}
}


