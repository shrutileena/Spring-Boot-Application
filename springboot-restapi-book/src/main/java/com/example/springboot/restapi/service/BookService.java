package com.example.springboot.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springboot.restapi.model.Book;

@Service
public class BookService {

	public static List<Book> books = new ArrayList<Book>();
	
	static {
		books.add(new Book(1234, "abc", "xyz"));	
		books.add(new Book(1235, "abcd", "xyza"));
		books.add(new Book(1236, "abcde", "xyzab"));
		books.add(new Book(1237, "abcdef", "xyzabc"));
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = books.stream().filter(e->e.getId()==id).findFirst().get();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void deleteBook(int id) {
		books = books.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
	}
	
	public Book updateBook(int id, Book book) {
		books = books.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		return books.stream().filter(e->e.getId()==id).findFirst().get();
	}
}
