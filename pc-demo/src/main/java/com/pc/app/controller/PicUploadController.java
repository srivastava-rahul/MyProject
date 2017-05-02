package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.competition.pics.PicsCompetition;
import com.pc.app.pic.competiton.PicUploadService;
import com.pc.app.security.SecurityController;


@RestController
@RequestMapping("/picupload")
public class PicUploadController {

	@Autowired
	PicUploadService picuploadsrv;
	
	@Autowired
	SecurityController security;
	/**
	 *Uploading a pics for competition 
	 * return message  Success or fail
	 */
	@RequestMapping(value = "/addpicupload", method=RequestMethod.POST)
	public ResponseEntity<?> addpicupload(@RequestBody PicsCompetition picupload){
		if(picupload == null || picupload.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		boolean check=security.checkforaddpicupload(picupload);
		if(check==false){
        String uploadpicresult=picuploadsrv.uploadpic(picupload);
		return new ResponseEntity<String>(uploadpicresult,HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);	
		}
	}

	/**
	 *Getting uploaded pics 
	 * return list of uploaded pics
	 */
	@RequestMapping(value = "/listpicupload", method=RequestMethod.GET)
	public ResponseEntity<?> listpicupload(){
		List<PicsCompetition>  resultofrules=picuploadsrv.listofpicupload();
		if(resultofrules == null || resultofrules.isEmpty()){
		return new ResponseEntity<String>("Rules List Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<PicsCompetition>>(resultofrules,HttpStatus.OK);
		}
	}
	
	/**
	 * Vote count to increase
	 * return count of vote
	 */
	@RequestMapping(value = "/votecount", method=RequestMethod.POST)
	public ResponseEntity<?> votecount(@RequestParam ("pic_id")String pic_id,@RequestParam ("email_id")String email_id,
			@RequestParam ("name")String name){
		if(pic_id == null || pic_id.equals("")||
		   email_id == null || email_id.equals("")||
				   name == null ||name.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
		boolean check=security.checkforvotecount(pic_id, email_id, name);
		if(check==false){
		List<PicsCompetition> voteresult=picuploadsrv.forvoteincrement(pic_id,email_id, name);
		return new ResponseEntity<List<PicsCompetition>>(voteresult,HttpStatus.OK);
		}else{
			return null;	
		}
	}
	
	
}

