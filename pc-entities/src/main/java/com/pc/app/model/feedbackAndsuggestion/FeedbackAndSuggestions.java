package com.pc.app.model.feedbackAndsuggestion;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FeedbackAndSuggestions")
public class FeedbackAndSuggestions {

    
	private String email_id;  //it contain the id of user who has given the feedback
	
	private String feedback;
	
	private String createddate;
	
	public FeedbackAndSuggestions(){
		
	}
	
	public FeedbackAndSuggestions(String email_id, String feedback, String createddate) {
		super();
		this.email_id = email_id;
		this.feedback = feedback;
		this.createddate = createddate;
		
	}



	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getCreateddate() {
		return createddate;
	}

    public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

}
