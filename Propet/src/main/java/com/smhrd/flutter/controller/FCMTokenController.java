package com.smhrd.flutter.controller;

import com.smhrd.flutter.model.UserToken;
import com.smhrd.flutter.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FCMTokenController {

    @Autowired
    private UserTokenRepository userTokenRepository;

    // 클라이언트에서 전송한 FCM 토큰을 저장합니다.
    @PostMapping("/token")
    public void saveToken(@RequestBody UserToken userToken) {
        userTokenRepository.save(userToken);
        System.out.println("Received token: " + userToken.getToken());
    }
}
