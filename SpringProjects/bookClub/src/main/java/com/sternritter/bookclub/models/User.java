package com.sternritter.bookclub.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name is required!")
	@Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters long.")
	private String name;
	
	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email format!")
	private String email;
	
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, message = "Password must be at least 8 characters long.")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirmation password is required!")
	private String confirm;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Indicates relationship with the other table:
	@OneToMany(
			mappedBy = "user", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY
			)
	private List<BookList> books;
	
	// CONSTRUCTORS
	// Constructor 1: Blank constructor
	public User() {
	}

	// Constructor 2: With fields
	public User(
			String name,
			String email,
			String password,
			List<BookList> books
			) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.books = books;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public List<BookList> getBooks() {
		return books;
	}

	public void setBooks(List<BookList> books) {
		this.books = books;
	}
}
