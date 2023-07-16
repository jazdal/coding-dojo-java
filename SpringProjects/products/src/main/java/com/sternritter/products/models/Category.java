package com.sternritter.products.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Category name is required!")
	@Size(min = 3, max = 80, message = "Product name must be between 3 and 80 characters long.")
	private String catName;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Indicates relationship with the other table:
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "products_categories", 
			joinColumns = @JoinColumn(name = "category_id"), 
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> products;
	
	// CONSTRUCTORS
	// Constructor 1: Blank constructor
	public Category() {
	}

	// Constructor 2: With fields
	public Category(
			String catName,
			List<Product> products) {
		this.catName = catName;
		this.products = products;
	}
	
	// Constructor 3: Special constructor for timestamps
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
