package com.pc.app.security;

import org.springframework.web.bind.annotation.RestController;

import com.pc.app.model.aboutus.AboutUs;
import com.pc.app.model.contactus.ContactUs;
import com.pc.app.model.notification.Notification;
import com.pc.app.model.rules.Rules;
import com.pc.app.model.testimonial.Testimonial;
@RestController
public class SecurityController {
	
	
/*------------------------------Checking whether the field does not contain hacking script------------------------------------------------------------------------------------------------*/
	/*public boolean checkforSignupform(UserInformation user){

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
	 		
	 	}*/
	
/*------------------------------Checking whether the field does not contain hacking script--For Search Controller----------------------------------------------------------------------------------------------*/
       //Search
       public boolean checkforsearchinfo(String item){
       if(item.contains("?")||item.contains("*")||item.contains("<")||item.contains(">")
				||item.contains("<script>")||item.contains("</script>") ||item.contains("<Script>")||item.contains("</Script>")
				){

			return true;
		}else{
			return false;
		}
		
	}
       
/*------------------------------Checking whether the field does not contain hacking script for About Us Controller------------------------------------------------------------------------------------------------*/     
       
       //for Add
       public boolean checkforaddaboutus(AboutUs about){
           if(about.getEmail_id().contains("?")||about.getEmail_id().contains("*")||about.getEmail_id().contains("<")||about.getEmail_id().contains(">")
    		||about.getEmail_id().contains("<script>")||about.getEmail_id().contains("</script>") ||about.getEmail_id().contains("<Script>")||about.getEmail_id().contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
       
     //for Delete
       public boolean checkfordeleteaboutus(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
       
 /*------------------------------Checking whether the field does not contain hacking script for Contact Us Controller------------------------------------------------------------------------------------------------*/
       
       //for Add
       public boolean checkforaddcontactus(ContactUs contactus){
           if(contactus.getEmail_id().contains("?")||contactus.getEmail_id().contains("*")||contactus.getEmail_id().contains("<")||contactus.getEmail_id().contains(">")
    		||contactus.getEmail_id().contains("<script>")||contactus.getEmail_id().contains("</script>") ||contactus.getEmail_id().contains("<Script>")||contactus.getEmail_id().contains("</Script>")
    		||contactus.getName().contains("?")||contactus.getName().contains("*")||contactus.getName().contains("<")||contactus.getName().contains(">")
    		||contactus.getName().contains("<script>")||contactus.getName().contains("</script>") ||contactus.getName().contains("<Script>")||contactus.getName().contains("</Script>")){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
       
     //for Delete
       public boolean checkfordeletecontactus(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	}   
 /*------------------------------Checking whether the field does not contain hacking script for Testimonial Controller------------------------------------------------------------------------------------------------*/      
       //for Add
       public boolean checkforaddtestimonial(Testimonial testimonial){
           if(testimonial.getEmail_id().contains("?")||testimonial.getEmail_id().contains("*")||testimonial.getEmail_id().contains("<")||testimonial.getEmail_id().contains(">")
    		||testimonial.getEmail_id().contains("<script>")||testimonial.getEmail_id().contains("</script>") ||testimonial.getEmail_id().contains("<Script>")||testimonial.getEmail_id().contains("</Script>")
    		||testimonial.getGoodfeedbackmsg().contains("?")||testimonial.getGoodfeedbackmsg().contains("*")||testimonial.getGoodfeedbackmsg().contains("<")||testimonial.getGoodfeedbackmsg().contains(">")
    		||testimonial.getGoodfeedbackmsg().contains("<script>")||testimonial.getGoodfeedbackmsg().contains("</script>") ||testimonial.getGoodfeedbackmsg().contains("<Script>")||testimonial.getGoodfeedbackmsg().contains("</Script>")
    		||testimonial.getName().contains("?")||testimonial.getName().contains("*")||testimonial.getName().contains("<")||testimonial.getName().contains(">")
    		||testimonial.getName().contains("<script>")||testimonial.getName().contains("</script>") ||testimonial.getName().contains("<Script>")||testimonial.getName().contains("</Script>")
    		||testimonial.getProfile_pic().contains("?")||testimonial.getProfile_pic().contains("*")||testimonial.getProfile_pic().contains("<")||testimonial.getProfile_pic().contains(">")
    		||testimonial.getProfile_pic().contains("<script>")||testimonial.getProfile_pic().contains("</script>") ||testimonial.getProfile_pic().contains("<Script>")||testimonial.getProfile_pic().contains("</Script>")){
              return true;
    		}else{
    			return false;
    		}
    		
    	}
       
     //for Delete
       public boolean checkfordeletetestimonial(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	}  
/*------------------------------Checking whether the field does not contain hacking script for Feedback Controller------------------------------------------------------------------------------------------------*/       
      
     //for Delete
       public boolean checkfordeletefeedbackinfo(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
       
/*------------------------------Checking whether the field does not contain hacking script Rules  Controller------------------------------------------------------------------------------------------------*/
       
       //for Add
       public boolean checkforaddrules(Rules rulesterms){
           if(rulesterms.getEmail_id().contains("?")||rulesterms.getEmail_id().contains("*")||rulesterms.getEmail_id().contains("<")||rulesterms.getEmail_id().contains(">")
    		||rulesterms.getEmail_id().contains("<script>")||rulesterms.getEmail_id().contains("</script>") ||rulesterms.getEmail_id().contains("<Script>")||rulesterms.getEmail_id().contains("</Script>")
    		
    		||rulesterms.getRole().contains("?")||rulesterms.getRole().contains("*")||rulesterms.getRole().contains("<")||rulesterms.getRole().contains(">")
    		||rulesterms.getRole().contains("<script>")||rulesterms.getRole().contains("</script>") ||rulesterms.getRole().contains("<Script>")||rulesterms.getRole().contains("</Script>")
    		
    		||rulesterms.getPrize().contains("?")||rulesterms.getPrize().contains("*")||rulesterms.getPrize().contains("<")||rulesterms.getPrize().contains(">")
    		||rulesterms.getPrize().contains("<script>")||rulesterms.getPrize().contains("</script>") ||rulesterms.getPrize().contains("<Script>")||rulesterms.getPrize().contains("</Script>")
    		
    		||rulesterms.getTermsAndCondition().contains("?")||rulesterms.getTermsAndCondition().contains("*")||rulesterms.getTermsAndCondition().contains("<")||rulesterms.getTermsAndCondition().contains(">")
    		||rulesterms.getTermsAndCondition().contains("<script>")||rulesterms.getTermsAndCondition().contains("</script>") ||rulesterms.getTermsAndCondition().contains("<Script>")||rulesterms.getTermsAndCondition().contains("</Script>")){
              return true;
    		}else{
    			return false;
    		}
    		
    	}
       
     //for Delete
       public boolean checkfordeleterules(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
/*------------------------------Checking whether the field does not contain hacking script Notification  Controller------------------------------------------------------------------------------------------------*/       
       
     //for Add
       public boolean checkforaddnotification(Notification notification){
           if(notification.getEmail_id().contains("?")||notification.getEmail_id().contains("*")||notification.getEmail_id().contains("<")||notification.getEmail_id().contains(">")
    		||notification.getEmail_id().contains("<script>")||notification.getEmail_id().contains("</script>") ||notification.getEmail_id().contains("<Script>")||notification.getEmail_id().contains("</Script>")
    	    ||notification.getNotificationMsg().contains("?")||notification.getNotificationMsg().contains("*")||notification.getNotificationMsg().contains("<")||notification.getNotificationMsg().contains(">")
    		||notification.getNotificationMsg().contains("<script>")||notification.getNotificationMsg().contains("</script>") ||notification.getNotificationMsg().contains("<Script>")||notification.getNotificationMsg().contains("</Script>")){
              return true;
    		}else{
    			return false;
    		}
    		
    	}
       
     //for Delete
       public boolean checkfordeletenotification(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
       
       
/*------------------------------Checking whether the field does not contain hacking script Winner Controller------------------------------------------------------------------------------------------------*/
     
     //for Delete
       public boolean checkfordeleteWinner(String email_id){
    	   if(email_id.contains("?")||email_id.contains("*")||email_id.contains("<")||email_id.contains(">")
    	   ||email_id.contains("<script>")||email_id.contains("</script>") ||email_id.contains("<Script>")||email_id.contains("</Script>")
    				){

    			return true;
    		}else{
    			return false;
    		}
    		
    	} 
}


