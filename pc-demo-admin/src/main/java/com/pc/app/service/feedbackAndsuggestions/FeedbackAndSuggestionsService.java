package com.pc.app.service.feedbackAndsuggestions;

import java.util.List;

import com.pc.app.model.feedbackAndsuggestion.FeedbackAndSuggestions;

public interface FeedbackAndSuggestionsService {

	/**
	 * Get the list Of feedback of User
	 * @return List All Feedback provide by User
	 */
	public List<FeedbackAndSuggestions> listfeedbackinfo();
	
	/**
	 * Delete Feedback Information
	 * return message  Success or fail
	 */
	public String deletefeedbackinfo(String email_id);

}
