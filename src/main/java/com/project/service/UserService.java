package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail()) ||
            userRepository.existsByPhone(user.getPhone())) {
            throw new IllegalArgumentException("Duplicate email or phone");
        }
        userRepository.save(user);
    }

}
