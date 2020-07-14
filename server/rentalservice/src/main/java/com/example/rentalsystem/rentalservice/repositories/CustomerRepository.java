package com.example.rentalsystem.rentalservice.repositories;

import com.example.rentalsystem.rentalservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerUserNameAndCustomerPassword(String customerUserName, String customerPassword);
}
