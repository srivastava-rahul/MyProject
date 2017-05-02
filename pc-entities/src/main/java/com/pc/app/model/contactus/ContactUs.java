package com.pc.app.model.contactus;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Contact_Us")
public class ContactUs {
   private String name;
   private List<String>email_id;
   private List<Long>phone;
   private String created_date;

   public ContactUs(){}
   public ContactUs(String name, List<String> email_id, List<Long> phone, String created_date) {
	super();
	this.name = name;
	this.email_id = email_id;
	this.phone = phone;
	this.created_date = created_date;
}

public String getCreated_date() {
	return created_date;
}
public void setCreated_date(String created_date) {
	this.created_date = created_date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getEmail_id() {
	return email_id;
}
public void setEmail_id(List<String> email_id) {
	this.email_id = email_id;
}
public List<Long> getPhone() {
	return phone;
}
public void setPhone(List<Long> phone) {
	this.phone = phone;
}
   
   
   
}
