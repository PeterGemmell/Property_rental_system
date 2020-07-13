package com.example.rentalsystem.rentalservice.controllers;

import com.example.rentalsystem.rentalservice.models.Property;
import com.example.rentalsystem.rentalservice.repositories.PropertyRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping(value = "/properties")
    public ResponseEntity<List<Property>> getAllProperties(){
        return new ResponseEntity<>(propertyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/properties/{id}")
    public ResponseEntity getProperty(@PathVariable Long id){
        return new ResponseEntity<>(propertyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/properties/countryandcity")
    public ResponseEntity findByCountryAndCity(
            @RequestParam(name = "country") String country,
            @RequestParam(name = "city") String city){
        return new ResponseEntity(propertyRepository.findByCountryAndCity(country, city), HttpStatus.OK);
    }

    @GetMapping(value = "/properties/cityandguests")
    public ResponseEntity findByCityAndNumberOfGuests(
            @RequestParam(name = "city") String city,
            @RequestParam(name = "numOfGuests") Integer numOfGuests){
        return new ResponseEntity(propertyRepository.findByCityAndNumberOfGuests(city, numOfGuests), HttpStatus.OK);
    }

    @GetMapping(value = "/properties/cityandrating")
    public ResponseEntity findByCityAndRating(
            @RequestParam(name = "city") String city,
            @RequestParam(name = "rating") Integer rating){
        return new ResponseEntity(propertyRepository.findByCityAndRating(city, rating), HttpStatus.OK);
    }

    @GetMapping(value = "/properties/cityandprice")
    public ResponseEntity findByCityAndPricePerNight(
            @RequestParam(name = "city") String city,
            @RequestParam(name = "pricePerNight") Double pricePerNight){
        return new ResponseEntity(propertyRepository.findByCityAndPricePerNight(city, pricePerNight), HttpStatus.OK);
    }

    @PostMapping(value = "/properties")
    public ResponseEntity<Property> postProperty(@RequestBody Property property){
        propertyRepository.save(property);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/properties/{id}")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property){
        propertyRepository.save(property);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @DeleteMapping(value = "/properties/{id}")
    public ResponseEntity<Property> deleteProperty(@PathVariable Long id){
        Property found = propertyRepository.getOne(id);
        propertyRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
