package spring.everytime.com.user;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.protobuf.TextFormatParseInfoTree;

import spring.everytime.com.model.UserEntity;
import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.UserDTO;

class JsonUser {
	int gender;
	String name;
	String id;
	String pw;
	String ph;
	String university;
	String entrance;
	String mail;
}

@Controller
public class UserControlloer {

	@Autowired
	private UserService service;

	@Autowired
	HttpSession hs;

	// jsp 연결
	@GetMapping("/user/login")
	public String login(Model model, HttpSession session) {

		// 네이버
		// 네이버 아이디로 인증 URL을 생성하기 위하여 naverLoginBO 클래스의
		// getAuthorizationUrl 메서드 호출
		String naverAuthUrl = naverLoginBO.getAuthzationUrl(session);
		System.out.println("네이버 : " + naverAuthUrl);
		model.addAttribute("url", naverAuthUrl);
		return "/user/login";
	}

	// 아자스 통신 로그인
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

	// jsp 연결
	@GetMapping("/user/join")
	public void join() {
	}

	@ResponseBody
	@PostMapping("/user/joinProc")
	public Map<String, Object> JoinProc(@RequestBody UserDTO dto) {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.insUser(dto));

		return val;
	}

	// 유저 정보
	@GetMapping("/user/myProfile")
	public void myProfile() {
	}

	// 아이디 변경, 비밀번호 변경
	@GetMapping("/user/idChange")
	public void idChange(Model model, UserDTO dto) {
		model.addAttribute("selUserNm", service.selUserNm(dto));
	}

	// 아이디 변경
	@ResponseBody
	@PostMapping("/user/idChange")
	public Map<String, Object> idChangeProc(@RequestBody UserDTO dto) {

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

	@GetMapping("/user/findInfo")
	public void userInfo() {

	}

	@ResponseBody
	@PostMapping("/user/findInfoProc")
	public Map<String, Object> userInfoProc(@RequestBody UserDTO dto) throws Exception {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.userInfoProc(dto));

		return val;
	}

	/* ----------------- naver ----------------- */

	// naverLoginBO

	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 로그인 첫 화면 요청 메서드
	/*
	 * @RequestMapping(value = "/user/login", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String naverLogin(Model model, HttpSession
	 * session) {
	 * 
	 * // 네이버 아이디로 인증 URL을 생성하기 위하여 naverLoginBO 클래스의 // getAuthorizationUrl 메서드 호출
	 * String naverAuthUrl = naverLoginBO.getAuthzationUrl(session);
	 * 
	 * System.out.println("네이버 : " + naverAuthUrl);
	 * 
	 * // 네이버 model.addAttribute("url", naverAuthUrl);
	 * 
	 * return "/user/login"; }
	 */
	// 네이버 로그인 성공시 callback호출 메서드
	@RequestMapping(value = "/user/naverCallBack", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session, RedirectAttributes re)
			throws IOException, ParseException {
		
		
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);

		// 1. 로그인 사용자 정보를 읽어온다
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String 형식의 json 데이터

		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		System.out.println("apiReuslt : " + apiResult);
		// 2. String 형식인 apiResult를 json 형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;

		// 3. 데이터 파싱
		// Top 레벨 단계 response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		System.out.println("res : " + response_obj);

		JsonUser jsonUser = UserInfo(response_obj);

		UserDTO dto = new UserDTO();
		dto.setUser_nm(jsonUser.name);
		dto.setPh(jsonUser.ph);
		dto.setMail(jsonUser.mail);
		dto.setEntrance(jsonUser.entrance);
		dto.setGender(jsonUser.gender);

		// 유저 정보 i_user id nm pw ph gender 학교 r_dt 입학년도 mail
		
		UserDomain vo = service.naverUserLogin(dto);
		// 4. 파싱 세션으로 저장
		if (vo == null) {
			re.addAttribute("user_nm", dto.getUser_nm());
			re.addAttribute("mail", dto.getMail());
			re.addAttribute("ph", dto.getPh());
			re.addAttribute("entrance", dto.getEntrance());
			re.addAttribute("gender", dto.getGender());
			return "redirect:/user/naverLogin";
		}
		if (vo != null) {
			System.out.println("값이 존재함");
			hs.setAttribute("loginUser", vo);
		}

		return "redirect:/main/home";

	}
	
	@GetMapping("/user/naverLogin")
	public void userNaverLogin() {}
	
	@ResponseBody
	@PostMapping("/user/naverLogin")
	public Map<String, Object>userNaverLogin(@RequestBody UserDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.userNaverLogin(dto));
		return val;
	}

	// naver에서 받은 유저 정보 객체로 변환
	public JsonUser UserInfo(JSONObject json) {
		String gender;
		String mail;
		String birthyear;
		String ph;
		
		JsonUser jsonUser = new JsonUser();
		
		gender = (String) json.get("gender");
		if(gender.equals("M")) {
			gender = "1";
		} else {
			gender = "2";
		}
		jsonUser.gender = Integer.parseInt(gender);
		
		jsonUser.name = (String) json.get("name");
		
		mail = (String) json.get("email");
		String[] str = mail.split("@");
		jsonUser.mail = str[0] + "@naver.com";
		
		jsonUser.id = str[0];
		
		ph = (String) json.get("mobile");
		String[] phone = ph.split("-");
		ph = phone[0] + phone[1] + phone[2];
		jsonUser.ph = ph;
		
		birthyear = (String) json.get("birthyear");
		birthyear = (Integer.parseInt(birthyear) + 19) + "학번";
		jsonUser.entrance = birthyear;
		
		return jsonUser;
	}
	/*
	 * // 로그아웃
	 * 
	 * @RequestMapping(value="/logout", method = {RequestMethod.GET,
	 * RequestMethod.POST}) public String logout(HttpSession session)throws
	 * IOException { System.out.println("여기는 logout"); session.invalidate();
	 * 
	 * return "redirect:index.jsp"; }
	 */
}