package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.contactus.ContactUs;
import com.pc.app.service.contactus.ContactUsService;


@RestController
@RequestMapping("/contactus")
public class ContactUsController {
	
	@Autowired
	ContactUsService contactsrv;
   /**
	 * List  of All Contact Us entered for User
	 * @return List All Contact Us entered for User
	 */
	@RequestMapping(value = "/listcontactus", method=RequestMethod.GET)
	public ResponseEntity<?> listcontactus(){
	List<ContactUs>  listconatact=contactsrv.listcontactinfo();
		 if(listconatact==null ||listconatact.isEmpty()){
			 return new ResponseEntity<String>("In-Valid Email_Id Or Data Does Not Exist",HttpStatus.OK);
		 }else{
			 return new ResponseEntity<List<ContactUs>>(listconatact,HttpStatus.OK);
			
		 }
		
		}
	
	
}
