package com.example.Lab2_NenashevDA_StaryginVA.repository;

import com.example.Lab2_NenashevDA_StaryginVA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}