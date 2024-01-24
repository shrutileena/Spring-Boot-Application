package com.example.springboot.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.restapi.model.Book;
import com.example.springboot.restapi.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
//	@GetMapping("/books")
//	public List<Book> getBooks() {
//		return bookService.getAllBooks();
//	}
	
	// get mapping with status code logic
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(list));
		}
	}
	
//	@GetMapping("/books/{id}")
//	public Book getBook(@PathVariable int id) {
//		return bookService.getBookById(id);
//	}
	
	// get mapping with status code logic
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		Book book = bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(book));
		}
	}
	
//	@PostMapping("/books")
//	public Book createBook(@RequestBody Book book) {
//		bookService.addBook(book);
//		return bookService.getBookById(book.getId());
//	}
	
	@PostMapping("/books")
	public ResponseEntity<Optional<Book>> createBook(@RequestBody Book book) {
		Book b = null;
		try {
			bookService.addBook(book);
			b = bookService.getBookById(book.getId());
			return ResponseEntity.ok(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	@DeleteMapping("/books/{id}")
//	public List<Book> deleteBook(@PathVariable int id) {
//		bookService.deleteBook(id);
//		return bookService.getAllBooks();
//	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<List<Book>> deleteBook(@PathVariable int id) {
		List<Book> books = null;
		try {
			bookService.deleteBook(id);
			books = bookService.getAllBooks();
			return ResponseEntity.of(Optional.of(books));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// if return type is void then use this
//	@DeleteMapping("/books/{id}")
//	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
//		try {
//			bookService.deleteBook(id);
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
	
//	@PutMapping("/books/{id}")
//	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
//		return bookService.updateBook(id, book);
//	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
		Book b = null;
		try {
			b = bookService.updateBook(id, book);
			return ResponseEntity.ok().body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
