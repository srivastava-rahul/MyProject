package com.pc.app.service.feedbackAndsuggestions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.feedbackAndsuggestion.FeedbackAndSuggestions;
import com.pc.app.service.FeedbackAndSuggestion.FeedbackRepository;

@Service
public class FeedbackAndSuggestionsServiceImpl implements FeedbackAndSuggestionsService {

	@Autowired
	FeedbackRepository feedbackrepo;
	
	/**
	 * Add Feedback of User
	 * @param email_id
	 * @param feedback
	 * @param Created Date
	 * @return Message
	 */
	@Override
	public String addfeedback(String email_id, String feedback) {
		if(email_id == null ||email_id.equals("") || feedback == null ||feedback.equals("")){
			return "Invalid-Data";
		}
		FeedbackAndSuggestions fdbk=new FeedbackAndSuggestions();
		fdbk.setEmail_id(email_id);
		fdbk.setFeedback(feedback);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		fdbk.setCreateddate(dateFormat.format(date));
		FeedbackAndSuggestions resultfeedback=feedbackrepo.save(fdbk);
		if(resultfeedback!=null){
			return "Success";
		}else{
			return "Fail";
		}
	}


}
