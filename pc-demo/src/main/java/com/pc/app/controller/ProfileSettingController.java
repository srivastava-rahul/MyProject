package com.pc.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.profile.ProfileSetting;
import com.pc.app.model.registration.UserInformation;
import com.pc.app.security.SecurityController;
import com.pc.app.service.profile.ProfileSettingService;
import com.pc.app.service.registration.UserRegistrationService;

@RestController
@RequestMapping("/profilesetting")
public class ProfileSettingController {


	@Autowired
	ProfileSettingService profilesetting;

	@Autowired
	SecurityController security;
	
	@Autowired
	UserRegistrationService  usersrv;
	/**
	 * Add Profile Information
	 * @param profilesettinginfo
	 * @return Message
	 */
	@RequestMapping(value = "/saveprofileinfo", method=RequestMethod.POST)
	public ResponseEntity<?> addprofileinfo(@RequestBody ProfileSetting profilesettinginfo){
		if(profilesettinginfo == null ||profilesettinginfo.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		boolean check=security.checkforaddprofileinfo(profilesettinginfo);
		if(check==false){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		profilesettinginfo.setCreated_date(dateFormat.format(date));
		String addmessage=profilesetting.addprofileinfo(profilesettinginfo);
        return new ResponseEntity<String>(addmessage,HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);	
		}
	}

	/**
	 * Update Profile Information
	 * @param profilesettinginfo
	 * @return Message
	 */
	@RequestMapping(value = "/updateprofileinfo", method=RequestMethod.POST)
	public ResponseEntity<?> updateprofileinfo(@RequestBody ProfileSetting profilesettinginfo){
		if(profilesettinginfo == null ||profilesettinginfo.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		
		boolean check=security.checkforupdateprofileinfo(profilesettinginfo);
		if(check==false){
		String updatemessage=profilesetting.updateprofileinfo(profilesettinginfo);
		return new ResponseEntity<String>(updatemessage,HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
		}


	}

	/**
	 * List All Profile Information of particular User
	 * @param email_id
	 * @return List of Information
	 */
	@RequestMapping(value = "/listprofileinfo", method=RequestMethod.GET)
	public ResponseEntity<?> listprofileinfo(@RequestParam(value="email_id") String email_id){
      if(email_id == null || email_id.equals("")){
			return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
		}
		
      List<UserInformation> resultexist=usersrv.listofuserbyemailid(email_id);
      
      if(resultexist.isEmpty()){
    	  return new ResponseEntity<String>("Email-Id Does Not Exist",HttpStatus.OK);
      }else{
      
          List<ProfileSetting>  listofinfo=profilesetting.listprofileinfo(email_id );
	     	if(listofinfo.isEmpty()){
			return new ResponseEntity<String>("In-Valid Email_Id Or Data Does Not Exist",HttpStatus.OK);
			
		}else{
			return new ResponseEntity<List<ProfileSetting>>(listofinfo,HttpStatus.OK);	
		}

      }
      
	}

}
