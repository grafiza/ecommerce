package com.tpe.dto;

import com.tpe.domain.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDTO {
    @NotBlank(message = "Product name is required!")
    private String productName;
    @NotBlank(message = "Product brand is required!")
    private String brand;
    @NotNull(message = "Price can not be null!")
    private Double price;
    public ProductDTO(Product product){
        this.productName=product.getProductName();
        this.brand=product.getBrand();
        this.price=product.getPrice();
    }
}
