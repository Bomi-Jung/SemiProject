package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	ProductService service;

	@GetMapping("/basic")
	public void basic() {
		
	}
	

	//목록화면
	@GetMapping("/list")
	public void list(Model model) {
		List<ProductDTO> list = service.getList(); // 서비스로 상품 목록 가져오기
		model.addAttribute("list", list);
	}
	
	
}


