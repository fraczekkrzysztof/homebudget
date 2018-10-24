package com.fraczekkrzysztof.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fraczekkrzysztof.homebudget.entity.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {

}
