package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.dto.CustomerDTO;
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
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAll();
        return ResponseEntity.ok(customerList);
    }

    // id ile tek bir customer getirme http://localhost:8080/customers/1 + GET
    // tabloda yoksa hata fırlatır
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerDTO(id);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping("/query")
    public ResponseEntity<CustomerDTO> getCustomerWithParam(@RequestParam Long id) {
        CustomerDTO customerDTO = customerService.getCustomerDTO(id);
        return ResponseEntity.ok(customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomerByID(id);
        return ResponseEntity.ok("Customer is delete successfully");
    }
}
