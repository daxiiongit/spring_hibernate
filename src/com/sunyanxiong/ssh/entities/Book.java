package com.sunyanxiong.ssh.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sun_book")
public class Book {

	private int id;
	private String bookname;
	private String isbn;
	private String price;
	private String stack;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getBookname() {
		return bookname;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getPrice() {
		return price;
	}

	public String getStack() {
		return stack;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

}
