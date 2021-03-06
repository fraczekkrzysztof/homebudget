package com.fraczekkrzysztof.homebudget.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fraczekkrzysztof.homebudget.dao.CategoryDao;
import com.fraczekkrzysztof.homebudget.entity.Category;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> findAll(){
		List<Category> categoryList = new ArrayList<Category>();
		for(Category c : categoryDao.findAll()) {
			categoryList.add(c);
		}
		return categoryList;
		
	}
	
	public Category findOne(int id) {
		return categoryDao.findById(id).orElse(null);
	}
	
	public Category save(Category category) {
		return categoryDao.save(category);
	}
	
	public void delete(int categoryId) {
		categoryDao.deleteById(categoryId);
	}
	
	public Category findBySymbol(String categorySymbol) {
		return categoryDao.findBySymbol(categorySymbol);
	}
}
