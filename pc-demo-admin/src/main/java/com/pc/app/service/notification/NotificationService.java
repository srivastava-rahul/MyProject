package com.pc.app.service.notification;

public interface NotificationService {

	/**
	 * Add Notification by Admin
	 * @param email_id
	 * @param notification
	 * @return Message
	 */
	public String addnotification(String email_id,String notification);
	
	/**
	 * Delete Notification Information
	 * return message  Success or fail
	 */
	public String deletenotification(String email_id);
	

}
