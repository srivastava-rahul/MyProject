package com.pc.app.service.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.notification.Notification;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	NotificationRepository notificationrepo;
	
	/**
	 * Get the list Of Notification for  User
	 * @return List All Notification for  User
	 */
	@Override
	public List<Notification> listnotificationinfo() {
		return notificationrepo.findAll() ;
	}
	
	
	

}
