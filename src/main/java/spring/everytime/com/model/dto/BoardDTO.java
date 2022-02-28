package spring.everytime.com.model.dto;

import spring.everytime.com.model.BoardEntity;

public class BoardDTO extends BoardEntity {
	private int board;
	private int pageNow;
	private int pageSection;
	private int pageFirst;


	public int getPageFirst() {
		return pageFirst;
	}

	public void setPageFirst(int pageFirst) {
		this.pageFirst = pageFirst;
	}

	public int getPageSection() {
		return pageSection;
	}

	public void setPageSection(int pageSection) {
		this.pageSection = pageSection;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getBoard() {
		return board;
	}

	public void setBoard(int board) {
		this.board = board;
	}

}
