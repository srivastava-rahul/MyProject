package com.pc.app.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.rules.Rules;
import com.pc.app.service.rules.RulesRepository;

@Service
public class RulesServiceImpl implements RulesService {

	@Autowired
	RulesRepository rulesrepo;

	@Autowired
    private MongoTemplate mongoTemplate;
	/**
	 * Add Rules for competition
	 * @param rules terms
	 * @param prize
	 * @return message of success or fail 
	 */
	@Override
	public String addrules(Rules rules_terms) {

		try{
			Rules newrulesadd=rulesrepo.save(rules_terms);
			if(newrulesadd!=null){
				return "Sucessfully Added Rules amd terms";
			}
		}catch(Exception e){
			return "No data to be added ";
		}
		return "Invalid data";
	}

	
	
	/**
	 * Delete Rules Information
	 * return message  Success or fail
	 */
	public String deleterules(String email_id){
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		Rules idexist=rulesrepo.findOne(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"Rules");
				
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}	
	

}
