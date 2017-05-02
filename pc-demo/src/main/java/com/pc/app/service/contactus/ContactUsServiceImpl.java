package com.pc.app.service.contactus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.contactus.ContactUs;

@Service
public class ContactUsServiceImpl implements ContactUsService{

	@Autowired
	ContactUsRepository contactrepo;
	
	/**
	 * Get the list Of Contact-Us for  User
	 * @return List Contact-Us for  User
	 */
	@Override
	public List<ContactUs> listcontactinfo() {
		return contactrepo.findAll() ;
	}
	
	
	

}
