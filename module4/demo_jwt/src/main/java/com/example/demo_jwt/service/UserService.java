package com.example.demo_jwt.service;

import com.example.demo_jwt.model.User;
import com.example.demo_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void createUserWithRoles() {
        // Tạo một đối tượng User mới
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");

        // Thêm các vai trò vào user
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        user.setRoles(roles);

        // Lưu người dùng vào cơ sở dữ liệu
        userRepository.save(user);
    }
}