package com.mulcam.study.chatBot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.study.service.ChatbotService;

@Controller
@RequestMapping("/goodM/chatbot")
public class ChatbotController {
	@Autowired
	private ChatbotService chatbotService;

	@GetMapping("/gibuni")
	public String chatbotForm() {
		return "chatbot/gibuni";
	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/chatbot") public String chatbotResult(@RequestParam("message")
	 * String inputText) throws Exception { String msg = ""; msg =
	 * chatbotService.main(inputText); return inputText; }
	 */

}