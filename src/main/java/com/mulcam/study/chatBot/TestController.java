package com.mulcam.study.chatBot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodM/test")
public class TestController {

	@GetMapping("/gibuni")
	public String gibuni() {
		return "test/gibuni";
	}
	
}
