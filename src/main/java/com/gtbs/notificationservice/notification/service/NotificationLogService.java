package com.gtbs.notificationservice.notification.service;

import com.gtbs.notificationservice.common.exception.ResourceNotFoundException;
import com.gtbs.notificationservice.notification.dto.BookingEvent;
import com.gtbs.notificationservice.notification.dto.NotificationLogResponse;
import com.gtbs.notificationservice.notification.entity.NotificationLog;
import com.gtbs.notificationservice.notification.repository.NotificationLogRepository;
import com.gtbs.notificationservice.user.entity.UserProfile;
import com.gtbs.notificationservice.user.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationLogService {

    private static final Logger log = LoggerFactory.getLogger(NotificationLogService.class);

    private final NotificationLogRepository notificationLogRepository;
    private final UserProfileRepository userProfileRepository;

    public NotificationLogService(NotificationLogRepository notificationLogRepository,
            UserProfileRepository userProfileRepository) {
        this.notificationLogRepository = notificationLogRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public void processBookingEvent(BookingEvent event) {
        UserProfile user = userProfileRepository.findByUserId(event.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + event.getUserId()));

        log.info("Sending EMAIL notification to {} for booking {} with status {}",
                user.getEmail(), event.getBookingId(), event.getStatus());

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setUserId(event.getUserId());
        notificationLog.setBookingId(event.getBookingId());
        notificationLog.setStatus(event.getStatus());
        notificationLog.setMessage(event.getMessage());
        notificationLog.setChannel("EMAIL");
        notificationLog.setSentAt(LocalDateTime.now());

        notificationLogRepository.save(notificationLog);

        log.info("Notification saved for user {}", event.getUserId());
    }

    public List<NotificationLogResponse> getNotificationsForUser(String userId) {
        return notificationLogRepository.findByUserId(userId)
                .stream()
                .map(log2 -> new NotificationLogResponse(
                        log2.getId(),
                        log2.getUserId(),
                        log2.getBookingId(),
                        log2.getStatus(),
                        log2.getMessage(),
                        log2.getSentAt()))
                .collect(Collectors.toList());
    }
}