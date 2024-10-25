package com.master.main.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.master.main.Entity.User;
import com.master.main.repository.UserRepository;
import com.master.main.service.UserServiceImpl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/regForm")
	public String registration(Model model) {
		
		model.addAttribute("user", new User());
		
		return "register";
	}
	
	@PostMapping("registration")
	public String registered(@ModelAttribute User user, Model model) {
		
		Boolean status = userServiceImpl.insertUser(user);
		if (status) {
			model.addAttribute("SuccessMsg", "User Registered Successfully");
		}else {
			model.addAttribute("ErrorMsg", "User Not Registerd !!! ");
		}
		
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String login(Model model) {
		
		model.addAttribute("userLogin", new User());
		
		return "login";
	}
	
	@PostMapping("login")
	public String Login(@ModelAttribute User user, Model model) {
		
		
		User validUser = userServiceImpl.loginUser(user.getUsername(), user.getPassword());
		if (validUser != null) {
			model.addAttribute("Done", user.getUsername());
			return "profile";
		}else {
			model.addAttribute("ErrorMsg", "Account doesn't Exist");
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
		}
		
		return "login";
	}
	
}
