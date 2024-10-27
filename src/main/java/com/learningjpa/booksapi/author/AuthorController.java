package com.learningjpa.booksapi.author;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningjpa.booksapi.book.Book;
import com.learningjpa.booksapi.book.BookRepo;

@RestController
public class AuthorController {

	private final AuthorRepo ar;
	private final BookRepo br;
	
	@Autowired
	public AuthorController(AuthorRepo ar,BookRepo br) {
		this.ar=ar;
		this.br=br;
	}
	
	public Author findAuthor(int id){
		Optional<Author> author= ar.findById(id);
		if(author.isEmpty()) {
			throw new RuntimeException("no such author found");
		}
		return author.get();
	}
	
	@GetMapping(path="/authors")
	List<Author> getAuthors(){
		return ar.findAll();
	}
	
	@GetMapping(path="/authors/{id}")
	Author getAuthor(@PathVariable int id) {
		Author author= findAuthor(id);
		return author;
	}
	
	@PostMapping(path="/authors")
	void addAuthor(@RequestBody Author au) {
		ar.save(au);
	}
	
	@PutMapping(path="/authors/{id}")
	void updateAuthor(@PathVariable int id,@RequestBody Author au) {
//		Author author= findAuthor(id);
		au.setId(id);
		ar.updateOrInsert(au);
		
	}
	
	@DeleteMapping(path="/authors/{id}")
	void removeAuthor(@PathVariable int id) {
		
		Author author =  findAuthor(id);;
		
		ar.delete(author);
	}
	
	@GetMapping(path="/authors/{id}/books")
	List<Book> getAuthorBooks(@PathVariable int id){
		Author author= findAuthor(id);
		return author.getAllBooks();
	}
	
	@PostMapping(path="/authors/{id}/books")
	void addAuthorBooks(@PathVariable int id,@RequestBody Book bookDetail ){
		Author author= findAuthor(id);
		bookDetail.setAuthor(author);
		br.save(bookDetail);
		
	}
	
}
