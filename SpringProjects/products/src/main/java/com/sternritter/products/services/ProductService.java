package com.sternritter.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.products.models.Category;
import com.sternritter.products.models.Product;
import com.sternritter.products.repositories.ProductRepository;

@Service
public class ProductService {
	// Adds the ProductRepository as a dependency:
	@Autowired
	private ProductRepository prodRepo;
	
	// Returns all products (READ):
	public List<Product> getAll() {
		return prodRepo.findAll();
	}
	
	// Returns all products belonging to a category (READ):
	public List<Product> getProductsInclusive(Category category) {
		return prodRepo.findAllByCategories(category);
	}
	
	// Returns all products not belonging to a category (READ):
	public List<Product> getProductsExclusive(Category category) {
		return prodRepo.findByCategoriesNotContains(category);
	}
	
	// Creates a new product (CREATE):
	public Product create(Product product) {
		return prodRepo.save(product);
	}
	
	// Retrieves a product (READ):
	public Product findProduct(Long id) {
		return prodRepo.findById(id).orElse(null);
	}
	
	// Updates a product (UPDATE):
	public Product update(Product product) {
		return prodRepo.save(product);
	}
	
	// Deletes a product (DELETE):
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}
}
