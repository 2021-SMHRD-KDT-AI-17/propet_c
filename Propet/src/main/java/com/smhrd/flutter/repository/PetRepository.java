package com.smhrd.flutter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.flutter.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
