package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	//We don't need to add any method, all the CRUD operations are doing by JPARepository itself.
}
