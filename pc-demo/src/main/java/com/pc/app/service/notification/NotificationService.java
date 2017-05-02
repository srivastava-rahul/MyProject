package com.pc.app.service.notification;

import java.util.List;

import com.pc.app.model.notification.Notification;

public interface NotificationService {

	
	
	/**
	 * Get the list Of Notification for  User
	 * @return List All Notification for  User
	 */
	public List<Notification> listnotificationinfo();

}
