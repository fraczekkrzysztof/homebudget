package com.fraczekkrzysztof.homebudget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraczekkrzysztof.homebudget.entity.Category;
import com.fraczekkrzysztof.homebudget.entity.Expense;
import com.fraczekkrzysztof.homebudget.service.CategoryService;
import com.fraczekkrzysztof.homebudget.service.ExpenseService;

@RestController()
@RequestMapping("/api")
public class ExpenseRestController {

	@Autowired
	private ExpenseService expenseService;
	
	@Autowired 
	private CategoryService categoryService;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from HomeRestController!";
	}
	
	@GetMapping("/expense")
	public List<Expense> getAllExpense(){
		return expenseService.findAll();
	}
	
	@GetMapping("/expense/{expenseId}")
	public Expense getExpenseById(@PathVariable int expenseId) {
		return expenseService.findOne(expenseId);
	}
	
	@PostMapping("/expense")
	public Expense addExpense(@RequestBody Expense expense) {
		Category tempCategory = expense.getCategory();
		Category category = categoryService.findBySymbol(tempCategory.getSymbol());
		expense.setCategory(category);
		expense.setId(0);
		Expense savedExpense = expenseService.saveExpense(expense);
		
		return savedExpense;
	}
	
	@PutMapping("/expense")
	public Expense updateExpense(@RequestBody Expense expense) {
		Category tempCategory = expense.getCategory();
		if (!(tempCategory == null)) {
			Category category = categoryService.findOne(tempCategory.getId());
			if (category == null) {
				category = categoryService.findBySymbol(tempCategory.getSymbol());
			}
			if (!(category==null)) {
				expense.setCategory(category);
			}
		}
		return expenseService.saveExpense(expense);
	}
	
	@DeleteMapping("/expense/{expenseId}")
	public String deleteExpense(@PathVariable int expenseId) {
		expenseService.deleteExpense(expenseId);
		return "Expense deleted!";
	}
	
	
}
