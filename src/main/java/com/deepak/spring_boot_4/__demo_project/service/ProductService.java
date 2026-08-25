package com.deepak.spring_boot_4.__demo_project.service;

import com.deepak.spring_boot_4.__demo_project.models.Product;
import com.deepak.spring_boot_4.__demo_project.models.ProductSpecification;
import com.deepak.spring_boot_4.__demo_project.models.ProductSummary;
import com.deepak.spring_boot_4.__demo_project.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public Page<ProductSummary> getProductsPagedMini(Pageable pageable) {
        return productRepository.findAllProjectedBy(pageable);
    }


    public Page<Product> getProductsFiltered(String category,
                                             Boolean available,
                                             BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {

        List<Specification<Product>> specifications = new ArrayList<>();

        if (category != null) {
            specifications.add(ProductSpecification.hasCategory(category));
        }

        if (available != null) {
            specifications.add(ProductSpecification.isAvailable(available));
        }

        if (minPrice != null) {
            specifications.add(ProductSpecification.priceGreaterThan(minPrice));
        }

        if (maxPrice != null) {
            specifications.add(ProductSpecification.priceLessThan(maxPrice));
        }

        Specification<Product> specification =
                Specification.allOf(specifications);

        return productRepository.findAll(specification, pageable);

    }
}
