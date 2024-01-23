package com.example.springdevtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String handler() {
		int a=67, b=35;
		return "this is just for testing! sum of a and b is - " + (a+b);
		// I make changes and save them, dynamically it restart app and reflect changes in browser
	}
}
