package com.pc.app.service.notification;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.notification.Notification;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	NotificationRepository notificationrepo;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	/**
	 * Add Notification by Admin
	 * @param email_id
	 * @param notification
	 * @return Message
	 */
	@Override
	public String addnotification(String email_id, String notification) {
		if(email_id == null ||email_id.equals("") || notification == null ||notification.equals("")){
			return "Invalid-Data";
		}
	     Notification notif=new Notification();
		 notif.setEmail_id(email_id);
		 notif.setNotificationMsg(notification);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		notif.setCreateddate(dateFormat.format(date));
		Notification resultnotification=notificationrepo.save(notif);
		if(resultnotification!=null){
			return "Success";
		}else{
			return "Fail";
		}
	}


	@Override
	public String deletenotification(String email_id) {
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		Notification idexist=notificationrepo.findOne(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"Notification");
				
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}	
	
	

}
