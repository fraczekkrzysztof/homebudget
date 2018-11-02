package com.fraczekkrzysztof.homebudget.controller.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fraczekkrzysztof.homebudget.dto.ExpenseDto;
import com.fraczekkrzysztof.homebudget.entity.Category;
import com.fraczekkrzysztof.homebudget.entity.Expense;
import com.fraczekkrzysztof.homebudget.service.CategoryService;
import com.fraczekkrzysztof.homebudget.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	@Autowired
	CategoryService categoryService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
	public String processDto(@Valid @ModelAttribute("expense") ExpenseDto theExpenseDto, Model theModel, BindingResult theBindingResult) throws ParseException {
//		System.out.println(theExpense.getDescription());
//		System.out.println(theExpense.getCategoryId());
//		System.out.println("Binding result: " + theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "add-expense";
		} else {
			Category theCategory = categoryService.findOne(theExpenseDto.getCategoryId());
			if (theCategory == null) {
				theModel.addAttribute("addError", "The Category dosn't exist!");
				return "add-expense";
			}
			Expense theExpense = new Expense(theExpenseDto.getId(), theExpenseDto.getDescription(), sdf.parse(theExpenseDto.getDate()),theCategory);
			Expense savedExpense = expenseService.saveExpense(theExpense);
			//theModel.addAttribute("addSucces","The Expense was succesfully added!");
			return "redirect:/expense";
		}
	}
	
}
