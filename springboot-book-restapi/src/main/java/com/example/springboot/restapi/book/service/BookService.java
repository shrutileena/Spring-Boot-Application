package com.example.springboot.restapi.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.restapi.book.model.Book;
import com.example.springboot.restapi.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> books = (List<Book>) bookRepository.findAll();
		return books;
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	public Book updateBook(int id, Book book) {
		bookRepository.save(book);
		return bookRepository.findById(book.getId());
	}
}
