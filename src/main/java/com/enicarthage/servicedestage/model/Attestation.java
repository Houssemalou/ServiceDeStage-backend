package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attestation {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
