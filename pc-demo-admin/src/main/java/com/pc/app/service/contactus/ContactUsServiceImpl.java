package com.pc.app.service.contactus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.contactus.ContactUs;

@Service
public class ContactUsServiceImpl implements ContactUsService{

	@Autowired
	ContactUsRepository contactrepo;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	 /**
	 * Add  Contact-Us information of admin
	 * @return message of success or fail
	 */
	@Override
	public String addcontactinfo(ContactUs contactus) {
		if(contactus == null ||contactus.equals("")){
			return "Invalid-Data";
		}
		
		ContactUs resultnotification=contactrepo.save(contactus);
		 if(resultnotification!=null){
			return "Success";
		}else{
			return "Fail";
		}
	
	}
	
	/**
	 * Delete  Contact-Us information 
	 * @return message of success or fail
	 */
	@Override
	public String deletecontactus(String email_id){
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		ContactUs idexist=contactrepo.findOne(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"ContactUs");
				
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}	
	
	

}
