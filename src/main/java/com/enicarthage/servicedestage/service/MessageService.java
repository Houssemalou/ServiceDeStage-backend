package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.exception.MessageNotFoundException;
import com.enicarthage.servicedestage.model.Message;
import com.enicarthage.servicedestage.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Message addMessage(Message message) {
        return messageRepo.save(message);
    }

    public Message updateMessage(Message message) {
        return messageRepo.save(message);
    }

    public List<Message> findAllMessages() {
        return messageRepo.findAll();
    }

    public Message findMessageById(Long id) {
        return messageRepo.findMessageById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message with id " + id + " not found"));
    }

    public void deleteMessage(Long id) {
        messageRepo.deleteMessageById(id);
    }
}
