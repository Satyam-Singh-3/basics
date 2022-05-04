package tectoro.springmvc.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {
    
	//Redirect view using redirect prefix;
	@RequestMapping("/one")
	public String one()
	{
		System.out.println("Welcome...!");
		return"redirect:two";
	}
	
	@RequestMapping("/two")
	public String two()
	{
		System.out.println("Thank_You...!");
		return"help";
	}
	
	//Redirect Using RedirectView
	
	@RequestMapping("/three")
	public RedirectView three()
	{
      RedirectView view = new RedirectView();
      view.setUrl("https://www.tectoro.com");
      return view;
	}
}
