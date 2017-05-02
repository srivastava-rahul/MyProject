package com.pc.app.model.winner;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Winner")
public class Winner {

	private String email_id; //This will remain hidden only name have to be seen
	private String name;
	private String winphotourl;
	private Integer vote;
	private String description;
	private HashMap<String,String> voterinfo;  // HashMap contain <email_id,name> of voter and email_id not ne duplicate
    

	private String createddate;
    private long timestamp;
	public Winner(){}

	

	public Winner(String email_id, String name, String winphotourl, Integer vote, String description,
			HashMap<String, String> voterinfo, String createddate, long timestamp) {
		super();
		this.email_id = email_id;
		this.name = name;
		this.winphotourl = winphotourl;
		this.vote = vote;
		this.description = description;
		this.voterinfo = voterinfo;
		this.createddate = createddate;
		this.timestamp = timestamp;
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
	public String getWinphotourl() {
		return winphotourl;
	}
	public void setWinphotourl(String winphotourl) {
		this.winphotourl = winphotourl;
	}
	public Integer getVote() {
		return vote;
	}
	public void setVote(Integer vote) {
		this.vote = vote;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public HashMap<String, String> getVoterinfo() {
		return voterinfo;
	}

	public void setVoterinfo(HashMap<String, String> voterinfo) {
		this.voterinfo = voterinfo;
	}



	public long getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


}
