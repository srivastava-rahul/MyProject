package com.pc.app.service.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pc.app.model.profile.ProfileSetting;
import com.pc.app.model.registration.UserInformation;
import com.pc.app.service.registration.UserInformationRepository;



@Service
public class ProfileSettingServiceImpl implements ProfileSettingService {
	
	@Autowired
	UserInformationRepository  userrepo;
	
      @Autowired
      ProfileSettingRepository profilesettingrepo;
      
  	@Autowired
    private MongoTemplate mongoTemplate;

	
    /* Add Profile Information
     * @see com.pc.app.service.profile.settinginfo.ProfileSettingService#addprofileinfo(com.pc.app.pojo.ProfileSetting)
     * @return Message
     */
    public String addprofileinfo(ProfileSetting userprofileinfo) {
    	if(userprofileinfo == null || userprofileinfo.equals("")){
			return "Invalid-Data";
		}
    	
    	UserInformation existinguser=userrepo.findbyid(userprofileinfo.getEmail_id());
    	if(existinguser!=null){
    		List<ProfileSetting> emailexist=mongoTemplate.find(new Query(Criteria.where("_id").is(userprofileinfo.getEmail_id())),ProfileSetting.class);
        	if(emailexist.isEmpty()){
        	                      ProfileSetting addprofileinfo=profilesettingrepo.save(userprofileinfo);
        	if(addprofileinfo!=null){
        	                         return "SuccessFully Added the Profile Information";
        	                        }else{
        	                            	 return "Invalid Data";
        	                             }
        	}else{
        		return "Already Data Exist";   
        	}
    	}
    	
    		return "Invalid-Data Or Invalid Email_ID";   
    	
    }
	
	/*  Update Profile Information
	 * @see com.pc.app.service.profile.settinginfo.ProfileSettingService#updateprofileinfo(com.pc.app.pojo.ProfileSetting)
	 * @return Message
	 */
	public String updateprofileinfo( ProfileSetting  userprofileinfo) {
		if(userprofileinfo == null || userprofileinfo.equals("")){
			return "Invalid-Data ";
		}
		
		ProfileSetting existingprofile=profilesettingrepo.findOne(userprofileinfo.getEmail_id());
		
		if(existingprofile!=null){
			ProfileSetting updateprofileinfo=new ProfileSetting();
			
	     /*-----------------------------------Address----------------------------------------------*/
			 if(existingprofile.getCity()!=userprofileinfo.getCity()|| existingprofile.getCity()==null || existingprofile.getCity().equals("")){
				  updateprofileinfo.setCity(userprofileinfo.getCity());
			    }
			  if(existingprofile.getCountry()!=userprofileinfo.getCountry() || existingprofile.getCountry()==null ||existingprofile.getCountry().equals("")){
				  updateprofileinfo.setCountry(userprofileinfo.getCountry());
			    }
			  
       /*---------------------------------Work--And--Education------------------------------------*/
			  if(existingprofile.getWork()!=userprofileinfo.getWork()|| existingprofile.getWork()==null ||existingprofile.getWork().equals("")){
				  updateprofileinfo.setWork(userprofileinfo.getWork());
			    }
			  if(existingprofile.getPostGraduation()!=userprofileinfo.getPostGraduation()|| existingprofile.getPostGraduation()==null||existingprofile.getPostGraduation().equals("")){
				  updateprofileinfo.setPostGraduation(userprofileinfo.getPostGraduation());
			    }
			  if(existingprofile.getGraduation()!=userprofileinfo.getGraduation()||existingprofile.getGraduation()==null||existingprofile.getGraduation().equals("")){
				  updateprofileinfo.setGraduation(userprofileinfo.getGraduation());
			    }
			  
			  if(existingprofile.getSchool_10()!=userprofileinfo.getSchool_10()||existingprofile.getSchool_10()==null ||existingprofile.getSchool_10().equals("")){
				  updateprofileinfo.setSchool_10(userprofileinfo.getSchool_10());
			    }
			  if(existingprofile.getSchool_12()!=userprofileinfo.getSchool_12()||existingprofile.getSchool_12()==null||existingprofile.getSchool_12().equals("")){
				  updateprofileinfo.setSchool_12(userprofileinfo.getSchool_12());
			    }
			  
	   /*-----------------------------------Personale--Information------------------------------------*/  
			  
			  
			  if(existingprofile.getBirthPlace()!=userprofileinfo.getBirthPlace()||existingprofile.getBirthPlace()==null||existingprofile.getBirthPlace().equals("")){
				  updateprofileinfo.setBirthPlace(userprofileinfo.getBirthPlace());
			    }
			  if(existingprofile.getReligious_Views()!=userprofileinfo.getReligious_Views()||existingprofile.getReligious_Views()==null||existingprofile.getReligious_Views().equals("")){
				  updateprofileinfo.setReligious_Views(userprofileinfo.getReligious_Views());
			    }
			  if(existingprofile.getRelationship()!=userprofileinfo.getRelationship()||existingprofile.getRelationship()==null||existingprofile.getRelationship().equals("")){
				  updateprofileinfo.setRelationship(userprofileinfo.getRelationship());
			    }
			  if(!userprofileinfo.getHobyy().isEmpty() && userprofileinfo.getHobyy().size()>0){
				  updateprofileinfo.setHobyy(userprofileinfo.getHobyy());
			    }
			  if(!userprofileinfo.getFavouriteFood().isEmpty() && userprofileinfo.getFavouriteFood().size()>0){
				  updateprofileinfo.setFavouritedailysoap(userprofileinfo.getFavouriteFood());
			    }
			  
	 /*-----------------------------------------Entertainment---------------------------------------------------*/ 
			 
			  if(!userprofileinfo.getFavouritesinger().isEmpty() && userprofileinfo.getFavouritesinger().size()>0){
				  updateprofileinfo.setFavouritesinger(userprofileinfo.getFavouritesinger());
			    }
			  if(!userprofileinfo.getFavouritesmovies().isEmpty() && userprofileinfo.getFavouritesmovies().size()>0){
				  updateprofileinfo.setFavouritesmovies(userprofileinfo.getFavouritesmovies());
			    }
			  if(!userprofileinfo.getFavouritedailysoap().isEmpty() && userprofileinfo.getFavouritedailysoap().size()>0 ){
				  updateprofileinfo.setFavouritedailysoap(userprofileinfo.getFavouritedailysoap());
			    }
			  
			  
			 
			
		}
		
		
		ProfileSetting updateProfileinfo=profilesettingrepo.save(userprofileinfo);
    	if(updateProfileinfo == null || updateProfileinfo.equals("")){
    		           return "Invalid-Data Or Invalid Email_ID";
    	}else{
     	           return "SuccessFully Updated the Profile Information";
    	}
		
	}
	
	/* List All Profile Information of particular User
	 * @see com.pc.app.service.profile.settinginfo.ProfileSettingService#listprofileinfo(java.lang.String)
	 * @return List of Information
	 */
	public  List<ProfileSetting> listprofileinfo(String email_id) {
		if(email_id == null || email_id.equals("")){
		 return null;	
		}
		
		List<ProfileSetting> listofprofileinfo=mongoTemplate.find(new Query(Criteria.where("_id").is(email_id)),ProfileSetting.class);
			return listofprofileinfo ;
		
			
	}

}
