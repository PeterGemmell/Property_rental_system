package com.example.rentalsystem.rentalservice.repositories;

import com.example.rentalsystem.rentalservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    Booking findByCustomerNameAndBookingReference( String customerName, String bookingReference);
}
