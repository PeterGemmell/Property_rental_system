package com.example.rentalsystem.rentalservice.repositories;

import com.example.rentalsystem.rentalservice.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {

    Host findByHostUserNameAndPassword(String hostUserName, String hostPassword);
}
