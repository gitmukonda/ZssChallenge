package com.example.demoMysqltutorial.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demoMysqltutorial.exception.ResourceNotFoundException;
import com.example.demoMysqltutorial.model.Employee;
import com.example.demoMysqltutorial.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements com.example.demoMysqltutorial.service.EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));
		
	}


	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
