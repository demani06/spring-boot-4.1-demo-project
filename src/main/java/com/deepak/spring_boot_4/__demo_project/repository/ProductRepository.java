package com.deepak.spring_boot_4.__demo_project.repository;

import com.deepak.spring_boot_4.__demo_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
