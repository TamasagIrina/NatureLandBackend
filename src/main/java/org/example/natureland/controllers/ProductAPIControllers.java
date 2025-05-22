package org.example.natureland.controllers;

import org.example.natureland.entety.Messages;
import org.example.natureland.entety.Products;
import org.example.natureland.enums.MessageStatus;
import org.example.natureland.enums.Stoc;
import org.example.natureland.repo.CartRepo;
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

    private CartRepo cartRepo;

    public ProductAPIControllers(ProductRepo productRepo , CartRepo cartRepo) {
        this.productRepo = productRepo;
        this.cartRepo = cartRepo;
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
        product.setStoc(Stoc.IN_STOC);
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

    @PutMapping("/outOfStoc/{id}")
    public ResponseEntity<String> outOfStoc(@PathVariable int id) {
        Optional<Products> productsOptional = productRepo.findById(id);
        if (productsOptional.isPresent()) {
            Products products = productsOptional.get();
            products.setStoc(Stoc.OUT_OF_STOC);
            productRepo.save(products);
            return ResponseEntity.ok("Up dated");
        }

        return ResponseEntity.ok().body("Product not found");

    }

    @PutMapping("/inStoc/{id}")
    public ResponseEntity<String> inStoc(@PathVariable int id) {
        Optional<Products> productsOptional = productRepo.findById(id);
        if (productsOptional.isPresent()) {
            Products products = productsOptional.get();
            products.setStoc(Stoc.IN_STOC);
            productRepo.save(products);
            return ResponseEntity.ok("Up dated");
        }

        return ResponseEntity.ok().body("Product not found");

    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        try {
            Optional<Products> productOptional = productRepo.findById(id);
            if (productOptional.isPresent()) {
                cartRepo.deleteByProductId(id);

                productRepo.delete(productOptional.get());

                return ResponseEntity.ok("Product and related cart entries deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product: " + e.getMessage());
        }
    }

}
