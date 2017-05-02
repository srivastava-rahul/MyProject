package com.pc.app.vote;

import java.util.HashMap;

public class Vote {

	private long votecount=0;
	private HashMap<String,String> voterinfo;  //HashMap contain <email_id,name> it do not store duplicate email_id

	public Vote(){}

    public Vote(long votecount, HashMap<String, String> voterinfo) {
		super();
		this.votecount = votecount;
		this.voterinfo = voterinfo;
	}

   public long getVotecount() {
		return votecount;
	}

	public void setVotecount(long votecount) {
		this.votecount = votecount;
	}

    public HashMap<String, String> getVoterinfo() {
		return voterinfo;
	}

    public void setVoterinfo(HashMap<String, String> voterinfo) {
		this.voterinfo = voterinfo;
	}


}
