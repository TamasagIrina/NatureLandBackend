package org.example.natureland.repo;

import org.example.natureland.entety.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {


    List<Orders> findByClientId(int clientId);

}
