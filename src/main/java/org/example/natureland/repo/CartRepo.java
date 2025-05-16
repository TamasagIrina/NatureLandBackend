package org.example.natureland.repo;

import org.example.natureland.entety.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByPersonID(int personID);

    boolean findAllById(int id);
}
