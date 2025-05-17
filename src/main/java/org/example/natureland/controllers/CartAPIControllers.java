package org.example.natureland.controllers;


import org.example.natureland.entety.Cart;
import org.example.natureland.entety.CartProductDTO;
import org.example.natureland.repo.CartRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CartAPIControllers {

    CartRepo cartRepo;
    public CartAPIControllers(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCard(@RequestBody Cart cart) {
        cart.setId(0);
        if (getById(cart.getProduct().getId(),cart.getPersonid())) {
            return ResponseEntity.ok().body("Cart already exists.");
        }

        cartRepo.save(cart);
        return ResponseEntity.ok("added");
    }

    @GetMapping("/getByIds/{idProduct}/{idPerson}")
    public boolean getById(@PathVariable int idProduct, @PathVariable int idPerson) {
        List<Cart> carts= cartRepo.findAllByPersonid(idPerson);
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
        return cartRepo.findAllByPersonid(id).stream()
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

    @DeleteMapping("/delete/{personId}/{productid}")
  public ResponseEntity<String> deleteProduct(@PathVariable int personId, @PathVariable int productid) {
        List<Cart> optionalCart = cartRepo.findAllByPersonid(personId);
        for (Cart cart : optionalCart) {
            if (cart.getProduct().getId() == productid) {
                cartRepo.delete(cart);
                return ResponseEntity.ok("Deleted");
            }
        }
        return ResponseEntity.ok("product not found");
    }

}
