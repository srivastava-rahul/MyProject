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

import com.pc.app.model.rules.Rules;
import com.pc.app.rules.RulesService;
import com.pc.app.security.SecurityController;

@RestController
@RequestMapping("/rules")
public class RulesController {

	@Autowired
	RulesService rules;
	
	@Autowired
	SecurityController security;
	
	/**
	 * Add Rules and Prize for competition
	 * @param email_id
	 * @param rules
	 * @param prize
	 * @return Message of success or fail
	 */
	@RequestMapping(value = "/addrules", method=RequestMethod.POST)
	public ResponseEntity<?> addrules(@RequestBody Rules rulesterms){
		if(rules == null || rules.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		boolean check=security.checkforaddrules(rulesterms);
		if(check==false){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		rulesterms.setCreated_date(dateFormat.format(date));
		   String addrulesmsg=rules.addrules(rulesterms);
		    return new ResponseEntity<String>(addrulesmsg,HttpStatus.OK);
		}else{
			  return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);	
		}
		}
	
	/**
	 * Delete Rules Information
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/deleterules", method=RequestMethod.POST)
	public ResponseEntity<?> deleterules(@RequestParam ("email_id")String email_id){
		if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	    	boolean check=security.checkfordeleterules(email_id);
	    	if(check==false){
		   String deleterulesmsg=rules.deleterules(email_id);
		    return new ResponseEntity<String>(deleterulesmsg,HttpStatus.OK);
	    	}else{
	    		 return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
	    	}
		}
}
