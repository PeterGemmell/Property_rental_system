package com.example.rentalsystem.rentalservice;

import com.example.rentalsystem.rentalservice.models.Booking;
import com.example.rentalsystem.rentalservice.models.Customer;
import com.example.rentalsystem.rentalservice.models.Host;
import com.example.rentalsystem.rentalservice.models.Property;
import com.example.rentalsystem.rentalservice.repositories.BookingRepository;
import com.example.rentalsystem.rentalservice.repositories.CustomerRepository;
import com.example.rentalsystem.rentalservice.repositories.HostRepository;
import com.example.rentalsystem.rentalservice.repositories.PropertyRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentalserviceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	HostRepository hostRepository;

	@Autowired
	PropertyRepository propertyRepository;

	Customer peter;
	Host bob;
	Property flat;
	Booking booking;


	@Before
	public void before() {
		peter = new Customer("Peter", "Gemmell", "PeteG", "07870988635", "petergemmell65@hotmail.com", "Howdy22$");
		customerRepository.save(peter);

		bob = new Host("Bob", "Smith", "07845234562", "bob@bobsmith.com", "HeyItsBob", "Bob123");
		hostRepository.save(bob);

		flat = new Property("France", "Cannes", "Apartment", 4, 2, "Croisette, LE MIRAMAR, located between Le MARTINEZ and Le CARLTON, This luxury residence will allow you the time of a weekend or a few weeks, to discover our French Riviera in the heart of the City of CANNES.", 4, 179.00, "https://a0.muscache.com/im/pictures/75420856/eac8efbb_original.jpg?im_w=1200", bob);
		propertyRepository.save(flat);

		booking = new Booking("no", "BZ5423WE1", peter, flat);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void canSaveCustomerDetailsToSite(){
		Customer customer1 = new Customer("Peter", "Gemmell", "PeteG", "07870988635", "petergemmell65@hotmail.com", "Howdy22$");
		customerRepository.save(customer1);
	}

	@Test
	public void canAddHostToSite(){
		Host host1 = new Host("Bob", "Smith", "07845234562", "bob@bobsmith.com", "HeyItsBob", "Bob123");
		hostRepository.save(host1);
	}

	@Test
	public void canAddPropertyToSite(){

		Property property1 = new Property("France", "Cannes", "Apartment", 4, 2, "Croisette, LE MIRAMAR, located between Le MARTINEZ and Le CARLTON, This luxury residence will allow you the time of a weekend or a few weeks, to discover our French Riviera in the heart of the City of CANNES.", 4, 179.00, "https://a0.muscache.com/im/pictures/75420856/eac8efbb_original.jpg?im_w=1200", bob);
	}

	@Test
	public void canSaveABookingToSite(){
//		Customer customer1 = new Customer("Peter", "Gemmell", "PeteG", "07870988635", "petergemmell65@hotmail.com", "Howdy22$");
//		customerRepository.save(customer1);
//		Host host1 = new Host("Bob", "Smith", "07845234562", "bob@bobsmith.com", "HeyItsBob", "Bob123");
//		hostRepository.save(host1);
//		Property property1 = new Property("France", "Cannes", "Apartment", 4, 2, "Croisette, LE MIRAMAR, located between Le MARTINEZ and Le CARLTON, This luxury residence will allow you the time of a weekend or a few weeks, to discover our French Riviera in the heart of the City of CANNES.", 4, 179.00, "https://a0.muscache.com/im/pictures/75420856/eac8efbb_original.jpg?im_w=1200", host1);
//		propertyRepository.save(property1);
		Booking booking1 = new Booking("no", "BZ5423WE1", peter, flat);
	}

	@Test
	public void canDeletePropertyFromSite(){

	}
}
