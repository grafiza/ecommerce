package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.domain.OrderItem;
import com.tpe.domain.Product;
import com.tpe.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    public void createOrder(Long cid, Long prod, Integer quant) {
        Customer customer=customerService.getCustomerById(cid);
        Product product=productService.getProductById(prod);
        OrderItem order;

        // aynı müşteri aynı siparişi veriyorsa sadece miktarı artıralım
        // farklı ise yeni sipariş oluşturalım
    }
}
