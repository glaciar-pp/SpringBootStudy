package com.mulcam.study.chatBot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ChatbotController1 {

	@Value("${naver.chatApiUrl}") private String apiUrl;
	@Value("${naver.chatSecretKey}") private String secretKey;
	
	/*
	 * @GetMapping("/gibuni") public String gibuni() { return "chatbot/gibuni"; }
	 */
	@RequestMapping("/goodM/chatbotTest")
	public static String main(String chatMessage, String apiUrl, String secretKey) throws Exception {

		String chatbotMessage = "";

			String apiURL = "https://ex9av8bv0e.apigw.ntruss.com/custom_chatbot/prod/";

			URL url = new URL(apiURL);
System.out.println("하나");
			String message = getReqMessage(chatMessage);
			System.out.println("##1번" + message);

			String encodeBase64String = makeSignature(message, secretKey);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json;UTF-8");
			con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);
			System.out.println("둘");
			// post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			
			wr.write(message.getBytes("UTF-8"));
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();

			BufferedReader br;
			System.out.println("셋");
			if (responseCode == 200) { // Normal call
				System.out.println(con.getResponseMessage());

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String decodedString;
				String jsonString = "";
				while ((decodedString = in.readLine()) != null) {
					 jsonString = decodedString;
				}
				System.out.println("넷");
				//받아온 값을 세팅하는 부분
	            JSONParser jsonparser = new JSONParser();
	            try {
	                JSONObject json = (JSONObject)jsonparser.parse(jsonString);
	                JSONArray bubblesArray = (JSONArray)json.get("bubbles");
	                JSONObject bubbles = (JSONObject)bubblesArray.get(0);
	                JSONObject data = (JSONObject)bubbles.get("data");
	                String description = "";
	                description = (String)data.get("description");
	                chatMessage = description;
	            } catch (Exception e) {
	                System.out.println("error");
	                e.printStackTrace();
	            }
				// chatbotMessage = decodedString;
				in.close();
				System.out.println("다섯");
			} else { // Error occurred
				 chatMessage = con.getResponseMessage();
			}
			System.out.println("여섯");
		return chatMessage;
	}

	public static String makeSignature(String message, String secretKey) {

		String encodeBase64String = "";
		System.out.println("일곱");
		try {
		    byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");
			System.out.println("여덟");

			SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
	            
            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);

			return encodeBase64String;

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("아홉");
		return encodeBase64String;

	}

	public static String getReqMessage(String chatMessage) {

		String requestBody = "";
		System.out.println("열");
		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##2번" + timestamp);
			System.out.println("열하나");
			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

			obj.put("timestamp", timestamp);
			System.out.println("열둘");
			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", chatMessage);
			System.out.println("열셋");
			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.put(bubbles_obj);
			System.out.println("열넷");
			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();
			System.out.println("열다섯");			
		} catch (Exception e) {
			System.out.println("##3번 Exception : " + e);
		}
		System.out.println("열여섯");
		return requestBody;

	}
}
