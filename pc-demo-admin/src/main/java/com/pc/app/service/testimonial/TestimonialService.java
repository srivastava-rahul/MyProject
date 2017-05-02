package com.pc.app.service.testimonial;

public interface TestimonialService {
	
	
	/**
	 * Add Testimonial by Admin which is good feedback 
	 * @return message of Success or failure
	 */
	public String  addtestimonial(String email_id,String testimonialmsg,
			String name,String profile_pic);

	/**
	 * DeleteTestimonial by Admin which is good feedback
	 * return message  Success or fail
	 */
	public String  deletetestimonial(String email_id);
	
}
