package com.example.rentalsystem.rentalservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private LocalDate date;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="is_completed")
    private String isCompleted;

    @JsonIgnoreProperties(value="bookings")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties(value="bookings")
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;


    public Booking(String customerName, String isCompleted, Customer customer, Property property){
        this.date = LocalDate.now();
        this.customerName = customerName;
        this.isCompleted = isCompleted;
        this.customer = customer;
        this.property = property;
    }

    public Booking(){

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void addBooking(Booking booking1) {
    }
}
