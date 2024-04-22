package com.enicarthage.servicedestage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.enicarthage.servicedestage.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {




    User findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    <S extends User> S save(S entity);


}
