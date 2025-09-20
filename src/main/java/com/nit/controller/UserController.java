package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.UserData;
import com.nit.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public String loginPage(@RequestParam String mail,
			                @RequestParam String password)
	{
		String loginPageData = userService.loginPageData(mail,password);
		return loginPageData;
	}
	@PostMapping("/register")
	public String registerPage(@RequestBody UserData userData)
	{
		String registerPageData = userService.registerPageData(userData);
		return registerPageData;
	}

}
