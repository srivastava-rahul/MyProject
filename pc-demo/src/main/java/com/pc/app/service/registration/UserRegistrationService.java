package com.pc.app.service.registration;

import java.util.List;

import com.pc.app.model.registration.UserInformation;

public interface UserRegistrationService {
	
	/**
	 *  Add User 
	 * @param userinfo
	 * @return Message
	 */
	public String adduser(UserInformation userinfo);
	
	/**
	 * Update User
	 * @param userinfo
	 * @return Message
	 */
	public String updateuser(UserInformation userinfo);
	
	/**
	 * Delete User
	 * @param email_id
	 * @return Message
	 */
	public String deleteuser(String email_id);
	
	/**
	 * List of User
	 * @return List of User
	 */
	public List<UserInformation> listofuser();
	
	
	/**
	 * List of User By email_id
	 * @return List of User
	 */
	public List<UserInformation> listofuserbyemailid(String email_id);
	
	/**
	 * Deactivate the Account of User
	 * @param email_id
	 * @param status
	 * @return Message
	 */
	public String deactivateuser(String email_id,String status);
	
	
	/**
	 * Create Folder of User for photo based on email_id
	 * @param email
	 * @return Message
	 */
	 public String createfolderforpic(String email);
	 
	 /**
      * Create Folder of User for photo based on email_id
      * @param email
	  * @return Message
	  */
	 public String deletefolderforpic(String email);

}
