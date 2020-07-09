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

    @Column(name="booking_ref")
    private String bookingRef;

    @Column(name="is_completed")
    private String isCompleted;

    @JsonIgnoreProperties(value="bookings")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "bookings_properties",
            joinColumns = {@JoinColumn(name="booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="property_id", nullable = false, updatable = false)}
    )

    private List<Property> properties;


    public Booking(String customerName, String bookingRef, String isCompleted, Customer customer){
        this.date = LocalDate.now();
        this.customerName = customerName;
        this.bookingRef = bookingRef;
        this.isCompleted = isCompleted;
        this.customer = customer;
        this.properties = new ArrayList<>();
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

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
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

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
