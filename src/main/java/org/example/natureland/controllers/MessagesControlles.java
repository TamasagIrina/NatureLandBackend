package org.example.natureland.controllers;


import org.example.natureland.entety.Messages;
import org.example.natureland.entety.Orders;
import org.example.natureland.enums.MessageStatus;
import org.example.natureland.enums.Status;
import org.example.natureland.repo.MessagesRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MessagesControlles {

    MessagesRepo messagesRepo;
    public MessagesControlles(MessagesRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }

    @PostMapping("/addMessage")
    public ResponseEntity<String> addMessage(@RequestBody Messages message) {
        message.setId(0);
        messagesRepo.save(message);
        return ResponseEntity.ok("Message added");
    }

    @GetMapping("/getAllMasseges")
    public List<Messages> getAllMasseges(){
        return messagesRepo.findAll();
    }

    @PutMapping("/answered/{id}")
    public ResponseEntity<String> answered(@PathVariable int id) {
        Optional<Messages> messagesOptional = messagesRepo.findById(id);
        if (messagesOptional.isPresent()) {
            Messages message = messagesOptional.get();
            message.setMessageStatus(MessageStatus.ANSWERED);
            messagesRepo.save(message);
            return ResponseEntity.ok("Message answered");
        }

        return ResponseEntity.ok().body("Message not found");

    }
}
