package com.pc.app.service.testimonial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.testimonial.Testimonial;

@Service
public class TestimonialServiceImpl implements TestimonialService {

	@Autowired
	TestimonialRepository testimonialrepo;
	
	/**
	 * List Testimonial of good feedback
	 * @return List of Testimonial of Winner
	 */
	@Override
	public List<Testimonial> listoftestimonial() {
		
		List<Testimonial>  testimonial=testimonialrepo.findAll();
		if(testimonial==null ||testimonial.isEmpty()){
			 return null;
		}else{
		     return testimonial;
		}
	}
	

}
