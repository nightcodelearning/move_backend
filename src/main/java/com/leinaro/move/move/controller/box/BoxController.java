package com.leinaro.move.move.controller.box;

import com.leinaro.move.move.entity.Box;
import com.leinaro.move.move.service.BoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/box")
public class BoxController {

    private BoxService boxService;

//    @GetMapping()
//    public ResponseEntity<List<Box>> getAllByUser(@PathVariable ){
//
//        return boxService.findAll();
//    }
    @PostMapping("/create")
    public ResponseEntity<Box> createbox(Box box){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String,String> data  = (Map<String,String>) authentication.getDetails();
        Box newBox = boxService.saveBox(box,data);

        return ResponseEntity.ok(newBox);
    }
}
