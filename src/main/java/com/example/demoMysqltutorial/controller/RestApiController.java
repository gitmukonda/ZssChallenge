package com.example.demoMysqltutorial.controller;

import java.io.StringWriter;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demoMysqltutorial.model.Books;
import com.example.demoMysqltutorial.model.Category;
import com.example.demoMysqltutorial.model.Purchase;
import com.example.demoMysqltutorial.model.Purchase.Root;
import com.example.demoMysqltutorial.repository.BooksRepository;
import com.example.demoMysqltutorial.repository.PurchaseResponseRepository;
import com.example.demoMysqltutorial.model.PurchaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
	 public static final String PERSISTENCE_UNIT_NAME = "Books";
	@Autowired
	private PurchaseResponseRepository purchaseResponseRepository;
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	private static String get_url = "http://localhost:8080/api/v1/Categories";
	private static String create_url = "http://localhost:8080/api/v1/Category_Add";
	private static String post_purchase_url = "https://lab.v.co.zw/interview/api/transaction";

	
	@GetMapping("/Consume_Categories")
	public List<Object> getCategories(){
	Object[] category = restTemplate.getForObject(get_url, Object[].class);
	return Arrays.asList(category);
	}
	
	@PostMapping("/Consume_Create_Categories")
	public List<Object>postCountries(@RequestBody Category category){
	ResponseEntity<Category> category2 = restTemplate.postForEntity(create_url,category, Category.class);
	return Arrays.asList(category2);
	}
	
	@PostMapping("/Consume_Purchase")
	public ResponseEntity<ResponseEntity<PurchaseResponse>> postPurchase(@RequestBody Purchase purchase, @RequestHeader(value="Accept") String AcceptHeader,
	@RequestHeader(value="Authorization") String AuthorizationHeader) throws JsonMappingException, JsonProcessingException{
		

	ResponseEntity<PurchaseResponse> resp = restTemplate.postForEntity(post_purchase_url,purchase, PurchaseResponse.class);
	return ResponseEntity.ok(resp);
	}
	
    @PostMapping(path = "/PurchaseBook", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Books getMyResponse(@RequestBody Root root,
            @RequestHeader(value="Accept") String acceptHeader,
            @RequestHeader(value="Authorization") String authorizationHeader
            )
    {
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("Accept", acceptHeader);
        returnValue.put("Authorization", authorizationHeader);
        
        // Add Headers 
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "9ca3d5ed-dc04-4700-8dd6-7d60c3cdf0fa");
        
        RestTemplate restTemplate = new RestTemplate();
        
     // Data attached to the request.
     	HttpEntity<Root> requestBody = new HttpEntity<>(root,headers);
     	
  
     	
     // Send request with POST method.
     ResponseEntity<PurchaseResponse> result 
     = restTemplate.postForEntity(post_purchase_url, requestBody, PurchaseResponse.class);
        
     //Saving the Purchase Response into Database
     PurchaseResponse purResponse = result.getBody();
     purchaseResponseRepository.save(purResponse);
     String pRef = purResponse.getReference();
     
     // Getting book with reference used to pay
   
    Books bk = booksRepository.findBypurchasereference(pRef);
    bk.setPurchase_status(purResponse.getResponseCode());
    bk.setUpdated(purResponse.getUpdated());
    bk.setResponseCode(purResponse.getResponseCode());
    bk.setResponseDescription(purResponse.getResponseDescription());
    bk.setDebitReference(purResponse.getDebitReference());
    // Look Up for the Book that has Received a Purchase Transaction
    
    
    //Update Book record with API response
    booksRepository.save(bk);
     
     return bk;
    }

	
}