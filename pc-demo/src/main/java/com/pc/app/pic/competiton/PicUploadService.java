package com.pc.app.pic.competiton;

import java.util.List;

import com.pc.app.model.competition.pics.PicsCompetition;

public interface PicUploadService {

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
	public String uploadpic(PicsCompetition picupload);
	
	
	/**
	 * get uploaded pic
	 * @param
	 * @return List of uploaded pics
	 */
	public List<PicsCompetition> listofpicupload();
	
	/**
	 * increase the vote on the basis of pic_id
	 * @param whole object of PicsCompetition containing  pic_id votecount voterinfo
	 * @return Message Success or fail
	 */
	public List<PicsCompetition>forvoteincrement(String pic_id,String email_id,String name);
}
