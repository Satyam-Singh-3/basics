package tectoro.springmvc.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tectoro.springmvc.com.model.User;

@Controller
public class HelpController {
	@ModelAttribute
	public void commonDataForAll(Model m)
	{
		m.addAttribute("head","Registration_Form");
		m.addAttribute("desc", "Please..! fill this form");
		
	}
	@RequestMapping("/form")
	public String showForms() {
		return "help";
	}

	/*
	 * @RequestMapping(path="/handleform",method = RequestMethod.POST)
	 * 
	 * public String formHandler(
	 * 
	 * @RequestParam("email")String userEmail,
	 * 
	 * @RequestParam("name")String userName,
	 * 
	 * @RequestParam("pwd")String userPassword,Model model)
	 * 
	 * {
	 * 
	 * User user=new User();
	 * 
	 * user.setName(userName); user.setEmail(userEmail); user.setPwd(userPassword);
	 * 
	 * System.out.println();
	 * 
	 * model.addAttribute("user",user);
	 * 
	 * 
	 * model.addAttribute("userName", userName);
	 * model.addAttribute("userEmail",userEmail); model.addAttribute("userPassword",
	 * userPassword);
	 * 
	 * return"success"; }
	 */
	
	 //@ModelAttribute Annotation;
	
	 @RequestMapping(path="/handleform",method = RequestMethod.POST)
	    
	    public String formHandler(@ModelAttribute User user,Model model)
	    		
	    {
	    	
	        
			
			  if(user.getName().isBlank()) 
			  { 
				  return"redirect:/form";
			  }
			 
	        
	        
			/*
			 * model.addAttribute("userName", userName);
			 * model.addAttribute("userEmail",userEmail); model.addAttribute("userPassword",
			 * userPassword);
			 */
	    	return"success";
	    }
}
