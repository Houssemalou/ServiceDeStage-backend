package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Message;
import com.enicarthage.servicedestage.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.findAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping({"/find/{id}"})
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
        Message message = messageService.findMessageById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping({"/add"})
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message newMessage = messageService.addMessage(message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }

    @PutMapping({"/update"})
    public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
        Message updatedMessage = messageService.updateMessage(message);
        return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
    }

    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id) {
        try {
            messageService.deleteMessage(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete message with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
