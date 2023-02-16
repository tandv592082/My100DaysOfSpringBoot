package com.springstarter.webrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstarter.webrest.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByProductName(String productName);
}
