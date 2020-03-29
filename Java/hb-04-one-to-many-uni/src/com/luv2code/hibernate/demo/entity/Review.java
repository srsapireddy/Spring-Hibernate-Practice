package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// 244
@Entity
@Table(name="review")
public class Review {

	// define fields
	//annotate fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="comment")
	private String comment;
	
	// define constructors --> To initialize the object
	public Review() {
		
	}

	// define getter/setter
	public Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	// define toString --> If we log this entity to a log file
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

	
}
