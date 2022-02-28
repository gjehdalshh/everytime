package spring.everytime.com.user;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;

import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private HttpSession hs;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	// 회원가입
	int insUser(UserDTO dto) {

		UserDomain vo = selUser(dto);

		if (!dto.getUser_pw().equals(dto.getClkPw())) {
			return 2;
		}

		if (dto.getUser_nm().length() > 4) {
			return 3;
		}

		if (vo != null) {
			if (vo.getUser_id().equals(dto.getUser_id())) {
				return 4;
			}
			if (vo.getUser_nm().equals(dto.getUser_nm())) {
				return 5;
			}
			if (vo.getPh().equals(dto.getPh())) {
				return 6;
			}
			if (vo.getMail().equals(dto.getMail())) {
				return 7;
			}
		}
		
		dto.setUser_pw(bcrypt.encode(dto.getUser_pw()));

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

		if (!bcrypt.matches(dto.getClkPw(), vo.getUser_pw())) {
			return 3;
		}
		hs.setAttribute("loginUser", vo);

		return 1;
	}

	// 유저 아이디 변경
	int idChange(UserDTO dto) {

		UserDomain vo = mapper.selUserId(dto);
		if (dto.getUser_nm() == "") {
			return 2;
		}
		if (dto.getUser_id() == "") {
			return 3;
		}
		if (dto.getUser_pw() == "") {
			return 4;
		}
		if (!vo.getUser_nm().equals(dto.getUser_nm())) {
			return 5;
		}
		if (!vo.getUser_id().equals(dto.getUser_chkId())) {
			return 6;
		}
		if (!vo.getUser_pw().equals(dto.getUser_pw())) {
			return 7;
		}

		return mapper.idChange(dto);
	}

	// 유저 비밀번호 변경
	int pwChange(UserDTO dto) {
		UserDomain vo = mapper.selUserId(dto);
		if (dto.getUser_pw() == "") {
			return 2;
		}
		if (dto.getNew_pw() == "") {
			return 3;
		}
		if (dto.getNew_chkPw() == "") {
			return 4;
		}
		if (!vo.getUser_pw().equals(dto.getUser_pw())) {
			return 5;
		}
		if (!dto.getNew_pw().equals(dto.getNew_chkPw())) {
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
		if (m_dt < 604800) {
			return 3;
		}
		if (vo.getUser_nm().equals(dto.getUser_nm())) {
			return 2;
		}
		return mapper.nmChange(dto);
	}

	// 아이디, 비밀번호 찾기
	public UserDomain userInfoProc(UserDTO dto) throws Exception {

		UserDomain vo = mapper.userInfoProc(dto);
		
		if(vo == null) {
			return null;
		}

		if (vo.getUser_id() != null && dto.getMail() != null && dto.getUser_id() == null) {
			String title = "에브리타임 아이디 찾기";
			sendmail(title, "아이디는 " + vo.getUser_id() + " 입니다.", dto.getMail());

			return vo;
		}

		UserDomain find = mapper.findUser(dto);

		if (find == null) {
			return null;
		}

		if (vo.getUser_id() != null && dto.getMail() != null && dto.getUser_id() != null
				&& vo.getUser_id().equals(find.getUser_id())) {
			System.out.println("ddd");
			String title = "에브리타임 비밀번호 찾기";
			sendmail(title, "임시 비밀번호는 " + vo.getUser_pw() + " 입니다.\n비밀번호를 변경해주세요.\nhttp://localhost:8090/user/login", dto.getMail());

			return vo;
		}

		return null;
	}
	
	public UserDomain naverUserLogin(UserDTO dto) {
		return mapper.naverUserLogin(dto);
	}
	
	public int userNaverLogin(UserDTO dto) {
		
		if(!dto.getUser_pw().equals(dto.getClkPw())) {
			return 2;
		}
		
		String[] str = dto.getMail().split("@");
		dto.setUser_id(str[0]);
		
		//아이디 생성
		mapper.naverUserInsert(dto);
		
		UserDomain vo = mapper.naverUserLogin(dto);
		hs.setAttribute("loginUser", vo);
		
		return 1;
	}
	
	// 아이디, 비밀번호 찾기 mail (유틸로 옮겨야함)
	public void sendmail(String title, String info, String mail) throws Exception {
		// 메일 정보 (보내는 사람)
		String host = "smtp.naver.com";
		final String userName = "gjehdalshh"; // 네이버 메일 중 앞 주소
		final String passWord = "@784523ea"; // 네이버 비밀번호
		int port = 465;

		// 메일 내용 (받는 사람)
		String recipient = mail; // 메일을 발송할 이메일 주소
		String subject = title;
		String body = info;

		Properties props = System.getProperties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new Authenticator() {
			String un = userName;
			String pw = passWord;

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});

		session.setDebug(true);

		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("gjehdalshh@naver.com"));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

		mimeMessage.setSubject(subject);
		mimeMessage.setText(body);
		Transport.send(mimeMessage);

	}
}
