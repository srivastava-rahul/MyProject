package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.aboutus.AboutUsService;
import com.pc.app.model.aboutus.AboutUs;

@RestController
@RequestMapping("/aboutus")
public class AboutUsController {
	
	@Autowired
	AboutUsService aboutussrv;
	

	/**
	 * List of Data related to About Us
	 * @return List of  Data related to About Us
	 */
	@RequestMapping(value = "/listaboutus", method=RequestMethod.GET)
	public ResponseEntity<?> listofaboutus(){
		List<AboutUs>  resultofaboutus=aboutussrv.listofaboutus();
		if(resultofaboutus == null || resultofaboutus.isEmpty()){
		return new ResponseEntity<String>("Rules List Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<AboutUs>>(resultofaboutus,HttpStatus.OK);
		}
		
	}
}
