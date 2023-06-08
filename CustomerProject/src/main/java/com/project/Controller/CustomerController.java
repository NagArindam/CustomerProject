package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entity.Customer;
import com.project.Repository.CustomerRepository;

@RestController
@RequestMapping("/Customers")
public class CustomerController {

	private final CustomerRepository CustomerRepo;
	
	@Autowired
	public CustomerController(CustomerRepository CustomerRepo) {
		this.CustomerRepo = CustomerRepo;
	}
	
	//Find list of all the customers.
	@GetMapping
	public List<Customer> retrieveAllCustomers(){
		return CustomerRepo.findAll();
	}
	
	//Get Customer details by entering Id.
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
	    return CustomerRepo.findById(id)
	             .orElseThrow(() -> new IllegalArgumentException("Entered Invalid Customer Id: "+id));
	}
	
	//Add a new Customer to the database.
	@PostMapping
	public Customer addANewCustomer(@RequestBody Customer cus) {
		return CustomerRepo.save(cus);
	}
	
	//Update our existing Customers by entering Id.
	@PutMapping("/{id}")
	public Customer updateAnExistingCustomer(@PathVariable Integer id, @RequestBody Customer updatedCus) {
		
		Customer existingCustomer = CustomerRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Entered Invalid Customer Id: "+id));
		existingCustomer.setName(updatedCus.getName());
		existingCustomer.setEmail(updatedCus.getEmail());
		existingCustomer.setPhoneNumber(updatedCus.getPhoneNumber());
		
		return CustomerRepo.save(existingCustomer);
		
	}
	
	//Delete Customers from our database by entering the Id.
	@DeleteMapping("/{id}")
	public void deleteACustomerById(@PathVariable Integer id) {
		CustomerRepo.deleteById(id);
	}
	
}

