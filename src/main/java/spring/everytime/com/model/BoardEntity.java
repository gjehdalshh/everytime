package spring.everytime.com.model;

public class BoardEntity {
	private int i_board;
	private int i_board_type;
	private int i_user;
	private String board_nm;
	private String board_ctnt;
	private int board_favorite;
	private int secret;
	private String r_dt;
	private int board_hit;
	private int listCount;

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public int getI_board_type() {
		return i_board_type;
	}
	public void setI_board_type(int i_board_type) {
		this.i_board_type = i_board_type;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getBoard_nm() {
		return board_nm;
	}
	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}
	public String getBoard_ctnt() {
		return board_ctnt;
	}
	public void setBoard_ctnt(String board_ctnt) {
		this.board_ctnt = board_ctnt;
	}
	public int getBoard_favorite() {
		return board_favorite;
	}
	public void setBoard_favorite(int board_favorite) {
		this.board_favorite = board_favorite;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	
	
}
