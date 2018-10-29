package com.fraczekkrzysztof.homebudget.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fraczekkrzysztof.homebudget.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/expense")
	public String getAllExpenses(Model theModel) {
		theModel.addAttribute("listOfExpense", expenseService.findAll());
		return "expense";
	}
}
