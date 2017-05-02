package com.pc.app.aboutus;

import com.pc.app.model.aboutus.AboutUs;

 
public interface AboutUsService {


	/**
	 * Add data related to about us
	 * @param aboutus 
	 * @return message of success or fail 
	 */
	public String addaboutus(AboutUs aboutus);
	
	/**
	 * Delete data related to about us
	 * @param email_id 
	 * @return message of success or fail 
	 */
	public String deleteaboutus(String email_id);
	
	
}
