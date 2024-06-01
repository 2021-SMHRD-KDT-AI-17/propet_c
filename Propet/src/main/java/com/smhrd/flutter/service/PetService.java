package com.smhrd.flutter.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.flutter.model.AiBoard;
import com.smhrd.flutter.model.Pet;
import com.smhrd.flutter.repository.PetRepository;

@Service
public class PetService implements PetServiceImpl {

    @Autowired
    PetRepository repo;

    @Override
    public int petEnroll(Pet p) {
        Pet result = repo.save(p);
        if (result != null) {
            System.out.println("Pet enrolled successfully: " + result); // 로그 추가
            return 1; // 펫등록 성공
        } else {
            System.out.println("Failed to enroll pet."); // 로그 추가
            return 0; // 펫등록 실패
        }
    }

	public List<Pet> selectAllPet(long uidx) {
		return repo.findByUidx(uidx);
	}

	public void deletePet(Long p_idx) {
		repo.deleteById(p_idx);
	}

}
