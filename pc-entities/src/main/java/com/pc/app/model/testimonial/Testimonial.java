package com.pc.app.model.testimonial;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Testimonial")
public class Testimonial {
	
	@Id
	private String email_id;  //it is the id of user who has given good feedback
	private String  goodfeedbackmsg;
	private String name;
	private String  profile_pic;
	private String createddate;
	
	public Testimonial(){
		
	}
	
     

	public Testimonial(String email_id, String goodfeedbackmsg, String name, String profile_pic, String createddate) {
		super();
		this.email_id = email_id;
		this.goodfeedbackmsg = goodfeedbackmsg;
		this.name = name;
		this.profile_pic = profile_pic;
		this.createddate = createddate;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getGoodfeedbackmsg() {
		return goodfeedbackmsg;
	}

    public void setGoodfeedbackmsg(String goodfeedbackmsg) {
		this.goodfeedbackmsg = goodfeedbackmsg;
	}
    
    public String getProfile_pic() {
		return profile_pic;
	}



	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}



	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	
	
}