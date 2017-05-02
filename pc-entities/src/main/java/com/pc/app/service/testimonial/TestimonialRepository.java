package com.pc.app.service.testimonial;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pc.app.model.testimonial.Testimonial;

public interface TestimonialRepository extends MongoRepository <Testimonial, String> {

}
