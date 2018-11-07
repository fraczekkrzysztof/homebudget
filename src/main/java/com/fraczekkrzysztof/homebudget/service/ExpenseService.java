package com.fraczekkrzysztof.homebudget.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraczekkrzysztof.homebudget.dao.ExpenseDao;
import com.fraczekkrzysztof.homebudget.entity.Expense;
import com.fraczekkrzysztof.homebudget.wrapper.ExpenseWrapper;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseDao expenseDao;
	
	public List<Expense> findAll(){
		List<Expense> listExpense =  new ArrayList<Expense>();
		for (Expense exp : expenseDao.findAll()) {
			listExpense.add(exp);
		}
		return listExpense;
	}
	public List<ExpenseWrapper> findAllWrapped(){
		List<ExpenseWrapper> listExpenseWrapped = new ArrayList<ExpenseWrapper>();
		for (Expense exp: expenseDao.findAll()){
			listExpenseWrapped.add(new ExpenseWrapper(false,exp));
		}
		return listExpenseWrapped;
	}
	
	public Expense findOne(int id) {
		return expenseDao.findById(id).orElse(null);
	}
	
	public Expense saveExpense(Expense exp) {
		return expenseDao.save(exp);
	}
	
	public void deleteExpense(int expenseId) {
		expenseDao.deleteById(expenseId);
	}
	
}
