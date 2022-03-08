package com.example.demoMysqltutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMysqltutorial.exception.ResourceNotFoundException;
import com.example.demoMysqltutorial.model.Books;
import com.example.demoMysqltutorial.model.Category;
import com.example.demoMysqltutorial.model.Employee;
import com.example.demoMysqltutorial.repository.BooksRepository;
import com.example.demoMysqltutorial.repository.CategoryRepository;
import com.example.demoMysqltutorial.repository.EmployeeRepository;
import com.example.demoMysqltutorial.service.BooksService;
import com.example.demoMysqltutorial.service.EmployeeService;



@RestController
@RequestMapping("/api/v1")
public class BooksController {
	
	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private BooksService booksService;
	
	@Autowired
	private CategoryRepository categoryRepository;


	
	    //Create  Book record api
		@PostMapping("/Book_Add")
		public ResponseEntity<Books> saveEmployee(@RequestBody Books books){
		Category category = categoryRepository.findById(books.getCategory())
		.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + books.getId() ,null,books.getId()));
		return new ResponseEntity<Books>(booksService.saveBooks(books), HttpStatus.CREATED);
		}
		
		//Get All Books Records
		@GetMapping("/Books")
		public List<Books> getAllBooks(){
		return booksRepository.findAll();
		}
		

		//Get Book by id
		@GetMapping("/Books/{id}")
		public ResponseEntity<Optional<Books>> getBookById(@PathVariable("id") long bookid)	{
		Optional<Books> books = booksRepository.findById(bookid);
		return ResponseEntity.ok().body(books);
		}
		
		
		//Get Book by id
		@GetMapping("/Books_By_Category/{category}")
		public List<Books> getBookByCategory(@PathVariable("category") long cid){
		List<Books> books = booksRepository.findBycategory(cid);
		return books;
		}
		
		
		
		@PutMapping("/Purchase_Book_Step01/{id}")
		public ResponseEntity<Books> updateBooks(
		@PathVariable(value = "id") Long bookId,
		@RequestBody Books booksUpdateDetails) throws ResourceNotFoundException {
		
		Books books = booksRepository.findById(bookId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found :: " + bookId, null, bookId));
			
		
		books.setPurchase_status(booksUpdateDetails.getPurchase_status());
		books.setPurchasereference(booksUpdateDetails.getPurchasereference());
	
		
			
		final Books updatedBooks = booksRepository.save(books);
		return ResponseEntity.ok(updatedBooks);
		}
		


}
