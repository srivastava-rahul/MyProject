package com.pc.app.winner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.winner.Winner;
import com.pc.app.service.winner.WinnerRepository;

@Service
public class WinnerServiceImpl implements WinnerService {

	@Autowired
	WinnerRepository winrepo;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Override
	public List<Winner> listwinnerinfo() {
		List<Winner>  winnerlist=winrepo.findAll();
		if(winnerlist==null ||winnerlist.isEmpty()){
			 return null;
		}else{
		     return winnerlist;
		}
	}
	
	/*==============Demo purpose only delete after use==================*/
	
	/**
	 * Add Winner of the day
	 * @param email_id
	 * @param name
	 * @param description
	 * @param  vote number
	 * @param list of email_id of voter people
	 * @param winner photo url
	 * @param Created Date
	 * @return Message
	 */
	@Override
	public String addwinner(Winner winuser) {
		if(winuser == null ||winuser.equals("") ){
			return "Invalid-Data";
		}
		Winner win=new Winner();
		
		win.setEmail_id(winuser.getEmail_id());
		win.setDescription(winuser.getDescription());
		win.setName(winuser.getName());
		win.setVote(winuser.getVote());
		win.setVoterinfo(winuser.getVoterinfo());
		win.setWinphotourl(winuser.getWinphotourl());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		win.setCreateddate(dateFormat.format(date));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  win.setTimestamp(timestamp.getTime());
	     Winner resultwinuser=winrepo.save(win);
		if(resultwinuser!=null){
			return "Success";
		}else{
			return "Fail";
		}
	}

	/**
	 * Delete Winner of the day
	 * return message  Success or fail
	 */
      public String deleteWinner(String email_id){
    	  if(email_id == null ||email_id.equals("")){
  			return "Invalid-Data";
  		}

    	  Winner idexist=winrepo.findOne(email_id);

  		if(idexist !=null){
  			try{
  				mongoTemplate.remove(new Query(Criteria.where("_id").is(email_id)),"Winner");
  				
  			}catch(Exception e){

  			}

  			return "Sucessfully Deleted the Account";
  		}
  		return "Email_Id Invalid Or Does Not Exist";

  		
      }

	
}
