package com.pc.app.security;

import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.competition.pics.PicsCompetition;
import com.pc.app.model.feedbackAndsuggestion.FeedbackAndSuggestions;
import com.pc.app.model.profile.ProfileSetting;
import com.pc.app.model.registration.UserInformation;
@RestController
public class SecurityController {


	/*------------------------------Checking whether the field does not contain hacking script- for User Registration Information-----------------------------------------------------------------------------------------------*/
	
	//for Add
	public boolean checkforadduser(UserInformation user){

		if(user.getFirstName().contains("?")||user.getFirstName().contains("*")||user.getFirstName().contains("<")||user.getFirstName().contains(">")
				||user.getFirstName().contains("<script>")||user.getFirstName().contains("</script>") ||user.getFirstName().contains("<Script>")||user.getFirstName().contains("</Script>")
				||user.getLastName().contains("?")||user.getLastName().contains("*")||user.getLastName().contains("<")||user.getLastName().contains(">")
				||user.getLastName().contains("<script>")||user.getLastName().contains("</script>")||user.getLastName().contains("<Script>")||user.getLastName().contains("</Script>")
				||user.getEmail_id().contains("?")||user.getEmail_id().contains("*")||user.getEmail_id().contains("<")||user.getEmail_id().contains(">")
				||user.getEmail_id().contains("<script>")||user.getEmail_id().contains("</script>")||user.getEmail_id().contains("<Script>")||user.getEmail_id().contains("</Script>")
				||user.getPassword().contains("<script>")){

			return true;
		}else{
			return false;
		}

	}

	//for Update
	public boolean checkforupdateuser(UserInformation user){

		if(user.getFirstName().contains("?")||user.getFirstName().contains("*")||user.getFirstName().contains("<")||user.getFirstName().contains(">")
				||user.getFirstName().contains("<script>")||user.getFirstName().contains("</script>") ||user.getFirstName().contains("<Script>")||user.getFirstName().contains("</Script>")
				||user.getLastName().contains("?")||user.getLastName().contains("*")||user.getLastName().contains("<")||user.getLastName().contains(">")
				||user.getLastName().contains("<script>")||user.getLastName().contains("</script>")||user.getLastName().contains("<Script>")||user.getLastName().contains("</Script>")
				||user.getEmail_id().contains("?")||user.getEmail_id().contains("*")||user.getEmail_id().contains("<")||user.getEmail_id().contains(">")
				||user.getEmail_id().contains("<script>")||user.getEmail_id().contains("</script>")||user.getEmail_id().contains("<Script>")||user.getEmail_id().contains("</Script>")
				||user.getPassword().contains("<script>")){

			return true;
		}else{
			return false;
		}

	}

	//for Delete
	public boolean checkfordeleteuser(String email_id){
		if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
				||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")){
			return true;
		}else{
			return false;
		}

	}

	//for Deactivate
	public boolean checkfordeactivateuser(String email_id,String status){
		if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
				||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
				||status.contains("?")||status.contains("*")||status.contains("<")||status.contains(">")
				||status.contains("<script>")||status.contains("</script>") ||status.contains("<Script>")||status.contains("</Script>")){
			return true;
		}else{
			return false;
		}

	}
	/*------------------------------Checking whether the field does not contain hacking script- For search Controller-----------------------------------------------------------------------------------------------*/	

	//for search option
	public boolean checkforsearchinfo(String item){

		if(item.contains("?")||item.contains("*")||item.contains("<")||item.contains(">")
				||item.contains("<script>")||item.contains("</script>") ||item.contains("<Script>")||item.contains("</Script>")
				){

			return true;
		}else{
			return false;
		}

	}

	/*------------------------------Checking whether the field does not contain hacking script- For Feedback Controller-----------------------------------------------------------------------------------------------*/	

	public boolean checkforFeedback(FeedbackAndSuggestions feedback){
		if(feedback.getEmail_id().contains("?")||feedback.getEmail_id().contains("*")||feedback.getEmail_id().contains("<")||feedback.getEmail_id().contains(">")
				||feedback.getEmail_id().contains("<script>")||feedback.getEmail_id().contains("</script>") ||feedback.getEmail_id().contains("<Script>")||feedback.getEmail_id().contains("</Script>")
				||feedback.getFeedback().contains("?")||feedback.getFeedback().contains("*")||feedback.getFeedback().contains("<")||feedback.getFeedback().contains(">")
				||feedback.getFeedback().contains("<script>")||feedback.getFeedback().contains("</script>") ||feedback.getFeedback().contains("<Script>")||feedback.getFeedback().contains("</Script>")){

			return true;
		}else{
			return false;
		}

	}

	/*------------------------------Checking whether the field does not contain hacking script- For Pic Upload Controller-----------------------------------------------------------------------------------------------*/
	
	//for Add pic upload
	public boolean checkforaddpicupload(PicsCompetition picupload){
		if(picupload.getEmail_id().contains("?")||picupload.getEmail_id().contains("*")||picupload.getEmail_id().contains("<")||picupload.getEmail_id().contains(">")
				||picupload.getEmail_id().contains("<script>")||picupload.getEmail_id().contains("</script>") ||picupload.getEmail_id().contains("<Script>")||picupload.getEmail_id().contains("</Script>")
				||picupload.getDescription().contains("?")||picupload.getDescription().contains("*")||picupload.getDescription().contains("<")||picupload.getDescription().contains(">")
				||picupload.getDescription().contains("<script>")||picupload.getDescription().contains("</script>") ||picupload.getDescription().contains("<Script>")||picupload.getDescription().contains("</Script>")
				||picupload.getIsActive().contains("?")||picupload.getIsActive().contains("*")||picupload.getIsActive().contains("<")||picupload.getIsActive().contains(">")
				||picupload.getIsActive().contains("<script>")||picupload.getIsActive().contains("</script>") ||picupload.getIsActive().contains("<Script>")||picupload.getIsActive().contains("</Script>")
				||picupload.getName().contains("?")||picupload.getName().contains("*")||picupload.getName().contains("<")||picupload.getName().contains(">")
				||picupload.getName().contains("<script>")||picupload.getName().contains("</script>") ||picupload.getName().contains("<Script>")||picupload.getName().contains("</Script>")
				||picupload.getPicsurl().contains("?")||picupload.getPicsurl().contains("*")||picupload.getPicsurl().contains("<")||picupload.getPicsurl().contains(">")
				||picupload.getPicsurl().contains("<script>")||picupload.getPicsurl().contains("</script>") ||picupload.getPicsurl().contains("<Script>")||picupload.getPicsurl().contains("</Script>")){

			return true;
		}else{
			return false;
		}

	}

    //for Vote to uploaded pic
	public boolean checkforvotecount(String pic_id,String email_id,String name){
		if(pic_id.contains("?")||pic_id.contains("*")||pic_id.contains("<")||pic_id.contains(">")
				||pic_id.contains("<script>")||pic_id.contains("</script>") ||pic_id.contains("<Script>")||pic_id.contains("</Script>")
				||email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
				||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
				||name.contains("?")||name.contains("*")||name.contains("<")||name.contains(">")
				||name.contains("<script>")||name.contains("</script>") ||name.contains("<Script>")||name.contains("</Script>")){
			return true;
		}else{
			return false;
		}

	}

	/*------------------------------Checking whether the field does not contain hacking script- For ProfileSetting Controller-----------------------------------------------------------------------------------------------*/

    //for Adding Profile Data
	public boolean checkforaddprofileinfo(ProfileSetting profilesettinginfo){
		if(profilesettinginfo.getAddress().contains("?")||profilesettinginfo.getAddress().contains("*")||profilesettinginfo.getAddress().contains("<")||profilesettinginfo.getAddress().contains(">")
				||profilesettinginfo.getAddress().contains("<script>")||profilesettinginfo.getAddress().contains("</script>") ||profilesettinginfo.getAddress().contains("<Script>")||profilesettinginfo.getAddress().contains("</Script>")

				||profilesettinginfo.getBirthPlace().contains("?")||profilesettinginfo.getBirthPlace().contains("*")||profilesettinginfo.getBirthPlace().contains("<")||profilesettinginfo.getBirthPlace().contains(">")
				||profilesettinginfo.getBirthPlace().contains("<script>")||profilesettinginfo.getBirthPlace().contains("</script>") ||profilesettinginfo.getBirthPlace().contains("<Script>")||profilesettinginfo.getBirthPlace().contains("</Script>")

				||profilesettinginfo.getCity().contains("?")||profilesettinginfo.getCity().contains("*")||profilesettinginfo.getCity().contains("<")||profilesettinginfo.getCity().contains(">")
				||profilesettinginfo.getCity().contains("<script>")||profilesettinginfo.getCity().contains("</script>") ||profilesettinginfo.getCity().contains("<Script>")||profilesettinginfo.getCity().contains("</Script>")

				||profilesettinginfo.getCountry().contains("?")||profilesettinginfo.getCountry().contains("*")||profilesettinginfo.getCountry().contains("<")||profilesettinginfo.getCountry().contains(">")
				||profilesettinginfo.getCountry().contains("<script>")||profilesettinginfo.getCountry().contains("</script>") ||profilesettinginfo.getCountry().contains("<Script>")||profilesettinginfo.getCountry().contains("</Script>")

				||profilesettinginfo.getEmail_id().contains("?")||profilesettinginfo.getEmail_id().contains("*")||profilesettinginfo.getEmail_id().contains("<")||profilesettinginfo.getEmail_id().contains(">")
				||profilesettinginfo.getEmail_id().contains("<script>")||profilesettinginfo.getEmail_id().contains("</script>") ||profilesettinginfo.getEmail_id().contains("<Script>")||profilesettinginfo.getEmail_id().contains("</Script>")

				||profilesettinginfo.getGraduation().contains("?")||profilesettinginfo.getGraduation().contains("*")||profilesettinginfo.getGraduation().contains("<")||profilesettinginfo.getGraduation().contains(">")
				||profilesettinginfo.getGraduation().contains("<script>")||profilesettinginfo.getGraduation().contains("</script>") ||profilesettinginfo.getGraduation().contains("<Script>")||profilesettinginfo.getGraduation().contains("</Script>")

				||profilesettinginfo.getPostGraduation().contains("?")||profilesettinginfo.getPostGraduation().contains("*")||profilesettinginfo.getPostGraduation().contains("<")||profilesettinginfo.getPostGraduation().contains(">")
				||profilesettinginfo.getPostGraduation().contains("<script>")||profilesettinginfo.getPostGraduation().contains("</script>") ||profilesettinginfo.getPostGraduation().contains("<Script>")||profilesettinginfo.getPostGraduation().contains("</Script>")

				||profilesettinginfo.getProfile_pic().contains("?")||profilesettinginfo.getProfile_pic().contains("*")||profilesettinginfo.getProfile_pic().contains("<")||profilesettinginfo.getProfile_pic().contains(">")
				||profilesettinginfo.getProfile_pic().contains("<script>")||profilesettinginfo.getProfile_pic().contains("</script>") ||profilesettinginfo.getProfile_pic().contains("<Script>")||profilesettinginfo.getProfile_pic().contains("</Script>")

				||profilesettinginfo.getRelationship().contains("?")||profilesettinginfo.getRelationship().contains("*")||profilesettinginfo.getRelationship().contains("<")||profilesettinginfo.getRelationship().contains(">")
				||profilesettinginfo.getRelationship().contains("<script>")||profilesettinginfo.getRelationship().contains("</script>") ||profilesettinginfo.getRelationship().contains("<Script>")||profilesettinginfo.getRelationship().contains("</Script>")

				||profilesettinginfo.getReligious_Views().contains("?")||profilesettinginfo.getReligious_Views().contains("*")||profilesettinginfo.getReligious_Views().contains("<")||profilesettinginfo.getReligious_Views().contains(">")
				||profilesettinginfo.getReligious_Views().contains("<script>")||profilesettinginfo.getReligious_Views().contains("</script>") ||profilesettinginfo.getReligious_Views().contains("<Script>")||profilesettinginfo.getReligious_Views().contains("</Script>")

				||profilesettinginfo.getSchool_10().contains("?")||profilesettinginfo.getSchool_10().contains("*")||profilesettinginfo.getSchool_10().contains("<")||profilesettinginfo.getSchool_10().contains(">")
				||profilesettinginfo.getSchool_10().contains("<script>")||profilesettinginfo.getSchool_10().contains("</script>") ||profilesettinginfo.getSchool_10().contains("<Script>")||profilesettinginfo.getSchool_10().contains("</Script>")

				||profilesettinginfo.getSchool_12().contains("?")||profilesettinginfo.getSchool_12().contains("*")||profilesettinginfo.getSchool_12().contains("<")||profilesettinginfo.getSchool_12().contains(">")
				||profilesettinginfo.getSchool_12().contains("<script>")||profilesettinginfo.getSchool_12().contains("</script>") ||profilesettinginfo.getSchool_12().contains("<Script>")||profilesettinginfo.getSchool_12().contains("</Script>")

				||profilesettinginfo.getWork().contains("?")||profilesettinginfo.getWork().contains("*")||profilesettinginfo.getWork().contains("<")||profilesettinginfo.getWork().contains(">")
				||profilesettinginfo.getWork().contains("<script>")||profilesettinginfo.getWork().contains("</script>") ||profilesettinginfo.getWork().contains("<Script>")||profilesettinginfo.getWork().contains("</Script>")){
			return true;
		}else{
			return false;
		}

	}


	  //for Updating Profile Data
	public boolean checkforupdateprofileinfo(ProfileSetting profilesettinginfo){
		if(profilesettinginfo.getAddress().contains("?")||profilesettinginfo.getAddress().contains("*")||profilesettinginfo.getAddress().contains("<")||profilesettinginfo.getAddress().contains(">")
				||profilesettinginfo.getAddress().contains("<script>")||profilesettinginfo.getAddress().contains("</script>") ||profilesettinginfo.getAddress().contains("<Script>")||profilesettinginfo.getAddress().contains("</Script>")

				||profilesettinginfo.getBirthPlace().contains("?")||profilesettinginfo.getBirthPlace().contains("*")||profilesettinginfo.getBirthPlace().contains("<")||profilesettinginfo.getBirthPlace().contains(">")
				||profilesettinginfo.getBirthPlace().contains("<script>")||profilesettinginfo.getBirthPlace().contains("</script>") ||profilesettinginfo.getBirthPlace().contains("<Script>")||profilesettinginfo.getBirthPlace().contains("</Script>")

				||profilesettinginfo.getCity().contains("?")||profilesettinginfo.getCity().contains("*")||profilesettinginfo.getCity().contains("<")||profilesettinginfo.getCity().contains(">")
				||profilesettinginfo.getCity().contains("<script>")||profilesettinginfo.getCity().contains("</script>") ||profilesettinginfo.getCity().contains("<Script>")||profilesettinginfo.getCity().contains("</Script>")

				||profilesettinginfo.getCountry().contains("?")||profilesettinginfo.getCountry().contains("*")||profilesettinginfo.getCountry().contains("<")||profilesettinginfo.getCountry().contains(">")
				||profilesettinginfo.getCountry().contains("<script>")||profilesettinginfo.getCountry().contains("</script>") ||profilesettinginfo.getCountry().contains("<Script>")||profilesettinginfo.getCountry().contains("</Script>")

				||profilesettinginfo.getEmail_id().contains("?")||profilesettinginfo.getEmail_id().contains("*")||profilesettinginfo.getEmail_id().contains("<")||profilesettinginfo.getEmail_id().contains(">")
				||profilesettinginfo.getEmail_id().contains("<script>")||profilesettinginfo.getEmail_id().contains("</script>") ||profilesettinginfo.getEmail_id().contains("<Script>")||profilesettinginfo.getEmail_id().contains("</Script>")

				||profilesettinginfo.getGraduation().contains("?")||profilesettinginfo.getGraduation().contains("*")||profilesettinginfo.getGraduation().contains("<")||profilesettinginfo.getGraduation().contains(">")
				||profilesettinginfo.getGraduation().contains("<script>")||profilesettinginfo.getGraduation().contains("</script>") ||profilesettinginfo.getGraduation().contains("<Script>")||profilesettinginfo.getGraduation().contains("</Script>")

				||profilesettinginfo.getPostGraduation().contains("?")||profilesettinginfo.getPostGraduation().contains("*")||profilesettinginfo.getPostGraduation().contains("<")||profilesettinginfo.getPostGraduation().contains(">")
				||profilesettinginfo.getPostGraduation().contains("<script>")||profilesettinginfo.getPostGraduation().contains("</script>") ||profilesettinginfo.getPostGraduation().contains("<Script>")||profilesettinginfo.getPostGraduation().contains("</Script>")

				||profilesettinginfo.getProfile_pic().contains("?")||profilesettinginfo.getProfile_pic().contains("*")||profilesettinginfo.getProfile_pic().contains("<")||profilesettinginfo.getProfile_pic().contains(">")
				||profilesettinginfo.getProfile_pic().contains("<script>")||profilesettinginfo.getProfile_pic().contains("</script>") ||profilesettinginfo.getProfile_pic().contains("<Script>")||profilesettinginfo.getProfile_pic().contains("</Script>")

				||profilesettinginfo.getRelationship().contains("?")||profilesettinginfo.getRelationship().contains("*")||profilesettinginfo.getRelationship().contains("<")||profilesettinginfo.getRelationship().contains(">")
				||profilesettinginfo.getRelationship().contains("<script>")||profilesettinginfo.getRelationship().contains("</script>") ||profilesettinginfo.getRelationship().contains("<Script>")||profilesettinginfo.getRelationship().contains("</Script>")

				||profilesettinginfo.getReligious_Views().contains("?")||profilesettinginfo.getReligious_Views().contains("*")||profilesettinginfo.getReligious_Views().contains("<")||profilesettinginfo.getReligious_Views().contains(">")
				||profilesettinginfo.getReligious_Views().contains("<script>")||profilesettinginfo.getReligious_Views().contains("</script>") ||profilesettinginfo.getReligious_Views().contains("<Script>")||profilesettinginfo.getReligious_Views().contains("</Script>")

				||profilesettinginfo.getSchool_10().contains("?")||profilesettinginfo.getSchool_10().contains("*")||profilesettinginfo.getSchool_10().contains("<")||profilesettinginfo.getSchool_10().contains(">")
				||profilesettinginfo.getSchool_10().contains("<script>")||profilesettinginfo.getSchool_10().contains("</script>") ||profilesettinginfo.getSchool_10().contains("<Script>")||profilesettinginfo.getSchool_10().contains("</Script>")

				||profilesettinginfo.getSchool_12().contains("?")||profilesettinginfo.getSchool_12().contains("*")||profilesettinginfo.getSchool_12().contains("<")||profilesettinginfo.getSchool_12().contains(">")
				||profilesettinginfo.getSchool_12().contains("<script>")||profilesettinginfo.getSchool_12().contains("</script>") ||profilesettinginfo.getSchool_12().contains("<Script>")||profilesettinginfo.getSchool_12().contains("</Script>")

				||profilesettinginfo.getWork().contains("?")||profilesettinginfo.getWork().contains("*")||profilesettinginfo.getWork().contains("<")||profilesettinginfo.getWork().contains(">")
				||profilesettinginfo.getWork().contains("<script>")||profilesettinginfo.getWork().contains("</script>") ||profilesettinginfo.getWork().contains("<Script>")||profilesettinginfo.getWork().contains("</Script>")){
			return true;
		}else{
			return false;
		}

	}








}






