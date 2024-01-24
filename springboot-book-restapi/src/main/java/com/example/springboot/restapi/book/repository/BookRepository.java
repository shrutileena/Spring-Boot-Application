package com.example.springboot.restapi.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.restapi.book.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);
}
