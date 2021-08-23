package spring.everytime.com.model;

public class BoardCmtEntity {
	private int i_cmt;
	private int i_user;
	private int i_board;
	private String ctnt;
	private String r_dt;
	private int secret;
	private int cmt_favorite;
	
	public int getI_cmt() {
		return i_cmt;
	}
	public void setI_cmt(int i_cmt) {
		this.i_cmt = i_cmt;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	public int getCmt_favorite() {
		return cmt_favorite;
	}
	public void setCmt_favorite(int cmt_favorite) {
		this.cmt_favorite = cmt_favorite;
	}
	
	
}
