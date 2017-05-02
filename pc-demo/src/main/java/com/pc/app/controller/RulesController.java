package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.rules.Rules;
import com.pc.app.rules.RulesService;

@RestController
@RequestMapping("/rules")
public class RulesController {
	
	@Autowired
	RulesService rules;
	

	/**
	 * List of Rules and prize
	 * @return List of  Rules and prize
	 */
	@RequestMapping(value = "/listrules", method=RequestMethod.GET)
	public ResponseEntity<?> listofrules(){
		List<Rules>  resultofrules=rules.listofrules();
		if(resultofrules == null || resultofrules.isEmpty()){
		return new ResponseEntity<String>("Rules List Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Rules>>(resultofrules,HttpStatus.OK);
		}
		
	}
}
