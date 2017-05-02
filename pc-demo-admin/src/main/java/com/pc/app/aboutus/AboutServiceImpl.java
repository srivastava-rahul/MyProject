package com.pc.app.aboutus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.aboutus.AboutUs;
import com.pc.app.service.aboutus.AboutUsRepository;

@Service
public class AboutServiceImpl implements AboutUsService {

	@Autowired
	AboutUsRepository aboutusrepo;
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public String addaboutus(AboutUs aboutus) {
		try{
			AboutUs newraboutadd=aboutusrepo.save(aboutus);
			if(newraboutadd!=null){
				return "Sucessfully Added Rules amd terms";
			}
		}catch(Exception e){
			return "No data to be added ";
		}
		return "Invalid data";
	}

	@Override
	public String deleteaboutus(String email_id) {
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		AboutUs idexist=aboutusrepo.findOne(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"AboutUs");
				
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}

	
}
