package com.sternritter.relationships.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 200, message = "Must be at least 2 characters.")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 200, message = "Must be at least 2 characters.")
	private String lastName;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// Indicates relationship with the other table
	@OneToOne(
			mappedBy="person", 
			cascade=CascadeType.ALL, 
			fetch=FetchType.LAZY
			)
	private License license;
	
	// REQUIRED CONSTRUCTORS
	// Constructor 1: Blank constructor
	public Person() {
	}
	
	/* Constructor 2: With required fields
	 * When creating this second constructor, do not include the
	 * id, createdAt, and updatedAt fields */
	public Person(
			String firstName, 
			String lastName
			) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}
}
