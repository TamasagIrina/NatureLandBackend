package org.example.natureland.controllers;


import org.example.natureland.entety.Cart;
import org.example.natureland.entety.CartProductDTO;
import org.example.natureland.repo.CartRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CartAPIControllers {

    CartRepo cartRepo;
    public CartAPIControllers(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCard(@RequestBody Cart cart) {
        cart.setId(0);
        if (getById(cart.getProduct().getId(),cart.getPersonID())) {
            return ResponseEntity.badRequest().body("Cart already exists.");
        }

        cartRepo.save(cart);
        return ResponseEntity.ok("added");
    }

    @GetMapping("/getByIds/{idProduct}/{idPerson}")
    public boolean getById(@PathVariable int idProduct, @PathVariable int idPerson) {
        List<Cart> carts= cartRepo.findAllByPersonID(idPerson);
        for (Cart cart : carts) {
            if (cart.getProduct().getId() == idProduct) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getCart() {
        List<Cart> carts = cartRepo.findAll();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/joined/{id}")
    public List<CartProductDTO> getCartWithProducts(@PathVariable int id) {
        return cartRepo.findAllByPersonID(id).stream()
                .map(CartProductDTO::new)
                .collect(Collectors.toList());
    }
    @PutMapping("/{cartItemId}/{updateAmount}")
    public ResponseEntity<String> updateAmount(@PathVariable int cartItemId,@PathVariable int updateAmount) {
        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);

        if (optionalCart.isPresent()) {
            Cart cartItem = optionalCart.get();
            cartItem.setAmount(updateAmount);
            cartRepo.save(cartItem);
            return ResponseEntity.ok("Amount updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart item not found");
        }
    }

}
