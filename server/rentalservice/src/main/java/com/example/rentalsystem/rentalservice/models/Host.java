package com.example.rentalsystem.rentalservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hosts")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="host_first_name")
    private String hostFirstName;

    @Column(name="host_last_name")
    private String hostLastName;

    @Column(name="host_contact_number")
    private String hostContactNumber;

    @Column(name="host_email")
    private String hostEmail;

    @Column(name="host_password")
    private String hostPassword;

    @Column(name="host_user_name")
    private String hostUserName;

    @JsonIgnoreProperties(value = "hosts")
    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private List<Property> properties;

    public Host(String hostFirstName, String hostLastName, String hostContactNumber, String hostEmail, String hostPassword, String hostUserName){
        this.hostFirstName = hostFirstName;
        this.hostLastName = hostLastName;
        this.hostContactNumber = hostContactNumber;
        this.hostEmail = hostEmail;
        this.hostPassword = hostPassword;
        this.hostUserName = hostUserName;
        this.properties = new ArrayList<Property>();
    }

    public Host(){

    }

    public String getHostFirstName() {
        return hostFirstName;
    }

    public void setHostFirstName(String hostFirstName) {
        this.hostFirstName = hostFirstName;
    }

    public String getHostLastName() {
        return hostLastName;
    }

    public void setHostLastName(String hostLastName) {
        this.hostLastName = hostLastName;
    }

    public String getHostContactNumber() {
        return hostContactNumber;
    }

    public void setHostContactNumber(String hostContactNumber) {
        this.hostContactNumber = hostContactNumber;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public String getHostPassword() {
        return hostPassword;
    }

    public void setHostPassword(String hostPassword) {
        this.hostPassword = hostPassword;
    }

    public String getHostUsername() {
        return hostUserName;
    }

    public void setHostUsername(String hostUserName) {
        this.hostUserName = hostUserName;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
