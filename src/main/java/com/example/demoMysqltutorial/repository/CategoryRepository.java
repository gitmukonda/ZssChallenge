package com.example.demoMysqltutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoMysqltutorial.model.Books;
import com.example.demoMysqltutorial.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{

}
