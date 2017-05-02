package com.pc.app.service.registration;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pc.app.model.registration.UserInformation;


@Repository
public interface UserInformationRepository extends MongoRepository <UserInformation, String>{
	
	@Query(value="{ '_id' : ?0, 'status' : ?1} ")
	UserInformation deactivateuser(String _id,String status);
   
	@Query(value="{ '_id' : ?0}")
	UserInformation findbyid(String id);
	
	 
	
	
	
}

