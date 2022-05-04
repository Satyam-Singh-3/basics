package tectoro.springmvc.com.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	//Sending data from controller to view by using model;
	
	@RequestMapping("/hi")
	public String show(Model model)
	{   
		model.addAttribute("name","Satyam_Singh");
		
		List<String>list=new ArrayList<String>();
		list.add("Satyam");
		list.add("Mohan");
		list.add("Arun");
		
		model.addAttribute("L", list);
		
		return"home";
	}
	
	//Sending data from controller to view by using ModelAndView;
	@RequestMapping("/about")
	public ModelAndView about()
	{
	    ModelAndView modelAndView=new ModelAndView();
	    
	    modelAndView.addObject("s","Salman");
	    
		
		  LocalDateTime now=LocalDateTime.now();
		  modelAndView.addObject("satyam","now");
		 
	    
	    modelAndView.setViewName("about");
	    
	    
		return modelAndView;
	}
}
