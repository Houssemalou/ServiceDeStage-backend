package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private Long chat_id ;
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender ;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver ;

    @CreationTimestamp
    private LocalDateTime timestamp;
}
