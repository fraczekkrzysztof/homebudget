package com.fraczekkrzysztof.homebudget.controller.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fraczekkrzysztof.homebudget.dto.ExpenseDto;
import com.fraczekkrzysztof.homebudget.entity.Category;
import com.fraczekkrzysztof.homebudget.service.CategoryService;
import com.fraczekkrzysztof.homebudget.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/expense")
	public String getAllExpenses(Model theModel) {
		theModel.addAttribute("listOfExpense", expenseService.findAll());
		return "expense";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		ExpenseDto theExpenseDto = new ExpenseDto();
		//add a category lis
		Map referenceData = new HashMap();
		Map<Integer,String> theCategories = new LinkedHashMap<Integer,String>();
		for(Category cat : categoryService.findAll()) {
			theCategories.put(cat.getId(),cat.getName());
		}
		theModel.addAttribute("expense", theExpenseDto);
		theModel.addAttribute("categories", theCategories);
		return "add-expense";
	}
	
	@PostMapping("/saveExpense")
	public String processDto(@Valid @ModelAttribute("expense") ExpenseDto theExpense, BindingResult theBindingResult) {
		System.out.println(theExpense.getDescription());
		System.out.println(theExpense.getCategoryId());
		System.out.println("Binding result: " + theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "add-expense";
		} else {
			return "redirect:/expense";
		}
	}
}
