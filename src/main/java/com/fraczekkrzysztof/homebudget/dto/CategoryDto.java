package com.fraczekkrzysztof.homebudget.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryDto {

	private int id;
	@NotNull(message = "Symbol is required")
	@Size(message = "Symbol is required")
	private String symbol;
	@NotNull(message = "Name is required")
	@Size(message = "Name is required")
	private String name;

	public CategoryDto() {

	}

	public CategoryDto(int id, String symbol, String name) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", symbol=" + symbol + ", name=" + name + "]";
	}

}
