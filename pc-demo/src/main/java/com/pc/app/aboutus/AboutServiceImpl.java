package com.pc.app.aboutus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.aboutus.AboutUs;
import com.pc.app.service.aboutus.AboutUsRepository;

@Service
public class AboutServiceImpl implements AboutUsService {
	
	@Autowired
	AboutUsRepository aboutusrepo;
	
	/**
	 * List of data related to about us
	 * @return List of data related to about us
	 */
	@Override
	public List<AboutUs> listofaboutus() {		
		return aboutusrepo.findAll();
	}
}
