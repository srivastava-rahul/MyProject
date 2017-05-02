package com.pc.app.service.profile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pc.app.model.profile.ProfileSetting;

@Repository
public interface ProfileSettingRepository extends MongoRepository<ProfileSetting, String> {

	

}
