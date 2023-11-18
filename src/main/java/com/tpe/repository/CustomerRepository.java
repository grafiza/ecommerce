package com.tpe.repository;

import com.tpe.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional okunabilirlik
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByEmail(String email);
}