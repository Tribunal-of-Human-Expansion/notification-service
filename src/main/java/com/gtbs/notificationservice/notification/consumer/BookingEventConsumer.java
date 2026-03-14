package com.gtbs.notificationservice.notification.consumer;

import com.gtbs.notificationservice.notification.dto.BookingEvent;
import com.gtbs.notificationservice.notification.entity.NotificationLog;
import com.gtbs.notificationservice.notification.repository.NotificationLogRepository;
import com.gtbs.notificationservice.user.entity.UserProfile;
import com.gtbs.notificationservice.user.repository.UserProfileRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingEventConsumer {

    private final UserProfileRepository userProfileRepository;
    private final NotificationLogRepository notificationLogRepository;

    public BookingEventConsumer(UserProfileRepository userProfileRepository,
            NotificationLogRepository notificationLogRepository) {
        this.userProfileRepository = userProfileRepository;
        this.notificationLogRepository = notificationLogRepository;
    }

    @KafkaListener(topics = "booking-events-v2", groupId = "notification-service-group-v2")
    public void consumeBookingEvent(BookingEvent event) {
        UserProfile userProfile = userProfileRepository.findByUserId(event.getUserId())
                .orElse(null);

        if (userProfile == null) {
            return;
        }

        NotificationLog log = new NotificationLog();
        log.setBookingId(event.getBookingId());
        log.setUserId(event.getUserId());
        log.setStatus(event.getStatus());
        log.setChannel(userProfile.getPreferredChannel());
        log.setMessage(event.getMessage());
        log.setSentAt(LocalDateTime.now());

        notificationLogRepository.save(log);

        System.out.println("Notification prepared for user: " + userProfile.getEmail());
    }
}
