package com.pc.app.service.testimonial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.testimonial.Testimonial;

@Service
public class TestimonialServiceImpl implements TestimonialService {

	@Autowired
	TestimonialRepository testimonialrepo;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	/**
	 * Add Testimonial by Admin which is good feedback 
	 * @return message of Success or failure
	 */
	@Override
	public String addtestimonial(String email_id,String testimonialmsg,
			String name,String profile_pic) {
		
		if(email_id == null ||email_id.equals("") || testimonialmsg == null ||testimonialmsg.equals("")||name == null ||name.equals("")){
			return "Invalid-Data";
		}
		Testimonial testmnl=new Testimonial();
		testmnl.setEmail_id(email_id);
		testmnl.setGoodfeedbackmsg(testimonialmsg);
		testmnl.setName(name);
		testmnl.setProfile_pic(profile_pic);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		testmnl.setCreateddate(dateFormat.format(date));
		Testimonial resultnotification=testimonialrepo.save(testmnl);
		if(resultnotification!=null){
			return "Success";
		}else{
			return "Fail";
		}
	
	}
	

	/**
	 * DeleteTestimonial by Admin which is good feedback
	 * return message  Success or fail
	 */
	public String  deletetestimonial(String email_id){
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		Testimonial idexist=testimonialrepo.findOne(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"Testimonial");
				
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}	
	
}
