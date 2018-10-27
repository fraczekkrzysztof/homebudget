package com.fraczekkrzysztof.homebudget.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fraczekkrzysztof.homebudget.entity.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
	
	@Query("from Category cat where cat.symbol = :catSymbol")
	public Category findBySymbol(@Param("catSymbol") String catSymbol);

}
