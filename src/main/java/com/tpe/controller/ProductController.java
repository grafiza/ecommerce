package com.tpe.controller;

import com.tpe.domain.Customer;
import com.tpe.domain.Product;
import com.tpe.dto.ProductDTO;
import com.tpe.service.CustomerService;
import com.tpe.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>("Product is saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList=productService.getAll();
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        ProductDTO productDTO=productService.getProductDTO(id);
        return ResponseEntity.ok(productDTO);
    }
}
