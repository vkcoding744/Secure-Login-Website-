package in.codingvk.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController 
{		
	 //public home page
	@GetMapping("/home")
	public String getHomePage() 
	{
		return "index";
	}
	
   // Custom login for user & admin page
	@GetMapping("/login")
	public String getLoginSecurityPage() 
	{
	 	return "login";
	}
	  
	 //user profile page
	@GetMapping("/user/userProfile")
	public String userProfilePage() 
	{
		return "userprofile";
	}	
	
	  //Admin Profile page
	@GetMapping("/admin/adminProfile")
	public String adminProfilePage() 
	{  
		return "adminprofile";
	}	

		
}    
