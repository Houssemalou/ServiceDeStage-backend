package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.User;
import com.enicarthage.servicedestage.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findById(email).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String email, User user) {
        if (userRepository.existsById(email)) {
            user.setEmail(email);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    // Other CRUD methods as needed
}

