package com.pc.app.model.notification;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Notification")
public class Notification {
	
	private String email_id;                 //it contain the id of Admin who have entered
	private String notificationMsg;
	private String createddate;
	
	
	public Notification(){
		
	}
	
	
	

    public Notification(String email_id, String notificationMsg, String createddate) {
		super();
		this.email_id = email_id;
		this.notificationMsg = notificationMsg;
		this.createddate = createddate;
	}

    public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	


	public String getNotificationMsg() {
		return notificationMsg;
	}




	public void setNotificationMsg(String notificationMsg) {
		this.notificationMsg = notificationMsg;
	}




	public String getCreateddate() {
		return createddate;
	}


	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	
	

}
