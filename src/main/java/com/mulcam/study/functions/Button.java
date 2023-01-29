package com.mulcam.study.functions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class Button {
	@Controller
	@RequestMapping("/study/button")
	public class UserController {
		
		@GetMapping("/button")
		public String buttonForm() {
			return "study/button";
		}
		
		@PostMapping("/button") 
		public String button(Model model) {
			int result = 0;
			if (result <= 4){
				model.addAttribute("msg", "아무개님 환영합니다.");
				model.addAttribute("url", "study/button");
			}else {
				model.addAttribute("msg", "인원이 가득찼습니다.");
				model.addAttribute("url", "study/button"); 
				return "user/alertMsg";
			}
			return null;
			
		}
	}
}
		