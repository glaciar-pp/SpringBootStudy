package com.mulcam.study.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mulcam.study.entity.DiaryBoard;
import com.mulcam.study.entity.GenBoard;
import com.mulcam.study.service.DiaryBoardService;
import com.mulcam.study.service.JSONUtil;

@Controller
@RequestMapping("/goodM/diaryBoard")
public class DiaryBoardController {
	
	@Autowired private DiaryBoardService diaryBoardService;
	@Value("${spring.servlet.multipart.location}") private String uploadDir;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<DiaryBoard> list = diaryBoardService.getDiaryBoardList();
		model.addAttribute("diaryBoardList", list);
//		String today = LocalDate.now().toString(); 
//		model.addAttribute("today", today);
		return "diaryBoard/list";
	}
	
	
//==2/2 dir: DiaryBoard -> diaryBoard로 수정//  
//==아래부턴 2/3a에 작업부분===//
	@GetMapping("/write")
	public String write() {
		return "diaryBoard/write";
	}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req) {
		String uid = (String) req.getParameter("uid");
		String title = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		List<MultipartFile> fileList = req.getFiles("files");
		List<String> list = new ArrayList<>();
		// File upload
		for (MultipartFile file: fileList) {
			list.add(file.getOriginalFilename());
			String uploadFile = uploadDir + "/" + file.getOriginalFilename();
			File fileName = new File(uploadFile);
			try {
				file.transferTo(fileName);
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
		JSONUtil json = new JSONUtil();
		String files = json.stringify(list);
		DiaryBoard diaryBoard = new DiaryBoard(uid, title, content, files); 
		diaryBoardService.insertDiaryBoard(diaryBoard);
		return "redirect:/goodM/diaryBoard/list?p=1&f=&q=";
	}
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest req, Model model) {
		int did = Integer.parseInt(req.getParameter("did"));
		String uid = req.getParameter("uid");
		String option = req.getParameter("option");
		HttpSession session = req.getSession();
		String sessionUid = (String) session.getAttribute("uid");
		DiaryBoard diaryBoard = diaryBoardService.getDiaryBoard(did);
		String jsonFiles = diaryBoard.getFiles();
		if (!(jsonFiles == null || jsonFiles.equals(""))) {
			JSONUtil json = new JSONUtil();
			List<String> fileList = json.parse(jsonFiles);
			model.addAttribute("fileList", fileList);
		}
		model.addAttribute("diaryBoard", diaryBoard); 
		return "diaryBoard/detail";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		int did = Integer.parseInt(req.getParameter("did"));
		model.addAttribute("did", did);
		return "diaryBoard/delete";
	}
	@GetMapping("/deleteConfirm")
	public String deleteConfirm(HttpServletRequest req) {
		int did = Integer.parseInt(req.getParameter("did"));
		diaryBoardService.deleteDiaryBoard(did);
		HttpSession session = req.getSession();
		return "redirect:/goodM/diaryBoard/list?p=" + session.getAttribute("currentDiaryBoardPage") + "&f=&q=";
	}

	//=====2/3a 추가한 update부분 ==== 다시 확인하기 =====
	@GetMapping("/update")  //getmapping부분 2/3b에 추가 
	public String updateForm(HttpServletRequest req, Model model) {
		int did = Integer.parseInt(req.getParameter("did"));
		DiaryBoard diaryBoard = diaryBoardService.getDiaryBoard(did);
		HttpSession session = req.getSession();
		
		String jsonFiles = diaryBoard.getFiles();
		if (!(jsonFiles == null || jsonFiles.equals(""))) {
			JSONUtil json = new JSONUtil();
			List<String> fileList = json.parse(jsonFiles);
			session.setAttribute("fileList", fileList);
		}
		model.addAttribute("diaryBoard", diaryBoard);  // 이게 빠졌었음 2/3b에 추가
		return "diaryBoard/update";
	}
	
	@PostMapping("/update")
	public String update(MultipartHttpServletRequest req) {
		int did = Integer.parseInt(req.getParameter("did"));
		String uid = req.getParameter("uid");
		String title = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		
		HttpSession session = req.getSession();
		List<String> additionalFileList = (List<String>) session.getAttribute("fileList"); //<-----확인하기
		String[] delFileList = req.getParameterValues("delFile");
		if (delFileList != null) {
			for (String delName: delFileList) {
				File delFile = new File(uploadDir + "/" + delName);
				delFile.delete();
				additionalFileList.remove(delName);
			}
			session.setAttribute("fileList", additionalFileList);
		}
		
		List<MultipartFile> fileList = req.getFiles("files");
		List<String> newFileList = new ArrayList<>();
		// File upload
		for (MultipartFile file: fileList) {
			newFileList.add(file.getOriginalFilename());
			String uploadFile = uploadDir + "/" + file.getOriginalFilename();
			File fileName = new File(uploadFile);
			try {
				file.transferTo(fileName);
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
		for (String fname: newFileList) {
			additionalFileList.add(fname);
		}
		List<String> newAdditionalFileList = new ArrayList<>();
		for (String afname: additionalFileList) {
			if (afname.equals(""))
				continue;
			newAdditionalFileList.add(afname);
		}
		JSONUtil json = new JSONUtil();
		String files = json.stringify(newAdditionalFileList);
		DiaryBoard diaryBoard = new DiaryBoard(did, title, content, files);
		diaryBoardService.updateDiaryBoard(diaryBoard);
		return "redirect:/goodM/diaryBoard/detail?did=" + did + "&uid=" + uid + "&option=DNI";
	}
		
}
