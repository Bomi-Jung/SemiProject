package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass //해당 클래스는 테이블로 생성하지 않음
@EntityListeners(value = {AuditingEntityListener.class})
//엔티티에 변화를 감지하는 리스너 지정
@Getter
public class BaseEntity {
	
	@CreatedDate //인스턴스가 생성되는 것을 감지하여 현재시간을 저장 
	LocalDateTime regDate;//상품번호를 만들기 위한 등록일자
	
	}


