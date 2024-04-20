package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Chat;
import com.enicarthage.servicedestage.model.Message;
import com.enicarthage.servicedestage.repository.ChatRepo;
import com.enicarthage.servicedestage.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate ;

    @Autowired
    private ChatRepo chatrepo ;
    @Autowired
    private MessageRepo messagerepo ;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, Message message) {
        System.out.println("handling send message :" + message + "to:" + to );
        message.setChat_id(createAndOrGetChat(to));
        message.setTimestamp(LocalDateTime.now());
        message = messagerepo.save(message) ;
        messagingTemplate.convertAndSend("/topic/messages/" + to ,message);
    }

    @MessageMapping("/chat.private")
    public void sendPrivateMessage(Message message) {
        messagingTemplate.convertAndSendToUser(message.getReceiver().getNom(), "/queue/messages", message);
    }

    @PostMapping("/getChats")
    public List<Chat> getchats(@RequestBody String user) {
        return (List<Chat>) chatrepo.findByNom(user);
    }


    @PostMapping("/getMessages")
    public List<Message> getMessages(@RequestBody String chat) {
        Chat ce = chatrepo.findByNom(chat);

        if(ce != null) {
            return messagerepo.findAllById(Collections.singleton(ce.getId()));
        }
        else{
            return new ArrayList<Message>();
        }
    }


    //finds the chat whose name is the parameter, if it doesn't exist it gets created, the ID gets returned either way
    private Long createAndOrGetChat(String name) {
        Chat ce = chatrepo.findByNom(name);

        if (ce != null) {
            return ce.getId();
        }
        else {
            Chat newChat = new Chat(name);
            return chatrepo.save(newChat).getId();
        }
    }
}
