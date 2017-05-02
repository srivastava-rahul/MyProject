package com.pc.app.service.competition.pics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pc.app.model.competition.pics.PicsCompetition;

@Repository
public interface PicsCompetitionRepository extends MongoRepository<PicsCompetition, String> {

}
