package com.gtbs.notificationservice.notification.consumer;

import com.gtbs.notificationservice.notification.dto.BookingEvent;
import com.gtbs.notificationservice.notification.service.NotificationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(BookingEventConsumer.class);

    private final NotificationLogService notificationLogService;

    public BookingEventConsumer(NotificationLogService notificationLogService) {
        this.notificationLogService = notificationLogService;
    }

    @KafkaListener(topics = "booking-events-v2", groupId = "notification-service-group-v2")
    public void consumeBookingEvent(BookingEvent event) {
        log.info("Received booking event for userId: {}", event.getUserId());
        notificationLogService.processBookingEvent(event);
    }
}