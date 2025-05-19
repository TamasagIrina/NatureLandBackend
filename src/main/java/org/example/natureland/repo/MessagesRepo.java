package org.example.natureland.repo;

import org.example.natureland.entety.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepo extends JpaRepository<Messages, Integer> {
}
