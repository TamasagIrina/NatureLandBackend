package org.example.natureland.repo;

import jakarta.transaction.Transactional;
import org.example.natureland.entety.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;


public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByPersonid(int personID);

    boolean findAllById(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.product.id = :productId")
    void deleteByProductId(@Param("productId") int productId);

}
