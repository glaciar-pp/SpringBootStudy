package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ChatbotService;

@Controller
@RequestMapping("/goodM/chat")
public class ChatController {
	
	@Autowired
	private ChatbotService chatbotService;
	
	@GetMapping("/gibuni")
	public String gibuni(String result) {
		result = chatbotService.main("");
		System.out.println("위");
		return "chat/gibuni";
	}
	
	@ResponseBody
	@PostMapping("/gibuni")
	public String gibuniResult(@RequestParam("message")String inputText) throws Exception { 
		String msg = ""; 
		System.out.println("아래");
		msg = chatbotService.main(inputText); 
		System.out.println("아래아래");
		return msg;
	    }
}
