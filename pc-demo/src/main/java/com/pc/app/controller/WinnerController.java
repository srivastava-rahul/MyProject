package com.pc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.winner.Winner;
import com.pc.app.winner.WinnerService;


@RestController
@RequestMapping("/winner")
public class WinnerController {
	
	@Autowired
	WinnerService winnersrv;
   /**
	 * List  of All Winner of the day
	 * @return List All Winner of the day
	 */
	@RequestMapping(value = "/listwinner", method=RequestMethod.GET)
	public ResponseEntity<?> listwinner(){
		List<Winner>  listofwinner=winnersrv.listwinnerinfo();
		if(listofwinner == null || listofwinner.isEmpty()){
		return new ResponseEntity<String>("Winner Does Not Exist",HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Winner>>(listofwinner,HttpStatus.OK);
		}
		
		}
	
 /*==============================================for demo purpose delete it ==================================================================================*/

	/**
	 * Add   Winner of the day
	 * @return message of success and fail
	 */
	
	@RequestMapping(value = "/addwinner", method=RequestMethod.POST)
	public ResponseEntity<?> addWinner(@RequestBody Winner winuser){
		if(winuser == null || winuser.equals("")){
			return new ResponseEntity<String>("Invalid-Data",HttpStatus.OK);
		}
	        String addwinnersg=winnersrv.addwinner(winuser);
		    return new ResponseEntity<String>(addwinnersg,HttpStatus.OK);
		}
	
	}


