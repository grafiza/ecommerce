package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    //customer save işlemi http://localhost:8080/customers/save + POST + JSON
    // email daha önce kullanılmışsa hata fırlatır (ConflictException)
    @PostMapping("/save")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("Customer is saved successfully", HttpStatus.CREATED);
    }
    @GetMapping //http://localhost:8080/customers/save + GET
    public ResponseEntity<List<Customer>> getAllCustomers(){
       List<Customer> customerList= customerService.getAll();
       return ResponseEntity.ok(customerList);
    }
}
