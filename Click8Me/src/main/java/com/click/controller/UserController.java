package com.click.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.User;
import com.click.entity.UserRole;
import com.click.service.SendMailService;
import com.click.service.UserService;
import com.click.utils.Global;

@Controller
public class UserController {

	@Value("${app.url}")
	String APP_URL;

	@Autowired
	SendMailService sendMailService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable String userId, Model model) {
		try {
			User user = userService.findUserById(userId);
			System.out.println("user object :" + user.toLogString());
			model.addAttribute("user", user);
		} catch (Exception e) {
			System.out.println("Error getUser");
			e.printStackTrace();
		}
		return "user";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String viewUser(Model model) {
		try {
			System.out.println("view user");
			User user = new User();
			model.addAttribute("user", user);
		} catch (Exception e) {
			System.out.println("Error viewUser");
			e.printStackTrace();
		}
		return "user";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password) {
		try {
			System.out.println(
					"first name -" + firstName + "lastName- " + lastName + "email -" + email + "password -" + password);
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(email);
			user.setPassword(password);
			UserRole role = new UserRole();
			role.setId("111");
			user.setUserRole(role);
			user = userService.saveUser(user);
			sendRegistrationEmail(new String[] { user.getEmailId() }, user.getFirstName(), user.getId(),
					"Thanks For Registration");
			System.out.println("user object :" + user.toLogString());
		} catch (Exception e) {
			System.out.println("Error saveUser");
			e.printStackTrace();
		}
		return "WEB-INF/views/jsp/login";
	}

	@RequestMapping(value = "/activateUser/{id}", method = RequestMethod.GET)
	public String activateUser(@PathVariable String id) {
		try {
			userService.activateUser(id);
			System.out.println("user activated successfully");
		} catch (Exception e) {
			System.out.println("Error activate user");
			e.printStackTrace();
		}
		return "WEB-INF/views/jsp/login";
	}

	private void sendRegistrationEmail(String[] mailTo, String userName, String id, String message) {
		String url = APP_URL;
		String subject = "Registration";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("message", message);
		map.put("loginUrl", url);
		map.put("appUrl", url + "/activateUser/" + id);
		sendMailService.sendEmailTemplate(mailTo, subject, map, Global.REGISTRATION_MAIL_TEMPLATE);
	}

}
