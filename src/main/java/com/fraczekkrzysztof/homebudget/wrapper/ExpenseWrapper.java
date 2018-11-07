package com.fraczekkrzysztof.homebudget.wrapper;

import com.fraczekkrzysztof.homebudget.entity.Expense;

public class ExpenseWrapper {
	
	private boolean isSelected;
	private Expense expense;
	
	public ExpenseWrapper() {
		
	}
	

	public ExpenseWrapper(boolean isSelected, Expense theExpense) {
		super();
		this.isSelected = isSelected;
		this.expense = theExpense;
	}


	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense theExpense) {
		this.expense = theExpense;
	}

	@Override
	public String toString() {
		return "ExpenseWrapper [isSelected=" + isSelected + ", theExpense=" + expense + "]";
	}
	
	

}
