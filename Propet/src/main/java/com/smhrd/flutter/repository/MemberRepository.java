package com.smhrd.flutter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.flutter.model.AiMember;

@Repository
public interface MemberRepository extends JpaRepository<AiMember, Long>{
	// select * from AiMember where m_id=? and m_password=?
	public AiMember findByIdAndPassword(String id, String pw); //묶어서 보내면안됨!!
	//by where절
	
}
