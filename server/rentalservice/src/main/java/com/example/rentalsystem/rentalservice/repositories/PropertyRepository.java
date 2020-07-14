package com.example.rentalsystem.rentalservice.repositories;

import com.example.rentalsystem.rentalservice.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Property findByCountryAndCity(String country, String city);

    Property findByCityAndNumOfGuests(String city, Integer numOfGuests);

    Property findByCityAndRating(String city, Integer rating);

    Property findByCityAndPricePerNight(String city, Double pricePerNight);
}
