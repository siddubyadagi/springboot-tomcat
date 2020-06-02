package com.accurate.solutions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accurate.solutions.model.Customer;

@RestController
@RequestMapping("/springboot/api")
public class HomeController {

    	@GetMapping(value = "/health")
    	public String customerInformation(){
            return "Hey, I am from external weblogic container";
        }
    	
    	@GetMapping(value = "/customer/all")
    	public ResponseEntity<List<Customer>> getCustomers() {
    		
    		List<Customer> customers = new ArrayList<>();
    		Customer customer1 = new Customer(1, "testa", "testb", "test@gmail.com");
    		Customer customer2 = new Customer(1, "testb", "testb", "testb@gmail.com");
    		Customer customer3 = new Customer(1, "testc", "testb", "testc@gmail.com");
    		Customer customer4 = new Customer(1, "testd", "testb", "testd@gmail.com");
    		Customer customer5 = new Customer(1, "teste", "testb", "teste@gmail.com");
    		customers.add(customer1);
    		customers.add(customer2);
    		customers.add(customer3);
    		customers.add(customer4);
    		customers.add(customer5);
    		
    		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    	}
    	
    	@GetMapping(value = "/customer/{id}")
    	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
    		
    		if(id <= 2) {
    			Customer customer = new Customer(1, "testa", "testb", "test@gmail.com");
    			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    		}
    		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    	}
    	
    }
