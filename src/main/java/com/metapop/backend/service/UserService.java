package com.metapop.backend.service;

import com.metapop.backend.entity.User;
import com.metapop.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void join(User user) {
        userRepository.save(user);
    }

    public boolean isEmailDuplicate(String email) {
        User findUser = userRepository.findByEmail(email);
        return findUser != null;
    }
}
