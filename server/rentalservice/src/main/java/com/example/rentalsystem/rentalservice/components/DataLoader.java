package com.example.rentalsystem.rentalservice.components;

import com.example.rentalsystem.rentalservice.models.Booking;
import com.example.rentalsystem.rentalservice.models.Customer;
import com.example.rentalsystem.rentalservice.models.Host;
import com.example.rentalsystem.rentalservice.models.Property;
import com.example.rentalsystem.rentalservice.repositories.BookingRepository;
import com.example.rentalsystem.rentalservice.repositories.CustomerRepository;
import com.example.rentalsystem.rentalservice.repositories.HostRepository;
import com.example.rentalsystem.rentalservice.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    HostRepository hostRepository;

    @Autowired
    PropertyRepository propertyRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("Peter", "Gemmell", "PeteG", "07870988635", "petergemmell65@hotmail.com", "Howdy22$");
        customerRepository.save(customer1);

        Host host1 = new Host("Bob", "Smith", "07845234562", "bob@bobsmith.com", "HeyItsBob", "Bob123");
        hostRepository.save(host1);

        Host host2 = new Host("Claire", "Jones", "07890710893", "clairejones1@gmail.com", "TravelTime23", "HeyItsClaire");
        hostRepository.save(host2);

        Host host3 = new Host("Paul", "Davidson", "01413326254", "pauld@gmail.com", "WeePaul5%", "PaulyD53");
        hostRepository.save(host3);

        Property property1 = new Property("France", "Cannes", "Apartment", 4, 2, "Croisette, LE MIRAMAR, located between Le MARTINEZ and Le CARLTON, This luxury residence will allow you the time of a weekend or a few weeks, to discover our French Riviera in the heart of the City of CANNES.", 4, 179.00, "https://a0.muscache.com/im/pictures/75420856/eac8efbb_original.jpg?im_w=1200", host1);
        propertyRepository.save(property1);

        Property property2 = new Property("Italy", "Rome", "Hotel", 3, 2, "In a quiet and safe place, our modern guesthouse offers 5 rooms all with en-suite bathroom.", 4, 76.00, "https://a0.muscache.com/im/pictures/5c1025ae-0c6b-44f5-8bdc-e28d7aba0ea7.jpg?im_w=1200", host1);
        propertyRepository.save(property2);

        Property property3 = new Property("United Kingdom", "London", "Apartment", 4, 2, "The building houses a range of well designed studio and one bedroom apartments suitable for 2 or 4 guests respectively.", 5, 109.00, "https://a0.muscache.com/im/pictures/fe90559c-7de8-4246-8a7d-3435a7b84d4d.jpg?im_w=1200", host2);
        propertyRepository.save(property3);

        Property property4 = new Property("Spain", "Madrid", "Apartment", 8, 3, "All rooms have AC, Internet, fully equipped kitchen, SMART TV with Netflix.", 4, 117.00, "https://a0.muscache.com/im/pictures/d3c25204-fe8d-448b-8aff-4c6788310b09.jpg?im_w=1200", host3);
        propertyRepository.save(property4);


        Booking booking1 = new Booking("no", "BZ5423WE1", customer1, property1);
        bookingRepository.save(booking1);
        booking1.addBooking(booking1);


    }
}
