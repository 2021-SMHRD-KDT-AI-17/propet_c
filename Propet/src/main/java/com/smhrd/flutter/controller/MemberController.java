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

	// HashMap - JSON 호환성 좋음
	// Jackson 라이브러리 내장(boot) => JSON 문자열 => Object(HashMap - key:value)
	
	//	http://localhost:8089/boot
	@PostMapping("/join") // 회원가입	
	public int memberJoin(@RequestBody HashMap<String,Object>map) {
//			System.out.println(map);
//		HashMap => AiMember(class)
		ObjectMapper om = new ObjectMapper();
//		joinMember key 값에서 json 데이터 받아와서 AiMember 클래스로
		AiMember joinMember =  om.convertValue(map.get("joinMember"), AiMember.class);
		
//		Controller(요청받음)-> Service(로직처리)-> Repository(db연동)
		
//		Service 1 or 0 return
		int result = service.memberJoin(joinMember);
		return result;
	}
	@PostMapping("/login")
	public String memberLogin(@RequestBody HashMap<String,Object> map) {
//		System.out.println(map);
		ObjectMapper om =new ObjectMapper();
		AiMember loginMember = om.convertValue(map.get("loginMember"),AiMember.class);
//		Java Object => JSON 형식의 문자열ㄹㄹ 로변형
		AiMember result = service.memberLogin(loginMember);
		
//		로그인 성공 : result != null => result(AiMember) -> jsonString
//		로그인 실패 : result != null => null 반환
		String jsonString=null;
		if(result !=null) {
			try {
				jsonString = om.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		System.out.println(jsonString);
		return jsonString;
	}
	@PatchMapping("/update")
	public String memberUpdate(@RequestBody HashMap<String,Object>map) {
		System.out.println(map);
	ObjectMapper om = new ObjectMapper();
	AiMember updateMember =  om.convertValue(map.get("updateMember"), AiMember.class);
	
//	result : 기존(uid, id, age) / 수정(password, nickname)
	AiMember result = service.memberUpdate(updateMember);
	String jsonString = null;
	if(result !=null) {
		try {
			jsonString = om.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	return jsonString;
}
	@DeleteMapping("/delete")
	public int memberDelete(@RequestBody HashMap<String, Object> map) {
// 삭제만 진행할거라 repository 안해도됨
		ObjectMapper om = new ObjectMapper();
		Long uid = om.convertValue(map.get("uid"),Long.class );
		service.memberDelete(uid);
		return 0;
	}
}
