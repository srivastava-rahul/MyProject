package com.pc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.notification.Notification;
import com.pc.app.security.SecurityController;
import com.pc.app.service.notification.NotificationService;



@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	
	@Autowired
	NotificationService notificationsrv;
	
	@Autowired
	SecurityController security;
	
	/**
	 * Add All Notification by Admin
	 * @return message of Success
	 */
	@RequestMapping(value = "/addnotification", method=RequestMethod.POST)
	public ResponseEntity<?> addnotification(@RequestBody Notification notification){
		if(notification == null || notification.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	   boolean check=security.checkforaddnotification(notification);
	   if(check==false){
		String addnotificationmsg=notificationsrv.addnotification(notification.getEmail_id(),notification.getNotificationMsg());
		 return new ResponseEntity<String>(addnotificationmsg,HttpStatus.OK);
		 }else{
			 return new ResponseEntity<String>("Invalid Data",HttpStatus.OK); 
		 }		 
        }
	
	
	/**
	 * Delete Notification Information
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/deletenotification", method=RequestMethod.POST)
	public ResponseEntity<?> deletenotification(@RequestParam ("email_id")String email_id){
		if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	    	boolean check=security.checkfordeletenotification(email_id);
	    	if(check==false){
	    		 String deletenotificationmsg=notificationsrv.deletenotification(email_id);
	 		    return new ResponseEntity<String>(deletenotificationmsg,HttpStatus.OK);
	    	}else{
	    		 return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
	    	}
		  
		}

}