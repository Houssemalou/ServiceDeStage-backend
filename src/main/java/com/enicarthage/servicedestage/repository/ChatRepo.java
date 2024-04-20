package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepo extends JpaRepository<Chat, Long> {

    Chat findChatByNom(String name);
}
