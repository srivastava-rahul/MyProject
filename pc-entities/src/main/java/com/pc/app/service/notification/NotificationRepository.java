package com.pc.app.service.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pc.app.model.notification.Notification;

public interface NotificationRepository extends MongoRepository <Notification , String> {

}
