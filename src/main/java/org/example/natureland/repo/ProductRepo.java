package org.example.natureland.repo;

import org.example.natureland.entety.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Products, Integer> {
    boolean existsProductsByProductName(String productName);

    Optional<Products> findByProductName(String productName);
}
