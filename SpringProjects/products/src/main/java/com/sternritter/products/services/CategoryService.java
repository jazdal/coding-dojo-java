package com.sternritter.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.products.models.Category;
import com.sternritter.products.models.Product;
import com.sternritter.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	// Adds the CategoryRepository as a dependency:
	@Autowired
	private CategoryRepository catRepo;
	
	// Returns all categories (READ):
	public List<Category> getAll() {
		return catRepo.findAll();
	}
	
	// Returns all categories belonging to a product (READ):
	public List<Category> getCategoriesInclusive(Product product) {
		return catRepo.findAllByProducts(product);
	}
	
	// Returns all categories not belonging to a product (READ):
	public List<Category> getCategoriesExclusive(Product product) {
		return catRepo.findByProductsNotContains(product);
	}
	
	// Creates a new category (CREATE):
	public Category create(Category category) {
		return catRepo.save(category);
	}
	
	// Retrieves a category (READ):
	public Category findCategory(Long id) {
		return catRepo.findById(id).orElse(null);
	}
	
	// Updates an existing category (UPDATE):
	public Category update(Category category) {
		return catRepo.save(category);
	}
	
	// Deletes a category (DELETE):
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
	}
}
