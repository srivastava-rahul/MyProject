package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.notification.Notification;
import com.pc.app.service.notification.NotificationService;


@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	
	@Autowired
	NotificationService notificationsrv;
	
	/**
	 * List  of All Notification entered for User
	 * @return List All Notification entered for User
	 */
	@RequestMapping(value = "/listnotification", method=RequestMethod.GET)
	public ResponseEntity<?> listnotification(){
	
		List<Notification>  listnotificationinfo=notificationsrv.listnotificationinfo();
		 if(listnotificationinfo==null ||listnotificationinfo.isEmpty()){
			 return new ResponseEntity<String>("In-Valid Email_Id Or Data Does Not Exist",HttpStatus.OK);
		 }else{
			 return new ResponseEntity<List<Notification>>(listnotificationinfo,HttpStatus.OK);
			
		 }
		
		}

}
