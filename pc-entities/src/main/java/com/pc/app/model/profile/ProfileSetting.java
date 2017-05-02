package com.pc.app.model.profile;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Profile_Setting")
public class ProfileSetting {
	
	@Id
	private String email_id;
	private String profile_pic;
	/*--------Address---------*/
	private String country;
	private String city;

	/*--------Work--And--Education---------*/
	private String work;
	private String postGraduation;
	private String graduation;
	private String school_12;
	private String school_10;
	
	/*----------Personale--Information------------------------------------*/
	private String birthPlace;
	private String religious_Views;
	private String relationship;
	
	private String address;
	private Long paytm;
	private List<String> hobyy;
	private List<String> favouriteFood;
	
    /*----------Entertainment--------------------------------------------*/
	private List<String> favouritesinger;
	private List<String> favouritesmovies;
	private List<String> favouritedailysoap;
	
	/*----------Friend-List---------------------------------------------*/
	private List<String> friendList;
	private String created_date;
	
	
	public ProfileSetting(){
		
	}


	public ProfileSetting(String email_id, String profile_pic, String country, String city, String work,
			String postGraduation, String graduation, String school_12, String school_10, String birthPlace,
			String religious_Views, String relationship, String address, Long paytm, List<String> hobyy,
			List<String> favouriteFood, List<String> favouritesinger, List<String> favouritesmovies,
			List<String> favouritedailysoap, List<String> friendList, String created_date) {
		super();
		this.email_id = email_id;
		this.profile_pic = profile_pic;
		this.country = country;
		this.city = city;
		this.work = work;
		this.postGraduation = postGraduation;
		this.graduation = graduation;
		this.school_12 = school_12;
		this.school_10 = school_10;
		this.birthPlace = birthPlace;
		this.religious_Views = religious_Views;
		this.relationship = relationship;
		this.address = address;
		this.paytm = paytm;
		this.hobyy = hobyy;
		this.favouriteFood = favouriteFood;
		this.favouritesinger = favouritesinger;
		this.favouritesmovies = favouritesmovies;
		this.favouritedailysoap = favouritedailysoap;
		this.friendList = friendList;
		this.created_date = created_date;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getProfile_pic() {
		return profile_pic;
	}


	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}


	public String getPostGraduation() {
		return postGraduation;
	}


	public void setPostGraduation(String postGraduation) {
		this.postGraduation = postGraduation;
	}


	public String getGraduation() {
		return graduation;
	}


	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}


	public String getSchool_12() {
		return school_12;
	}


	public void setSchool_12(String school_12) {
		this.school_12 = school_12;
	}


	public String getSchool_10() {
		return school_10;
	}


	public void setSchool_10(String school_10) {
		this.school_10 = school_10;
	}


	public String getBirthPlace() {
		return birthPlace;
	}


	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}


	public String getReligious_Views() {
		return religious_Views;
	}


	public void setReligious_Views(String religious_Views) {
		this.religious_Views = religious_Views;
	}


	public String getRelationship() {
		return relationship;
	}


	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getPaytm() {
		return paytm;
	}


	public void setPaytm(Long paytm) {
		this.paytm = paytm;
	}


	public List<String> getHobyy() {
		return hobyy;
	}


	public void setHobyy(List<String> hobyy) {
		this.hobyy = hobyy;
	}


	public List<String> getFavouriteFood() {
		return favouriteFood;
	}


	public void setFavouriteFood(List<String> favouriteFood) {
		this.favouriteFood = favouriteFood;
	}


	public List<String> getFavouritesinger() {
		return favouritesinger;
	}


	public void setFavouritesinger(List<String> favouritesinger) {
		this.favouritesinger = favouritesinger;
	}


	public List<String> getFavouritesmovies() {
		return favouritesmovies;
	}


	public void setFavouritesmovies(List<String> favouritesmovies) {
		this.favouritesmovies = favouritesmovies;
	}


	public List<String> getFavouritedailysoap() {
		return favouritedailysoap;
	}


	public void setFavouritedailysoap(List<String> favouritedailysoap) {
		this.favouritedailysoap = favouritedailysoap;
	}


	public List<String> getFriendList() {
		return friendList;
	}


	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}


	public String getCreated_date() {
		return created_date;
	}


	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}


   
		
}
