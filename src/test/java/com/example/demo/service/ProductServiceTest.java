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
	public void 상품등록() {
		ProductDTO dto = ProductDTO.builder().company("정샘물").content("쿠션입니다").price(41000).product("쿠션").build();
		int no = service.register(dto);
		System.out.println("새로운 게시물 번호: " + no);
	}

	@Test
	public void 상품목록조회() {
		List<ProductDTO> list = service.getList();
		for (ProductDTO dto : list) {
			System.out.println(dto);
		}
	}

	@Test
	public void 상품단건조회() {
		ProductDTO dto = service.read(2);
		System.out.println(dto);
	}
	
	@Test
	public void 상품정보수정() {
		ProductDTO dto = service.read(4);
		dto.setPrice(15000);
		dto.setContent("베스트 셀러 클렌징오일입니다~");
		service.modify(dto);
	}
	
	@Test
	public void 상품정보삭제() {
		service.remove(5);
	}
}
