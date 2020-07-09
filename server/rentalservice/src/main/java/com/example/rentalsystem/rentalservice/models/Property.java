package com.example.rentalsystem.rentalservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="type")
    private String type;

    @Column(name="num_of_guests")
    private Integer numOfGuests;

    @Column(name="num_of_rooms")
    private Integer numOfRooms;

    @Column(name="features")
    private String features;

    @Column(name="rating")
    private Integer rating;

    @Column(name="price_per_night")
    private Double pricePerNight;

    @Column(name="image_link")
    private String imgLink;

    @JsonIgnoreProperties(value="properties")
    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @JsonIgnoreProperties(value = "properties")
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Property(String country, String city, String type, Integer numOfGuests, Integer numOfRooms, String features, Integer rating, Double pricePerNight, String imgLink, Host host){
        this.country = country;
        this.city = city;
        this.type = type;
        this.numOfGuests = numOfGuests;
        this.numOfRooms = numOfRooms;
        this.features = features;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.imgLink = imgLink;
        this.host = host;
        this.bookings = new ArrayList<Booking>();
    }

    public Property(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(Integer numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
