package com.fraczekkrzysztof.homebudget.helper;

public class ExpenseStatistic {
	
	private String categoryName;
	private Long cnt;
	
	
	public ExpenseStatistic() {
		super();
	}
	public ExpenseStatistic(String categoryName, Long cnt) {
		super();
		this.categoryName = categoryName;
		this.cnt = cnt;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
	
	
	
	

}
