package com.pc.app.rules;

import com.pc.app.model.rules.Rules;

 
public interface RulesService {


	/**
	 * Add Rules for competition
	 * @param rules terms
	 * @param prize 
	 * @return message of success or fail 
	 */
	public String addrules(Rules rules_terms);
	
	/**
	 * Delete Rules Information
	 * return message  Success or fail
	 */
	public String deleterules(String email_id);


	
}
