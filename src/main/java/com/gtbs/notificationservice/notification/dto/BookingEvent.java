package com.gtbs.notificationservice.notification.dto;

public class BookingEvent {

    private String bookingId;
    private String userId;
    private String status;
    private String message;

    public BookingEvent() {
    }

    public BookingEvent(String bookingId, String userId, String status, String message) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.status = status;
        this.message = message;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
