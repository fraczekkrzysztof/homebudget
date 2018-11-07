package com.fraczekkrzysztof.homebudget.controller.web;

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

import com.fraczekkrzysztof.homebudget.dto.CategoryDto;
import com.fraczekkrzysztof.homebudget.entity.Category;
import com.fraczekkrzysztof.homebudget.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	private Map<String, String> messages = new TreeMap<String, String>();

	private String getMessage(String key) {
		String message = messages.get(key);
		messages.remove(key);
		return message;
	}

	@GetMapping("/list")
	public String getAllCategories(Model theModel) {
		theModel.addAttribute("listOfCategories", categoryService.findAll());
		// after add get confirmation message
		String addMessage = getMessage("addSucces");
		if (!(addMessage == null)) {
			theModel.addAttribute("addSucces", addMessage);
		}
		return "categories";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		CategoryDto categoryDto = new CategoryDto();
		theModel.addAttribute("category", categoryDto);
		return "add-category";
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@Valid @ModelAttribute("category") CategoryDto categoryDto,
			BindingResult theBidingResult, Model theModel) {
		if (theBidingResult.hasErrors()) {
			return "add-category";
		}
		Category newCategory = new Category(0, categoryDto.getSymbol(), categoryDto.getName());
		Category savedCategory = categoryService.save(newCategory);
		messages.put("addSucces", "The Expense was succesfuly added!");
		return "redirect:/category/list";
	}
}
