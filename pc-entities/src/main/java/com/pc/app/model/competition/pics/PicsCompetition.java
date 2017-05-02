package com.pc.app.model.competition.pics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pc.app.vote.Vote;

@Document(collection="Pic_Upload")
public class PicsCompetition {
    @Id
    private String _id;
	private String email_id;
	private String name;
	private String picsurl;
	private Vote vote;
	private String description;
	private String isActive="Active";
	private String createdate;
	private long timestamp;

	public PicsCompetition(){

	}

     public PicsCompetition(String _id, String email_id, String name, String picsurl, Vote vote, String description,
			String isActive, String createdate, long timestamp) {
		super();
		this._id = _id;
		this.email_id = email_id;
		this.name = name;
		this.picsurl = picsurl;
		this.vote = vote;
		this.description = description;
		this.isActive = isActive;
		this.createdate = createdate;
		this.timestamp = timestamp;
	}






	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public String getPicsurl() {
		return picsurl;
	}

	public void setPicsurl(String picsurl) {
		this.picsurl = picsurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}






	public long getTimestamp() {
		return timestamp;
	}






	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}



	
	
}
