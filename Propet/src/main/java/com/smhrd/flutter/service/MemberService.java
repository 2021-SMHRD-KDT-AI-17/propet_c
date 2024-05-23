package com.smhrd.flutter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.flutter.model.AiMember;
import com.smhrd.flutter.repository.MemberRepository;

@Service
public class MemberService implements MemberServiceImpl {

	
	//MemberRepository 의존성 추가
	@Autowired
	MemberRepository repo;
	
	@Override
	public int memberJoin(AiMember m) {
		
		// insert / update 둘다 -> save
		// result : 어떤값들이 insert 되었는지
		AiMember result = repo.save(m);
		
		
	//	repo.find
		
		if(result!=null) return 1; // 가입 성공
		else return 0;	// 가입 실패
		
	}

	@Override
	public AiMember memberLogin(AiMember m) {


		return repo.findByIdAndPassword(m.getId(), m.getPassword());

		
	}

	@Override
	public AiMember memberUpdate(AiMember m) {
		// 수정(update)
		// 1. update(수정) 하고 싶은 행 현재 정보 가져오기(selcet)
		// select -> primary key(id) 조건
		AiMember member = repo.findById(m.getUid()).orElseThrow(()->{
			throw new IllegalArgumentException("해당하는 uid가 없습니다"); //예외처리
		});
		
		//2. 수정하고 싶은 값으로 값 필드 값 바꾸기(비밀번호, 닉네임)
		member.setPassword(m.getPassword());
		member.setNickname(m.getNickname());
		
		
		//3. member 가 가지고 있는 값으로 최종 저장(save)
		// save -> insert(해당 uid없을때) update(해당 uid 있을때)
		AiMember result = repo.save(member);
		
		return result;
	}

	@Override
	public void memberDelete(long uid) {
		repo.deleteById(uid);
		
	}

}
