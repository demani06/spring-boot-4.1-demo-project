package com.deepak.spring_boot_4.__demo_project.repository;

import com.deepak.spring_boot_4.__demo_project.models.Product;
import com.deepak.spring_boot_4.__demo_project.models.ProductSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<ProductSummary> findAllProjectedBy(Pageable pageable);
}
