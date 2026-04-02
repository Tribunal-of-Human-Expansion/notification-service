package com.gtbs.notificationservice.notification.dto;

public record BookingEvent(
        String bookingId,
        String userId,
        String status,
        String message) {
}