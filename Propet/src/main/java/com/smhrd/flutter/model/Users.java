package com.smhrd.flutter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users") //테이블이름
@Getter
@Setter
public class Users {

	@Column(name ="u_id", length = 50)
	private String u_id;
	
	@Column(name ="u_name", length = 50)
	private String u_name;
	
	@Column(name ="u_pw", length = 50)
	private String u_pw;
	
	@Column(name ="u_phone", length = 50)
	private String u_phone;
	
	//등록일 필요하나?
	

}
