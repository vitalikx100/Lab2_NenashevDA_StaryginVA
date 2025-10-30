package com.example.Lab2_NenashevDA_StaryginVA.service;

import com.example.Lab2_NenashevDA_StaryginVA.model.User;
import com.example.Lab2_NenashevDA_StaryginVA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        try {
            if (userRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("User with email " + user.getEmail() + " already exists");
            }
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage(), e);
        }
    }

    public User updateUser(User user) {
        try {
            if (!userRepository.existsById(user.getId())) {
                throw new RuntimeException("User with ID " + user.getId() + " not found");
            }
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user: " + e.getMessage(), e);
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public boolean userExists(Integer id) {
        return userRepository.existsById(id);
    }
}