package com.leinaro.move.move.controller.user;

import com.leinaro.move.move.dto.MessageDto;
import com.leinaro.move.move.entity.User;
import com.leinaro.move.move.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/validate")
    public ResponseEntity validateUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String,String> data  = (Map<String,String>) authentication.getDetails();
        return ResponseEntity.ok(new MessageDto("Hola "+userService.validateUser(data)+" from springboot"));
    }

    @GetMapping("/home")
    public ResponseEntity<MessageDto> getHome(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(new MessageDto("Hola "+username+" from springboot"));
    }

}
