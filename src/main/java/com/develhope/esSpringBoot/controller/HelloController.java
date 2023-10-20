package com.develhope.esSpringBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String returnString(){
        return "Hello World!";
    }
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Good Night!");
    }
    @GetMapping("/good-evening")
    public ResponseEntity<String> index(){
        if(new Date().getHours() >=21) {
            return ResponseEntity.badRequest().body("It's not evening, it's night");
        }
        return ResponseEntity.ok("good morning!!");
    }
}
