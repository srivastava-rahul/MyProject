package com.pc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * Add Feedback of User
	 * @param email_id
	 * @param feedback
	 * @return Message
	 */
	@RequestMapping(value = "/addfeedback", method=RequestMethod.POST)
	public ResponseEntity<?> addfeedback(@RequestBody FeedbackAndSuggestions feedback){
		if(feedback == null || feedback.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		
		boolean check=security.checkforFeedback(feedback);
		if(check==false){
		 String addfeedbackmsg=feedbacksrv.addfeedback(feedback.getEmail_id(),feedback.getFeedback());
		    return new ResponseEntity<String>(addfeedbackmsg,HttpStatus.OK);
		    }else{
		    	 return new ResponseEntity<String>("In-valid Data",HttpStatus.OK);
		    }
		}
	
	
}
