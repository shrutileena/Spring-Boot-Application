package com.example.springboot.restapi.book.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publisher_id")
	private int pId;
	
	@Column(name = "publisher_name")
	private String pName;
	
	@Column(name = "publisher_city")
	private String pCity;
	
	@OneToOne(mappedBy = "publisher")
	@JsonBackReference
	private Book book;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCity() {
		return pCity;
	}

	public void setpCity(String pCity) {
		this.pCity = pCity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publisher(int pId, String pName, String pCity, Book book) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pCity = pCity;
		this.book = book;
	}

	@Override
	public String toString() {
		return "Publisher [pId=" + pId + ", pName=" + pName + ", pCity=" + pCity + ", book=" + book + "]";
	}

}
