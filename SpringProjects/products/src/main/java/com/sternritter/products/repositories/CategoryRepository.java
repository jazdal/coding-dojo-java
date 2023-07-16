package com.sternritter.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.products.models.Category;
import com.sternritter.products.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	// Gets all the categories from the database:
	List<Category> findAll();
	
	// Retrieves a list of all categories for a particular product:
	List<Category> findAllByProducts(Product product);
	
	// Retrieves a list of all categories a particular product does not belong to:
	List<Category> findByProductsNotContains(Product product);
}
