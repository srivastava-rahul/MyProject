package com.pc.app.service.contactus;

import com.pc.app.model.contactus.ContactUs;

public interface ContactUsService {

	
	
	/**
	 * Add  Contact-Us information of admin
	 * @return message of success or fail
	 */
	public String addcontactinfo(ContactUs contactus);
	
	
	/**
	 * Delete  Contact-Us information of admin
	 * @return message of success or fail
	 */
	public String deletecontactus(String email_id);
	
	
}
