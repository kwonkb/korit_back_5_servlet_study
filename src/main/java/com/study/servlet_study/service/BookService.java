package com.study.servlet_study.service;

import java.util.List;
import java.util.Map;

import com.study.servlet_study.entity.Book;
import com.study.servlet_study.repository.BookRepository;

public class BookService {
	private  BookRepository bookRepository;
	private static BookService instance;
	private BookService() {
		bookRepository = BookRepository.getInstance();
		
	}
	
	public static BookService getInstance() {
		if(instance == null) {
			instance = new BookService();
		}
		return instance;
	}
	
	public boolean addbook(Book book) {
		return bookRepository.saveBook(book) > 0;
	}
	
	public Book getbook(int bookId) {
		return bookRepository.findBookByBookId(bookId);
	}
	
	public List<Book> getBookList(Map<String,String> params) {
		return bookRepository.searchBookList(params);
	}
	

}
