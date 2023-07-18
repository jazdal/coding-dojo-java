package com.sternritter.dojooverflow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "questions")
public class Question {
	// MODEL STRUCTURE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	@NotBlank(message = "Question must not be blank.")
	private String text;
	
	// This will not allow the createdAt column to be updated after creation:
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Establishes relationships with other tables:
	@OneToMany(
			mappedBy = "question", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY
	)
	private List<Answer> answers;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "tagged_questions", 
			joinColumns = @JoinColumn(name = "question_id"), 
			inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private List<Tag> tags;
	
	// CONSTRUCTORS
	// Constructor 1: Blank constructor
	public Question() {
	}

	// Constructor 2: With fields
	public Question(
			String text, 
			List<Answer> answers,
			List<Tag> tags
			) {
		this.text = text;
		this.answers = answers;
		this.tags = tags;
	}
	
	// Constructor 3: Special constructor for timestamps:
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
