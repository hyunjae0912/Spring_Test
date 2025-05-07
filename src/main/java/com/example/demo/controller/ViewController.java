package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/Reservation")
public class ViewController {
	
	@Autowired
	ReservationService service;
	
	// 기본 창, 서비스에서 list 꺼내오기
	// html에서 반복문을 사용해서 찾기
	@GetMapping("/list")
	public void list(Model model) {
		// 완성됨
		List<ReservationDTO> list = service.reservationList();
		model.addAttribute("list", list);
		System.out.println(list);
	}
	
	
	@GetMapping("/read")
	public void read(@RequestParam(name = "no") int no, Model model) {
		ReservationDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}
	
	// 등록하기 서비스에 있는거 사용하기
	// 일단 등록 화면으로 들어감
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 등록 처리하기
	@PostMapping("/register")
	public String registerPost(ReservationDTO dto, RedirectAttributes redirectAttributes) {
		System.out.println(dto);
	    service.register(dto);
	    return "redirect:/Reservation/list"; // 목록으로 리다이렉트
	}	
}