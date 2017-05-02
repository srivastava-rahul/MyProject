package com.pc.app.service.FeedbackAndSuggestion;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pc.app.model.feedbackAndsuggestion.FeedbackAndSuggestions;

public interface FeedbackRepository extends MongoRepository <FeedbackAndSuggestions , String> {

}
