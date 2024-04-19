package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    void deleteMessageById(Long id);
    Optional<Message> findMessageById(Long id);
}
