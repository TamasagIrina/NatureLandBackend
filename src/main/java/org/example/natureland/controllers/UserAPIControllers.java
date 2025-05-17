package org.example.natureland.controllers;

import org.example.natureland.entety.User;
import org.example.natureland.enums.UserRole;
import org.example.natureland.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserAPIControllers {

    private UserRepo userRepo;

    @Autowired
    public UserAPIControllers(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/verify/{email}/{password}")
    public ResponseEntity<String> verify(@PathVariable String email, @PathVariable String password) {
        if(userRepo.findUserByEmailAndPassword(email, password)!=null) {
            return ResponseEntity.ok().body("logged in");
        }
        return ResponseEntity.ok().body("User not found, go to signup");
    }

    @GetMapping("/getId/{email}")
    public ResponseEntity<Integer> getId(@PathVariable String email) {
        if(userRepo.findUserByEmail(email)==null) {
            return ResponseEntity.ok().body(0);
        }
        int id = userRepo.findUserByEmail(email).getId();
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/getRole/{email}")
    public ResponseEntity<String> getRole(@PathVariable String email) {
        if(userRepo.findUserByEmail(email)==null) {
            return ResponseEntity.ok().body("Name not found, go to signup");
        }
        UserRole role = userRepo.findUserByEmail(email).getRole();
        return ResponseEntity.ok().body(role.toString());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        user.setId(0);
        user.setRole(UserRole.CUSTOMER);
        System.out.println(userRepo.findUserByEmail(user.getEmail())!=null);
        if(userRepo.findUserByEmail(user.getEmail())!=null) {
            return ResponseEntity.ok().body("User email exist");
        }
        userRepo.save(user);
        return ResponseEntity.ok().body("User added");
    }


}
