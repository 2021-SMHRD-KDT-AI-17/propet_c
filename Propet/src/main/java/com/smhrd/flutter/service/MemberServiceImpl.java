package com.smhrd.flutter.service;

import com.smhrd.flutter.model.AiMember;

public interface MemberServiceImpl {
//	회원가입(insert) 메소드
	public int memberJoin(AiMember m);
//	로그인(select) 메소드
	public AiMember memberLogin(AiMember m);
//	회원정보수정(update)메소드
	public AiMember memberUpdate(AiMember m);
	
//	회원정보삭제(delete) 메서드
	public void memberDelete(long uid);
	
}
