package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	// 목록화면
	@GetMapping("/list")
	public void list(Model model) {
		List<ProductDTO> list = service.getList(); // 서비스로 상품 목록 가져오기
		model.addAttribute("list", list);
	}

	// 등록화면
	@GetMapping("/register")
	public void register() {
	}

	// 등록처리
	@PostMapping("/register")
	// RedirectAttributes은 모델처럼 화면에 데이터를 전달하는 객체
	// 화면에서 전달한 데이터를 파라미터로 수집
	public String registerPost(ProductDTO dto, RedirectAttributes redirectAttributes) {

		// 게시물 등록하고 새로운 게시불 번호 반환
		int no = service.register(dto);

		// 목록화면에 새로운 게시물 번호 전달
		redirectAttributes.addFlashAttribute("msg", no);

		// 목록화면으로 이동. HTML 경로 아닌 url 주소를 작성할 것
		return "redirect:/main/list";
	}

	// 상세화면(조회처리)
	@GetMapping("/read")
	public void read(@RequestParam(name = "no") int no, Model model) {
		ProductDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}

	// 수정화면
	@GetMapping("/modify")
	public void modify(@RequestParam(name = "no") int no, Model model) {
		ProductDTO dto = service.read(no); // 게시물 번호로 조회
		model.addAttribute("dto", dto); // 화면에 게시물 정보 전달

	}

	// 수정처리
	@PostMapping("/modify")
	public String modifyPost(@RequestParam(name= "no") int no, ProductDTO dto, RedirectAttributes redirectAttributes) {
		 // 로그 추가
	    System.out.println("Received no: " + no);
		// 상품 수정
		service.modify(dto);
		// 리다이렉트 주소에 파라미터 추가
		redirectAttributes.addFlashAttribute("no", no);
		// 상세화면으로 이동
		return "redirect:/main/read";
	}

	// 삭제처리
	@PostMapping("/remove")
	public String removePost(@RequestParam(name = "no") int no) {
		service.remove(no);
		return "redirect:/main/list";
	}

}
