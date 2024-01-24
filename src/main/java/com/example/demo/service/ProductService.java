package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Products;

public interface ProductService {
	
	//상품 등록
	int register(ProductDTO dto) ;
	
	//목록 조회하기
	List<ProductDTO> getList();
	
	//상품 상세 조회
	ProductDTO read(int no);
	
	//상품 수정하기
	void modify(ProductDTO dto);
	
	//상품 삭제하기
	int remove(int no);
	
	//dto를 엔티티로 변환하는 메소드
	default Products dtoToEntity(ProductDTO dto) { //default 키워드를 사용하여 일반메소드 추가
		Products entity = Products.builder().no(dto.getNo()).company(dto.getCompany()).content(dto.getContent()).price(dto.getPrice()).product(dto.getProduct()).build();
		return entity;
	}
	
	//엔티티를 dto로 변환하는 메소드
	default ProductDTO entityToDto(Products entity) { //default 키워드를 사용하여 일반메소드 추가
		ProductDTO dto = ProductDTO.builder().no(entity.getNo()).company(entity.getCompany()).content(entity.getContent()).price(entity.getPrice()).product(entity.getProduct()).regDate(entity.getRegDate()).build();
		return dto;
		
	}
}


