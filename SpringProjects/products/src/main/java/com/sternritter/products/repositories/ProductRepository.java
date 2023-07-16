package com.sternritter.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.products.models.Category;
import com.sternritter.products.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	// Gets all products from the database:
	List<Product> findAll();
	
	// Retrieves a list of all products for a given category:
	List<Product> findAllByCategories(Category category);
	
	// Retrieves a list of all products not belonging to a certain category:
	List<Product> findByCategoriesNotContains(Category category);
}
