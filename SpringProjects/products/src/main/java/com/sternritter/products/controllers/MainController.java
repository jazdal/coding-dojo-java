package com.sternritter.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sternritter.products.models.Category;
import com.sternritter.products.models.Product;
import com.sternritter.products.services.CategoryService;
import com.sternritter.products.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	// Sets up automatic dependency injection for all the services:
	@Autowired
	ProductService prodService;
	
	@Autowired
	CategoryService catService;
	
	// INDEX
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", prodService.getAll());
		model.addAttribute("categories", catService.getAll());
		return "index.jsp";
	}
	
	// NEW PRODUCT
	@GetMapping("/products/new")
	public String newProductForm(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProduct(
			@Valid @ModelAttribute("product") Product product, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newproduct.jsp";
		}
		prodService.create(product);
		return "redirect:/";
	}
	
	// NEW CATEGORY
	@GetMapping("/categories/new")
	public String newCategoryForm(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newCategory(
			@Valid @ModelAttribute("category") Category category, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newcategory.jsp";
		}
		catService.create(category);
		return "redirect:/";
	}
	
	// PRODUCT PAGE
	@GetMapping("/products/{prodId}")
	public String showProduct(
			@PathVariable("prodId") Long prodId, 
			@ModelAttribute("product") Category category, 
			Model model
			) {
		Product currentProduct = prodService.findProduct(prodId);
		model.addAttribute("product", currentProduct);
		model.addAttribute("categoriesOfProducts", catService.getCategoriesInclusive(currentProduct));
		model.addAttribute("categories", catService.getCategoriesExclusive(currentProduct));
		return "showproduct.jsp";
	}
	
	@PostMapping("/products/{prodId}")
	public String addCategory(
			@PathVariable("prodId") Long prodId, 
			@Valid @ModelAttribute("product") Category category, 
			BindingResult result, 
			Model model
			) {
		Product currentProduct = prodService.findProduct(prodId);
		Category chosenCategory = catService.findCategory(category.getId());
		
		if (result.hasErrors()) {
			model.addAttribute("product", currentProduct);
			model.addAttribute("categoriesOfProducts", catService.getCategoriesInclusive(currentProduct));
			model.addAttribute("categories", catService.getCategoriesExclusive(currentProduct));
		}
		
		if (currentProduct != null && chosenCategory != null) {
			currentProduct.getCategories().add(chosenCategory);
			prodService.update(currentProduct);
		}
		return "redirect:/products/" + prodId;
	}
	
	// CATEGORY PAGE
	@GetMapping("/categories/{catId}")
	public String showCategory(
			@PathVariable("catId") Long catId, 
			@ModelAttribute("category") Product product, 
			Model model
			) {
		Category thisCategory = catService.findCategory(catId);
		model.addAttribute("category", thisCategory);
		model.addAttribute("productsInCategories", prodService.getProductsInclusive(thisCategory));
		model.addAttribute("products", prodService.getProductsExclusive(thisCategory));
		return "showcategory.jsp";
	}
	
	@PostMapping("/categories/{catId}")
	public String addProduct(
			@PathVariable("catId") Long catId, 
			@Valid @ModelAttribute("category") Product product, 
			BindingResult result, 
			Model model
			) {
		Category thisCategory = catService.findCategory(catId);
		Product selectedProduct = prodService.findProduct(product.getId());
		
		if (result.hasErrors()) {
			model.addAttribute("category", thisCategory);
			model.addAttribute("productsInCategories", prodService.getProductsInclusive(thisCategory));
			model.addAttribute("products", prodService.getProductsExclusive(thisCategory));
		}
		
		if (thisCategory != null && selectedProduct != null) {
			thisCategory.getProducts().add(selectedProduct);
			catService.update(thisCategory);
		}
		return "redirect:/categories/" + catId;
	}
}
