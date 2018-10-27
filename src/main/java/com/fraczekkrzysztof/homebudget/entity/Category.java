package com.fraczekkrzysztof.homebudget.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t2_category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id")
	private int id;
	
	@Column(name = "cat_symbol")
	private String symbol;
	
	@Column(name="cat_name")
	private String name;
	
	
	public Category() {
		
	}

	public Category(int id, String symbol, String name) {
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
		return "Category [id=" + id + ", symbol=" + symbol + ", name=" + name + "]";
	}

	
	
	
	
}
