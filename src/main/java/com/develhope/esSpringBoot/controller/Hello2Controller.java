package com.develhope.esSpringBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {
    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return ResponseEntity.ok("Good Request");
    }
}
