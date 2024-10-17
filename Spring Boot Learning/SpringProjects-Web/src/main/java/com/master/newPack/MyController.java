package com.master.newPack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/hello")
	@ResponseBody
	private String controller() {
		
		return "Hello Master";
	}
}
