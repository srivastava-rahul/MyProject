package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.feedbackAndsuggestion.FeedbackAndSuggestions;
import com.pc.app.security.SecurityController;
import com.pc.app.service.feedbackAndsuggestions.FeedbackAndSuggestionsService;


@RestController
@RequestMapping("/feedback")
public class FeedbackAndSuggestionsController {
	
	@Autowired
	FeedbackAndSuggestionsService feedbacksrv;
	
	@Autowired
	SecurityController security;
	
	/**
	 * List  of All Feedback provide by User
	 * @return List All Feedback provide by User
	 */
	@RequestMapping(value = "/listfeedbackinfo", method=RequestMethod.GET)
	public ResponseEntity<?> listfeedbackinfo(){
	
		List<FeedbackAndSuggestions>  listfeedbackinfo=feedbacksrv.listfeedbackinfo();
		 if(listfeedbackinfo==null ||listfeedbackinfo.isEmpty()){
			 return new ResponseEntity<String>("In-Valid Email_Id Or Data Does Not Exist",HttpStatus.OK);
		 }else{
			 return new ResponseEntity<List<FeedbackAndSuggestions>>(listfeedbackinfo,HttpStatus.OK);
			
		 }
		
		}

	/**
	 * Delete Feedback Information
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/deletefeedbackinfo", method=RequestMethod.POST)
	public ResponseEntity<?> deletefeedbackinfo(@RequestParam ("email_id")String email_id){
		if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	    	boolean check=security.checkfordeletefeedbackinfo(email_id);
	    	if(check==false){
		   String deletefeedbackmsg=feedbacksrv.deletefeedbackinfo(email_id);
		    return new ResponseEntity<String>(deletefeedbackmsg,HttpStatus.OK);
	    	}else{
	    		 return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);	
	    	}
		}

	
	
}
