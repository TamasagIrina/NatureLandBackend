package org.example.natureland.controllers;


import org.example.natureland.entety.Messages;
import org.example.natureland.repo.MessagesRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MessagesControlles {

    MessagesRepo messagesRepo;
    public MessagesControlles(MessagesRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }

    @PostMapping("/addMessage")
    public Messages addMessage(@RequestBody Messages message) {
        return messagesRepo.save(message);
    }

    @GetMapping("/getAllMasseges")
    public List<Messages> getAllMasseges(){
        return messagesRepo.findAll();
    }
}
