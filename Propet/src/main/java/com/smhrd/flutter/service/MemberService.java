package com.smhrd.flutter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.flutter.model.AiMember;
import com.smhrd.flutter.repository.MemberRepository;

@Service
public class MemberService implements MemberServiceImpl {

	// MemberRepository 의존성 추가
	@Autowired
	MemberRepository repo;
	
	@Override
	public int memberJoin(AiMember m) {
		// insert / update 둘다
		// result : 어떤 값들이 insert 되었는지
		AiMember result =  repo.save(m);
		
		if(result!=null) return 1; // 가입성공
		else return 0; // 가입실패
	}

	public AiMember memberLogin(AiMember m) {
//		findAll->select*
//		findById -> pk가져오기
//		where 문findBy ?ANd?OR
		return  repo.findByIdAndPw(m.getId(), m.getPw());
	}
	
	public AiMember memberUpdate(AiMember m) {
//		update
//		1. update(수정)하고 싶은 행 현재 정보 가져오기(select)
//		select -> primary key(uid) 조건
		AiMember member = repo.findById(m.getUid()).orElseThrow(()->{
			throw new IllegalArgumentException("해당하는 uid가 없습니다"); //예외처리
		});
//		2. 수정하고 싶은 값으로 값 필드값 바꾸기(비밀번호, 닉네임)
		member.setPw(m.getPw());
		member.setNick(m.getNick());
		
//		3. member 가 가지고 있는 값으로 최종 저장 (save)
//		save -> insert(해당 uid 없을 때) / update(해당 uid 있을 때)
		AiMember result = repo.save(member);
		return result;
	}

	@Override
	public void memberDelete(long uid) {
		repo.deleteById(uid);
		
	}
		

}
