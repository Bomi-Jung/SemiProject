package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Products;
import com.example.demo.repository.ProductsRepository;

@Service // 서비스 클래스로 지정
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductsRepository repository; // 사용할 리파지토리를 멤버로 선언

	// 상속받을 메소드 구현하기

	// 상품 등록하기
	@Override
	public int register(ProductDTO dto) {

		Products entity = dtoToEntity(dto); // 파라미터로 전달받은 dto를 엔티티로 변환
		repository.save(entity);
		int newNo = entity.getNo();
		
		System.out.println(entity);
		
		return newNo; //새로운 상품의 번호를 반환 
	}
	
	//목록 조회하기
	@Override
	public List<ProductDTO> getList() {
		List<Products> result = repository.findAll(); // 데이터베이스에서 상품목록을 가져온다
		List<ProductDTO> list = new ArrayList<>();
		list = result.stream().map(entity -> entityToDto(entity))//중간연산으로 엔티티를 dto로 변환
				.collect(Collectors.toList());//최종연산으로 결과를 리스트로 반환 
		
		return list; // 화면에 필요한 dto 리스트 반환


	}

	//상품 상세정보 조회하기 
	@Override
	public ProductDTO read(int no) {
		Optional<Products> result = repository.findById(no);
		
		if(result.isPresent()) {
		Products products = result.get();
		ProductDTO dto = entityToDto(products);
		return dto;	
	}else {
		return null;
	}
	
	
	

	}

	//상품수정하기
	@Override
	public void modify(ProductDTO dto) {
	//업데이트 할 항목은 '상품명','가격', '내용'
		
	//전딜받은 DTO에서 게시물 번호를 꺼내고, 해당 게시물 조회 
	 Optional<Products> result = repository.findById(dto.getNo());
	 if(result.isPresent()) {
		 Products entity = result.get();
		 
		 //기존 엔티티에서 변경내용을 변경
		 entity.setProduct(dto.getProduct());
		 entity.setContent(dto.getContent());
		 entity.setPrice(dto.getPrice());
		 
		 //다시 저장
		 repository.save(entity);
	 }
	}

	//상품 삭제하기
	@Override
	public int remove(int no) {
		Optional<Products> result = repository.findById(no);
		
		if (result.isPresent()) {
			repository.deleteById(no);
			return 1; //성공
		} else {
			return 0; //실패 
		}
		
	}
}
