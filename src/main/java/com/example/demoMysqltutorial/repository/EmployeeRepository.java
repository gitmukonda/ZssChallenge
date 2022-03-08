package com.example.demoMysqltutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoMysqltutorial.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
