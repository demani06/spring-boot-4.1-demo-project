package com.deepak.spring_boot_4.__demo_project.repository;

import com.deepak.spring_boot_4.__demo_project.models.Product;
import com.deepak.spring_boot_4.__demo_project.models.ProductSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Page<ProductSummary> findAllProjectedBy(Pageable pageable);
}
