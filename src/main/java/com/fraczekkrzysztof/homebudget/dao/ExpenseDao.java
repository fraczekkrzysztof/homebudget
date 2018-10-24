package com.fraczekkrzysztof.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fraczekkrzysztof.homebudget.entity.Expense;

@Repository
public interface ExpenseDao extends CrudRepository<Expense, Integer> {

}
