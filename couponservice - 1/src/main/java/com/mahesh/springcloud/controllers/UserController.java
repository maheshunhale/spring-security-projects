package com.mahesh.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahesh.springcloud.model.User;
import com.mahesh.springcloud.repos.UserRepo;
import com.mahesh.springcloud.security.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "login";
	}
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String email, String password) {
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "index";
		}
		return "login";
	}
}
