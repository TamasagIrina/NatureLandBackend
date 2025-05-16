package org.example.natureland.controllers;

import org.example.natureland.entety.Products;
import org.example.natureland.entety.User;
import org.example.natureland.repo.ProductRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductAPIControllers {
    private ProductRepo productRepo;

    public ProductAPIControllers(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> add(@RequestBody Products product) {
        product.setId(0);
        if(productRepo.existsProductsByProductName(product.getProductName())) {
            return ResponseEntity.badRequest().body("Product exist. ");
        }
        if(product.getProductName().isEmpty()||product.getProductImg().isEmpty()|| product.getProductPrice() == null) {
            return ResponseEntity.badRequest().body("Insert product!!! ");
        }
        productRepo.save(product);
        return ResponseEntity.ok().body("Product added");
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Products>> getProducts() {
        return ResponseEntity.ok().body(productRepo.findAll());
    }

    @GetMapping("/productId/{productName}")
    public int getProductById(@PathVariable String productName) {
        Optional<Products> products = productRepo.findByProductName(productName);
        return products.map(Products::getId).orElse(0);
    }

}
