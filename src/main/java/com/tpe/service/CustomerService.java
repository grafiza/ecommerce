package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.dto.CustomerDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        boolean isExists = customerRepository.existsByEmail(customer.getEmail());
        if (isExists) {
            throw new ConflictException("Customer already exists by email: " + customer.getEmail());
        }
        customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    // id ile customer getirme
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer is not found by id:" + id));
        return customer;
    }

    public CustomerDTO getCustomerDTO(Long id) {
        Customer customer = getCustomerById(id);
        CustomerDTO customerDTO = new CustomerDTO(customer);
        return customerDTO;
    }

    public void deleteCustomerByID(Long id) {
        getCustomerById(id); // customer yoksa hata fırlatılır
        customerRepository.deleteById(id);
    }
}
