package spring.everytime.com.model.dto;

import spring.everytime.com.model.BoardEntity;

public class BoardDTO extends BoardEntity {
	private int board;
	private int listCount;

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getBoard() {
		return board;
	}

	public void setBoard(int board) {
		this.board = board;
	}

}
