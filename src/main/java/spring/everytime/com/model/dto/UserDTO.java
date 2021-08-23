package spring.everytime.com.model.dto;

import spring.everytime.com.model.UserEntity;


public class UserDTO extends UserEntity{
	private String clkPw;
	private String user_chkId;
	private String new_pw;
	private String new_chkPw;

	public String getNew_pw() {
		return new_pw;
	}

	public void setNew_pw(String new_pw) {
		this.new_pw = new_pw;
	}

	public String getNew_chkPw() {
		return new_chkPw;
	}

	public void setNew_chkPw(String new_chkPw) {
		this.new_chkPw = new_chkPw;
	}

	public String getUser_chkId() {
		return user_chkId;
	}

	public void setUser_chkId(String user_chkId) {
		this.user_chkId = user_chkId;
	}

	public String getClkPw() {
		return clkPw;
	}

	public void setClkPw(String clkPw) {
		this.clkPw = clkPw;
	}
	
}
