package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Long> {
}
