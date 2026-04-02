package com.gtbs.notificationservice.user.controller;

import com.gtbs.notificationservice.user.dto.CreateUserRequest;
import com.gtbs.notificationservice.user.dto.UserProfileResponse;
import com.gtbs.notificationservice.user.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfileResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserProfileResponse response = userProfileService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileResponse> getUserByUserId(@PathVariable String userId) {
        UserProfileResponse response = userProfileService.getUserByUserId(userId);
        return ResponseEntity.ok(response);
    }
}