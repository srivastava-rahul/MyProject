package com.pc.app.service.contactus;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pc.app.model.contactus.ContactUs;

@Repository
public interface ContactUsRepository extends MongoRepository<ContactUs, String> {

}
