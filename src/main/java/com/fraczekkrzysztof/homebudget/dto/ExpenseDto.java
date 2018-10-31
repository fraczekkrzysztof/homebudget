package com.fraczekkrzysztof.homebudget.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExpenseDto {
	private int id;
	@NotNull(message="Description is required")
	@Size(min=10, message="Description is required")
	private String description;
	private Date date;
	private int categoryId;
	
	public ExpenseDto() {
		
	}

	public ExpenseDto(int id, String description, Date date, int categoryId) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.categoryId = categoryId;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ExpenseDto [id=" + id + ", description=" + description + ", date=" + date + ", categoryId=" + categoryId
				+ "]";
	}

	
	
	

}
