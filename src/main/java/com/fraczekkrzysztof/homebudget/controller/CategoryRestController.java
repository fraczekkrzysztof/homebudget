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
import com.fraczekkrzysztof.homebudget.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
	
	@GetMapping("/category/{categoryId}")
	public Category getCategoryById(@PathVariable int categoryId) {
		return categoryService.findOne(categoryId);
	}
	
	@GetMapping("/category/bysymbol/{categorySymbol}")
	public Category getCategoryBySymbol(@PathVariable String categorySymbol) {
		return categoryService.findBySymbol(categorySymbol);
	}
	
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		category.setId(0);
		return categoryService.save(category);
	}
	
	@PutMapping("/category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@DeleteMapping("/category/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {
		categoryService.delete(categoryId);
		return "Category deleted!";
	}
}
