package com.smhrd.flutter.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="goods")
@Getter
@Setter
public class Goods {

	@Id // PK 지정 long 으로 자주 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 고유키 자동생성
	@Column(name = "g_idx")
	private Long g_idx;
	
	@Column(name ="g_name", length = 50) //상품이름
	private String g_name;
	
	@Column(name ="g_explan", length = 50) //설명 - 오타잇음
	private String g_explan;
	
	
	@Column(name ="g_ingre", length = 50) // 성분
	private String g_ingre;
	
	@Column(name ="g_price") //가격
	private Long g_price;
	
	@Column(name ="g_link", length = 100) //중성화여부
	private String g_link;
	
	@Column(name ="g_soldout", length = 1) //질환여부
	private String g_soldout;
	
}
