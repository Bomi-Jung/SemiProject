package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="tbl_products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products extends BaseEntity { // 등록일 필드 상속받기 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no; //상품 번호

	@Column(length = 255, nullable = false)
	String company; //제조사
	
	@Column(length = 255, nullable = false)
	String product; //상품명
	
	@Column(nullable = false)
	int price; //가격
	
	@Column(length = 255, nullable = true)
	String content; //내용
	
	//상품등록일자 
}
