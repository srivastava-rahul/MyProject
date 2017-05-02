package com.pc.app.pic.competiton;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.pc.app.model.competition.pics.PicsCompetition;
import com.pc.app.service.competition.pics.PicsCompetitionRepository;

@Service
public class PicUploadServiceImpl implements PicUploadService {

	@Autowired
	PicsCompetitionRepository picuploadrepo;

	@Autowired
    private MongoTemplate mongoTemplate;
	
	/**
	 * Upload Pic for competiton
	 * @param email_id
	 * @param name
	 * @param picurl
	 * @param vote
	 * @param description
	 * @param isActive
	 * @param created date
	 * @return Message Success or fail
	 */
	@Override
	public String uploadpic(PicsCompetition picupload) {
		PicsCompetition picinfo=new PicsCompetition();
		
		 picinfo.setEmail_id(picupload.getEmail_id());
		 picinfo.setName(picupload.getName());
		 Date date = new Date();
		 picinfo.setPicsurl(picupload.getEmail_id()+"~"+date.getTime());
		 picinfo.setVote(picupload.getVote());
		 picinfo.setDescription(picupload.getDescription());
		 picinfo.setIsActive(picupload.getIsActive());
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 picinfo.setCreatedate(dateFormat.format(date));
		 
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 picinfo.setTimestamp(timestamp.getTime());;
		 PicsCompetition resultpicupload=picuploadrepo.save(picinfo);
			if(resultpicupload!=null){
				return "Success";
			}else{
				return "Fail";
			}
     	
	}
	
	/**
	 * get uploaded pic
	 * @param
	 * @return List of uploaded pics
	 */
	public List<PicsCompetition> listofpicupload(){
		return picuploadrepo.findAll();
	}
	
	/**
	 * increase the vote on the basis of pic_id
	 * @param whole object of PicsCompetition containing  pic_id votecount voterinfo
	 * @return Message Success or fail
	 */
	public List<PicsCompetition> forvoteincrement(String pic_id,String email_id,String name){
		
		PicsCompetition pic=picuploadrepo.findOne(pic_id);
		 long votecount=pic.getVote().getVotecount()+1;
		 HashMap<String,String> t=new HashMap<>();
		 t.put(email_id, name);
		 //List<HashMap<String, String>> list=new  ArrayList<HashMap<String,String>>();
		 
		/* Vote v=new Vote();
		 v.setVotecount(votecount);
		 v.setVoterinfo(t);
		 pic.setVote(v);
		 picuploadrepo.save(pic);*/
		 
		 mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(pic_id)),new Update().set("Vote.$.votecount", votecount).set("Vote.$.voterinfo",t),PicsCompetition.class);
		 
		return picuploadrepo.findAll();
		 
	
		
	}
}
