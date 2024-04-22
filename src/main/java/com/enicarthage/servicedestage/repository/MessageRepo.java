package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Message;
import com.enicarthage.servicedestage.model.Stage;
import com.enicarthage.servicedestage.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    void deleteMessageById(Long id);
    Optional<Message> findMessageById(Long id);
    <S extends Message> S save(S msg);
    List<Message> findAll();
}
