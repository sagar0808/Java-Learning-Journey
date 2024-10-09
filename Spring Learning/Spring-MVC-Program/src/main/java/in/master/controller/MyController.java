package in.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public ModelAndView modelAndView() {
	System.out.println("Model and View Function Called...");
	
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("hello");
	
	return modelAndView;
    }
    
    @GetMapping("/login")
    public String newPage() {
	return "new";
    }
}
