package com.gtbs.notificationservice.notification.repository;

import com.gtbs.notificationservice.notification.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
