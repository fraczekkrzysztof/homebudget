package com.fraczekkrzysztof.homebudget.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraczekkrzysztof.homebudget.dao.ExpenseDao;
import com.fraczekkrzysztof.homebudget.entity.Expense;
import com.fraczekkrzysztof.homebudget.helper.ExpenseStatistic;

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
	
	public Expense findOne(int id) {
		return expenseDao.findById(id).orElse(null);
	}
	
	public Expense saveExpense(Expense exp) {
		return expenseDao.save(exp);
	}
	
	public void deleteExpense(int expenseId) {
		expenseDao.deleteById(expenseId);
	}
	
	public List<ExpenseStatistic> getExpenseStatistic(){
		return expenseDao.getExpenseStatistic();
	}
	
	public List<Expense> getFilteredExpense(int id, Date from, Date to){
		return expenseDao.getFilteredExpense(id, from, to);
	}
	public List<Expense> getFilteredExpense2(int id){
		return expenseDao.getFilteredExpense2(id);
	}
	
	public List<ExpenseStatistic> getFilteredStatistic(int id, Date from, Date to){
		return expenseDao.getFilteredStatistic(id, from, to);
	}
	
}
