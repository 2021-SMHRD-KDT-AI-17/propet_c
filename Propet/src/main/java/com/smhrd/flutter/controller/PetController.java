package com.smhrd.flutter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.flutter.model.AiBoard;
import com.smhrd.flutter.model.AiMember;
import com.smhrd.flutter.model.Pet;
import com.smhrd.flutter.model.Users;
import com.smhrd.flutter.service.PetService;

@RestController
public class PetController {
    
    @Autowired
    PetService service;
    
    @PostMapping("/deletePet")
    public int deletePet(@RequestBody HashMap<String, Object> map) {
    	ObjectMapper om = new ObjectMapper();
		Long p_idx = om.convertValue(map.get("pidx"), Long.class);

		System.out.println("p_idx: " + p_idx);
		service.deletePet(p_idx);
    	return 0;
    }

    @PostMapping("/selectAllPet")
    public String selectAllPet(@RequestBody HashMap<String, Object> map) {
    	
    	ObjectMapper om = new ObjectMapper();
    	Long uidx = Long.valueOf(map.get("uidx").toString());
    	List<Pet> list = service.selectAllPet(uidx);
    	String jsonString = null;
    	if (list !=null) {
    		try {
    			jsonString = om.writeValueAsString(list);
    		}catch (JsonProcessingException e) {
    			e.printStackTrace();
			}
    	}
    	
    	return jsonString;
    }
    
    @PostMapping("/enroll")
    public int petEnroll(@RequestBody HashMap<String, Object> map) {
        ObjectMapper om = new ObjectMapper();
        Pet enrollPet = om.convertValue(map.get("enrollPet"), Pet.class);
        System.out.println("Received pet data: " + enrollPet); // 로그 추가
        int result = service.petEnroll(enrollPet);
        
		
        return result;
    }
}
