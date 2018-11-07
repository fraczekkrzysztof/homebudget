package com.fraczekkrzysztof.homebudget.controller.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fraczekkrzysztof.homebudget.dto.ExpenseDto;
import com.fraczekkrzysztof.homebudget.entity.Category;
import com.fraczekkrzysztof.homebudget.entity.Expense;
import com.fraczekkrzysztof.homebudget.service.CategoryService;
import com.fraczekkrzysztof.homebudget.service.ExpenseService;
import com.fraczekkrzysztof.homebudget.wrapper.ExpenseWrapper;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	@Autowired
	CategoryService categoryService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private Map<String, String> messages = new TreeMap<String, String>();
	private boolean isUpdate;

	private String getMessage(String key) {
		String message = messages.get(key);
		messages.remove(key);
		return message;
	}

	@GetMapping("/list")
	public String getAllExpenses(Model theModel) {
		theModel.addAttribute("listOfExpense", expenseService.findAllWrapped());
		// after add get confirmation message
		String addMessage = getMessage("addSucces");
		if (!(addMessage == null)) {
			theModel.addAttribute("addSucces", addMessage);
		}
		String deleteMessage = getMessage("deleteSucces");
		if (!(deleteMessage == null)) {
			theModel.addAttribute("deleteSucces", deleteMessage);
		}
		String updateMessage = getMessage("updateSucces");
		if (!(updateMessage == null)) {
			theModel.addAttribute("updateSucces", updateMessage);
		}
		return "expense";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		ExpenseDto theExpenseDto = new ExpenseDto();
		// add a category lis
		Map referenceData = new HashMap();
		Map<Integer, String> theCategories = new LinkedHashMap<Integer, String>();
		for (Category cat : categoryService.findAll()) {
			theCategories.put(cat.getId(), cat.getName());
		}
		theModel.addAttribute("expense", theExpenseDto);
		theModel.addAttribute("categories", theCategories);
		isUpdate=false;
		return "add-expense";
	}

	@PostMapping("/saveExpense")
	public String processDto(@Valid @ModelAttribute("expense") ExpenseDto theExpenseDto,
			BindingResult theBindingResult, Model theModel) throws ParseException {
		System.out.println("Binding result: " + theBindingResult);
		if (theBindingResult.hasErrors()) {
			System.out.println("Binding result: " + theBindingResult);
			return "add-expense";
		} else {
			Category theCategory = categoryService.findOne(theExpenseDto.getCategoryId());
			if (theCategory == null) {
				theModel.addAttribute("addError", "The Category dosn't exist!");
				return "add-expense";
			}
			Expense theExpense = new Expense(theExpenseDto.getId(), theExpenseDto.getDescription(),
					sdf.parse(theExpenseDto.getDate()), theCategory);
			Expense savedExpense = expenseService.saveExpense(theExpense);
			if (isUpdate) {
				messages.put("updateSucces", "The Expense was succesfully updated!");
				isUpdate=false;
			}
			else {
			messages.put("addSucces", "The Expense was succesfuly added!");
			}
			return "redirect:/expense/list";
		}
	}
	
	@GetMapping("/deleteExpense")
	public String deleteExpense(@RequestParam("expenseId") int id) {
		expenseService.deleteExpense(id);
		messages.put("deleteSucces", "The Expense was succesfully deleted");
		return "redirect:/expense/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateExpense(@RequestParam("expenseId") int id, Model theModel) {
		Expense theExpense = expenseService.findOne(id);
		ExpenseDto theExpenseDto = new ExpenseDto(theExpense.getId(),theExpense.getDescription(),sdf.format(theExpense.getDate()),theExpense.getCategory().getId());
		Map<Integer, String> theCategories = new LinkedHashMap<Integer, String>();
		for(Category cat: categoryService.findAll()) {
			theCategories.put(cat.getId(), cat.getName());
		}
		theModel.addAttribute("expense", theExpenseDto);
		theModel.addAttribute("categories", theCategories);
		isUpdate = true;
		return "add-expense";
	}
	
	@PostMapping("/deleteSelectedExpense")
	public String deleteSelectedExpenses(@ModelAttribute("listOfExpense") List<ExpenseWrapper> listOfExpense, Model theModel) {
		for(ExpenseWrapper theExpenseWrapper: listOfExpense) {
			System.out.println(theExpenseWrapper.isSelected());
		}
		return "redirect:/expense/list";
	}

}
