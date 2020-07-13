package com.example.rentalsystem.rentalservice.controllers;

import com.example.rentalsystem.rentalservice.models.Host;
import com.example.rentalsystem.rentalservice.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    HostRepository hostRepository;

    @GetMapping(value = "/hosts")
    public ResponseEntity<List<Host>> getAllHosts(){
        return new ResponseEntity<>(hostRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/hosts/{id}")
    public ResponseEntity getHost(@PathVariable Long id){
        return new ResponseEntity<>(hostRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/hosts/login")
    public ResponseEntity findByHostUserNameAndPassword(
            @RequestParam(name = "hostUserName") String hostUserName,
            @RequestParam(name = "hostPassword") String hostPassword){
        return new ResponseEntity(hostRepository.findByHostUserNameAndPassword(hostUserName, hostPassword), HttpStatus.OK);
    }

    @PostMapping(value = "/hosts")
    public ResponseEntity<Host> postHost(@RequestBody Host host){
        hostRepository.save(host);
        return new ResponseEntity<>(host, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/hosts/{id}")
    public ResponseEntity<Host> updateHost(@RequestBody Host host){
        hostRepository.save(host);
        return new ResponseEntity<>(host, HttpStatus.OK);
    }

    @DeleteMapping(value = "/hosts/{id}")
    public ResponseEntity<Host> deleteHost(@PathVariable Long id){
        Host found = hostRepository.getOne(id);
        hostRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }





}
