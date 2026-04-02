package com.gtbs.notificationservice.notification.dto;

import java.time.LocalDateTime;

public class NotificationLogResponse {

    private Long id;
    private String userId;
    private String bookingId;
    private String status;
    private String message;
    private LocalDateTime createdAt;

    public NotificationLogResponse() {
    }

    public NotificationLogResponse(Long id, String userId, String bookingId,
            String status, String message, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.bookingId = bookingId;
        this.status = status;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}