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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Product name is required!")
	@Size(min = 2, max = 80, message = "Product name must be between 2 and 80 characters long.")
	private String prodName;
	
	@NotEmpty(message = "Product description is required!")
	@Size(min = 3, max = 255, message = "Product description must be between 3 and 255 characters long.")
	private String description;
	
	@NotNull(message = "Price must not be blank.")
	@DecimalMin(value = "1.00", inclusive = true, message = "Price should be greater than 0.")
	private Double price;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Indicates relationship with the other table
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "products_categories", 
			joinColumns = @JoinColumn(name = "product_id"), 
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories;
	
	// CONSTRUCTORS:
	// Constructor 1: Blank constructor
	public Product() {
	}

	// Constructor 2: With fields
	public Product(
			String prodName,
			String description,
			Double price,
			List<Category> categories
			) {
		this.prodName = prodName;
		this.description = description;
		this.price = price;
		this.categories = categories;
	}
	
	// Constructor 3: Special constructor for timestamps
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
