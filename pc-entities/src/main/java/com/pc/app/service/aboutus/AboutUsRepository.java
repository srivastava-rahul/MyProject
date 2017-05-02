package com.pc.app.service.aboutus;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pc.app.model.aboutus.AboutUs;

public interface AboutUsRepository extends MongoRepository <AboutUs , String> {

}
