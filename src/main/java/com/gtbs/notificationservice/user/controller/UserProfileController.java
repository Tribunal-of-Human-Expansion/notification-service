package com.gtbs.notificationservice.user.controller;

import com.gtbs.notificationservice.user.entity.UserProfile;
import com.gtbs.notificationservice.user.repository.UserProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileRepository userProfileRepository;

    public UserProfileController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @PostMapping
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile userProfile) {
        UserProfile savedUser = userProfileRepository.save(userProfile);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getUserByUserId(@PathVariable String userId) {
        return userProfileRepository.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
