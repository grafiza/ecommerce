package com.tpe.service;

import com.tpe.domain.Product;
import com.tpe.dto.ProductDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        boolean isExists = productRepository.existsByProduct(product.getProductName());
        if (isExists) {
            throw new ConflictException("Product is already exists by name:" + product.getProductName());
        }
        productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Product is not found by id:" + id));
        return product;
    }

    public ProductDTO getProductDTO(Long id) {
        Product product = getProductById(id);
        ProductDTO productDTO = new ProductDTO(product);
        return productDTO;
    }
}
