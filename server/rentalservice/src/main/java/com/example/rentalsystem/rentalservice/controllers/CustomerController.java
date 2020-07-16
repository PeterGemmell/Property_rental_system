package com.example.rentalsystem.rentalservice.controllers;

import com.example.rentalsystem.rentalservice.models.Customer;
import com.example.rentalsystem.rentalservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

//Spring RestController annotation is used to create RESTful web services using Spring MVC.
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

//  @Autowired annotation is used for automatic dependency injection.
//  Spring framework is built on dependency injection and we inject the class dependencies through spring bean configuration file.
//  Dependency Injection (DI) is a software design pattern that implements inversion of control for resolving dependencies.
//  An injection is the passing of a dependency to a dependent object that would use it.


//  @GetMapping annotation maps HTTP GET requests onto specific handler methods.
//  ResponseEntity represents an HTTP response, including headers, body, and status.

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

//  @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable.
//  It has the following optional elements:
//  name - name of the path variable to bind to. required - tells whether the path variable is required.

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

//  @RequestParam is a Spring annotation used to bind a web request parameter to a method parameter.
//  It has the following optional elements: defaultValue -
//  used as a fallback when the request parameter is not provided or has an empty value.
//  name - name of the request parameter to bind to.

    @GetMapping(value = "/customers/login")
    public ResponseEntity findByCustomerUserNameAndCustomerPassword(
            @RequestParam(name = "customerUserName") String customerUserName,
            @RequestParam(name = "customerPassword") String customerPassword){
        return new ResponseEntity(customerRepository.findByCustomerUserNameAndCustomerPassword(customerUserName, customerPassword), HttpStatus.OK);
    }

//  @PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
//  @RequestBody annotation maps the HttpRequest body to a transfer or domain object,
//  enabling automatic deserialization of the inbound HttpRequest body onto a Java object.

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

//  PATCH: Submits a partial modification to a resource. If you only need to update one field for the resource,
//  you may want to use the PATCH method.

    @PatchMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

//  @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer found = customerRepository.getOne(id);
        customerRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
