package com.deepak.spring_boot_4.__demo_project.service;

import com.deepak.spring_boot_4.__demo_project.models.Product;
import com.deepak.spring_boot_4.__demo_project.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Page<Product> getProductsPaged(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
