package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Notification;
import com.enicarthage.servicedestage.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationRequest request) {
        notificationService.createAndSaveNotification(request.getMessage(), request.getRecipient());
    }

    static class NotificationRequest {
        private String message;
        private String recipient;

        // Getters and setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getRecipient() {
            return recipient;
        }

        public void setRecipient(String recipient) {
            this.recipient = recipient;
        }
    }
}
