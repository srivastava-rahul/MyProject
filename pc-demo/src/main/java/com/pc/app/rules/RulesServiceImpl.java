package com.pc.app.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.rules.Rules;
import com.pc.app.service.rules.RulesRepository;

@Service
public class RulesServiceImpl implements RulesService {
	
	@Autowired
	RulesRepository rulesrepo;
	
	/**
	 * List of Rules and prize
	 * @return List of  Rules and prize
	 */
	@Override
	public List<Rules> listofrules() {
		return rulesrepo.findAll();
	}
}
