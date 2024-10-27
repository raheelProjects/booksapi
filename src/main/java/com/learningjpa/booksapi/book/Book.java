package com.learningjpa.booksapi.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningjpa.booksapi.author.Author;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;

	private String title;
	private String genre; 
	private String publicationDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Author	author;

	public Book() {
	}
	
	
	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Book(int id, String title, String genre, String publicationDate) {
	
	this.title = title;
	this.genre = genre;
	this.publicationDate = publicationDate;
}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

}
