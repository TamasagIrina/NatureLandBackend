package org.example.natureland.repo;

import org.example.natureland.entety.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findUserByEmail(String email);

}
