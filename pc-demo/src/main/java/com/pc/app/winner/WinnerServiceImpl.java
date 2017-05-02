package com.pc.app.winner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.app.model.winner.Winner;
import com.pc.app.service.winner.WinnerRepository;

@Service
public class WinnerServiceImpl implements WinnerService {

	@Autowired
	WinnerRepository winrepo;
	
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
	     Winner resultwinuser=winrepo.save(win);
		if(resultwinuser!=null){
			return "Success";
		}else{
			return "Fail";
		}
	}

	
	
}
