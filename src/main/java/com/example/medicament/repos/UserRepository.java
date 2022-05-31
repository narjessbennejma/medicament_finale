package com.example.medicament.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicament.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);

}
