package com.example.rentalsystem.rentalservice;

import com.example.rentalsystem.rentalservice.models.Customer;
import com.example.rentalsystem.rentalservice.repositories.BookingRepository;
import com.example.rentalsystem.rentalservice.repositories.CustomerRepository;
import com.example.rentalsystem.rentalservice.repositories.HostRepository;
import com.example.rentalsystem.rentalservice.repositories.PropertyRepository;
import org.aspectj.lang.annotation.Before;
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

	@Test
	public void contextLoads() {
	}

	@Test
	public void canSaveCustomerDetailsToSite(){
		Customer customer1 = new Customer("Peter", "Gemmell", "PeteG", "07870988635", "petergemmell65@hotmail.com", "Howdy22$");
		customerRepository.save(customer1);
	}

}
