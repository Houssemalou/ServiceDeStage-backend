package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chat_id ;
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Utilisateur sender ;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Utilisateur receiver ;

    private LocalDateTime timestamp;
}
