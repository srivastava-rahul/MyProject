package com.pc.app.model.rules;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Rules")
public class Rules {
	
	@Id
	private String email_id;
	private String role;
	private List<String> prize;
	private List<String> termsAndCondition;
	private String created_date;
	
	public Rules(){}

	public Rules(String email_id, String role, List<String> prize, List<String> termsAndCondition,
			String created_date) {
		super();
		this.email_id = email_id;
		this.role = role;
		this.prize = prize;
		this.termsAndCondition = termsAndCondition;
		this.created_date = created_date;
	}

    public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public List<String> getPrize() {
		return prize;
	}

	public void setPrize(List<String> prize) {
		this.prize = prize;
	}

	public List<String> getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(List<String> termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}
	
	
}
