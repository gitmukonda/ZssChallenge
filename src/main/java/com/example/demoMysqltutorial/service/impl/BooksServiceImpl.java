package com.example.demoMysqltutorial.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demoMysqltutorial.exception.ResourceNotFoundException;
import com.example.demoMysqltutorial.model.Books;
import com.example.demoMysqltutorial.model.Employee;
import com.example.demoMysqltutorial.repository.BooksRepository;
import com.example.demoMysqltutorial.repository.EmployeeRepository;

@Service
public class BooksServiceImpl implements com.example.demoMysqltutorial.service.BooksService{

	private BooksRepository booksRepository;
	
	public BooksServiceImpl(BooksRepository booksRepository) {
		super();
		this.booksRepository = booksRepository;
	}

	@Override
	public Books saveBooks(Books books) {
		return booksRepository.save(books);
	}

	@Override
	public List<Books> getAllBooks() {
		return booksRepository.findAll();
	}



}
