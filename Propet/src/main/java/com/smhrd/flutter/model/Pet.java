package com.smhrd.flutter.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="pet")
@Getter
@Setter
public class Pet {

	
	
	@Id // PK 지정 long 으로 자주 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 고유키 자동생성
	@Column(name = "p_idx")
	private long pidx;
	
	@Column(name ="p_name", length = 50) //펫이름
	private String pname;
	
	@Column(name ="p_kind", length = 50) //펫 종
	private String pkind;
	
	@Column(name ="p_age") //펫나이
	private Long page;
	
	@Column(name = "p_kg", precision = 4, scale = 2) //펫 몸무게
    private BigDecimal pKg;
	
	@Column(name ="p_gender", length = 50) //펫성별
	private String pgender;
	
	@Column(name ="p_surgery", length = 50) //중성화여부
	private String psurgery;
	
	@Column(name ="p_disease", length = 50) //질환여부
	private String pdisease;
	
	@Column(name ="p_diseaseinf", length = 50) //질환정보
	private String pdiseaseinf;
	
	@Column(name ="u_idx")
	private long uidx;
	
	
}
