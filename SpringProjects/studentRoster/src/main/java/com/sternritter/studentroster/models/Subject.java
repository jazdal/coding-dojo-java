package com.sternritter.studentroster.models;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "subjects")
public class Subject {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Class name is required.")
	@Size(min = 3, max = 80, message = "Class name should be at least 3 characters long.")
	private String className;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Indicates relationship with the other table
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "student_classes", 
			joinColumns = @JoinColumn(name = "subject_id"), 
			inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	private List<Student> students;
	
	// CONSTRUCTORS
	// Constructor 1: Blank constructor
	public Subject() {
	}

	// Constructor 2: With fields
	public Subject(
			String className,
			List<Student> students
			) {
		this.className = className;
		this.students = students;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
