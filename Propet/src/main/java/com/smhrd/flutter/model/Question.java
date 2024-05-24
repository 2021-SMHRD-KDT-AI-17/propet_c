package com.smhrd.flutter.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name=("question"))
@Getter
@Setter
public class Question {

	@Id // PK 지정 long 으로 자주 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 고유키 자동생성
	@Column(name = "q_idx")
	private Long q_idx;
	
	@Column(name ="q_content", length = 50) //질문 내용
	private String q_content;
	
	@Column(name ="q_answer", length = 50) //질문 답변
	private String q_answer;
	
	@Column(name ="q_embedding") //질문벡터데이터  //BLOB자료형
	private byte[] q_embedding;
	
	
	@Column(name ="q_tf", length = 50) //답변 여부
	private String q_tf;
	
	
	@Column(name ="q_category", length = 50) //질문카테고리
	private String q_category;
	
	@Column(name ="u_id", length = 50)
	private String u_id;
}
