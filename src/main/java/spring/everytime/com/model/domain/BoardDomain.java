package spring.everytime.com.model.domain;

import spring.everytime.com.model.BoardEntity;

public class BoardDomain extends BoardEntity {
	private String user_nm;
	private String type_title;
	private String sub_type;
	private int favorite;
	private int cmt;
	
	// 페이징
	
	
	
	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public int getCmt() {
		return cmt;
	}

	public void setCmt(int cmt) {
		this.cmt = cmt;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	public String getType_title() {
		return type_title;
	}

	public void setType_title(String type_title) {
		this.type_title = type_title;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

}
