package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Products;

@SpringBootTest
public class ProductsRepositoryTest {

	@Autowired
	ProductsRepository repository;

	@Test
	void 상품등록() {
		Products product = Products.builder().company("마녀공장").content("클렌징오일입니다.").price(25000).product("클렌징오일")
				.build();

		repository.save(product);
	}
	
	@Test
	void 게시물수정() {
		Optional<Products> result = repository.findById(1);
		Products product =result.get();
		product.setContent("수정된 내용입니다.");
		repository.save(product);
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteById(1);
		
	}
}
