package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Repository.UserRepo;
import com.nit.entity.UserData;

@Service
public class UserService 
{
	
	@Autowired
	private UserRepo userRepo;

	public String registerPageData(UserData userData) 
	{
		UserData byMailId = userRepo.findByMailId(userData.getMailId());
		if(byMailId==null)
		{
			userRepo.save(userData);
			return "Register Successfully";
		}
		else 
		{
			return "User alreay exist with : "+userData.getMailId();
		}
		
		
	}

	public String loginPageData(String mail,String password) 
	{
		UserData byMailIdAndPassword = userRepo.findByMailIdAndPassword(mail,password);
		if(byMailIdAndPassword!=null)
		{
			if(byMailIdAndPassword.getMailId().equals(mail) && byMailIdAndPassword.getPassword().equals(password))
			{
				return "User login successfull :  " +byMailIdAndPassword.getMailId();
			}
			else 
			{
				return "email and password is mismatch";
			}
		}
		else 
		{
			return "record not found";
		}
	}
}
