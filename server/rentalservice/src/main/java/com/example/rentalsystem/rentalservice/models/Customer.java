package com.example.rentalsystem.rentalservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.beans.binding.When;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity annotation defines that a class can be mapped to a table.
//@Table annotation specifies the name of the database table to be used for mapping.
@Entity
@Table(name="customers")
public class Customer {

//  @Id annotation marks a field as a primary key field.
    @Id
//  @GeneratedValue annotation specifies that the primary key is automatically allocated by ObjectDB.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//  This GenerationType indicates that the persistence provider must assign primary keys for the entity using a database identity column.

    @Column(name="customer_first_name")
    private String customerFirstName;

    @Column(name="customer_last_name")
    private String customerLastName;

    @Column(name="customer_user_name")
    private String customerUserName;

    @Column(name="customer_contact_number")
    private String customerContactNumber;

    @Column(name="customer_email")
    private String customerEmail;

    @Column(name="customer_password")
    private String customerPassword;

//  @JsonIgnoreProperties is used at class level to mark a property or list of properties to be ignored.

//    Sometimes you have two entities and there's a relationship between them.
//    For example, you might have an entity called University and another entity called Student and a University might have many Students:
//    The University entity might have some basic properties such as id, name, address, etc.
//    as well as a collection property called students that returns the list of students for a given university:
//    Now when you load a University from the database, JPA loads its id, name, and address fields for you.
//    But you have two options for how students should be loaded:
//    To load it together with the rest of the fields (i.e. eagerly), or
//    To load it on-demand (i.e. lazily) when you call the university's getStudents() method.
//    When a university has many students it is not efficient to load all of its students together with it,
//    especially when they are not needed and in suchlike cases you can declare that you want students to be loaded when they are actually needed.
//    This is called lazy loading.


    @JsonIgnoreProperties(value = "customers")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Customer(String customerFirstName, String customerLastName, String customerUserName, String customerContactNumber, String customerEmail, String customerPassword){
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerUserName = customerUserName;
        this.customerContactNumber = customerContactNumber;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.bookings = new ArrayList<Booking>();
    }

    public Customer(){

    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
