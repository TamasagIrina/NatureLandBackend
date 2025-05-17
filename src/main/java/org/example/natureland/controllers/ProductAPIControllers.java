package org.example.natureland.controllers;

import org.example.natureland.entety.Products;
import org.example.natureland.repo.ProductRepo;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getProductId/{productName}")
    public ResponseEntity<Integer> getProductID(@PathVariable("productName") String productName) {

        if(productRepo.findByProductName(productName).isPresent()){
            int id = productRepo.findByProductName(productName).get().getId();
            return ResponseEntity.status(HttpStatus.OK).body(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(0);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> add(@RequestBody Products product) {
        product.setId(0);
        if(productRepo.existsProductsByProductName(product.getProductName()) && productRepo.findByProductDescription(product.getProductDescription())==null) {
            return ResponseEntity.ok().body("Product exist. ");
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
