package com.deepak.spring_boot_4.__demo_project.models;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/*
 * Specification class for dynamic filtering
 *
 * */
public class ProductSpecification {

    public static Specification<Product> hasCategory(String category) {
        return (root, _, cb) ->
                cb.equal(root.get("category"), category);
    }

    public static Specification<Product> isAvailable(Boolean available) {
        return (root, _, cb) ->
                cb.equal(root.get("available"), available);
    }

    public static Specification<Product> priceGreaterThan(BigDecimal minPrice) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLessThan(
            BigDecimal maxPrice) {

        return (root, query, cb) ->
                cb.lessThanOrEqualTo(
                        root.get("price"),
                        maxPrice
                );
    }
}
