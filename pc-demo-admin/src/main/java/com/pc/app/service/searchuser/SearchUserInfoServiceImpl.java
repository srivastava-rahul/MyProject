package com.pc.app.service.searchuser;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.registration.UserInformation;

@Service
public class SearchUserInfoServiceImpl implements SearchUserInfoService {
	
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public List<UserInformation> listofuserbyemail(String email) {
		
		
		
		//List<UserInformation> listOfUserInfo=mongoTemplate.find(new Query(Criteria.where("email_id").regex(Pattern.compile(email, Pattern.CASE_INSENSITIVE))),UserInformation.class,"UserInformation");
		List<UserInformation> listOfUserInfo=mongoTemplate.find(new Query(Criteria.where("_id").is(Pattern.compile(email, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS))),UserInformation.class,"UserInformation");
		return listOfUserInfo;
	}

	@Override
	public List<UserInformation> listofuserbyphone(long phone) {
		
		
		List<UserInformation> listOfUserInfo=mongoTemplate.find(new Query(Criteria.where("phone").is(phone)),UserInformation.class,"UserInformation");
		return listOfUserInfo;
	}

	@Override
	public List<UserInformation> listofuserbyname(String name) {
		
		
		List<UserInformation> listOfUserInfo=mongoTemplate.find(new Query(Criteria.where("firstName").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE))),UserInformation.class,"UserInformation");
		return listOfUserInfo;
	}
	
	
	
	

}
