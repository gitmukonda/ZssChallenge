package com.example.demoMysqltutorial.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMysqltutorial.exception.ResourceNotFoundException;
import com.example.demoMysqltutorial.model.Employee;
import com.example.demoMysqltutorial.repository.EmployeeRepository;
import com.example.demoMysqltutorial.service.EmployeeService;

import com.example.demoMysqltutorial.model.Books;

import com.example.demoMysqltutorial.repository.BooksRepository;

import com.example.demoMysqltutorial.service.BooksService;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	////####  Books Start ####
	
	//Create  Book record api

	
     ////####  Books END ####
	
	
	//Create get all employees api
	@PostMapping("/employeesadd")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
	return employeeRepository.findAll();
	
	}
	
	
	
	//Create employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	//get employee by id
		
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") long employeeid) 
	{
	Optional<Employee> employee = employeeRepository.findById(employeeid);
	
	return ResponseEntity.ok().body(employee);
	}
	
	//Get Employee using method 2 (By ID)
	

	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable(value = "id") Long employeeId,
			 @RequestBody Employee employeeUpdateDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found :: " + employeeId, null, employeeId));
		
		
		employee.setEmailId(employeeUpdateDetails.getEmailId());
		employee.setLastname(employeeUpdateDetails.getLastname());
		employee.setFirstname(employeeUpdateDetails.getFirstname());
	//	employee.setFirstname("fixed for testing");
		
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	
	//Delete employee by id
	@DeleteMapping("/employees/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	throws ResourceNotFoundException {
	Employee employee = employeeRepository.findById(employeeId)
	.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId ,null,employeeId));
    var y = employee.getFirstname()+ " " +employee.getLastname();
    var z = y.toUpperCase();
	employeeRepository.delete(employee);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted "+z, Boolean.TRUE);
	return response;
}
	
	
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
	        employeeService.deleteEmployee(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	  
		@DeleteMapping("/deletedd/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
			
			Optional<Employee> employee = employeeRepository.findById(id);
		
			// delete employee from DB
			employeeService.deleteEmployee(id);
			
			return new ResponseEntity<String>(employee+"Employee deleted successfully!.", HttpStatus.OK);
		}
		
		
	
}
