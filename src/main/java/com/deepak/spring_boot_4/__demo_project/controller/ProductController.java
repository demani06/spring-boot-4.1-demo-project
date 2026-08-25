package com.deepak.spring_boot_4.__demo_project.controller;

import com.deepak.spring_boot_4.__demo_project.models.Product;
import com.deepak.spring_boot_4.__demo_project.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {

        //TODO validations
        List<Product> products = productService.getProducts();

        //TODO exception handling
        return ResponseEntity.ok(products);

    }

    @GetMapping("/products-paging")
    public Page<Product> getProductsPaging(Pageable pageable) {
        return productService.getProductsPaged(pageable);

    }
}
