package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Notification;
import com.enicarthage.servicedestage.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepo notificationrepo;

    @Autowired
    public NotificationService(NotificationRepo notificationrepo) {
        this.notificationrepo= notificationrepo;
    }

    public void createAndSaveNotification(String message, String recipient) {
        Notification notification = new Notification();
        notification.setText(message);
        notification.setTo(recipient);
        notification.setTimestamp(LocalDateTime.now());

        notificationrepo.save(notification);
    }
}
