package com.mulcam.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodM/survey")
public class SurveyController {

	@GetMapping("/survey1")
	public String surveyForm() {
		return "survey/survey1";
	}
	
}
