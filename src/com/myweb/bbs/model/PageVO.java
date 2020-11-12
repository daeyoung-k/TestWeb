package com.myweb.bbs.model;

public class PageVO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int pageNum = 1;
	private int amount = 10;
	private int total;
	
	
	public PageVO(int pageNum, int amount, int total) {
		
		this.pageNum = pageNum;
		this.amount = amount;
		this.total = total;
		
		this.endPage = (int)Math.ceil(this.pageNum / (double)5)* 5;
		
		this.startPage = this.endPage - 5 + 1;
		
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		if(endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = realEnd > endPage;
		
		System.out.println("시작페이지:" + this.startPage + ",끝페이지:" + this.endPage);
		
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
	
}
