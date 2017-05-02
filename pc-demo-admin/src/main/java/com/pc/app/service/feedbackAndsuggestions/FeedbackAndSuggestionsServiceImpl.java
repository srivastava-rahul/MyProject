package com.pc.app.service.feedbackAndsuggestions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.feedbackAndsuggestion.FeedbackAndSuggestions;
import com.pc.app.service.FeedbackAndSuggestion.FeedbackRepository;


@Service
public class FeedbackAndSuggestionsServiceImpl implements FeedbackAndSuggestionsService {

	@Autowired
	FeedbackRepository feedrepo;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	/**
	 * Get the list Of feedback of User
	 * @return List All Feedback provide by User
	 */
	@Override
	public List<FeedbackAndSuggestions> listfeedbackinfo() {
		return feedrepo.findAll();
	}

	/**
	 * Delete Feedback Information
	 * return message  Success or fail
	 */
	@Override
	public String deletefeedbackinfo(String email_id) {
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		FeedbackAndSuggestions idexist=feedrepo.findOne(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"FeedbackAndSuggestions");
				
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}	

}
