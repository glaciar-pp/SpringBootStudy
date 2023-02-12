package com.mulcam.study.chatBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mulcam.study.service.ChatbotService;

@Controller
@RequestMapping("/goodM/chatbot")
public class ChatbotController {
	@Autowired
	private ChatbotService chatbotService;	
	
	@RequestMapping("/chatbotSend")
    public String chatbotSend(@RequestParam("inputText") String inputText) {
        String msg = "";
        msg = chatbotService.main(inputText);
        return msg;
    }
}