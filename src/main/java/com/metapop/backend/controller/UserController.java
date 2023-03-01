package com.metapop.backend.controller;


import com.metapop.backend.entity.User;
import com.metapop.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> join(@RequestBody User user) {
        if(userService.isEmailDuplicate(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        userService.join(user);
        return ResponseEntity.ok("Join Success!");
    }
}
