package com.pc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.testimonial.Testimonial;
import com.pc.app.security.SecurityController;
import com.pc.app.service.testimonial.TestimonialService;

@RestController
@RequestMapping("/testimonial")
public class TestimonialController {
	
	
/*................................................................................................................................*/	
/*....................................In this we only show the good feedback  given by the user..................................*/	
/*................................................................................................................................*/	
	@Autowired
	TestimonialService testimonialsrv;
	
	@Autowired
	SecurityController  security;
	
	/**
	 * Add Testimonial by Admin which is good feedback 
	 * @return message of Success or failure
	 */
	@RequestMapping(value = "/addtestimonial", method=RequestMethod.POST)
	public ResponseEntity<?> addtestimonial(@RequestBody Testimonial testimonial){
		if(testimonial == null || testimonial.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		 boolean check=security.checkforaddtestimonial(testimonial);
		 if(check==false){
		String addtestimonialresult=testimonialsrv.addtestimonial(testimonial.getEmail_id(),testimonial.getGoodfeedbackmsg(),
				testimonial.getName(),testimonial.getProfile_pic()	);
		 return new ResponseEntity<String>( addtestimonialresult,HttpStatus.OK);
		 }else{
			 return new ResponseEntity<String>("Invalid Data",HttpStatus.OK); 
		 }
        }
	
	
	/**
	 * DeleteTestimonial by Admin which is good feedback
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/deletetestimonial", method=RequestMethod.POST)
	public ResponseEntity<?> deletetestimonial(@RequestParam ("email_id")String email_id){
		if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	    boolean check=security.checkfordeletetestimonial(email_id);	
	   if(check==false){
		   String deletetestimonialmsg=testimonialsrv.deletetestimonial(email_id);
		    return new ResponseEntity<String>(deletetestimonialmsg,HttpStatus.OK);
	   }else{
		   return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
	   }
		}
}

