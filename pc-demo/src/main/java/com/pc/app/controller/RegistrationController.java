package com.pc.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.registration.UserInformation;
import com.pc.app.security.SecurityController;
import com.pc.app.service.registration.UserRegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	
	@Autowired
	UserRegistrationService userregistration;
	
	@Autowired
	SecurityController security;
	
	/**
	 * Add User
	 * @param userinfo
	 * @return Message
	 */
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public ResponseEntity<?> adduser(@RequestBody UserInformation userinfo){
		if(userinfo == null ||userinfo.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		boolean b=security.checkforadduser(userinfo);
		Map<String,String> m=new LinkedHashMap<String,String>();
		if(b== false){
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			userinfo.setCreated_date(dateFormat.format(date));
			String  result=userregistration.adduser(userinfo);
			m.put("message",  result);
			return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
		}else{
			
			m.put("message",  "Your data Contain some invalid characters Please check data And Try Again..!");
			return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
		}
	}
	
	/**
	 * Update User
	 * @param userinfo
	 * @return Message
	 */
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public ResponseEntity<?> updateuser(@RequestBody UserInformation userinfo){
		if(userinfo == null ||userinfo.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		
		boolean b=security.checkforupdateuser(userinfo);
		if(b== false){
			String  result=userregistration.updateuser(userinfo);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}else{
			String msg="Your data Contain some invalid characters "
					    + "Please check data And Try Again..!";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
	}
	
	/**
	 * Delete User
	 * @param email_id
	 * @return Message
	 */
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public ResponseEntity<?> deleteuser(@RequestParam (value="email") String email_id){
		if(email_id == null ||email_id.equals("")){
			return new ResponseEntity<String>("Invalid-Email_ID",HttpStatus.OK);
		}
		boolean check=security.checkfordeleteuser(email_id);
		if(check==false){
		 String result=userregistration.deleteuser(email_id);
		return new ResponseEntity<String>(result,HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
		}
		
		}
	
	/**
	 * List of User
	 * @return List of User
	 */
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ResponseEntity<?> listofuser(){
		List<UserInformation>  result=userregistration.listofuser();
		if(result == null || result.isEmpty()){
		return new ResponseEntity<String>("User List Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<UserInformation>>(result,HttpStatus.OK);
		}
		
	}
	
	
	
	/**
	 * Deactivate the Account of User
	 * @param email_id
	 * @param status
	 * @return Message
	 */
	@RequestMapping(value = "/deactivate", method=RequestMethod.GET)
	public ResponseEntity<?> deactivateuser(@RequestParam (value="email") String email_id ,@RequestParam (value="status") String status){
		if(email_id == null ||email_id.equals("") || status==null || status.equals("")){
			return new ResponseEntity<String>("Invalid-Email_ID",HttpStatus.OK);
		}
		boolean check=security.checkfordeactivateuser(email_id, status);
		if(check==false){
		String  result=userregistration.deactivateuser(email_id,status);
		return new ResponseEntity<String>(result,HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);	
		}
		
		}

}
