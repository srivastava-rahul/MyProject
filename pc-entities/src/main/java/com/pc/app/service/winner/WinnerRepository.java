package com.pc.app.service.winner;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pc.app.model.winner.Winner;

@Repository
public interface WinnerRepository extends MongoRepository<Winner, String> {

}
