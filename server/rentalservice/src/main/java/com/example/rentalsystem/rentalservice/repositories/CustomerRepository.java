package com.example.rentalsystem.rentalservice.repositories;

import com.example.rentalsystem.rentalservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerUserNameAndCustomerPassword(String customerUserName, String customerPassword);
}


//  JpaRepository is JPA specific extension of Repository . It contains the full API of CrudRepository and PagingAndSortingRepository.
//  So it contains API for basic CRUD operations and also API for pagination and sorting.
