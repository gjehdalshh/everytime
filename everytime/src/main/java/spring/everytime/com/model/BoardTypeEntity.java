package spring.everytime.com.model;

public class BoardTypeEntity {
	private int i_board_type;
	private String type_title;
	private int board_hit;
	
	
	
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public int getI_board_type() {
		return i_board_type;
	}
	public void setI_board_type(int i_board_type) {
		this.i_board_type = i_board_type;
	}
	public String getType_title() {
		return type_title;
	}
	public void setType_title(String type_title) {
		this.type_title = type_title;
	}
	
	
}
