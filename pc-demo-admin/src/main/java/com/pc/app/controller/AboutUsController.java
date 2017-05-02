package com.pc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.aboutus.AboutUsService;
import com.pc.app.model.aboutus.AboutUs;
import com.pc.app.security.SecurityController;

@RestController
@RequestMapping("/aboutus")
public class AboutUsController {
	
	@Autowired
	AboutUsService aboutussrv;
	
	@Autowired
	SecurityController security;


	/**
	 * Add  Data related to About Us
	 * @return message of success or failure
	 */
	@RequestMapping(value = "/addaboutus", method=RequestMethod.POST)
	public ResponseEntity<?> addaboutus(@RequestBody AboutUs about){
		if(about == null || about.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		
		boolean check=security.checkforaddaboutus(about);
		if(check==false){
	    	String addaboutussmsg=aboutussrv.addaboutus(about);
		    return new ResponseEntity<String>(addaboutussmsg,HttpStatus.OK);
		   }else{
			   return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);  
		   }
		}
	
	
	@RequestMapping(value = "/deleteaboutus", method=RequestMethod.POST)
	public ResponseEntity<?> deleteaboutus(@RequestParam ("email_id")String email_id){
		if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		    boolean check=security.checkfordeleteaboutus(email_id);
		    if(check==false){
		    	String deleteaboutussmsg=aboutussrv.deleteaboutus(email_id);
			    return new ResponseEntity<String>(deleteaboutussmsg,HttpStatus.OK);	
		    }else{
		    
		    return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
		    }
		}
	
}
