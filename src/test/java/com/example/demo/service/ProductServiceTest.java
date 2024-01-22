package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ProductDTO;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService service;
	
	@Test
	public void 게시물등록() {
		ProductDTO dto = ProductDTO.builder().company("에뛰드").content("틴트입니다").price(8900).product("픽싱틴트").build();
		int no = service.register(dto);
		System.out.println("새로운 게시물 번호: " + no);
	}
	
	@Test
	public void 게시물목록조회() {
		List<ProductDTO> list = service.getList();
		for(ProductDTO dto : list) {
			System.out.println(dto);
		}
	}
}
