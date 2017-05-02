package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.testimonial.Testimonial;
import com.pc.app.service.testimonial.TestimonialService;

@RestController
@RequestMapping("/testimonial")
public class TestimonialController {
	
	
/*................................................................................................................................*/	
/*....................................In this we only show the good feedback  given by the user..................................*/	
/*................................................................................................................................*/	
	@Autowired
	TestimonialService testimonialsrv;
	
	/**
	 * List Testimonial of Good Feedback
	 * @return List of Testimonial Good Feedback
	 */
	@RequestMapping(value = "/listoftestimonial", method=RequestMethod.GET)
	public ResponseEntity<?> listoftestimonial(){
		List<Testimonial>  resulttestimonial=testimonialsrv.listoftestimonial();
		if(resulttestimonial == null || resulttestimonial.isEmpty()){
		return new ResponseEntity<String>("Testimonial Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Testimonial>>(resulttestimonial,HttpStatus.OK);
		}
	}
}
