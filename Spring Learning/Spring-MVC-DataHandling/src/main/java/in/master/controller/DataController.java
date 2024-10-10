package in.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.master.bean.User;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DataController {
    
    @GetMapping("click")
    public ModelAndView modelAndView() {
	System.out.println("Model and View Function Called...");
	
	ModelAndView modelAndView = new ModelAndView("click");
	
	return modelAndView;
    }
    
    @GetMapping("form")
    public String form() {
	return "form";
    }
    
    // Data Access from form.jsp through http request parameter
//    @PostMapping("register")
//    public String register(HttpServletRequest req) {
//	
//	String name = req.getParameter("name");
//	String email = req.getParameter("email");
//	String pass = req.getParameter("pass");
//	
//	return "profile";
//    }
    
    
    // Data access from form through annotation @requestParam
//    @PostMapping("register")
//    public String register(@RequestParam("name") String name,
//	    		   @RequestParam("email") String email,
//	    		   @RequestParam("pass") String pass,
//	    		   Model model) {
//	
//	model.addAttribute("modelName", name);
//	model.addAttribute("modelEmail", email);
//	model.addAttribute("modelPass", pass);
//	
//	return "profile";
//    }
    
 // Data access from form through annotation @requestParam and bean object
//    @PostMapping("register")
//    public String register(@RequestParam("name") String name,
//	    		   @RequestParam("email") String email,
//	    		   @RequestParam("pass") String pass,
//	    		   Model model) {
//	
//	User user = new User();
//	user.setName(name);
//	user.setEmail(email);
//	
//	model.addAttribute("modelObj", user);
//	
//	return "profile";
//    }
    
    // Data access from form through annotation @ModelAttribute
    @PostMapping("register")
    public String register(@ModelAttribute User user) {
	return "profile";
    }

}
