package com.develhope.esSpringBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomResponseController {
    @GetMapping("/random")
    public ResponseEntity<String> random(){
        if(new Random().nextBoolean()){
            return ResponseEntity.ok("It's OK");
        }
        return ResponseEntity.badRequest().body("Bad Request");
    }
}
