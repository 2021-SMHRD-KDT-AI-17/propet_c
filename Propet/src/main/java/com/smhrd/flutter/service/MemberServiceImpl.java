package com.smhrd.flutter.service;

import com.smhrd.flutter.model.AiMember;

public interface MemberServiceImpl {
	// 회원 가입(insert) 메서드
	public int memberJoin(AiMember m);
	
	//로그인(select)메서드
	public AiMember memberLogin(AiMember m); //추상메서드
	
	//회원정보수정(update) 메서드
	public AiMember memberUpdate(AiMember m);
	
	//회원정보 삭제- 탈퇴(delete) 메서드
	public void memberDelete(long uid);
}
