package com.fraczekkrzysztof.homebudget.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t2_expense")
public class Expense {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_id")
	private int id;
	
	@Column(name="exp_desc")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="exp_cat_id")
	private Category category;
	
	public Expense() {
		
	}

	public Expense(int id, String description, Category category) {
		this.id = id;
		this.description = description;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", description=" + description + ", category=" + category + "]";
	}
	
	
	
}
