package com.example.demoMysqltutorial.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.demoMysqltutorial.model.Books;

import org.springframework.stereotype.Repository;



@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{
	Books findBypurchasereference(String purchasereference);
	List<Books> findBycategory(long purchasereference);
	List<Books> findBytitleContaining(String title); 
	List<Books> findBydescriptionContaining(String description);
}
