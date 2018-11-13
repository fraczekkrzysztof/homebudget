package com.fraczekkrzysztof.homebudget.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	
	@Query( "SELECT e FROM Expense as e"
			+ " JOIN e.category as c"
			+ " WHERE (:id = -1 or c.id = :id)"
			+ " AND ((:from is null or e.date > :from)"
			+ " AND (:to is null or e.date<:to))")
	public List<Expense> getFilteredExpense(@Param("id") int id,@Param("from") Date from, @Param("to") Date to);
	
	@Query( "SELECT e FROM Expense as e"
			+ " JOIN e.category as c"
			+ " WHERE (c.id = :id)")
	public List<Expense> getFilteredExpense2(@Param("id") int id);
	
	@Query( "SELECT new com.fraczekkrzysztof.homebudget.helper.ExpenseStatistic(c.name, count(c))"
			+ " FROM Expense as e"
			+ " JOIN e.category as c"
			+ " WHERE (:id = -1 or c.id = :id)"
			+ " AND ((:from is null or e.date > :from)"
			+ " AND	 (:to is null or e.date<:to))"
			+ " GROUP BY c.name")
	public List<ExpenseStatistic> getFilteredStatistic(@Param("id") int id,@Param("from") Date from, @Param("to") Date to);

}
