package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.exception.ConflictException;
import com.tpe.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
