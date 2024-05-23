package com.smhrd.flutter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//JPA(Class-Table 매핑)
@Entity(name="aimember")
@Getter
@Setter
public class AiMember {
	@Id //primary key 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //고유키 자동생성
	@Column(name="uid")
	private long uid;
	
	@Column(name="m_id")
	private String id;
	
	@Column(name="m_password")
	private String password;
	
	@Column(name="m_age")
	private int age;
	
	@Column(name="m_nickname")
	private String nickname;
}
