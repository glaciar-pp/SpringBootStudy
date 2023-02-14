package com.mulcam.study.map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.study.entity.Map;
import com.mulcam.study.service.MapService;

@Controller
@RequestMapping("/goodM/map")
public class MapController {
	@Value("${naver.accessId}")
	private String accessId;

	@Value("${naver.secretKey}")
	private String secretKey;

	@Value("${roadAddrKey}")
	private String roadAddrKey;

	@Autowired
	private MapService mapService;	

	@GetMapping("/kakaoMap")
	public String list(@ModelAttribute Map map, Model model) throws Exception {
		List<Map> mapList = mapService.getMapList();
		model.addAttribute("mapList", mapList);

		return "map/kakaoMap";
	}
	
}
