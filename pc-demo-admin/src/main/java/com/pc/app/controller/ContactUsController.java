package com.pc.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.contactus.ContactUs;
import com.pc.app.security.SecurityController;
import com.pc.app.service.contactus.ContactUsService;


@RestController
@RequestMapping("/contactus")
public class ContactUsController {

	@Autowired
	ContactUsService contactsrv;
	
	@Autowired
	SecurityController security;
	
	
	/**
	 * Add  Contact Information
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/addcontactus", method=RequestMethod.POST)
	public ResponseEntity<?> addcontactus(@RequestBody ContactUs contactus){
		if(contactus == null || contactus.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}

        boolean check=security.checkforaddcontactus(contactus);
        if(check==false){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		contactus.setCreated_date(dateFormat.format(date));
		String addcontactmsg=contactsrv.addcontactinfo(contactus);
		return new ResponseEntity<String>(addcontactmsg,HttpStatus.OK);
        }else{
        	return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
        }
	}
	
	/**
	 * Delete  Contact Information
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/deletecontactus", method=RequestMethod.POST)
	public ResponseEntity<?> deletecontactus(@RequestParam ("email_id")String email_id){
		if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	    	boolean check=security.checkfordeletecontactus(email_id);
	    	if(check==false){
		   String deletecontactmsg=contactsrv.deletecontactus(email_id);
		    return new ResponseEntity<String>(deletecontactmsg,HttpStatus.OK);
	    	}else{
	          return new ResponseEntity<String>("Invalid data",HttpStatus.OK);
	    	}
		}

}



