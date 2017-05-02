package com.pc.app.service.registration;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.pc.app.heartbeat.Heartbeat;
import com.pc.app.model.registration.UserInformation;
import com.pc.app.service.profile.ProfileSettingRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserInformationRepository  userrepo;

	@Autowired	
	ProfileSettingRepository  profilerepo;

	
	@Autowired
    private MongoTemplate mongoTemplate;


	/*same class object is created to call create folder method in which we put pics of related user*/
	//UserRegistrationServiceImpl userregister=new UserRegistrationServiceImpl();

	/**
	 * Add User
	 * @param userinfo
	 * @return Message
	 */
	@Override
	public String adduser(UserInformation userinfo) {
		//adding user
		if(userinfo == null ||userinfo.equals("")){
			return "Invalid-Data";
		}

		UserInformation existinguser=userrepo.findbyid(userinfo.getEmail_id());

		if(existinguser!=null){
			return "User Already Exist";

		}else{
			try{
				UserInformation newuseradd=userrepo.save(userinfo);
				if(newuseradd!=null){
					return "Sucessfully Registered";
				}
			}catch(Exception e){

			}
		}
		return "Failed to Registered";
	}


	/**
	 * Update User
	 * @param userinfo
	 * @return Message
	 */
	@Override
	public String updateuser(UserInformation userinfo) {
		if(userinfo == null ||userinfo.equals("")){
			return "Invalid-Data";
		}
		UserInformation existinguser=userrepo.findbyid(userinfo.getEmail_id());
		if(existinguser!=null){
			UserInformation userinfoupdate= new UserInformation();

			if(existinguser.getFirstName() != userinfo.getFirstName()){
				userinfoupdate.setFirstName(userinfo.getFirstName());
			}
			if(existinguser.getLastName() != userinfo.getLastName()){
				userinfoupdate.setLastName(userinfo.getLastName());
			}

			if(existinguser.getGender() != userinfo.getGender()){
				userinfoupdate.setGender(userinfo.getGender());
			}
			if(existinguser.getDob() != userinfo.getDob()){
				userinfoupdate.setDob(userinfo.getDob());
			}
			if(existinguser.getPassword() != userinfo.getPassword()){
				userinfoupdate.setPassword(userinfo.getPassword());
			}
			if(existinguser.getPhone() != userinfo.getPhone()){
				userinfoupdate.setPhone(userinfo.getPhone());
			}

		}else{
			return "No Data is Avaliable to Update";

		}
		try{
			userrepo.save(userinfo);
			return "Data Sucessfully Updated";
		}catch(Exception e){

		}
		return "Data Failed to Updated";
	}


	/**
	 * Delete User
	 * @param email_id
	 * @return Message
	 */
	@Override
	public String deleteuser(String email_id) {
		if(email_id == null ||email_id.equals("")){
			return "Invalid-Data";
		}

		UserInformation idexist=userrepo.findbyid(email_id);

		if(idexist !=null){
			try{
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"ProfileSetting");
				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"UserInformation");
			}catch(Exception e){

			}

			return "Sucessfully Deleted the Account";
		}
		return "Email_Id Invalid Or Does Not Exist";

	}


	/**
	 * List of User
	 * @return List of User
	 */
	@Override
	public List<UserInformation> listofuser() {
		Heartbeat h= new Heartbeat();
		try {
			//h.runForRecoveryHeartBeat();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return  userrepo.findAll();

	}
	/**
	 * List of User BY email_id
	 * @return List of User
	 */
	@Override
	public List<UserInformation> listofuserbyemailid(String email_id) {
		
		List<UserInformation> userinforeult=mongoTemplate.find(new Query(Criteria.where("_id").is(email_id)),UserInformation.class,"UserInformation");
		
		return userinforeult ;

	}
	//----------------------=====================================================================================--------
	/**
	 * Deactivate the Account of User
	 * @param email_id
	 * @param status
	 * @return Message
	 */
	@Override
	public String deactivateuser(String email_id,String status) {
		if(email_id == null ||email_id.equals("") || status == null ||status.equals("")){
			return "Invalid-Data";
		}
		UserInformation existinguser=userrepo.findbyid(email_id);
		if(existinguser!=null){
			try{
				mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(email_id)),new Update().set("status", status),UserInformation.class);
				return "Sucessfully deactivate the Account";
			}catch(Exception e)
			{
				
			}
		}
		return "Email_Id Does Not Exist";
	}




	/**
	 * Create Folder of User for photo based on email_id
	 * @param email
	 * @return Message
	 */
	@Override
	public String createfolderforpic(String email) {
		if(email!=null){
			File currentDirectory = new File(new File(".").getAbsolutePath());
			File pic_folder = new File(currentDirectory.getAbsolutePath() + "\\pic_folder\\" + email);
			File profile_pic_folder = new File(currentDirectory.getAbsolutePath() + "\\profile_pic_folder\\" + email);
			if (!pic_folder.exists() && !profile_pic_folder.exists() ) {
				pic_folder.mkdirs();
				profile_pic_folder.mkdirs();
				return "Success";
			}
			else{
				return "Fail";
			}
		}
		return "Already Folder Exist with same name";

	}


	/**
	 * Create Folder of User for photo based on email_id
	 * @param email
	 * @return Message
	 */
	@Override
	public String deletefolderforpic(String email) {
		if(email!=null){
			File currentDirectory = new File(new File(".").getAbsolutePath());
			File pic_folder = new File(currentDirectory.getAbsolutePath() + "\\pic_folder\\" + email);
			File profile_pic_folder = new File(currentDirectory.getAbsolutePath() + "\\profile_pic_folder\\" + email);
			if (pic_folder.exists() && profile_pic_folder.exists() ) {
				pic_folder.delete();
				profile_pic_folder.delete();
				return "Success";
			}
			else{
				return "Folder Already deleted";
			}
		}
		return "Folder Does Not Exist";
	}



}
