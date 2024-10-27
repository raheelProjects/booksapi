package com.learningjpa.booksapi.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	private final BookRepo br;
	

	@Autowired
	public BookController(BookRepo br){
		this.br = br;
		
	}
	
	@GetMapping("/books")
	Page<Book> getBooks(){
		return br.findAll(PageRequest.of(0, 3));
	}
	
	@GetMapping("/books/{id}")
	Book getBook(@PathVariable int id){
		Optional<Book> optionalBook = br.findById(id);
		if(optionalBook.isEmpty()) {
			throw new RuntimeException("no such book find");
		}
		
		return optionalBook.get();
	}
	
}
