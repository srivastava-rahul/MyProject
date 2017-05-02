package com.pc.app.service.rules;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pc.app.model.rules.Rules;

@Repository
public interface RulesRepository extends MongoRepository<Rules, String> {

	

}
