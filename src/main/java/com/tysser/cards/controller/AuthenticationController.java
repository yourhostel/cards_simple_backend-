package com.tysser.cards.controller;

import com.tysser.cards.dto.JwtResponse;
import com.tysser.cards.dto.LoginDto;
import com.tysser.cards.dto.UserDto;
import com.tysser.cards.model.User;
import com.tysser.cards.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        User user = userService.registerNewUserAccount(userDto);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        String token = userService.login(loginDto.getUsername(), loginDto.getPassword());
        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
