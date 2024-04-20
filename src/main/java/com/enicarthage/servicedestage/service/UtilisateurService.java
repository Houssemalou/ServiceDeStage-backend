package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Utilisateur;
import com.enicarthage.servicedestage.repository.UtilisateurRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private final UtilisateurRepo utilisateurrepo;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepo utilisateurrepo, PasswordEncoder passwordEncoder) {
        this.utilisateurrepo = utilisateurrepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createUser(String nom, String email, String password) {
        // Check if user with the same username already exists
        if (utilisateurrepo.findUtilisateurByNom(nom) != null) {
            throw new RuntimeException("Username already exists");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(passwordEncoder.encode(password));

        utilisateurrepo.save(utilisateur);
    }

}
