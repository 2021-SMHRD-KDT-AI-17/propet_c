package com.smhrd.flutter.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.flutter.model.AiMember;
import com.smhrd.flutter.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
	//HashMap - JSON 호환성이 가장 좋음!!
	//Jackson 라이브러리 내장(boot) => JSON 문자열 => object(HashMap: key-value) -> 함수형태
	
	//http://localhost:8089/boot/join
	@PostMapping("/join") // 회원가입
	public int memberJoin(@RequestBody HashMap<String, Object> map ) {
		
		// HashMap => Aimember(class)
		ObjectMapper om=new ObjectMapper();
		AiMember joinMember = om.convertValue(map.get("joinMember"), AiMember.class);
		
		//controller(요청받음) -> service(로직 처리) -> repository(DB연동)
		
		int result = service.memberJoin(joinMember);
		
		return result;
	}
	
	//http://localhost:8089/boot/login
	@PostMapping("/login")
	public String memeberLogin(@RequestBody HashMap<String, Object> map) {
		//System.out.println(map); // 값 넘어오는지 확인
		ObjectMapper om=new ObjectMapper();
		AiMember loginMember = om.convertValue(map.get("loginMember"), AiMember.class);
		
		//Java Object => json 형식의 문자열(String) 변형
		AiMember result = service.memberLogin(loginMember);
		
		//로그인이 성공 : result != null => result(AiMember) -> jsonString
		// 로그인 실패 : result = null => null
		
		String jsonString =null;
		if(result != null) {
			try {
				jsonString = om.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(jsonString);
		return jsonString;
	}
	
	@PatchMapping("/update")
	public String memberUpdate(@RequestBody HashMap<String, Object> map) {
		
		//System.out.println(map);
		ObjectMapper om=new ObjectMapper();
		AiMember updateMember = om.convertValue(map.get("updateMember"), AiMember.class);
		
		//result : 기존(uid,id,age)/ 수정(password,nickname)
		AiMember result= service.memberUpdate(updateMember);
		
		String jsonString =null;
		
		if(result!=null) {
			try {
				jsonString=om.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonString;
	}
	
	@DeleteMapping("/delete")
	public int memberDelete(@RequestBody HashMap<String, Object> map) {
		
		//System.out.println(map);
		ObjectMapper om=new ObjectMapper();
		Long uid = om.convertValue(map.get("uid"), Long.class );
		
		service.memberDelete(uid);
		
		
		return 0;
	}
}
