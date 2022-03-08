package com.example.demoMysqltutorial.service;

import java.util.List;

import com.example.demoMysqltutorial.model.Books;

public interface BooksService {
	
	Books saveBooks(Books books);
	List<Books> getAllBooks();


}
