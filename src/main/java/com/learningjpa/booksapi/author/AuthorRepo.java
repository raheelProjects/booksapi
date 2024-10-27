package com.learningjpa.booksapi.author;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

	@Transactional
	default Author updateOrInsert(Author entity) {
		return save(entity);
	}

}
