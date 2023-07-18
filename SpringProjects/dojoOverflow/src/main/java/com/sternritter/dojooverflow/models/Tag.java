package com.sternritter.dojooverflow.models;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tags")
public class Tag {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String subject;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Establishes relationships with other tables:
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "tagged_questions", 
			joinColumns = @JoinColumn(name = "tag_id"), 
			inverseJoinColumns = @JoinColumn(name = "question_id")
	)
	private List<Question> questions;
	
	// CONSTRUCTORS
	// Constructor 1: Blank constructor
	public Tag() {
	}

	// Constructor 2: With fields
	public Tag(String subject) {
		this.subject = subject;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
