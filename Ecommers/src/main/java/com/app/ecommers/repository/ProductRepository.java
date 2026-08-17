package com.app.ecommers.repository;

import com.app.ecommers.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query: Spring otomatis menerjemahkan nama method menjadi SQL Query!
    List<Product> findByNameContainingIgnoreCase(String keyword);
}
