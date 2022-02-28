package spring.everytime.com.model.domain;

import spring.everytime.com.model.BoardEntity;

public class BoardDomain extends BoardEntity {
	private String user_nm;
	private String type_title;
	private String sub_type;
	private int favorite;
	private int cmt;
	
	// 페이징
	private int list;
	private int pageNow;
	private int total;
	private int pageCount;
	private int rest;
	private int first;
	private int last;
	private int pageFirst;
	private int pageLast;
	private int pageSection;
	
	
	
	public int getPageSection() {
		return pageSection;
	}

	public void setPageSection(int pageSection) {
		this.pageSection = pageSection;
	}

	public int getPageFirst() {
		return pageFirst;
	}

	public void setPageFirst(int pageFirst) {
		this.pageFirst = pageFirst;
	}

	public int getPageLast() {
		return pageLast;
	}

	public void setPageLast(int pageLast) {
		this.pageLast = pageLast;
	}

	public int getList() {
		return list;
	}

	public void setList(int list) {
		this.list = list;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

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
