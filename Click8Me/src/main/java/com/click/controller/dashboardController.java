package com.click.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.User;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class dashboardController {

	
	@RequestMapping(value = "/dashboard")
	protected String getAllCourses(Model model) throws Exception {
		System.out.println("In user dashborad controller");
		User u = SecurityLibrary.getLoggedInUser();
		System.out.println(u.getEmailId());
		return "dashboard";
	}

	
}
