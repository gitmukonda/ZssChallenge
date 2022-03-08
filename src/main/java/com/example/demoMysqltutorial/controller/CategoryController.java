package com.example.demoMysqltutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;

	 	
	    //Create  Category record api
		@PostMapping("/Category_Add")
		public Category saveCategory(@RequestBody Category category){
		return categoryRepository.save(category);
		}
		
		//Get All Category Records
		@GetMapping("/Categories")
		public List<Category> getAllCategory(){
		return categoryRepository.findAll();
		}
		


}
