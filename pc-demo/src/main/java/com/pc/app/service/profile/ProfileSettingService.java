package com.pc.app.service.profile;

import java.util.List;

import com.pc.app.model.profile.ProfileSetting;

public interface ProfileSettingService {

	/**
	 *  Add Profile Information
	 * @param userprofileinfo
	 * @return Message
	 */
	public String addprofileinfo( ProfileSetting  userprofileinfo);
	
	/**
	 * Update Profile Information
	 * @param userprofileinfo
	 * @return Message
	 */
	public String updateprofileinfo( ProfileSetting  userprofileinfo);
	
	/**
	 * List All Profile Information of particular User
	 * @param email_id
	 * @return List of Information
	 */
	public List<ProfileSetting> listprofileinfo(String email_id);
	
}
