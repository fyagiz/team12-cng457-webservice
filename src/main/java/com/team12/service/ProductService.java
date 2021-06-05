package com.team12.service;

import com.team12.entity.Product;
import com.team12.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product newProduct){
        return productRepository.save(newProduct);
    }
}
