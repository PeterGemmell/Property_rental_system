package com.example.rentalsystem.rentalservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_first_name")
    private String customerFirstName;

    @Column(name="customer_last_name")
    private String customerLastName;

    @Column(name="customer_contact_number")
    private String customerContactNumber;

    @Column(name="customer_email")
    private String customerEmail;

    @Column(name="customer_password")
    private String customerPassword;

    @JsonIgnoreProperties(value = "customers")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Customer(String customerFirstName, String customerLastName,String customerContactNumber, String customerEmail, String customerPassword){
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
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
