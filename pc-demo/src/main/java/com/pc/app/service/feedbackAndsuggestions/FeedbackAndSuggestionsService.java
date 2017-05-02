package com.pc.app.service.feedbackAndsuggestions;

public interface FeedbackAndSuggestionsService {

	/**
	 * Add Feedback of User
	 * @param email_id
	 * @param feedback
	 * @return Message
	 */
	public String addfeedback( String email_id,String feedback);
	

}
