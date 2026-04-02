package com.gtbs.notificationservice.user.dto;

public class UserProfileResponse {

    private Long id;
    private String userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String preferredChannel;

    public UserProfileResponse() {
    }

    public UserProfileResponse(Long id, String userId, String fullName,
            String email, String phoneNumber, String preferredChannel) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preferredChannel = preferredChannel;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPreferredChannel() {
        return preferredChannel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPreferredChannel(String preferredChannel) {
        this.preferredChannel = preferredChannel;
    }
}