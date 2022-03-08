package com.example.demoMysqltutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoMysqltutorial.model.PurchaseResponse;

public interface PurchaseResponseRepository extends JpaRepository<PurchaseResponse, Long>{

	
}
