package com.smhrd.flutter.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.flutter.model.Pet;

import com.smhrd.flutter.service.PetService;

@RestController
public class PetController {
    
    @Autowired
    PetService service;

    @PostMapping("/enroll")
    public int petEnroll(@RequestBody HashMap<String, Object> map) {
        ObjectMapper om = new ObjectMapper();
        Pet enrollPet = om.convertValue(map.get("enrollPet"), Pet.class);
        System.out.println("Received pet data: " + enrollPet); // 로그 추가
        int result = service.petEnroll(enrollPet);
        
		
        return result;
    }
}
