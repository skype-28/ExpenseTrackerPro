package com.skp.expensetrackerpro.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skp.expensetrackerpro.dto.RegisterDto;
import com.skp.expensetrackerpro.entity.User;
import com.skp.expensetrackerpro.repository.UserRepository;
import com.skp.expensetrackerpro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }

        User user = new User();

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());

        // Encrypt password
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setRole("USER");

        userRepository.save(user);
    }
}