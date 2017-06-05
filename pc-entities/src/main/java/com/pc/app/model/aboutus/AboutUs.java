package com.pc.app.model.aboutus;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

// ABOUT VIPUL
@Document(collection="About_Us")
public class AboutUs {
	
	private String email_id;
	private List<String> aboutus;
	private String created_date;
	
	
	public AboutUs(){}
	public AboutUs(String email_id, List<String> aboutus, String created_date) {
		super();
		this.email_id = email_id;
		this.aboutus = aboutus;
		this.created_date = created_date;
	}



	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public List<String> getAboutus() {
		return aboutus;
	}

	public void setAboutus(List<String> aboutus) {
		this.aboutus = aboutus;
	}
	
	
    
}
