package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.registration.UserInformation;
import com.pc.app.security.SecurityController;
import com.pc.app.service.searchuser.SearchUserInfoService;

@RestController
@RequestMapping("/searchuser")
public class SearchUserInfoController {

	@Autowired
	SearchUserInfoService searchsrv;

	@Autowired
	SecurityController check;

	/**
	 * Search User
	 * @param userinfo
	 * @return Message
	 */
	@RequestMapping(value = "/search")
	public ResponseEntity<?> adduser(@RequestParam (value="item")String item,@RequestParam (value="type") String type){
		if(item == null ||item.equals("") && type == null ||type.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		boolean checkresult=check.checkforsearchinfo(item);
		if(checkresult==false){
		List<UserInformation> result = null;
		if(type.equals("Email")){
			result=searchsrv.listofuserbyemail(item);
		}else if(type.equals("Phone")){
			long phone=Long.parseLong(item);
			result=searchsrv.listofuserbyphone(phone);
		}else if(type.equals("Name")){
			result=searchsrv.listofuserbyname(item);
		}

		if(result == null || result.isEmpty()){
			return new ResponseEntity<String>("User Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<UserInformation>>(result,HttpStatus.OK);
		}
		
	  }else{
		  return new ResponseEntity<String>("In-valid Data to be search",HttpStatus.OK);
	  }
	}
}
