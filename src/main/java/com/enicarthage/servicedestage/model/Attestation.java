package com.enicarthage.servicedestage.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attestation {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
