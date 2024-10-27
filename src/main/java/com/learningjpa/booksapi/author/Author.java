package com.learningjpa.booksapi.author;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningjpa.booksapi.book.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	int id;
	String name;
	String email;
	
	public Author( String name, String email, List<Book> allBooks) {
		
		this.name = name;
		this.email = email;
		this.allBooks = allBooks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Book> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(List<Book> allBooks) {
		this.allBooks = allBooks;
	}

	@OneToMany(mappedBy="author")
	@JsonIgnore
	List<Book> allBooks;

	public Author() {
		
	}

}
