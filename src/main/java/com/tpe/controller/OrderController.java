package com.tpe.controller;

import com.tpe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save/filter")
    public ResponseEntity<String> enterOrder(@RequestParam("cid") Long cid,
                                             @RequestParam("prod") Long prod,
                                             @RequestParam("quant") Integer quant){
        orderService.createOrder(cid,prod,quant);
        return new ResponseEntity<>("Order is created successfully...", HttpStatus.CREATED);
    }
}
