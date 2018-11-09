package com.fraczekkrzysztof.homebudget.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fraczekkrzysztof.homebudget.entity.Expense;
import com.fraczekkrzysztof.homebudget.helper.ExpenseStatistic;

@Repository
public interface ExpenseDao extends CrudRepository<Expense, Integer> {
	
	@Query("SELECT new com.fraczekkrzysztof.homebudget.helper.ExpenseStatistic(c.name, count(c))"
			+ " FROM Expense as e"
			+ " JOIN e.category as c"
			+ " GROUP BY c.name"
			)
	public List<ExpenseStatistic> getExpenseStatistic(); 

}
