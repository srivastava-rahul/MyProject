package com.pc.app.service.searchuser;

import java.util.List;

import com.pc.app.model.registration.UserInformation;

public interface SearchUserInfoService {
	
	
	/**
	 * List of User
	 * @return List of User
	 */
	public List<UserInformation> listofuserbyemail(String email);
	
	/**
	 * List of User
	 * @return List of User
	 */
	public List<UserInformation> listofuserbyphone(long phone);
	
	/**
	 * List of User
	 * @return List of User
	 */
	public List<UserInformation> listofuserbyname(String name);

}
