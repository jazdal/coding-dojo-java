package com.sternritter.savetravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="expenses")
public class Expense {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String expenseName;
	
	@NotEmpty
	private String vendor;
	
	@NotNull(message = "Must not be blank")
	@Min(value = 1, message = "Amount should be greater than 0.")
	private Double amount;
	
	@NotEmpty
	private String description;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// REQUIRED CONSTRUCTORS
	// Constructor 1: Blank constructor
	public Expense() {
	}
	
	/* Constructor 2: With required fields
	 * When creating this second constructor, do not include the
	 * id, createdAt, and updatedAt fields. */
	public Expense(
			String expenseName, 
			String vendor, 
			Double amount, 
			String description
			) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
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

	// REQUIRED GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
