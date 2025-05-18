package org.example.natureland.controllers;

import org.example.natureland.entety.Orders;
import org.example.natureland.repo.OrdersRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrdersAPIControllers {

    private OrdersRepo ordersRepo;

    public OrdersAPIControllers(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }


    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestBody Orders orders) {
        orders.setId(0);
        ordersRepo.save(orders);
        return ResponseEntity.ok("Order added successfully");
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Orders>> getAll() {
        return ResponseEntity.ok(ordersRepo.findAll());
    }

    @GetMapping("/getOrderById/{clientId}")
    public ResponseEntity<List<Orders>> getById(@PathVariable int clientId) {
        List<Orders> orders = ordersRepo.findByClientId(clientId);
        return ResponseEntity.ok(orders);
    }

}
